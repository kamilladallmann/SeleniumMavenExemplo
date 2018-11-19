/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import org.openqa.selenium.By;
import static org.openqa.selenium.By.id;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author kamil
 */
public class UserAndAccessesPage extends SysPassBasePage{
    
    public UserAndAccessesPage(WebDriver driver) {
        super(driver);
    }
    
    //Abas do User and Accesses
    
    @FindBy(xpath = "//*[@id=\"tabsHeader\"]/a[1]/span") WebElement btnUser;
    
    @FindBy(xpath = "//*[@id=\"tabsHeader\"]/a[2]/span") WebElement btnGroups;
    
    @FindBy(xpath = "//*[@id=\"tabsHeader\"]/a[3]/span") WebElement btnProfile;
    
    @FindBy(xpath = "//*[@id=\"tabsHeader\"]/a[4]/span") WebElement btnAPIAuth;
    
   
    
    public UsersPage accessUser(){
        btnUser.click();
        return new UsersPage(driver);
    }
     
   public GroupsPage accessGroups(){
        btnGroups.click();
        return new GroupsPage(driver);
    }
    
   public ProfilePage accessProfile(){
        btnProfile.click();
        return new ProfilePage(driver);
    }
   public UserAndAccessesPage accessApiAuth(){
        btnAPIAuth.click();
        return this;
    }

   
    
}
