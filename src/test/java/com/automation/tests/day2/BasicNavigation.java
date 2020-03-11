package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception{       // Thread.sleep hiisen bol throws Exception end nemj bichne.

        WebDriverManager.chromedriver().setup();        // Chrome browser songono
        ChromeDriver driver = new ChromeDriver();       // Songoson browseroo idevhjuulne
        driver.get("http://google.com");                // test hiih website-aa songono
        driver.manage().window().maximize();            // orson web browserpp tom bolgono
        Thread.sleep(3000);                       // 3 second huleene
        String title = driver.getTitle();               // title automataar songono
        String expectedTitle = "Google";                // yag yamar title avchirhaa ooroo hiij ogno
        System.out.println("Title is : " + title);

        if (expectedTitle.equals(title)){               // ooroo hiisen automataar songoson title adilhan uu?
            System.out.println("TEST PASSED!");         // adil bol PASSED
        } else {
            System.out.println("TEST FAILED!");         // adil bish bol FAILED
        }

        driver.navigate().to("http://amazon.com");   // driver.get - tei adilhan website songono

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        Thread.sleep(3000);
        driver.navigate().refresh();                    // page-aa refresh hiine
        Thread.sleep(3000);

        driver.navigate().back();                       // amazon.com - oosoo butsaad google.com -ruu oroh
        verifyEquals(driver.getTitle(), "Google");      // door zohios methodoo test hiih
        Thread.sleep(3000);

        driver.navigate().forward();                    // google.com - oosoo uragshaa amazon.com - ruugaa shiljih
        System.out.println("Title : " + driver.getTitle());         // amazon.com oosoo title automataar hevlene.
        System.out.println("URL : " + driver.getCurrentUrl());      // URL hevleh


        Thread.sleep(3000);
        driver.close();                                 // website maani automataar haagdana.
                            // driver.quit - 2 3 window ongorhoi baisan ch bugdiig ni haana.
                            // driver.close - gantshan orson baigaa window-oo haana.
    }

    public static void verifyEquals(String arg1, String arg2){  // shine method zohioh eniig haana ch ashiglaj bolno.
        if (arg1.equals(arg2)){                                  // arg1 arg2 - hoyor hoorondoo tentsuu esehiig test hiine
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }
}
