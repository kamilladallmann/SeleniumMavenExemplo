/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.tests;

import br.edu.utfpr.po.CustomersPage;
import br.edu.utfpr.po.EventPage;
import br.edu.utfpr.po.HomePage;
import br.edu.utfpr.po.ItemsPage;
import br.edu.utfpr.po.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author kamil
 */
public class CT08EventLog {
    
    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
      
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);   
        driver.manage().window().maximize();
        driver.get("http://192.168.15.9");
        
        LoginPage login = new LoginPage(driver); 
        login.setUsuario("teste").setSenha("utfpr").login();
        
    }
    
    @After
    public void after() {
        driver.close();
    }
        
    
     @Test
     public void testEventLog(){
        HomePage home = new HomePage(driver); 
        EventPage event = home.getMenu().goToEvents();
        assertTrue(event.eventoExiste("1"));
     }
     
    
}
