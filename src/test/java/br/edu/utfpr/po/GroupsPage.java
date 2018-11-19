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
public class GroupsPage extends SysPassBasePage {
    
    public GroupsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"btn-add-721\"]") WebElement addNovo;
    
    @FindBy(id = "name") WebElement groupName;
    
    @FindBy(id = "description") WebElement groupDescription;
    
    @FindBy(xpath = "//*[@id=\"selUsers-selectized\"]") WebElement groupUser;
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSalva;
    
    public GroupsPage addNovoGrupo(){
        addNovo.click();
        return this;
    }
    
    public GroupsPage setNome(String nome){
        groupName.sendKeys(nome);
        return this;
    }
    
    public GroupsPage setDescricao(String descricao){
        groupDescription.sendKeys(descricao);
        return this;
    }
    
    public GroupsPage setUser(String user){
        groupUser.sendKeys(user);
        groupUser.sendKeys(Keys.ENTER);
        return this;
    }
    
    public GroupsPage salvaGrupo(){
        btnSalva.click();
        return this;
    }
    
    public boolean adicionadoComSucesso(){
        List<WebElement> success = driver.findElements(By.className("toast-success"));
        return success.size() > 0;
    }
}
