package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import sistemadetestes.pageObject.LoginPO;
import sistemadetestes.pageObject.ProductInsertTestPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductInsertTest extends BaseTest {

    private static ProductInsertTestPO productInsertTestPO;
    private static LoginPO loginPo;

    @BeforeClass
	public static void prepararTestes() {
        loginPo = new LoginPO(driver);
		productInsertTestPO = new ProductInsertTestPO(driver);
        loginPo.executarAcaoDeLogar("admin@admin.com", "admin@123");
	}

    @Test
    public void TC001_CabecalhoPadronizado(){

        String fistColumn = productInsertTestPO.getFirstHeaderColumn();
        String secondColumn = productInsertTestPO.getSecondHeaderColumn();
        String thirdColumn = productInsertTestPO.getThirdHeaderColumn();
        String fourthColumn = productInsertTestPO.getFourtheaderColumn();
        String fifthColumn = productInsertTestPO.getFifthHeaderColumn();

        assertEquals(fistColumn, "Código");
        assertEquals(secondColumn, "Nome");
        assertEquals(thirdColumn, "Quantidade");
        assertEquals(fourthColumn, "Valor");
        assertEquals(fifthColumn, "Data de Criação");
    }


    @Test
    public void TC002_LetraNoPreco(){
        productInsertTestPO.openCadastrarProduto();
        productInsertTestPO.cadastrarProduto("1", "borracha", "1", "a", "08-20-1985");
        String mensagem = productInsertTestPO.obterMensagem();
        assertEquals(mensagem, "A quantidade deve ser um número");
    }

    @Test
    public void TC003_DataFormat(){
        productInsertTestPO.cadastrarProduto("1", "lápis", "1", "1.5", "20-20-1985");
        String mensagem = productInsertTestPO.obterMensagem();
        assertEquals(mensagem, "A data deve estar no formato mês/dia/ano (mm/dd/aaaa)");
    }

    @Test
    public void TC004_ProdutoCadastrado(){
        productInsertTestPO.cadastrarProduto("1", "Caneta", "1", "1.5", "02-20-2020");
        List<WebElement> tableRow = productInsertTestPO.insertedData.findElements(By.tagName("td"));
        String codigo = tableRow.get(0).getText();
        String nome = tableRow.get(1).getText();
        String quantity = tableRow.get(2).getText();
        String value = tableRow.get(3).getText();
        String creationDate = tableRow.get(4).getText();

        assertEquals(codigo, "1");
        assertEquals(nome, "Caneta");
        assertEquals(quantity, "1");
        assertEquals(value, "1.5");
        assertEquals(creationDate, "2020-02-20");
    }

    @Test
    public void TC005_ValorDecimalSeparadoPorPonto(){
        productInsertTestPO.cadastrarProduto("1", "Caneta", "1", "1,5", "02-20-2020");
        String mensagem = productInsertTestPO.obterMensagem();
        assertEquals(mensagem, "Os numeros decimais do valor devem ser separados por ponto, não por vírgula");
    }

    @Test
    public void TC006_AbrirCadastrarProduto(){
        productInsertTestPO.buttonCriar.click();
        String modalTitle = productInsertTestPO.modalTitle.getText();

        assertEquals(modalTitle, "Produto");
    }
    
}
