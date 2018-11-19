/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.tests;

import br.edu.utfpr.po.HomePage;
import br.edu.utfpr.po.LoginPage;
import br.edu.utfpr.po.MenuUsuariosPage;
import br.edu.utfpr.po.RequestPasswordChangePage;
import br.edu.utfpr.po.UserAndAccessesPage;
import br.edu.utfpr.po.UsersPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author kamil
 */
public class CT02CreateNewUser {
    
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
    public void testCreateNewUser(){     
        HomePage home = new HomePage(driver); 
         
        UserAndAccessesPage userAc = home.getMenu().goToUserAccesses();
        UsersPage userPage = userAc.accessUser();
        userPage
                .addNovoUsuario()
                .setNome("Kamilla Dallmann Nunes")
                .setLogin("kamilladallmann")
                .setProfile("novoPerfil")
                .setGroup("Admin")
                .setEmail("kamillanunes@alunos.utfpr.edu.br")
                .setPassword("user123")
                .confirmPassword("user123")
                .setNotes("testando a criação de um novo usuário")
                .checkBoxesUser()
                .salvarUsuario();
        
        assertTrue(userPage.nomeExiste("Kamilla Dallmann Nunes"));    
       
    }
 }
