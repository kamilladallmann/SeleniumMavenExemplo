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
 * @author kamil
 */
public class NewAccountPage extends BasePage {
    
    public NewAccountPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"name\"]") WebElement nomePessoa;    
    
    @FindBy(xpath = "//*[@id=\"selCustomer-selectized\"]") WebElement selecionaCustomer;    
    
    @FindBy(xpath = "//*[@id=\"frmAccount\"]/table/tbody/tr[2]/td[2]/i") WebElement btnAddCustomer;
    
    @FindBy(xpath = "//*[@id=\"name\"]") WebElement nomeCustomer;
    
    @FindBy(xpath = "//*[@id=\"description\"]") WebElement descricaoCustomer;
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSalvaCustomer;
    
    @FindBy(xpath = "//*[@id=\"selCategory-selectized\"]") WebElement selecionaCategory;    
    
    @FindBy(xpath = "//*[@id=\"frmAccount\"]/table/tbody/tr[3]/td[2]/i") WebElement btnAddCategory;
    
    @FindBy(xpath = "//*[@id=\"name\"]") WebElement nomeCategory;
    
    @FindBy(xpath = "//*[@id=\"description\"]") WebElement descricaoCategory;
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSalvaCategory;
    
    @FindBy(xpath = "//*[@id=\"login\"]") WebElement userPessoa;    
    
    @FindBy(id = "accountpass") WebElement senhaPessoa;
     
    @FindBy(id = "accountpassR") WebElement senhaRPessoa;
    
    @FindBy(id = "accountpassdatechange") WebElement dataExpira;
    
    @FindBy(xpath = "//*[@id=\"btnSave\"]") WebElement btnSalvar;
    
    public NewAccountPage setName(String nome){
        
        nomePessoa.sendKeys(nome);
        return this;
    }
    
    public NewAccountPage setCustomer(String customer){
        selecionaCustomer.sendKeys(customer);
        selecionaCustomer.sendKeys(Keys.ENTER);
        return this;
    }
    
    public NewAccountPage setCategory(String category){
        selecionaCategory.sendKeys(category);
        selecionaCategory.sendKeys(Keys.ENTER);
        return this;
    }
    
     public NewAccountPage setUser(String usuario){
        
        userPessoa.sendKeys(usuario);
        return this;
    }
    
    public NewAccountPage setPass(String password){
        //insertPasswordAgain.clear();
        senhaPessoa.sendKeys(password);
        return this;
    }
    
    public NewAccountPage setPassAgain(String passwordR){
        //insertPasswordAgain.clear();
        senhaRPessoa.sendKeys(passwordR);
        return this;
    }
    
    public NewAccountPage setData(String dataexpira){
        dataExpira.click();
        dataExpira.sendKeys(dataexpira);
        dataExpira.sendKeys(Keys.ENTER);
        return this;
    }
    
    public NewAccountPage addCustomer(){
        btnAddCustomer.click();
        return this;
    }
    
    
    public NewAccountPage addCategory(){
        btnAddCategory.click();
        return this;
    }
       
      
    public NewAccountPage save(){
        btnSalvar.click();
        return this;
    }
    
    public boolean OperacaoRealizadaComSucesso(){
        List<WebElement> success = driver.findElements(By.className("toast-success"));
        return success.size() > 0;
    }
        
}
