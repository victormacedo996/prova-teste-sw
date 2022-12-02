package sistemadetestes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInsertTestPO extends BasePO {

    @FindBy(xpath = "/html/body/div/div[2]/table/thead/tr")
    public WebElement tableHeader;

    @FindBy(xpath = "//*[@id=\"btn-adicionar\"]")
    public WebElement createButton;

    @FindBy(xpath = "//*[@id=\"btn-salvar\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"btn-sair\"]")
    public WebElement exitButton;

    @FindBy(xpath = "//*[@id=\"mensagem\"]")
    public WebElement mensagem;

    @FindBy(xpath = "//*[@id=\"codigo\"]")
    public WebElement inputCodigo;

    @FindBy(xpath = "//*[@id=\"nome\"]")
    public WebElement inputNome;

    @FindBy(xpath = "//*[@id=\"quantidade\"]")
    public WebElement inputQuantidade;

    @FindBy(xpath = "//*[@id=\"valor\"]")
    public WebElement inputValor;

    @FindBy(xpath = "//*[@id=\"data\"]")
    public WebElement inputData;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr")
    public WebElement insertedData;


    public ProductInsertTestPO(WebDriver driver){
        super(driver);
    }

    public String getFirstHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[1]")).getText();
    }

    public String getSecondHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[2]")).getText();
    }

    public String getThirdHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[3]")).getText();
    }

    public String getFourtheaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[4]")).getText();
    }

    public String getFifthHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[5]")).getText();
    }

    public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto);
	}

    public void openCadastrarProduto(){
        createButton.click();
        createButton.click();
    }

    public String obterMensagem(){
        return mensagem.getText();
    }


}
