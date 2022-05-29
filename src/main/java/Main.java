import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//Domaći: Otići na kupujemprodajem.com, u pretragu ukucati iphone 13, kliknuti na prvi rezultat.
//        Proveriti da je naslov oglasa onaj koji smo uočili i tokom manuelnog izvođenja kejsa.

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.kupujemprodajem.com/");

        WebElement popUp = driver.findElement(By.className("kpBoxCloseButton"));
        popUp.click();

        WebElement search = driver.findElement(By.id("searchKeywordsInput"));
        search.sendKeys("iphone 13");
        search.submit();

        WebElement result1 = driver.findElement(By.xpath("//*[@id=\"adDescription7321776\"]/div/section[2]/div[1]/div[1]/a"));
        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].scrollIntoView(true);", result1);

        result1.click();

        String expectedTitle = "iPhone 13, iPhone 12, iPhone 11 - NOVO! - KupujemProdajem";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Validno.");
        }else{
            System.out.println("Nije validno.");
        }

        driver.close();
        

    }
}
