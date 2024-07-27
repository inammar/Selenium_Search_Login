package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setup();
        cookieAcceptance();
        timeout(3000);
        //loginTestNewUser();
        //loginTestRegisteredUser();
        //timeout(3000);

        //testing of search field with different phrases
        String[] phrases = {"Car", "Shop", "Soup", "Girl", "Transfer"};
        for (int i = 0; i < phrases.length; i++) {
            searchTestPhrases(phrases[i]);
        }
    }
    
    //setup of ChromeDriver
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //accepting the cookies
    public static void cookieAcceptance() {
        driver.get("website's address");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@aria-label='Accept']")));
        driver.findElement(By.xpath("//button[@aria-label='Accept']")).click();
    }

    //login test as a new user
    public static void loginTestNewUser() {
        driver.findElement(By.linkText("login")).click();
        timeout(2000);
        driver.findElement(By.cssSelector("a[title='Login into the system']")).click();
        timeout(2000);
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("John789");
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("jnn163@gmail.com");
        driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("123**As");
        driver.findElement(By.cssSelector("input[name='Password2']")).sendKeys("123**As");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        System.out.println("Your registration is successful");
    }

    //login test as a registered user
    public static void loginTestRegisteredUser () {
        driver.findElement(By.linkText("login")).click();
        driver.findElement(By.cssSelector("input[name='UserName']")).sendKeys("John789");
        driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("123**As");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        }
    
    //search field test with various different phrases
    public static void searchTestPhrases(String phrases) {
        driver.findElement(By.cssSelector("input[id='search-page-box']")).click();
        driver.findElement(By.cssSelector("input[id='search-page-box']")).sendKeys(phrases);
        driver.findElement(By.cssSelector("input[id='search-page-box']")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("input[id='search-page-box']")).clear();
}

        public static void timeout (int time)
        {
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        }
}
