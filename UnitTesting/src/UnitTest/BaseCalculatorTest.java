package UnitTest;

//import org.junit.Test;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.epam.tat.module4.Calculator;

public class BaseCalculatorTest {
	
	protected Calculator calculator;
	
	@BeforeClass
	public void Setup(){
	System.out.println ("Create instance of Calculator");
	calculator = new Calculator();
	}
	
	@BeforeTest
	public void beforeClass(){
	System.out.println ("Start of testing Calculator class");

	}
	
	@AfterTest
	public void afterClass(){
	System.out.println ("End of testing Calcularot class");

	}
	

protected void checkTime(){
System.out.println ("Current time:" + new Date (System.currentTimeMillis()));
}

	}
