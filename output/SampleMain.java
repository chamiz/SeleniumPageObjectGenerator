package com.isa.automation;


import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 


/**
 * Do not remove the CopyRight notice. Respect the Developer.
 *
 * Chamila Ambahera
 * chamila.ambahera@gmail.com
 * 4/8/15 11:59 AM
 * Automated Page Object Generation
 */

// This is a sample main page to give you idea about the implementation
public class Main {

   @Page
   PageObject Login;

   WebElement inputText = Login.getinputText();

   WebElement inputRadio = Login.getinputRadio();

   WebElement inputButton = Login.getinputButton();

   WebElement inputCheckbox = Login.getinputCheckbox();

   WebElement select = Login.getselect();

   WebElement anchor = Login.getanchor();

   WebElement submit = Login.getsubmit();


   public static void main(String[] args)  {
//elementName.sendKeys(); 
   }
}
