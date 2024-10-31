package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroAlertasService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroAlertasSteps {

    CadastroAlertasService cadastroAlertasService = new CadastroAlertasService();

    @Dado("que eu tenha os seguintes dados do alerta:")
    public void queEuTenhaOsSeguintesDadosDoAlerta(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroAlertasService.setFieldsAlerta(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de registro de alertas")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeAlertas(String endPoint) {
        cadastroAlertasService.createDelivery(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroAlertasService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = cadastroAlertasService.gson.fromJson(
                cadastroAlertasService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @Dado("que eu recupere o ID do alerta criado no contexto")
    public void queEuRecupereOIDDoAlertaCriadaNoContexto() {
        cadastroAlertasService.retrieveIdAlerta();
    }
    @Quando("eu enviar a requisição com o ID para o endpoint {string} de deleção de alerta")
    public void euEnviarARequisiçãoComOIDParaOEndpointDeDeleçãoDeAlerta(String endPoint) {
        cadastroAlertasService.deleteAlerta(endPoint);
    }

    @E("que o arquivo de contrato esperado é o {string}")
    public void queOArquivoDeContratoEsperadoÉO(String contract) throws IOException {
        cadastroAlertasService.setContract(contract);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoDeveEstarEmConformidadeComOContratoSelecionado() throws IOException {
        Set<ValidationMessage> validateResponse = cadastroAlertasService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}