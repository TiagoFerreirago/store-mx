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
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependencia-config0server.png" width="200" />
### Discovery-Server
- URL base do Eureka Server: http://localhost:9000/
#### Configuração básica:
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/application-discovery.png" width="200" />
#### Propósito do Eureka:
-  O Service Discovery intermedia as chamadas entre microserviços, fornecendo informações dinâmicas sobre os serviços registrados. Ele mantém um cache temporário das instâncias disponíveis e facilita o balanceamento de carga, garantindo a distribuição eficiente de requisições entre as instâncias.
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/Spring-Eureka.png" width="200" />
#### Dependencias:
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/application-discovery.png" width="200" />
------------------------------------------------------------------------------------------------------------------------
### Gateway
- URL base: http://localhost:8080/
#### Endpoint Health:
  - GET /actuator
  - GET /actuator/health
#### Configuração básica:
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/app-gateway2.png" width="200" />
#### Propósito do Gateway:
- Gateway esta atuando como um ponto central de entrada para os microserviços, gerenciando requisições de forma eficiente e segura. Ele simplifica a comunicação entre clientes (como frontend ou aplicativos móveis) e os serviços backend.
#### Rotas:
| Path   | Serviço       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `/product/**`      | `Product-Catalog	` | Rota para gerenciamento de produtos.|
| `/cart/**	`      | `Shopping-Cart` |Rota para gerenciamento do carrinho.|
#### Dependencias:
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependecia-gateway-part1.png" width="200" />
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependecia-gateway-part2.png" width="200" />


