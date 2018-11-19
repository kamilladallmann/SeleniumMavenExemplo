/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author kamil
 */
public class AccountsPage extends SysPassBasePage {
    
    public AccountsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"btn-search-4\"]") WebElement btnSearch;
    
    @FindBy(xpath = "//*[@id=\"search-4\"]") WebElement insertSearch;
    
    @FindBy(xpath = "//*[@id=\"data-table-tblAccounts\"]/table/thead/tr/th[1]/label/span[3]") WebElement selectAll;
    
    @FindBy(xpath = "//*[@id=\"tblAccounts-menu-lower-right\"]") WebElement btnOptions;
    
   @FindBy(xpath = "//*[@id=\"tabs-4\"]/div[1]/ul/li[3]/div/ul/li") WebElement delete;
   
   @FindBy(xpath = "//*[@id=\"positive\"]") WebElement okDeletar;
   
    public AccountsPage clicaBotaoSearch(){
        btnSearch.click();
        return this;
    }
    
    public AccountsPage insereBusca(String busca){
        insertSearch.sendKeys(busca);
        insertSearch.sendKeys(Keys.ENTER);
        return this;
    }
    
    public AccountsPage selecionaTudo(){
        selectAll.click();
        return this;
    }
    
    public AccountsPage abreOpcoes(){
        btnOptions.click();
        return this;
    }
    
    public AccountsPage deleteTudo(){
        delete.click();
        return this;
    }
    
    public AccountsPage confirmaDeleta(){
        okDeletar.click();
        return this;
    }
}
