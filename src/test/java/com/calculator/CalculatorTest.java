package com.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest{

    @Test
    public void addShouldSucceed(){
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_2")).click();

        driver.findElement(By.id("op_add")).click();

        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_5")).click();
        
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText().trim(),"27");
        takeScreenshot();
    }

    @Test
    public void subtractShouldSucceed(){
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_5")).click();

        driver.findElement(By.id("op_sub")).click();

        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_2")).click();

        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText().trim(),"3");
        takeScreenshot();
        driver.rotate(ScreenOrientation.LANDSCAPE);

    }

    @Test
    public void multiplicationShouldSucceed(){
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_5")).click();

        driver.findElement(By.id("op_mul")).click();

        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_2")).click();

        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText().trim(),"180");
        takeScreenshot();

    }

    @Test
    public void divisonShouldSucceed(){
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("digit_7")).click();

        driver.findElement(By.id("op_div")).click();

        driver.findElement(By.id("digit_3")).click();

        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText().trim(),"9");

        takeScreenshot();
    }
}
