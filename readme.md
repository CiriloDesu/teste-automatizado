# Projeto de Testes Automatizados

Este projeto é uma aplicação de testes automatizados desenvolvida em Java, utilizando Spring Boot e Docker. O objetivo é realizar testes de API e BDD (Behavior-Driven Development) para validar a comunicação entre serviços.

## Índice

- [Requisitos](#requisitos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Iniciar a Aplicação](#como-iniciar-a-aplicação)
- [Executando a Aplicação](#executando-a-aplicação)
- [Executando os Testes](#executando-os-testes)
- [Documentação Adicional](#documentação-adicional)

## Requisitos

- [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) ou superior
- [Maven](https://maven.apache.org/) instalado
- [Docker](https://www.docker.com/get-started) instalado (se você quiser rodar a aplicação em um contêiner)

## Tecnologias Utilizadas

- **Spring Boot**: Para desenvolvimento da API REST.
- **Docker**: Para criação e gestão de contêineres.

## Estrutura do Projeto

```plaintext
teste-automatizado/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── Dockerfile
├── monitoramento_ambiental.zip
└── README.md
````
## Instalação e Configuração
1.Clone o Repositório
Clone este repositório em sua máquina local:


Copiar código
```bash
git clone https://github.com/CiriloDesu/teste-automatizado.git
cd teste-automatizado
```

2. Configurar Variáveis de Ambiente
Se necessário, configure suas variáveis de ambiente no arquivo .env.

## Como Iniciar a Aplicação
###1. Com Maven
Para iniciar a aplicação localmente, você pode usar o Maven. Execute os seguintes comandos:


Copiar código
```bash
mvn clean package
java -jar target/teste-automatizado-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em http://localhost:8080.


2. Com Docker
Caso você tenha configurado o Docker, você pode construir a imagem e iniciar o contêiner:


Copiar código
```bash
docker build -t teste-monitoramento .
docker run -p 8080:8080 teste-monitoramento
```
A aplicação estará disponível em http://localhost:8080.

## Executando os Testes
Para executar os testes automatizados, use o seguinte comando:


Copiar código
```bash
mvn test
```

Os resultados dos testes serão exibidos no console.




## Documentação Adicional
Você pode visualizar o documento de captura de tela aqui.
![image](https://github.com/user-attachments/assets/f1d34c1a-ba1a-4729-95b3-4d7d183bde90)

![image](https://github.com/user-attachments/assets/6a4a2ae5-199a-48e4-8448-961b7e99ea55)

![image](https://github.com/user-attachments/assets/d097bc0c-1202-4b7a-975f-1909693def5c)




