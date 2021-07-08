package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class AtualizarFuncionarioTest {
	
	//atributo
		WebDriver driver;

	@Dado("^Acessar a p�gina de atualiza��o de tipo de contrata��o$")
	public void acessar_a_p�gina_de_atualiza��o_de_tipo_de_contrata��o() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();			
		driver.manage().window().maximize();
		driver.get("http://prjfinalteste-001-site1.ctempurl.com/Home/Exercicio02");  
	}

	@Dado("^Selecionar o funcion�rio desejado \"([^\"]*)\"$")
	public void selecionar_o_funcion�rio_desejado(String funcionario) {
	   WebElement element = driver.findElement(By.xpath("//*[@id=\"Funcionario\"]"));
	   Select select = new Select(element);
	   select.selectByVisibleText(funcionario);
	   
	}

	@Dado("^Selecionar o tipo de contrata��o \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contrata��o(String tipocontratacao) {
	   WebElement element = driver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]"));
	   Select select = new Select(element);
	   select.selectByVisibleText(tipocontratacao);
	     
	}

	@Quando("^Solicitar a atualiza��o do tipo de contrata��o$")
	public void solicitar_a_atualiza��o_do_tipo_de_contrata��o() {
	    driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	    
	}

	@Ent�o("^Sistema informa que o tipo de contrata��o foi atualizado com sucesso$")
	public void sistema_informa_que_o_tipo_de_contrata��o_foi_atualizado_com_sucesso() {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, "Dados atualizados com sucesso");	     
	}

	@Ent�o("^Sistema informa que os campos s�o obrigat�rios$")
	public void sistema_informa_que_os_campos_s�o_obrigat�rios() {
		String erroFuncionario = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();
		String erroTipocontratacao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();
		assertEquals(erroFuncionario, "Por favor, selecione o funcion�rio.");
		assertEquals(erroTipocontratacao, "Por favor, informe o tipo de contrata��o.");
	
	}
	
}
