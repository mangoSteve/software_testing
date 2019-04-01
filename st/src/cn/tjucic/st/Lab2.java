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
		// 设置 Firefox driver
		String driverPath = System.getProperty("user.dir") + "/src/resource/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		// 设置baseURL
		baseUrl = "http://121.193.130.195:8800/login";
		// 设置超时检测
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		// 读入指定文件工作簿
		XSSFWorkbook workbook = new XSSFWorkbook("软件测试名单.xlsx");
		sheet = workbook.getSheetAt(0);
	}

	@Test
	public void test() throws Exception {
		// 获取URL
		driver.get(baseUrl + "/");
		// 遍历行
		for (int row_idx = 2; row_idx < sheet.getPhysicalNumberOfRows(); row_idx++) {
			// 取出该行
			XSSFRow row = sheet.getRow(row_idx);
			// 获得 ID ，并将科学记数法 ID 转换为整数字符串
			String username = df.format(row.getCell(1).getNumericCellValue());
			// 计算密码
			String password = username.substring(username.length() - 6, username.length());
			// 获得 GitHub 地址
			String address = row.getCell(3).toString();
			// 利用 SeleniumIDE 获得用户名输入框元素名
			// 在用户名输入框中输入用户名
			driver.findElement(By.name("id")).sendKeys(username);
			// 利用 SeleniumIDE 获得密码输入框元素名
			// 在用户名输入框中输入密码
			driver.findElement(By.name("password")).sendKeys(password);
			// 利用 SeleniumIDE 获得登录按钮元素 ID
			// 点击登录按钮
			driver.findElement(By.id("btn_login")).sendKeys(Keys.ENTER);
			// 利用 SeleniumIDE 获得存储地址元素 ID
			// 获得该元素中的文字信息并转换为字符串
			String student_git = driver.findElement(By.id("student-git")).getText().toString();
			// 利用 SeleniumIDE 获得登出按钮元素 ID
			// 点击登出按钮
			driver.findElement(By.id("btn_logout")).sendKeys(Keys.ENTER);
			// 利用 SeleniumIDE 获得返回首页按钮元素 ID
			// 点击返回首页按钮
			driver.findElement(By.id("btn_return")).sendKeys(Keys.ENTER);
			// 进行判断
			assertEquals(address, student_git);
		}
	}

}
