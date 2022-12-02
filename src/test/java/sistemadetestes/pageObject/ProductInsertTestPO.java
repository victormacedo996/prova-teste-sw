package sistemadetestes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInsertTestPO extends BasePO {

    @FindBy(xpath = "/html/body/div/div[2]/table/thead/tr")
    public WebElement tableHeader;

    @FindBy(xpath = "//*[@id=\"btn-adicionar\"]")
    public WebElement buttonCriar;

    @FindBy(xpath = "//*[@id=\"btn-salvar\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"btn-sair\"]")
    public WebElement exitButton;

    @FindBy(xpath = "//*[@id=\"mensagem\"]")
    public WebElement spanMensagem;

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

    @FindBy(xpath = "//*[@id=\"cadastro-produto\"]/div/div/div[1]/h4")
    public WebElement modalTitle;

    /**
	 * Método que tenta executar a ação de cadastrar
     * um novo produto no sistema
	 * @param codigo codigo do produto
	 * @param nome nome do produto a ser cadastrado
     * @param quantidade quantidade do produto a ser cadastrada
     * @param valor valor do produto cadastrado
     * @param data data de cadastro do produto
	 * */
    public void cadastrarProduto(String codigo, String nome, String quantidade, String valor, String data){
        this.openCadastrarProduto();
        this.escrever(this.inputCodigo, codigo);
        this.escrever(this.inputNome, nome);
        this.escrever(this.inputQuantidade, quantidade);
        this.escrever(this.inputValor, valor);
        this.escrever(this.inputData, data);
        this.saveButton.click();
        this.exitButton.click();
    }

    /**
	 * Construtor padrão para criação de uma nova instância da página de cadastro do produto
	 * @param driver Driver da página de cadastro do produto
	 * */
    public ProductInsertTestPO(WebDriver driver){
        super(driver);
    }

    /**
     * Método para se capturar a primeira coluna de cabeçalho da tabela de cadastro de produto
     * @return Código (nome da coluna)
     */
    public String getFirstHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[1]")).getText();
    }


    /**
     * Método para se capturar a segunda coluna de cabeçalho da tabela de cadastro de produto
     * @return Nome (nome da coluna)
     */
    public String getSecondHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[2]")).getText();
    }

    /**
     * Método para se capturar a terceira coluna de cabeçalho da tabela de cadastro de produto
     * @return Quantidade (nome da coluna)
     */
    public String getThirdHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[3]")).getText();
    }

    /**
     * Método para se capturar a quarta coluna de cabeçalho da tabela de cadastro de produto
     * @return Value (nome da coluna)
     */
    public String getFourtheaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[4]")).getText();
    }

    /**
     * Método para se capturar a quinta coluna de cabeçalho da tabela de cadastro de produto
     * @return Create date (nome da coluna)
     */
    public String getFifthHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[5]")).getText();
    }

    
    /**
	 * Construtor padrão para criação de uma nova instância da página de cadastro do produto
	 * @param input elemento o qual será feito o input
     * @param texto texto que será inputado
	 * */
    public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto);
	}

    /**
     * Método responsável por abrir o modal de cadastro de produto
     */
    public void openCadastrarProduto(){
        buttonCriar.click();
        buttonCriar.click();
    }

    /**
     * Método responsável por obter a mensagem de erro quando o usuário tenta cadastrar um
     * novo produto com algum valor inválido
     * @return mensagem de erro
     */
    public String obterMensagem(){
        return spanMensagem.getText();
    }


}
