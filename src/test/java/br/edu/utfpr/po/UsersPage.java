/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author kamilla
 */
public class UsersPage extends SysPassBasePage{

    public UsersPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "btn-add-711") WebElement btnAddUser;
    
    @FindBy(xpath = "//*[@id=\"name\"]") WebElement nomeForm;
    
    @FindBy(xpath = "//*[@id=\"login\"]") WebElement loginForm;    
   
    @FindBy(id = "selProfile-selectized") WebElement profileForm;
    
    @FindBy(id = "selGroup-selectized") WebElement groupForm;
   
    @FindBy(xpath = "//*[@id=\"email\"]") WebElement emailForm;
    
    @FindBy(xpath = "//*[@id=\"userpass\"]") WebElement passForm;
    
    @FindBy(xpath = "//*[@id=\"userpassR\"]") WebElement passRForm;
    
    @FindBy(id = "notes") WebElement notesForm;
    
    @FindBy(xpath = "//*[@id=\"frmUsers\"]/table/tbody/tr[9]/td[2]/label[1]") WebElement selectApp;
    
    @FindBy(xpath = "//*[@id=\"frmUsers\"]/table/tbody/tr[9]/td[2]/label[2]/span[2]") WebElement selectAccounts;    
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSaveNewUser;
    
    @FindBy(xpath = "//*[@id=\"btn-search-0\"]") WebElement btnSearch;
    
    @FindBy(xpath = "//*[@id=\"search-0\"]") WebElement inputSearch;
    
    @FindBy(xpath = "//*[@id=\"btn-action-2-712\"]") WebElement botaoEditar;
    
    @FindBy(xpath = "//*[@id=\"frmUsers\"]/table/tbody/tr[7]/td[2]/label[1]/span[2]") WebElement appEdita;
    
    @FindBy(xpath = "//*[@id=\"frmUsers\"]/table/tbody/tr[7]/td[2]/label[2]/span[2]") WebElement accEdita;
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement confirmaEdita;
    
    public UsersPage addNovoUsuario(){
        btnAddUser.click();
        return this;
    }
   
   public UsersPage setNome(String nome) {
        nomeForm.sendKeys(nome);
        return this;
    }
   
   public UsersPage setLogin(String login) {
        loginForm.sendKeys(login);
        return this;
    }

   public UsersPage setProfile(String profile) {
       profileForm.sendKeys(profile);
       profileForm.sendKeys(Keys.ENTER);
       return this;
    }
      
   public UsersPage setGroup(String group) {
        groupForm.sendKeys(group);
        groupForm.sendKeys(Keys.ENTER);
        return this;
    }
   
   public UsersPage setEmail(String email){
       emailForm.sendKeys(email);
       return this;
   }
   
   public UsersPage setPassword(String pass){
       passForm.sendKeys(pass);
       return this;
   }
   
   public UsersPage confirmPassword(String passRepeat){
       passRForm.sendKeys(passRepeat);
       return this;
   }
   
   public UsersPage setNotes(String notes){
       notesForm.sendKeys(notes);
       return this;
   }
   
   public UsersPage checkBoxesUser(){
       selectApp.click();
       selectAccounts.click();       
       return this;
   }  
   
   public UsersPage salvarUsuario(){
       btnSaveNewUser.click();
       return this;
   }
   
   public boolean nomeExiste (String nome) {
        List<WebElement> users = 
                driver.findElements(By.xpath("//tbody[@id = 'data-rows-tblUsers']/tr/td[contains(text(), '" + nome + "')]"));
        return users.size() > 0;
    }  
    
   public UsersPage clickSearch(){
       btnSearch.click();
       return this;
   }
   
   public UsersPage inputPesquisa(String pesquisa){
       inputSearch.sendKeys(pesquisa);
       inputSearch.sendKeys(Keys.ENTER);
       return this;
   }
    
   public UsersPage editar(){
       botaoEditar.click();
       return this;
   }
   
   public UsersPage editaPrivilegios(){
       appEdita.click();
       accEdita.click();
       return this;       
   }
   
   public UsersPage saveEdita(){
       confirmaEdita.click();
       return this;
   }
   
   public boolean atualizadoComSucesso(){
        List<WebElement> success = driver.findElements(By.className("toast-success"));
        return success.size() > 0;
    }
}
