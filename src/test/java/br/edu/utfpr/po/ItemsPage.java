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
public class ItemsPage extends SysPassBasePage {
    
    public ItemsPage(WebDriver driver) {
        super(driver);
    }
    //Categoria
    
    @FindBy(id = "btn-add-611") WebElement btnNovaCategoria;
    
    @FindBy(id = "name") WebElement nomeCategoria;
    
    @FindBy(id = "description") WebElement descricaoCategoria;
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSalvaCategoria;
    
    //Cliente
    
    @FindBy(xpath = "//*[@id=\"tabsHeader\"]/a[2]") WebElement btnCustomer;
    
    //Account
    
    @FindBy(xpath = "//*[@id=\"tabsHeader\"]/a[5]") WebElement btnAccounts;
   
    
    public ItemsPage addNovaCategoria(){
        btnNovaCategoria.click();
        return this;
    }
    
    public ItemsPage setNomeCategoria(String nome){
        nomeCategoria.sendKeys(nome);
        return this;
    }
    
    public ItemsPage setDescricaoCategoria(String descricao){
        descricaoCategoria.sendKeys(descricao);
        return this;
    }
    
    public ItemsPage salvarCategoria(){
        btnSalvaCategoria.click();
        return this;
    }
    
    public CustomersPage goToCustomer(){
        btnCustomer.click();
        return new CustomersPage(driver);
    }
    
     public AccountsPage goToAccounts(){
        btnAccounts.click();
        return new AccountsPage(driver);
    }
    
    
    
}
