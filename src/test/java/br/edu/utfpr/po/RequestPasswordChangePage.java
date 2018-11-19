/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author kamil
 */
public class RequestPasswordChangePage extends SysPassBasePage{
    
    public RequestPasswordChangePage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "pass") WebElement pass;
    
    @FindBy(id = "passR") WebElement passR;
    
    @FindBy(id = "btnChange") WebElement btnChange;
    
    @FindBy(id = "btnBack") WebElement btnBack;
    
    public RequestPasswordChangePage setPass(String senha){
        pass.sendKeys(senha);
        return this;
    }
    
    public RequestPasswordChangePage setPassR(String senhaR){
        passR.sendKeys(senhaR);
        return this;
    }
    
    public RequestPasswordChangePage entrar(){
       btnChange.click();
        return this;
    }
    
    public RequestPasswordChangePage voltar(){
        btnBack.click();
        return this;
    }
    
    
    
}
