/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import static org.openqa.selenium.By.id;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author kamil
 */
public class MenuUsuariosPage extends SysPassBasePage{

    public MenuUsuariosPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"btnLogout\"]") WebElement btnLogout;
    
    @FindBy(id = "btnUserPass") WebElement btnUserPass;
    
    @FindBy(id = "btnPrefs") WebElement btnPreferences;
    
    
    public MenuUsuariosPage logout(){
        btnLogout.click();
        return this;
    }
    
    public MenuUsuariosPage changePassword(){
        btnUserPass.click();
        return this;
    }
    
    public MenuUsuariosPage userPreferences(){
        btnPreferences.click();
        return this;
    }
    
    
    
    

}
