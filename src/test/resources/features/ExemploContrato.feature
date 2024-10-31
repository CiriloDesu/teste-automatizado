# language: pt
@regressivo
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido de entrega
  Como usuário da API
  Quero cadastrar uma nova entrega bem-sucedido
  Para que eu cosniga validar se o contrato esta conforme o esperado

  Cenario: Validar contrato do cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados do alerta:
      | campo          | valor        |
      | numeroAlerta   | 1            |
      | localAlerta    | São Paulo    |
      | statusAlerta   | MEDIO_RISCO  |
      | dataAlerta     | 2024-10-31   |
    Quando eu enviar a requisição para o endpoint "/alertas" de registro de alertas
    Então o status code da resposta deve ser 201
    E que o arquivo de contrato esperado é o "Cadastro de alerta criado com sucesso"
    Então a resposta da requisição deve estar em conformidade com o contrato selecionado
