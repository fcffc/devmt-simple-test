package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// Elementos da página

	@FindBy(css = "a[href='http://www.seleniumhq.org/']")
	@CacheLookup
	private WebElement linkDocumentacaoSelenium;

	@FindBy(id = "reg:email")
	@CacheLookup
	private WebElement txtEmail;

	@FindBy(css = "a[href='https://www.github.com/fcffc/']")
	@CacheLookup
	private WebElement linkGithub;

	@FindBy(id = "reg:name")
	@CacheLookup
	private WebElement txtNome;

	@FindBy(xpath = "//input[@id='reg:phoneNumber']")
	@CacheLookup
	private WebElement txtTelefone;

	@FindBy(xpath = "html/body/div[1]/div[2]/table/tbody/tr/td[3]")
	@CacheLookup
	private WebElement emailRegistrado;

	@FindBy(id = "reg:register")
	@CacheLookup
	private WebElement btnRegistrar;

	@FindBy(className = "valid")
	@CacheLookup
	WebElement mensagemValida;

	@FindBy(className = "invalid")
	@CacheLookup
	WebElement mensagemInvalida;

	@FindBy(xpath = "//table[@class='simpletablestyle']/tbody/tr[2]/td[5]/a")
	@CacheLookup
	WebElement registro1;

	// Métodos com ações da página

	public void clickLinkDocumentacao() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(linkDocumentacaoSelenium));
		linkDocumentacaoSelenium.click();
	}

	public void clickLinkGithub() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(linkGithub));
		linkGithub.click();
	}

	public void setEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		txtEmail.sendKeys(email);
	}

	public void clicklinkGithub() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(linkGithub));
		linkGithub.click();
	}

	public void setNome(String nome) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(txtNome));
		txtNome.sendKeys(nome);
	}

	public void setTelefoone(String telefone) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(txtTelefone));
		txtTelefone.sendKeys(telefone);
	}

	public void clickBtnRegistrar() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnRegistrar));
		btnRegistrar.click();
	}

	// Metodos com verificação da páginas

	public void verifyEmailRegistrado(String emailReg) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(emailRegistrado));
		// String txt = emailRegistrado.getText();
		// System.out.println("Email:" + txt + "-");
		Assert.assertTrue(emailRegistrado.getText().equals(emailReg));

	}

	public void verifyMsgValida(String msgValida) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(mensagemValida));
//		String txt = mensagemValida.getText();
//		System.out.println("Sucesso:" + txt + "-");
		Assert.assertTrue(mensagemValida.getText().equals(msgValida));
	}

	public void verifyMsgInvalida(String msgInvalida) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(mensagemInvalida));
		Assert.assertTrue(mensagemInvalida.getText().equals(msgInvalida));
	}

	public void registroExistente() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(registro1));
	}

	// Auxiliar

	public void encerraSessao() {
		driver.quit();
	}
}
