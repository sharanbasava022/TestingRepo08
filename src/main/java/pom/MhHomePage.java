
package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;



import reuseablePackage.feature.AllActions;


public class MhHomePage {

// public WebDriver driver=null;
// public MhHomePage (WebDriver driver)
// 	{
// 		this.driver = driver;
// 		PageFactory.initElements(AllActions.driver, this);        // Reusable is a Reusable class where we initalize Web Driver ( public static WebDriver driver =null)
//     }
    
ThreadLocal<WebDriver> driver;
	 	public MhHomePage (ThreadLocal<WebDriver> driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver.get(), this);    
	}	


@FindBy(xpath="//a[contains(text(),'Click to update')]")public WebElement Updateq;

@FindBy(xpath="//a[@id='edit-btn']//img")public WebElement iconn;

@FindBy(xpath="//input[@id='weight']")public WebElement Weight;

@FindBy(xpath="//input[@id='height']")public WebElement Height;

@FindBy(xpath="//select[@id='bloodGroup']")public WebElement BloodGroup;

@FindBy(xpath="//button[contains(text(),'Save')]")public WebElement Save;

@FindBy(xpath="//a[@class='btn btn-primary dropdown-toggle blue-btn']")public WebElement LogoutB;
//pomStart
	


}
