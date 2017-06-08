package com.sdi.tests.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class PO_AltaForm {

	
	
   public void rellenaRegistroUsuario(WebDriver driver, String plogin, 
		   String pfirstname , String plastname , String pemail , String ppassword , String ppassword2)
   {
		WebElement login = driver.findElement(By.id("form-cuerpo:login"));
		login.click();
		login.clear();
		login.sendKeys(plogin);
		WebElement firstname = driver.findElement(By.id("form-cuerpo:firstname"));
		firstname.click();
		firstname.clear();
		firstname.sendKeys(pfirstname);
		WebElement lastname = driver.findElement(By.id("form-cuerpo:lastname"));
		lastname.click();
		lastname.clear();
		lastname.sendKeys(plastname);
		WebElement email = driver.findElement(By.id("form-cuerpo:email"));
		email.click();
		email.clear();
		email.sendKeys(pemail);
		WebElement password = driver.findElement(By.id("form-cuerpo:password"));
		password.click();
		password.clear();
		password.sendKeys(ppassword);
		WebElement password2 = driver.findElement(By.id("form-cuerpo:password2"));
		password2.click();
		password2.clear();
		password2.sendKeys(ppassword2);
		//Pulsar el boton de Alta.
		By boton = By.id("form-cuerpo:boton");
		driver.findElement(boton).click();	   
   }
   
   public void rellenaFormularioLogIn(WebDriver driver, String plogin, String ppassword)
   {
		WebElement nombre = driver.findElement(By.id("form-cuerpo:username"));
		nombre.click();
		nombre.clear();
		nombre.sendKeys(plogin);
		WebElement password = driver.findElement(By.id("form-cuerpo:password"));
		password.click();
		password.clear();
		password.sendKeys(ppassword);
		//Pulsar el boton de Alta.
		By boton = By.id("form-cuerpo:boton");
		driver.findElement(boton).click();	   
   }
   	
	
}
