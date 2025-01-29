# Store-MX

## DOCUMENTAÇÃO

### Config-Server:
- URL Base: http://localhost:8888
- Suporta configuração via Git no repositório: https://github.com/TiagoFerreirago/store-mx/tree/main
- Formato: .yml
#### Endpoint Acesso:
  - GET /{application.yml}/default:
#### Endpoint Health:
  - GET /actuator
  - GET /actuator/health
#### Dependencias:
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependencia-config0server.png" width="500" heigth="250" />
<h3>Discovery-Server</h3>  

+ URL base do Eureka Server: http://localhost:9000/
<h4>Configuração básica:</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/application-discovery.png" width="500" heigth="250" />
<h4>Propósito do Eureka:</h4>

-  O Service Discovery facilita as chamadas entre microserviços, fornecendo informações dinâmicas sobre os serviços registrados. Ele mantém um cache temporário das instâncias disponíveis e facilita o balanceamento de carga, garantindo a distribuição eficiente de requisições entre as instâncias.
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/Spring-Eureka.png" width="800" heigth="800" />
<h4>Dependencias:</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/application-discovery.png" width="500" heigth="250" />

<h3>Gateway</h3>

- URL base: http://localhost:8080/
<h4>Endpoint Health:</h4>

  - GET /actuator
  - GET /actuator/health
<h4>Configuração básica:</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/app-gateway2.png" width="500" heigth="250" />
<h4>Propósito do Gateway:</h4>

- Gateway está atuando como um ponto central de entrada para os microserviços, gerenciando requisições de forma eficiente e segura. Ele simplifica a comunicação entre clientes (como frontend ou aplicativos móveis) e os serviços backend.
<h4>Rotas:</h4>

| Path   | Serviço       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `/product/**`      | `Product-Catalog	` | Rota para gerenciamento de produtos.|
| `/cart/**	`      | `Shopping-Cart` |Rota para gerenciamento do carrinho.|
<h4>Dependencias:</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependecia-gateway-part1.png" width="500" heigth="250" />
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependecia-gateway-part2.png" width="500" heigth="250" />


