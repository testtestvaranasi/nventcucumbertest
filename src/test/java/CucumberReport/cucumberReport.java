package CucumberReport;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cucumberReport {
	String parentWinHandle;
	WebDriver driver = null; 
	Actions act;
	@Given("^Open chrome and start application$")
	public void Open_chrome_and_start_application() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		driver = new ChromeDriver();	
		act = new Actions(driver);
		driver.manage().window().maximize();		
		driver.get("https://qa3dexp.nventco.com/3dpassport/login?service=https%3A%2F%2Fqa3dexp.nventco.com%2F3dspace%2Fcommon%2FemxNavigator.jsp");
	}

	@When("^I enter valid (.*),(.*) fields$")
	public void I_enter_valid_E_Plm_fields(String usernamevalues, String passwordvalues) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		Thread.sleep(5000);
		String username = usernamevalues.replace("'", "");
		String password = passwordvalues.replace("'", "");
		driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		 driver.findElement(By.xpath("//div[@class='commands']")).click();
		 System.out.println("Login Successfully button clicked");
		 parentWinHandle = driver.getWindowHandle();
		 //Thread.sleep(50000);
		 driver.close();
	}

	@Given("^I have already accessed to create part page$")
	public void I_have_already_accessed_to_create_part_page() throws Throwable {
		
		driver = new ChromeDriver();	
		act = new Actions(driver);
		driver.manage().window().maximize();		
		driver.get("https://qa3dexp.nventco.com/3dpassport/login?service=https%3A%2F%2Fqa3dexp.nventco.com%2F3dspace%2Fcommon%2FemxNavigator.jsp");
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("E1125316");
	    driver.findElement(By.name("password")).sendKeys("Plm12345");
	    driver.findElement(By.xpath("//div[@class='commands']")).click();
	    Thread.sleep(50000);
	    System.out.println("Create Part Start");
	    
	   
	    driver.findElement(By.xpath("//div[@class='add topbar-menu-item topbar-cmd fonticon fonticon-plus']")).click();
	    
	    Thread.sleep(5000);
	   
	    Point engineering = driver.findElement(By.xpath("//span[text()='Engineering']")).getLocation();
	    Robot roboteng = new Robot();
	    roboteng.mouseMove(engineering.x,engineering.y+110);
	    Thread.sleep(500);       
	     
	     
	     Point part = driver.findElement(By.xpath("//span[text()='Part']")).getLocation();
	     Robot robotpart = new Robot();
	     robotpart.mouseMove(part.x+50,part.y+125);
	     Thread.sleep(500); 
	     
	     Point createnewpart = driver.findElement(By.xpath("//span[text()='Create Part']")).getLocation();
	     Robot robotcreatepart = new Robot();	
	     WebElement markNews = driver.findElement(By.xpath("//span[text()='Create Part']"));
	     markNews.click();
	     robotcreatepart.mouseMove(createnewpart.x,createnewpart.y+120);
	     Thread.sleep(5000);

	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     //Once the browser is opened with the given Url ,by default it will not be full maximized , we need to maximize it by using the above code.  
	     WebElement Element = driver.findElement(By.xpath("/html/body/div[22]/iframe")); // To identify a frame i.e Frame1 we need to identify it by using either Id or Name properties.  
         // Here 'Element' variable holds Complete information about the frame such as Frame displayed / Exists ,Frame coordinates , etc.  
         driver.switchTo().frame(Element) ;    
	     
         Thread.sleep(10000);  
          
	     driver.findElement(By.name("TypeActualDisplay")).sendKeys("Fixed Capacitor Part");
	     Thread.sleep(5000); 
	     Point createnewpartOrg = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[2]/td[2]/input[1]")).getLocation();
	     Robot robotcreatepartorg = new Robot();	     
	     robotcreatepartorg.mouseMove(createnewpartOrg.x+1500,createnewpartOrg.y+240);
	     WebElement markNewsorg = driver.findElement(By.xpath("/html/body/div[2]/form/div[1]/div[1]/table/tbody/tr/td"));
	     markNewsorg.click();
	              
         //driver.findElement(By.name("btnTypeActual")).click();
         
	     Thread.sleep(10000); 
	     
     
	     Select partFamily = new Select(driver.findElement(By.xpath("//*[@id=\"PartFamilyId\"]")));
	     partFamily.selectByVisibleText("Capacitor Ceramic Single Layer");	    
	     
	    // driver.findElement(By.xpath("//*[@id=\"NoOfParts\"]")).sendKeys("3");;
	     
		 driver.findElement(By.id("VPMProductName1")).sendKeys("Test Data sel");
		 
		//saving New Part new file
		 
		 driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/a/button")).click(); 
		 
		 Thread.sleep(10000); 
	}
	
	

	@When("^I enter valid '<type>','<partfamily>' values$")
	public void I_enter_valid_type_partfamily_values() throws Throwable {
	   
	}

	@When("^I clicked on Save button$")
	public void I_clicked_on_Save_button() throws Throwable {
	   
	}

	@Then("^I created a part successfully$")
	public void I_created_a_part_successfully() throws Throwable {
	  
	}


	@Given("^I close a browser$")
	public void I_close_a_browser() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		//driver.close();
	}

	


}
