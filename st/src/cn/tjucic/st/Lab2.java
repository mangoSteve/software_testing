package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lab2 {
	private WebDriver driver;
	private String baseUrl;
	private XSSFSheet sheet;
	private DecimalFormat df = new DecimalFormat("0");

	@Before
	public void setUp() throws Exception {
		// ���� Firefox driver
		String driverPath = System.getProperty("user.dir") + "/src/resource/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		// ����baseURL
		baseUrl = "http://121.193.130.195:8800/login";
		// ���ó�ʱ���
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		// ����ָ���ļ�������
		XSSFWorkbook workbook = new XSSFWorkbook("�����������.xlsx");
		sheet = workbook.getSheetAt(0);
	}

	@Test
	public void test() throws Exception {
		// ��ȡURL
		driver.get(baseUrl + "/");
		// ������
		for (int row_idx = 2; row_idx < sheet.getPhysicalNumberOfRows(); row_idx++) {
			// ȡ������
			XSSFRow row = sheet.getRow(row_idx);
			// ��� ID ��������ѧ������ ID ת��Ϊ�����ַ���
			String username = df.format(row.getCell(1).getNumericCellValue());
			// ��������
			String password = username.substring(username.length() - 6, username.length());
			// ��� GitHub ��ַ
			String address = row.getCell(3).toString();
			// ���� SeleniumIDE ����û��������Ԫ����
			// ���û���������������û���
			driver.findElement(By.name("id")).sendKeys(username);
			// ���� SeleniumIDE ������������Ԫ����
			// ���û������������������
			driver.findElement(By.name("password")).sendKeys(password);
			// ���� SeleniumIDE ��õ�¼��ťԪ�� ID
			// �����¼��ť
			driver.findElement(By.id("btn_login")).sendKeys(Keys.ENTER);
			// ���� SeleniumIDE ��ô洢��ַԪ�� ID
			// ��ø�Ԫ���е�������Ϣ��ת��Ϊ�ַ���
			String student_git = driver.findElement(By.id("student-git")).getText().toString();
			// ���� SeleniumIDE ��õǳ���ťԪ�� ID
			// ����ǳ���ť
			driver.findElement(By.id("btn_logout")).sendKeys(Keys.ENTER);
			// ���� SeleniumIDE ��÷�����ҳ��ťԪ�� ID
			// ���������ҳ��ť
			driver.findElement(By.id("btn_return")).sendKeys(Keys.ENTER);
			// �����ж�
			assertEquals(address, student_git);
		}
	}

}
