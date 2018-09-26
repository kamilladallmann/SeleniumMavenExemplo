package br.edu.utfpr.exemplomaven;


import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kamilladallmann
 */
public class ExemploTest {

    private static int idImage = 0;

    WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");
        
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
    }
    
    @After
    public void after() {
        driver.close();
    }
    
    @Test
    public void testLogin() {
        
        driver.get("https://ration.io/login");
        
        WebElement preencheEmail = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/form/div[1]/input"));
        preencheEmail.sendKeys("kamilla@uenp.edu.br");
        
        WebElement preencheSenha = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/form/div[2]/input"));
        preencheSenha.sendKeys("banana");
        
        WebElement botaoEntra = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/form/div[4]/button"));
        botaoEntra.click();
        
    }
        
    private void takeScreenShot() {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            idImage++;
            FileUtils.copyFile(sourceFile, new File("./res/" + idImage + ".png"));
        } catch(IOException e) {}
    }
    
    @Test
    public void insereImagem(){
        driver.get("https://ration.io/things");        
        
        WebElement botaoAddAnItem = driver.findElement(By.xpath("//*[@id=\"available-things\"]/div/div[1]/div/button"));
        botaoAddAnItem.click();
        
        WebElement botaoSelectImage = driver.findElement(By.xpath("//*[@id=\"available-things\"]/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/span/input"));
        botaoSelectImage.click();
        botaoSelectImage.sendKeys("/Users/kamil/Documents/UTFPR/TATS/teste.png");
        
        takeScreenShot();
        
        WebElement campoWhatIsIt = driver.findElement(By.xpath("//*[@id=\"available-things\"]/div[2]/div[2]/div/form/div[1]/div[2]/input"));
        campoWhatIsIt.sendKeys("Testando a insercao de imagem");
        
        WebElement botaoShareItem = driver.findElement(By.xpath("//*[@id=\"available-things\"]/div[2]/div[2]/div/form/div[2]/button[1]/span"));
        botaoShareItem.click();
        
        takeScreenShot();        
    }
    
    @Test
    public void testaCadastro(){
        //System.setProperty("webdriver.chrome.driver", "Users/kamil/Documents/UTFPR/TATS");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ration.io/");
        
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"page-header\"]/div/div/a"));
        signUpButton.click();
        
        //check msg:"Please enter your full name."
        //WebElement msgErro1 = driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div[1]/div"));
        //assertEquals("Please enter your full name.", msgErro1.getText().trim());
        
        //check msg:"Please enter a password."
        //WebElement msgErro2 = driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div[3]/div"));
        //assertEquals("Please enter password.", msgErro2.getText().trim());
        
        //fill the name
        WebElement nomeCompleto = driver.findElement(By.id("full-name"));
        nomeCompleto.sendKeys("Kamilla Dallmann Nunes");
        
        //fill e-mail
        WebElement email = driver.findElement(By.id("email-address"));
        email.sendKeys("kamillanunes@alunos.utfpr.edu.br");
        
        //checkbox
        WebElement checkAgreement = driver.findElement(By.id("terms-agreement"));
        checkAgreement.click();
        
        takeScreenShot();
        
        //click on button "create account"
        WebElement botaoConta = driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div[6]/button"));
        botaoConta.click();
        
        takeScreenShot();
        
        /*try{
            msgErro1 = driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div[1]/div"));
            fail();
        }catch(NoSuchElementException e){
            System.out.println("Mensagem de erro nÃ£o encontrada");}
        
        try{
            msgErro2 = driver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/form/div[3]/div"));
            fail();
        }catch(NoSuchElementException e){}
        
        driver.close();
        */
        
      
    }
    
}
