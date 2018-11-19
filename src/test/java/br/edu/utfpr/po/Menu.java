/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kamil
 */
public class Menu extends BasePage{
    
    @FindBy(id = "btn-1") WebElement btnBuscaHome;
    
    @FindBy(id = "btn-101") WebElement btnAddNovaConta;
    
    @FindBy(xpath = "//*[@id=\"btn-70\"]") WebElement btnUsuariosEAcessos;
    
    @FindBy(id = "btn-60") WebElement btnItensECustomizacoes;
    
    @FindBy(id = "btn-80") WebElement btnConfig;
    
    @FindBy(id = "btn-90") WebElement btnEventosLog;
    
    @FindBy(xpath = "//*[@id=\"notices-user\"]") WebElement btnNotificacoes;
    
    @FindBy(id = "users-menu-lower-right") WebElement btnMenuUsuarios;
    
    @FindBy(className = "mdl-navigation mdl-layout--large-screen-only") WebElement botoesMenu;
    
    @FindBy(id = "btnLogout") WebElement btnLogout;
    
    
    public Menu(WebDriver driver) {
        super(driver);
    }
        
    public NewAccountPage goToNewAccount() {
        clickMenuOption(btnAddNovaConta);
        return new NewAccountPage(driver);
    }

    public UserAndAccessesPage goToUserAccesses() {
        btnUsuariosEAcessos.click();
        return new UserAndAccessesPage(driver);
    }    
   
    public HomePage goToHome() {
        clickMenuOption(btnBuscaHome);
        return new HomePage(driver);
    } 
    
    public Menu goToMenuUsuarios(){
        btnMenuUsuarios.click();
        waitUntilCanBeClicked(By.id("btnLogout"));
        return this;
    }
    
    public ItemsPage goToItems(){
        btnItensECustomizacoes.click();
        return new ItemsPage(driver);
    }
    
    public LoginPage clickLogoutButton () {
        btnLogout.click();
        waitUntilCanBeClicked(By.className("toast"));
        return new LoginPage(driver);
    }

    
    public NotificationPage goToNotifications(){
        clickMenuOption(btnNotificacoes);
        return new NotificationPage(driver);
    }
    
    public HomePage goToSearch(){
        btnBuscaHome.click();
        return new HomePage(driver);
    }
    
    public EventPage goToEvents(){
        btnEventosLog.click();
        return new EventPage(driver);
    }
    
    
    
       
    private void clickMenuOption(WebElement menuOption) {
        //menu hides the options -- responsive page
        if(! menuOption.isDisplayed()) {
            botoesMenu.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.elementToBeClickable(menuOption) );
        menuOption.click();
    }
    
}
