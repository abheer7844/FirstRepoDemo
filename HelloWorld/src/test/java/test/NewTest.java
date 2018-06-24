package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import package1.Class1;

public class NewTest {
  @Test
  public void f() {
	  
	  Class1.BrowserOpenYoutube();
	  
  }
  
  
  @AfterTest
  public void afterTest() {
	  Class1.driverClose();
  }
}
