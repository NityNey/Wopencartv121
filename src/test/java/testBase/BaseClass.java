package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Sanity", "Regression", "Master", "Datadriven"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		logger = LogManager.getLogger(this.getClass());
		
		
		  
	            // Loading the properties file
	            FileReader file = new FileReader("./src//test//resources//config.properties");
	            p = new Properties();
	            p.load(file);
	            
	            
           // to execute test cases in remote environment(selenium grid)
	            if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	            {
	                DesiredCapabilities capabilities = new DesiredCapabilities();
	                
	                // os
	                if(os.equalsIgnoreCase("windows")) 
	                {
	                    capabilities.setPlatform(Platform.WIN11);
	                 }
	                
	                else if (os.equalsIgnoreCase("mac")) 
	                {
	                    capabilities.setPlatform(Platform.MAC);
	                }
	                else if (os.equalsIgnoreCase("linux")) 
	                {
	                    capabilities.setPlatform(Platform.LINUX);
	                }
	                else 
	                {
	                    System.out.println("No matching os");
	                    return;
	                 }

	                // browser
	                switch(br.toLowerCase()) 
	                {
	                case "chrome": capabilities.setBrowserName("chrome"); break;
	                case "firefox": capabilities.setBrowserName("firefox"); break;
	                case "edge": capabilities.setBrowserName("MircosoftEdge"); break;
                    default: System.out.println("no matchin browser"); return; 
	                }
	                
	                driver= new RemoteWebDriver(new URL("http://192.168.1.67:4444/wd/hub"),capabilities);

	            }
	            
	                
	     // to execute test cases in remote environment(selenium grid)
      
	    if(p.getProperty("execution_env").equalsIgnoreCase("local"))

	    {
		         switch(br.toLowerCase()) 
		         {
		         case "firfox": driver = new FirefoxDriver(); break;
		         case "edge": driver = new EdgeDriver();break;
		         //default: throw new IllegalArgumentException("Browser not supported: " + br);
		         }
	    }
	    
	    
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	
	@AfterClass (groups = {"Sanity", "Regression", "Master"})
    public void tearDown() {
		
		driver.close();
	}
	
	
	// Method to generate a random alphabetic string
		public String randomString() 
		{
			
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		// Method to generate a random numeric string
		 public String randomNumber() 
		 {
				
			String generatednumber = RandomStringUtils.randomNumeric(10);
			return generatednumber;
			}
			
			// Method to generate a random alphanumeric string

			public String randomeAlphaNumberic() {
						
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			String generatednumber = RandomStringUtils.randomNumeric(10);

			return (generatedString +"@"+ generatednumber);
			}
			
		// to capture screenshot
						    

			public String captureScreen(String tname) throws IOException{
             String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			    
			    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			    
			    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
			    File targetFile = new File(targetFilePath);
			  //  Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			    sourceFile.renameTo(targetFile);
			    return targetFilePath;
			}				
			


}
