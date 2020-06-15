package com.proyectoUno.BaseSelenium;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompraSmartTv {
	
	Logger logger=Logger.getLogger("CompraSmartTv");  
	private WebDriver driver;
	
	@Before
	public void setUp () {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriverV83.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://simple.ripley.cl/");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@Test
	public void testCompraSmartTv () throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement IconLogin = driver.findElement(By.xpath("//*[@id=\"ripley-sticky-header\"]/section/nav/ul/li[2]/div/div/a/span"));
		IconLogin.click();
		Thread.sleep(2000);
		logger.info("Dar Click a span Iniciar Sesion");
		
		Thread.sleep(2000);
		WebElement TxtRut = driver.findElement(By.name("ws_username"));
		TxtRut.sendKeys("11967937-0");
		Thread.sleep(2000);
		logger.info("Se ingresa el rut");
		
		
		if(TxtRut.getText().length() >= 10){
			logger.info("Largo de rut no válido");
	    }else {
	    	
	    	logger.info("Largo de rut válido");
	    	
	    }
				
		
		Thread.sleep(2000);
		WebElement TxtPass = driver.findElement(By.name("password"));
		TxtPass.sendKeys("pperez2020");
		Thread.sleep(2000);
		logger.info("Se ingresa la contraseña");
		
		Thread.sleep(2000);
		WebElement BtnIniciaSesion = driver.findElement(By.id("inicio-sesion-ripley"));
		BtnIniciaSesion.click();
		Thread.sleep(2000);
		logger.info("Se da click en BTN Iniciar Sesion");
		
		Thread.sleep(2000);
		WebElement BtnNoGracias = driver.findElement(By.id("onesignal-popover-cancel-button"));
		BtnNoGracias.click();
		Thread.sleep(2000);
		logger.info("Se da click en BTN No Gracias del mensaje de dialogo");
		
		Thread.sleep(2000);
		WebElement SearchBox = driver.findElement(By.cssSelector(".js-search-bar"));
		SearchBox.click();
		SearchBox.sendKeys("smart TV samsung");
		SearchBox.submit();
		Thread.sleep(3000);
		logger.info("Se busca smart TV samsung");
		
		//OJOO No consigue elemento
		Thread.sleep(2000);
		//WebElement LinkSmartTv = driver.findElement(By.id("2000378039990P"));
		//WebElement LinkSmartTv = driver.findElement(By.xpath("//*[@data-partnumber='2000378039990P']"));
		WebElement LinkSmartTv = driver.findElement(By.xpath("//*[@id=\"2000378039990P\"]/div[2]/div[1]/div/div"));
		LinkSmartTv.click();
		Thread.sleep(2000);
		logger.info("Hacer click en el link LED SAMSUNG UN55NU7095 UHD SMART TV 55”");
		
		Thread.sleep(2000);
		WebElement BtnAgregarBolsa = driver.findElement(By.id("buy-button"));
		BtnAgregarBolsa.click();
		Thread.sleep(2000);
		logger.info("Se da click en BTN Agregar a la Bolsa");
		
		Thread.sleep(2000);
		WebElement BtnContinuar = driver.findElement(By.xpath("//*[@id=\"modal-container\"]/div/div/div[2]/div/div/div[3]/button"));
		BtnContinuar.click();
		Thread.sleep(2000);
		logger.info("Se da click en BTN continuar del modal garantia extendida");
		
	}
	
	@After
	public void tearDown () {
		driver.quit();
		logger.info("End Page");
	}
}
