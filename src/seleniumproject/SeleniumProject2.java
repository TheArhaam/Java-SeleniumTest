package seleniumproject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class SeleniumProject2 {
    
//    FUNCTION TO EXTRACT INTEGER FROM A STRING
//    Using this function to pull the item count from the website
    static String extractInt(String str) 
    { 
        str = str.replaceAll("[^\\d]", " "); 
        str = str.trim(); 
        str = str.replaceAll(" +", " "); 
        if (str.equals("")) 
            return "-1"; 
        return str; 
    } 
    
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        
//        Opening the website for testing
        driver.get("https://demostore.x-cart.com/");
        
//        Initializing wait, to be used for Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,30);
        
//        SELECTING THE PRODUCT
        WebElement product = driver.findElement(By.xpath("//*[@id='content']/div/div/div[4]/div/div/div/ul/li[2]/div/div[1]/a/img"));
        product.click();
       
//        GETTING AVAILABLE STOCK
        WebElement availableItems = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[3]/div[4]/form[2]/div[2]/div/div[1]/span/span[2]"));
        int stock1 = Integer.parseInt(extractInt(availableItems.getText()));
        System.out.println("STOCK BEFORE PURCHASE: "+stock1);
        
//        ADDING PRODUCT TO CART
        WebElement addcart = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[3]/div[4]/form[2]/div[2]/div/div[3]/button"));
        addcart.click();
        
//        REFRESHING PAGE after 5 seconds
        Thread.sleep(5000);
        driver.navigate().refresh();
        
//        OPENING CART
        WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/div[1]/div/div[5]/div[4]"));
        cart.click();
        
//        CHECKING OUT
        WebElement checkout = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/div[1]/div/div[5]/div[4]/div[3]/div/a[2]"));
        checkout.click();
      
//        ENTERING EMAIL
        WebElement emailTextBox = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div/div[3]/div[2]/form/table/tbody/tr[1]/td/div[3]/span/input"));
        emailTextBox.sendKeys("arhaam.patvi@sitpune.edu.in");
        WebElement continuebttn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div/div[3]/div[2]/form/table/tbody/tr[2]/td/button"));
        continuebttn.click();
    
//    SHIPPING INFO
        WebElement fnamebox = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[1]/div/div/div/div[1]/div/div[1]/div[1]/shipping-address-form/div[2]/form/ul/li[1]/div[3]/span/input"));
        WebElement lnamebox = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[1]/div/div/div/div[1]/div/div[1]/div[1]/shipping-address-form/div[2]/form/ul/li[2]/div[3]/span/input"));
        WebElement addressbox = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[1]/div/div/div/div[1]/div/div[1]/div[1]/shipping-address-form/div[2]/form/ul/li[3]/div[3]/span/input"));
        WebElement stateselect = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[1]/div/div/div/div[1]/div/div[1]/div[1]/shipping-address-form/div[2]/form/ul/li[6]/div[3]/select"));
        WebElement shippingbttn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[2]/div[1]/div[2]/section-change-button/div/div[2]/next-button/button"));
        
        fnamebox.sendKeys("Arhaam");
        lnamebox.sendKeys("Patvi");
        addressbox.sendKeys("Home Address");
        stateselect.click();
        stateselect.sendKeys(Keys.ARROW_DOWN);
        stateselect.sendKeys(Keys.ENTER);
        shippingbttn.click();
        
//        DELIVERY METHOD
        WebElement localpickup = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div/shipping-methods/div/div/ul/li[3]/div/label/input"));
        localpickup.click();       
        Thread.sleep(1000);     
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[2]/div[1]/div[2]/section-change-button/div/div[2]/next-button/button")));
        WebElement paymentbttn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[2]/div[1]/div[2]/section-change-button/div/div[2]/next-button/button"));
        paymentbttn.click();
        
        Thread.sleep(1000); 
        
//        PAYMENT
        WebElement cod = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[1]/div/div/div/div[3]/div/div[1]/div[2]/div/payment-methods/div/form/ul/li[5]/div/label/input"));
        cod.click();      
        Thread.sleep(1000);       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[2]/div[1]/div[2]/section-change-button/div/div[1]/form/place-order/button")));
        WebElement placeorder = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[2]/sections/div[1]/div[2]/div[1]/div[2]/section-change-button/div/div[1]/form/place-order/button"));
        placeorder.click();
        
//        WAITING FOR ORDER CONFIRMATION
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/div/div/div[2]/div/div/h1")));
//        GOING BACK TO PRODUCT PAGE
        driver.get("https://demostore.x-cart.com/perfect-snacks");
//        GETTING NEW ITEM COUNT
        WebElement availableItems2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[3]/div[4]/form[2]/div[2]/div/div[1]/span/span[2]"));       
        int stock2 = Integer.parseInt(extractInt(availableItems2.getText()));
        System.out.println("STOCK AFTER PURCHASE: "+stock2);
        
//        ASSERTION FOR CHECKING IF ITEM COUNT HAS BEEN REDUCED
        Assert.assertEquals(stock1-1,stock2);
        System.out.println("TEST SUCCESSFULLY COMPLETED.");
        driver.close();
    }
}