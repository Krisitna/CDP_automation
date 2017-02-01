package UnitTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.epam.tat.module4.Timeout;

public class UnitTests extends BaseCalculatorTest{

	@Test (dataProvider = "dataProviderForSum" )
	public void testSum (long a, long b, long expectedResult)
	{
		 long sum = calculator.sum(a, b);
		Assert.assertEquals(sum, expectedResult, "Expected result " + expectedResult);
	}
	
	@DataProvider (name = "dataProviderForSum")
	public Object [][]dataProvider (){
		return new Object [][]{
				{1,1,2},
				{0,0,0},
				{4,-4,0},
				{1,-10,-9}
		};
		}
	
	
   @Test (expectedExceptions = NumberFormatException.class, groups= ("failedMethods"))// bug no try-catch block  for division by zero
	public void testDivByZeroDouble (){
		calculator.div(2.8, 0);
		Assert.fail("Attempt to divide by zero");
	}
   
   @Test (expectedExceptions = NumberFormatException.class)
  	public void testDivByZero (){
  		calculator.div(4, 0);
  		Assert.fail("Attempt to divide by zero");
  	}
  @Test (description = "test division for 6 by 2 equils 3" )
	public void testDivTreeByTwo (){
		long result = calculator.div(6, 2);
		Assert.assertEquals(result, 3);
		checkTime();
	
	
	}
	 @Test 
	 public void numberIsPositive (){
		boolean condition = calculator.isPositive(2);
		 Assert.assertEquals(condition, true,"Number is positive"); 
		 checkTime();
		
	 }
	
	 @Test 
	 public void numberIsNegative (){
		boolean condition = calculator.isNegative(-2);
		 Assert.assertEquals(condition, true,"Number is negative");
		 checkTime();
	
	 }
	 
	 @Test 
	 public void sqrtOfFour (){
			double result = calculator.sqrt(4);
			 Assert.assertEquals(result, 2.0); 
			 checkTime();
			
		 }
		
	@Test(description = "test sum for one plus one", enabled=false)//bug the result is rounded
	public void multiplicationTwoAndTwo (){
		double result = calculator.mult(1.5, 1.5);
		Assert.assertEquals(result, 2.25);
		
	}
	
	@Test (description = "cos of 0", groups= ("failedMethods"))// bug, the wrong actual result, cos functional is replaced to sin functions
			public void cosOfZero (){
		double result = calculator.cos(0);
		Assert.assertEquals(result, 1.0);
		
	}
	
	@Test (description = "sin of 0")
	public void sinOfZero (){
double result = calculator.cos(0);
Assert.assertEquals(result, 0.0);

}		
	 
	@Test (description = "ctg of 90",groups= ("failedMethods")) // bug, the actual result = 1, expected result = 0
	public void ctgOfRightTangel (){
double result = calculator.ctg(90);
Assert.assertEquals(result, 0.0);
	}

@Test (description = "tg of 90",groups= ("failedMethods"))   // bug,the actual result = NaN, expected result = 0
   public void tagOfZero (){
double result = calculator.tg(0);
Assert.assertEquals(result, 0.0);

}		

}		


