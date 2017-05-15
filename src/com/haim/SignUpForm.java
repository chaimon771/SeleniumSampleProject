package com.haim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpForm extends IO{

    //Mapping fields elements:
    private String firstName;
    private String lastName;
    private String email;


    public SignUpForm() {
    }

    public SignUpForm(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        firstName = IO.generateName(firstName);
        return firstName;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    public String getLastName() {
        lastName = IO.generateName(lastName);
        return lastName;
    }

    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }

    public String getEmail() {
        email = IO.generateName(email);
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    @Override
    public String toString() {
        return "SignUpForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * Created by DELL e7440 on 15/05/2017.
     */
    public static class FillSignUpForm extends SignUpForm {



        public static void signUp() {

            String webChromeDriver = "webdriver.chrome.driver";
            String chromeDriver = "C:/SeleniumTraining/Drivers/chromedriver.exe";

            System.setProperty(webChromeDriver,chromeDriver);


            WebDriver driver = new ChromeDriver();


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    //        driver.get("https://getsimpleform.com/demo");
    //        driver.get("https://www.24option.com/eu/binary-cfd/");
    //
    //        WebElement signUpButton = driver.findElement(By.xpath("//A[@class='btn btn-inv btn-hover-yellow'][text()='SIGN UP']"));
    //        signUpButton.click();


            driver.get("https://onboarding.24option.com/en/open-account/");

            SignUpForm form1 = new SignUpForm("Test","Test","qatest");
            WebElement firstName = driver.findElement(By.id("FirstName"));
            WebElement lastName = driver.findElement(By.id("LastName"));
            WebElement email = driver.findElement(By.id("Email"));
            WebElement preffix= driver.findElement(By.id("mobile-number"));
            WebElement phoneNumber = driver.findElement(By.name("PhoneNumber.Number"));
            WebElement password = driver.findElement(By.id("Password"));
            WebElement retyprPassword = driver.findElement(By.id("ReEnterPassword"));
            WebElement AccountAgreeLabel = driver.findElement(By.xpath("(//P)[2]"));
            WebElement FormSubmitBtn = driver.findElement(By.id("FormSubmitBtn"));

            firstName.sendKeys(form1.getFirstName());
            lastName.sendKeys(form1.getLastName());
            email.sendKeys(form1.getEmail()+"@test.com");
            preffix.clear();
            preffix.sendKeys("44");
            phoneNumber.sendKeys("1234567");

            String pass  ="123456";
            password.sendKeys(pass);

            retyprPassword.sendKeys(pass);

            AccountAgreeLabel.click();

            FormSubmitBtn.click();


        }
    }
}
