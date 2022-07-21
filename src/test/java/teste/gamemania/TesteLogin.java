package teste.gamemania;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	private WebDriver driver; 
	
	@Before
	public void  ConfigurarTeste () {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[5]")).click();
	}
	@Test
	public void  TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("password"));
		WebElement botao = driver.findElement(By.xpath("//*[@id=\"formloguin\"]/input[3]"));
		
		String[] listaEmails = {"caique@email.com","adriano@email.com", "adriano@email.com"};
		String[] listaSenhas = {"senhaaleatoria","senhaaleatoria", "senhadoadriano"};
		
		try {
			for(int contador = 0; contador < 3; contador++) {
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listaSenhas[contador]);
				botao.click();
				
				Thread.sleep(3000);
				campoEmail.clear();
				campoSenha.clear();
			}
			
			/*
			//caso de teste de email incorreto
			campoEmail.sendKeys("caique@email.com");
			campoSenha.sendKeys("senhaaleatoria");
			botao.click();
			
			Thread.sleep(3000);
			campoEmail.clear();
			campoSenha.clear();
			
			//caso de teste de senha incorreta
			campoEmail.sendKeys("adriano@email.com");
			campoSenha.sendKeys("senhaaleatoria");
			botao.click();
			
			Thread.sleep(3000);
			campoEmail.clear();
			campoSenha.clear();
			
			//caso de teste usuario correto
			campoEmail.sendKeys("adriano@email.com");
			campoSenha.sendKeys("senhadoadriano");
			botao.click();
			
			Thread.sleep(5000);
			
			*/
			
		} catch(InterruptedException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@After
	public void EncerrarTeste() {
		driver.quit();
		
	}
}
