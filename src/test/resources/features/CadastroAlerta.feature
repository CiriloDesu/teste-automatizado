# language: pt
@regressivo
Funcionalidade: Cadastro de novo alerta
  Como usuário da API
  Quero cadastrar um novo alerta
  Para que o registro seja salvo corretamente no sistema

  Cenário: Registro bem-sucedido de alerta
    Dado que eu tenha os seguintes dados do alerta:
      | campo          | valor        |
      | numeroAlerta   | 1            |
      | localAlerta    | São Paulo    |
      | statusAlerta   | MEDIO_RISCO  |
      | dataAlerta     | 2024-10-31   |
    Quando eu enviar a requisição para o endpoint "/alertas" de registro de alertas
    Então o status code da resposta deve ser 201

  @padrão
  Cenário: Registro de alerta sem sucesso ao passar o campo statusAlerta invalido
    Dado que eu tenha os seguintes dados do alerta:
      | campo          | valor        |
      | numeroAlerta   | 1            |
      | localAlerta    | São Paulo    |
      | statusAlerta   | INOFENSIVO   |
      | dataAlerta     | 2024-10-31   |
    Quando eu enviar a requisição para o endpoint "/alertas" de registro de alertas
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro da api deve retornar a mensagem "Dados fornecidos estão em formato inválido."









