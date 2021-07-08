package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AtualizarFuncionarioTest {
	
	//atributo
		WebDriver driver;

	@Dado("^Acessar a página de atualização de tipo de contratação$")
	public void acessar_a_página_de_atualização_de_tipo_de_contratação() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();			
		driver.manage().window().maximize();
		driver.get("http://prjfinalteste-001-site1.ctempurl.com/Home/Exercicio02");  
	}

	@Dado("^Selecionar o funcionário desejado \"([^\"]*)\"$")
	public void selecionar_o_funcionário_desejado(String funcionario) {
	   WebElement element = driver.findElement(By.xpath("//*[@id=\"Funcionario\"]"));
	   Select select = new Select(element);
	   select.selectByVisibleText(funcionario);
	   
	}

	@Dado("^Selecionar o tipo de contratação \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contratação(String tipocontratacao) {
	   WebElement element = driver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]"));
	   Select select = new Select(element);
	   select.selectByVisibleText(tipocontratacao);
	     
	}

	@Quando("^Solicitar a atualização do tipo de contratação$")
	public void solicitar_a_atualização_do_tipo_de_contratação() {
	    driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	    
	}

	@Então("^Sistema informa que o tipo de contratação foi atualizado com sucesso$")
	public void sistema_informa_que_o_tipo_de_contratação_foi_atualizado_com_sucesso() {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, "Dados atualizados com sucesso");	     
	}

	@Então("^Sistema informa que os campos são obrigatórios$")
	public void sistema_informa_que_os_campos_são_obrigatórios() {
		String erroFuncionario = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();
		String erroTipocontratacao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();
		assertEquals(erroFuncionario, "Por favor, selecione o funcionário.");
		assertEquals(erroTipocontratacao, "Por favor, informe o tipo de contratação.");
	
	}
	
}
