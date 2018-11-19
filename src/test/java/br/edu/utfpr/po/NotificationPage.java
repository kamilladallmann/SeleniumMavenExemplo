/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.po;

import java.util.List;
import javafx.scene.chart.PieChart.Data;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author kamil
 */
public class NotificationPage extends SysPassBasePage {
    
    public NotificationPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "btn-add-7611") WebElement btnAddNot;
    
    @FindBy(id = "notice_type") WebElement tipoNot;
    
    @FindBy(id = "notice_component") WebElement componenteNot;
    
    @FindBy(xpath = "//*[@id=\"notice_description\"]") WebElement descricaoNot;
    
    @FindBy(id = "notice_user-selectized") WebElement selecionaUser;
    
    @FindBy(xpath = "//*[@id=\"frmNotices\"]/table/tbody/tr[5]/td[2]/label/span[2]") WebElement checkGlobal;
    
    @FindBy(xpath = "//*[@id=\"box-popup\"]/div/button") WebElement btnSalvar; 
    
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/header/div[2]/nav/span[7]") WebElement mensagem;
    
    @FindBy(id = "btn-action-14-7614") WebElement btnVisualizar;
    
    @FindBy(xpath = "//*[@id=\"btn-action-14-7612\"]") WebElement btnEditar;
    
    @FindBy(xpath = "//*[@id=\"btn-action-14-7613\"]") WebElement btnExcluir;
    
    @FindBy(xpath = "//*[@id=\"data-table-tblNotices\"]/table/thead/tr/th[1]/label/span[3]") WebElement checkNot;
 
    @FindBy(xpath = "//*[@id=\"btn-search-0\"]") WebElement btnSearch;
    
    @FindBy(xpath = "//*[@id=\"search-0\"]") WebElement itemSearch;
    
    @FindBy(xpath = "//*[@id=\"data-table-tblNotices\"]") List<WebElement> linhas;
    
    @FindBy(xpath = "//*[@id=\"tblNotices-menu-lower-right\"]") WebElement options;
    
    @FindBy(xpath = "//*[@id=\"tabs-0\"]/div[1]/ul/li[4]/div") WebElement deleteSelected;
    
    @FindBy(xpath = "//*[@id=\"positive\"]") WebElement btnAceita;
    
    public boolean notificacaoExiste (String nome) {
        List<WebElement> notificacoes = 
                driver.findElements(By.xpath("//tbody[@id = 'data-rows-tblNotices']/tr/td[contains(text(), '" + nome + "')]"));
        return notificacoes.size() > 0;
    }    
      
   
    public NotificationPage moreOptions(){
        options.click();
        //waitUntilCanBeClicked(By.className("btn-action mdl-menu__item mdl-js-ripple-effect"));
        return this;
    }
    
     public NotificationPage deleteTeste(){
        deleteSelected.click();
        //waitUntilCanBeClicked(By.className("toast"));
        return this;
    }
     
     
    public int getNumberOfLines(){
        return linhas.size();
    }
    
    public NotificationPage search(){
        btnSearch.click();
        return this;
    }
    
    public NotificationPage itemPesquisa(String pesquisa){
        itemSearch.sendKeys(pesquisa);
        itemSearch.sendKeys(Keys.ENTER);
        return this;
    }
    
    public NotificationPage aceitarAlerta(){
        btnAceita.click();
        return this;
    }
    
    
    public NotificationPage viewNotice(){
        btnVisualizar.click();
        return this;
    }
    
    public NotificationPage editNotice(){
        btnEditar.click();
        return this;
    }
    
    public NotificationPage deleteNotice(){
        btnExcluir.click();
        return this;
    }
    
    public NotificationPage checkAllNotice(){
        checkNot.click();
        return this;
    }
    
    public NotificationPage addNotification(){
        btnAddNot.click();
        return this;
    }
    
    public NotificationPage setTipo(String tipo){
        tipoNot.sendKeys(tipo);
        return this;
    }
    
    public NotificationPage setComponente(String comp){
        componenteNot.sendKeys(comp);
        return this;
    }
    
    public NotificationPage setDescricao(String desc){
        descricaoNot.sendKeys(desc);
        return this;
    }
    
    public NotificationPage selectUser(String user){
        selecionaUser.sendKeys(user);
        selecionaUser.sendKeys(Keys.ENTER);
        return this;
    }
    
    public NotificationPage checkGlobal(){
        checkGlobal.click();
        return this;
    }
    
    public NotificationPage salvaNotificacao(){
        btnSalvar.click();
        return this;
    }
    
    public NotificationPage msgNovaNotificacao(){
        mensagem.getText();
        return this;
    }
    
    public boolean OperacaoRealizadaComSucesso(){
        List<WebElement> success = driver.findElements(By.className("toast-success"));
        return success.size() > 0;
    }
    
    
    
    
    
    
    
}
