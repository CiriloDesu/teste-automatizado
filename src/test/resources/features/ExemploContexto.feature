# language: pt
@regressivo
Funcionalidade: Deletar uma entrega
  Como usuário da API
  Quero conseguir deletar uma entrega
  Para que o registro seja apagado corretamente no sistema

  Contexto: Cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados do alerta:
      | campo          | valor        |
      | numeroAlerta   | 1            |
      | localAlerta    | São Paulo    |
      | statusAlerta   | MEDIO_RISCO  |
      | dataAlerta     | 2024-10-31   |
    Quando eu enviar a requisição para o endpoint "/alertas" de registro de alertas
    Então o status code da resposta deve ser 201

  Cenário: Deve ser possível deletar uma entrega
    Dado que eu recupere o ID do alerta criado no contexto
    Quando eu enviar a requisição com o ID para o endpoint "/alertas" de deleção de alerta
    Então o status code da resposta deve ser 204