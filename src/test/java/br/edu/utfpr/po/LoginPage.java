/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author kamil
 */
public class LoginPage extends BasePage{
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(name = "user") WebElement user;
    
    @FindBy(name = "pass") WebElement password;
    
    @FindBy(name = "mpass") WebElement mPassword;
    
    @FindBy(id = "btnLogin") WebElement buttonLogin;
   
    
    public LoginPage setUsuario(String usuario){
        user.sendKeys(usuario);
        return this;
    }
     
    public LoginPage setSenha(String senha){
        password.sendKeys(senha);
        return this;
    }
    
    
    public LoginPage login(){
        buttonLogin.click();
        return this;
    }
    
    public LoginPage setMasterSenha(String master){
        mPassword.sendKeys(master);
        return this;
    }
    
    public boolean deuCerto () {
        List<WebElement> erros = driver.findElements(By.className("toast-error"));
        return erros.size() <= 0;
    }
    
}
