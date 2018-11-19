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
public class CustomersPage extends SysPassBasePage{
    
    public CustomersPage(WebDriver driver) {
        super(driver);
    }
    
    
    
    @FindBy(xpath = "//*[@id=\"btn-add-621\"]") WebElement btnNovoCustomer;
    
    @FindBy(id = "name") WebElement nomeCustomer;
    
    @FindBy(id = "description") WebElement descricaoCustomer;
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSalvaCustomer;
    
    @FindBy(xpath = "//*[@id=\"btn-search-1\"]") WebElement btnSearch;
    
    @FindBy(xpath = "//*[@id=\"search-1\"]") WebElement input;
    
    @FindBy(xpath = "//*[@id=\"data-table-tblCustomers\"]/table/thead/tr/th[1]/label/span[3]") WebElement select;
    
    @FindBy(xpath = "//*[@id=\"tblCustomers-menu-lower-right\"]") WebElement options;
    
    @FindBy(xpath = "//*[@id=\"tabs-1\"]/div[1]/ul/li[4]/div/ul/li") WebElement delete;
    
    @FindBy(xpath = "//*[@id=\"positive\"]") WebElement confirma;
    
    public CustomersPage addNovoCustomer(){
        btnNovoCustomer.click();
        return this;
    }
    
    public CustomersPage setNomeCustomer(String nome){
        nomeCustomer.sendKeys(nome);
        return this;
    }
    
    public CustomersPage setDescricaoCustomer(String descricao){
        descricaoCustomer.sendKeys(descricao);
        return this;
    }
    
    public CustomersPage salvaCustomer(){
        btnSalvaCustomer.click();
        return this;
    }
    
    public CustomersPage searchCustomer(){
        btnSearch.click();
        return this;
    }
    
    public CustomersPage inputSearch(String pesquisa){
        input.sendKeys(pesquisa);
        input.sendKeys(Keys.ENTER);
        return this;
    }
    
    public CustomersPage selectCustomer(){
        select.click();
        return this;
    }
    
    public CustomersPage openOptions(){
        options.click();
        return this;
    }
    
    public CustomersPage deleteRegistro(){
        delete.click();
        return this;
    }
    
    public CustomersPage confirmDelete(){
        confirma.click();
        return this;
    }
    
    public boolean erroAoDeletar(){
        List<WebElement> erro = driver.findElements(By.className("toast-error"));
        return erro.size() > 0;
    }
    
    
}
