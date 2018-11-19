/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.tests;

import br.edu.utfpr.po.CustomersPage;
import br.edu.utfpr.po.HomePage;
import br.edu.utfpr.po.ItemsPage;
import br.edu.utfpr.po.LoginPage;
import br.edu.utfpr.po.NewAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
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

public class CT05CreateAccount {
    
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
     public void testCreateCategory(){
        HomePage home = new HomePage(driver); 
        ItemsPage items = home.getMenu().goToItems();
        items
                .addNovaCategoria()
                .setNomeCategoria("Categoria1")
                .setDescricaoCategoria("categoria 1 teste")
                .salvarCategoria();
     }
     
     @Test
     public void testCreateCustomer(){
        HomePage home = new HomePage(driver); 
        ItemsPage items = home.getMenu().goToItems();
        
        CustomersPage customers = items.goToCustomer();
        customers
                .addNovoCustomer()
                .setNomeCustomer("UTFPR")
                .setDescricaoCustomer("UTFPR teste")
                .salvaCustomer();
     }
     
    @Test
    public void testCreateNewAccount(){
        
        HomePage home = new HomePage(driver);      
              
        NewAccountPage account = home.getMenu().goToNewAccount();
            account
                    .setName("novaContaTeste")
                    .setCustomer("UTFPR")
                    .setCategory("Categoria1")
                    .setUser("kamilladallmann")
                    .setPass("user7890")
                    .setPassAgain("user7890")
                    .setData("05012019");                         
        
            assertTrue(account.OperacaoRealizadaComSucesso());
    }
    
}
