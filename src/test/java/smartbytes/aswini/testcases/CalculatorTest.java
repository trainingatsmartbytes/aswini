package smartbytes.aswini.testcases;



import static org.testng.Assert.assertEquals;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import smartbytes.aswini.Calculator;
     

public class CalculatorTest{
   Calculator calcInstance = new Calculator();
    @Ignore
	@Test(priority=1) 
	public void test_add() {
		int actualResult= calcInstance.add(10, 20);
		assertEquals(30, actualResult);
	}

	@Test
	public void test_subtract() {
		int actualResult= calcInstance.subtract(20, 10);
		assertEquals(10, actualResult);
	}

	@Test
	public void test_multiply() {
		int actualResult= calcInstance.multiply(10, 20);
		assertEquals(200, actualResult);
	}

}
