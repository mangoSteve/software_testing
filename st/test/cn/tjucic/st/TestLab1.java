package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLab1 {
	private Boolean expected;
	private int input;
	private Lab1 lab1;

	public TestLab1(Boolean expected, int input) {
		this.expected = expected;
		this.input = input;
	}

	@Before
	public void setUp() {
		// 实例化对象		
		this.lab1 = new Lab1();
	}

	@Parameters
	public static Collection<Object[]> getData() {
		// 返回测试用例		
		return Arrays.asList(new Object[][] { 
			{ true, 83 }, 
			{ true, 82 },
			{ true, 78 },    
			{ true, 33 }, 
			{ false, 84 },
			{ false, 35 }, 
			{ false, 34 } });
	}

	@Test
	public void testTakeOut() {
		// 进行测试		
		assertEquals(this.expected, lab1.takeOut(input));
	}
}
