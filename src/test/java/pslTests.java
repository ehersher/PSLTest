package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.junit.Test;

public class pslTests {

    // Input parameters
    String inputURL = "https://sdetassessment.azurewebsites.net";
    String[] trueCases = {"1 2 3", "1 r t 2 e 3", "1-)(2 3"};
    String[] falseCases = {"3 2 1", "1 4 2 3", "1 2 2 3"};
    String[] emptyCases = {"", " ", "    "};

    // XPath keys
    String A_SEQUENCE = "//*[contains(text(),\"Find '1 2 3'\")]";
    String INPUT_FIELD = "//input[@id='searchtext']";
    String BTN_SEARCH = "//button[contains(text(),\"Search\")]";
    String TXT_RESULT = "//div[@class=\"container\"]//p[2]";

    // Test results
    Boolean trueCase= true;
    Boolean falseCase = true;
    Boolean emptyCase = true;


    public void main(String caseType) throws Exception {

            // Use chrome driver to relative location of testing environment
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path + "/resources/chromedriver");

            // Create an instance of the driver
            WebDriver driver = new ChromeDriver();

            // Navigate to home page
            driver.get(inputURL);
            driver.manage().window().maximize();

            try {

                // Navigate to specific web page
                driver.findElement(By.xpath(A_SEQUENCE)).click();

                // Choose which set of data to loop through
                if (caseType == "true") {
                    for (int i = 0; i < trueCases.length && trueCase; i++) {
                        // Enter input string and click 'search'
                        driver.findElement(By.xpath(INPUT_FIELD)).clear();
                        driver.findElement(By.xpath(INPUT_FIELD)).sendKeys(trueCases[i]);
                        driver.findElement(By.xpath(BTN_SEARCH)).click();
                        Thread.sleep(2000);
                        trueCase = driver.findElement(By.xpath(TXT_RESULT)).getText().contains("True:");
                        System.out.println("The string \"" + trueCases[i] + "\" is shown as " + trueCase + " on the client.");
                    }
                } else if (caseType == "false") {
                    for (int j = 0; j < falseCases.length && falseCase; j++) {
                        driver.findElement(By.xpath(INPUT_FIELD)).clear();
                        driver.findElement(By.xpath(INPUT_FIELD)).sendKeys(falseCases[j]);
                        driver.findElement(By.xpath(BTN_SEARCH)).click();
                        Thread.sleep(2000);
                        falseCase = driver.findElement(By.xpath(TXT_RESULT)).getText().contains("False:");
                        System.out.println("The string \"" + falseCases[j] + "\" is shown as " + falseCase + " on the client.");
                    }
                } else {
                    for (int k = 0; k < emptyCases.length && emptyCase; k++) {
                        driver.findElement(By.xpath(INPUT_FIELD)).clear();
                        driver.findElement(By.xpath(INPUT_FIELD)).sendKeys(emptyCases[k]);
                        driver.findElement(By.xpath(BTN_SEARCH)).click();
                        Thread.sleep(2000);
                        emptyCase = driver.findElement(By.xpath(TXT_RESULT)).getText().contains("Please provide");
                        System.out.println("The string \"" + emptyCases[k] + "\" is shown as " + emptyCase + " on the client.");
                    }
                }
        } catch (Exception e) {
            throw new Exception("An error occurred when attempting to run the test.");
        } finally {
            // Close the browser
            driver.close();
        }

    }

    @Test
    public void trueCases() throws Exception {
        main("true");
        assertTrue(trueCase);
    }

    @Test
    public void falseCases() throws Exception {
        main("false");
        assertTrue(falseCase);
    }
    @Test
    public void emptyCase() throws Exception {
        main("empty");
        assertTrue(emptyCase);
    }
}