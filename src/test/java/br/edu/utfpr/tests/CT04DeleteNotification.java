/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.tests;

import br.edu.utfpr.po.HomePage;
import br.edu.utfpr.po.LoginPage;
import br.edu.utfpr.po.Menu;
import br.edu.utfpr.po.MenuUsuariosPage;
import br.edu.utfpr.po.NotificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author kamil
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT04DeleteNotification {
    
    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        /*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
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
    public void testSearchTesteNotification(){

        HomePage home = new HomePage(driver);
        
        NotificationPage notification = home.getMenu().goToNotifications();
        notification
            .search()
            .itemPesquisa("Tipo01");
        
        notification
            .checkAllNotice()
            .moreOptions()
            .deleteTeste()
            .aceitarAlerta(); 
        
        assertTrue(notification.OperacaoRealizadaComSucesso());
        
    }
   
    
}
