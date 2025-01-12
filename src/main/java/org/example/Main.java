package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P03_RegisterPage;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        P01_HomePage homePage = new P01_HomePage(driver);
        homePage.openRegisterPage();
        P03_RegisterPage registerPage = new P03_RegisterPage(driver);

        registerPage.register(
                "moaz",
                "awwad",
                "moaazawwad99@gmail.com",
                "+201033666666",
                "asdasd",
                "asdasd"
        );
//        P02_LoginPage loginPage = new P02_LoginPage(driver);


//        homePage.openLoginPage();
//        loginPage.login("email", "passwodsasd");
    }
}