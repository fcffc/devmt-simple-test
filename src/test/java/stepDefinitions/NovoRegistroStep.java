package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.HomePage;

public class NovoRegistroStep {

	WebDriver driver;	

	@Given("^eu estou na home page dos sistema$")
	public void eu_estou_na_home_page_dos_sistema(DataTable tabela) throws Throwable {

		List<List<String>> table = tabela.raw();
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumWebdrivers/chromedriver.exe");
		// System.setProperty("webdriver.ie.driver", "C:/SeleniumWebdrivers/IEDriverServer.exe");
		// System.setProperty("webdriver.gecko.driver", "C:/SeleniumWebdrivers/geckodriver.exe");
		// System.setProperty("phantomjs.binary.path", "C:/Selenium/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		driver = new ChromeDriver();
		// driver = new InternetExplorerDriver();
		// driver = new FirefoxDriver();
		// driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		driver.get(table.get(1).get(1));
	}

	@When("^eu informo o nome$")
	public void eu_informo_o_nome() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.setNome("Fernanda Teste");
	}

	@When("^eu informo o email corretamente$")
	public void eu_informo_o_email_corretamente() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.setEmail("email@email.com");

	}

	@When("^eu informo o telefone$")
	public void eu_informo_o_telefone() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.setTelefoone("65993403434");

	}

	@When("^eu clico no botao de registro$")
	public void eu_clico_no_botao_de_registro() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickBtnRegistrar();

	}

	@Then("^o registro eh realizado com sucesso$")
	public void o_registro_eh_realizado_com_sucesso() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.verifyMsgValida("Registrado com sucesso.");

	}

	@Then("^eu visualizo o novo membro registrado na listagem do sistema$")
	public void eu_visualizo_o_novo_membro_registrado_na_listagem_do_sistema() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.registroExistente();
		home.encerraSessao();
	}

	@Given("^jah exista algum membro resgistrado no sistema$")
	public void jah_exista_algum_membro_resgistrado_no_sistema() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.verifyEmailRegistrado("fernanda.ferreira@sigma.com.br");

	}

	@When("^eu informo o email jah existente$")
	public void eu_informo_o_email_jah_existente(DataTable tabela) throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		List<List<String>> table = tabela.raw();
		home.setEmail(table.get(1).get(1));

	}

	@Then("^eu recebo a mensagem de validacao$")
	public void eu_recebo_a_mensagem_de_validacao(DataTable tabela) throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		List<List<String>> table = tabela.raw();
		home.verifyMsgInvalida(table.get(1).get(1));
		home.encerraSessao();
	}

}