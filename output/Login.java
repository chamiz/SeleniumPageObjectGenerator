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

public class Login{
   @FindBy(id = "inputText")
   public WebElement inputText;

   @FindBy(id = "inputRadio")
   public WebElement inputRadio;

   @FindBy(id = "inputButton")
   public WebElement inputButton;

   @FindBy(id = "inputCheckbox")
   public WebElement inputCheckbox;

   @FindBy(id = "select")
   public WebElement select;

   @FindBy(id = "anchor")
   public WebElement anchor;

   @FindBy(id = "submit")
   public WebElement submit;

   public WebElement getinputText(){
       return inputText;
   }

   public WebElement getinputRadio(){
       return inputRadio;
   }

   public WebElement getinputButton(){
       return inputButton;
   }

   public WebElement getinputCheckbox(){
       return inputCheckbox;
   }

   public WebElement getselect(){
       return select;
   }

   public WebElement getanchor(){
       return anchor;
   }

   public WebElement getsubmit(){
       return submit;
   }

}