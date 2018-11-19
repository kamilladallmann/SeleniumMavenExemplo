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

/**
 *
 * @author kamil
 */
public class EventPage extends SysPassBasePage {
    
    public EventPage(WebDriver driver) {
        super(driver);
    }
    
  public boolean eventoExiste (String numero) {
        List<WebElement> eventos = 
                driver.findElements(By.xpath("//tbody[@id = 'resSearch']/tr/td[contains(text(), '" + numero + "')]"));
        return eventos.size() > 0;
    }  
    
    
}
