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
public class ProfilePage extends SysPassBasePage {
    
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "btn-add-731") WebElement btnAddProfile;
    
    @FindBy(id = "profile_name") WebElement nomeProfile;
    
        //Dentro de profile, aba Accounts

        @FindBy(xpath = "//*[@id=\"btnProfilesAcc\"]/label[1]/span[2]") WebElement checkAdd;

        @FindBy(xpath = "//*[@id=\"btnProfilesAcc\"]/label[2]/span[2]") WebElement checkView;

        @FindBy(xpath = "//*[@id=\"btnProfilesAcc\"]/label[3]/span[2]") WebElement checkViewPass;

        @FindBy(xpath = "//*[@id=\"btnProfilesAcc\"]/label[4]/span[2]") WebElement checkViewHistory;

        @FindBy(xpath = "//*[@id=\"btnProfilesAcc\"]/label[5]/span[2]") WebElement checkEdit;

        @FindBy(xpath = "//*[@id=\"btnProfilesAcc\"]/label[6]/span[2]") WebElement checkEditPass;

        @FindBy(xpath = "//*[@id=\"btnProfilesAcc\"]/label[7]/span[2]") WebElement checkDelete;

        //Dentro de profile, aba Management

        @FindBy(xpath = "//*[@id=\"btnProfilesUsers\"]/label[1]/span[2]") WebElement checkUsers;

        @FindBy(xpath = "//*[@id=\"btnProfilesUsers\"]/label[2]/span[2]") WebElement checkGroups;

        @FindBy(xpath = "//*[@id=\"btnProfilesUsers\"]/label[3]/span[2]") WebElement checkProfiles;

        @FindBy(xpath = "//*[@id=\"btnProfilesUsers\"]/label[4]/span[2]") WebElement checkCategories;

        @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSaveNewProfile;
    
    public ProfilePage addNovoPerfil(){
       btnAddProfile.click();
       return this;
   }
   
   public ProfilePage setNomePerfil(String nomePerfil){
       nomeProfile.sendKeys(nomePerfil);
       return this;
   }
   
   public ProfilePage checkBoxesProfile(){
       checkAdd.click();
       checkView.click();
       checkViewPass.click();
       checkViewHistory.click();
       checkEdit.click();
       checkEditPass.click();
       checkDelete.click();
       checkUsers.click();
       checkGroups.click();
       checkProfiles.click();
       checkCategories.click();       
       return this;
   }
   
   public ProfilePage salvarPerfil(){
       btnSaveNewProfile.click();
       return this;
   }
   
   public boolean perfilExiste (String nome) {
        List<WebElement> perfil = 
                driver.findElements(By.xpath("//tbody[@id = 'data-rows-tblProfiles']/tr/td[contains(text(), '" + nome + "')]"));
        return perfil.size() > 0;
    }  
    
}
