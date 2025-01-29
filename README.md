# Store-MX

## Product Catalog API

### Descrição

Este é um microserviço para gestão de produtos, permitindo adicionar novos produtos ao sistema e realizar buscas detalhadas por produtos registrados. Ele foi construído com Java 17, Spring Boot 3.4.1 e Elasticsearch para indexação e busca rápida.

### Funcionalidades

- **Adicionar produtos:** Você pode adicionar novos produtos ao catálogo.

- **Buscar produtos:** Realizar buscas detalhadas por produtos através da API.

- **Elasticsearch:** Utiliza Elasticsearch para indexação e pesquisa eficiente dos produtos.

### Tecnologias utilizadas
- **Java 17:** A versão utilizada.

- **Spring Boot 3.4.1:** Framework para criação de microserviços.

- **Elasticsearch:** Para indexação e buscas de dados em tempo real.
- **Swagger/OpenAPI:** Para documentação da API.

- **JPA Repositories:** Utiliza o Spring Data Elasticsearch para persistir dados.

### Pré-requisitos

Antes de rodar o projeto, você precisa ter as seguintes dependências instaladas:

- **Java 17** ou superior
- **Elasticsearch** rodando localmente ou remotamente (```porta padrão: 9200```)
- **Maven** ou **Gradle** para gerenciar dependências

### Como rodar localmente

1. Clone este repositório:

```bash
git clone https://github.com/SEU_USUARIO/product-catalog.git
cd product-catalog
```

2. Certifique-se de que o Elasticsearch está em execução. Você pode rodar o Elasticsearch localmente na porta padrão (```localhost:9200``` ).

3. Compile e rode o projeto com o Maven (ou Gradle, se preferir):
```bash
mvn spring-boot:run
```
Ou com Gradle:

```bash
./gradlew bootRun
```
4. A API estará disponível em http://localhost:8081.

### Endpoints da API

#### 1. Adicionar um novo produto

- **Método:** POST

- **Endpoint:** /api/products

- **Descrição:** Cria um novo produto no catálogo.

- **Body:**
```bash
json
{
  "name": "Smartphone X2000",
  "amount": 2999.99
}
```

- **Resposta:**

```bash
json
{
  "id": 1,
  "name": "Smartphone X2000",
  "amount": 2999.99
}
```

#### 2. Buscar produto por ID

 - **Método:** GET

- **Endpoint:** /api/products/{id}

- **Descrição:** Retorna as informações detalhadas de um produto pelo ID.

- **Exemplo de resposta:**

```bash
json
{
  "id": 1,
  "name": "Smartphone X2000",
  "amount": 2999.99
}

```

### Configuração do Elasticsearch

Este microserviço está configurado para se conectar a uma instância do Elasticsearch rodando localmente na porta ``` 9200 ```. Se o seu Elasticsearch estiver em um servidor diferente, altere a configuração no arquivo ElasticSearchConfig.java:

```bash
java

@Override
public ClientConfiguration clientConfiguration() {
    return ClientConfiguration.builder()
            .connectedTo("localhost:9200")  // Altere aqui para o endereço correto
            .withSocketTimeout(Duration.ofSeconds(10))
            .withConnectTimeout(Duration.ofSeconds(5))
            .build();
}
```

### Documentação da API

A documentação da API está disponível via Swagger. Acesse:

```bash
http://localhost:8081/swagger-ui/index.html
```
## Shopping Cart API

### Descrição
Este é um microserviço para gestão de carrinhos de compras, permitindo adicionar itens ao carrinho, consultar o carrinho e excluir carrinhos. Ele foi construído com Java 17, Spring Boot e Redis para armazenamento rápido e eficiente dos carrinhos de compras.

### Funcionalidades
- **Adicionar itens ao carrinho**: Permite adicionar itens ao carrinho de compras.
- **Consultar carrinho**: Consulta o carrinho de compras e exibe os itens nele.
- **Excluir carrinho**: Permite excluir um carrinho de compras do sistema.

### Tecnologias utilizadas
- **Java 17**: A versão utilizada.
- **Spring Boot**: Framework para criação de microserviços.
- **Redis**: Banco de dados em memória para armazenamento rápido do estado do carrinho.
- **Swagger/OpenAPI**: Para documentação da API.

### Pré-requisitos
Antes de rodar o projeto, você precisa ter as seguintes dependências instaladas:
- **Java 17** ou superior
- **Redis** rodando localmente ou remotamente
- **Maven** ou **Gradle** para gerenciar dependências

### Como rodar localmente

1. Clone este repositório:

   ```bash
   git clone https://github.com/SEU_USUARIO/shopping-cart.git
   cd shopping-cart
   
2. Certifique-se de que o Redis está em execução. Você pode rodar o Redis localmente na porta padrão (```localhost:6379```).

3. Compile e rode o projeto com o Maven (ou Gradle, se preferir):
```bash
mvn spring-boot:run
```
Ou com Gradle:

```bash
./gradlew bootRun
```
4. A API estará disponível em http://localhost:8082.

### Endpoints da API

#### 1. Adicionar um item ao carrinho

- **Método:** POST

- **Endpoint:** /api/carts/{id}

- **Descrição:** Adiciona um item ao carrinho de compras. Se o carrinho não existir, ele será criado.

- **Parâmetros:**
  - id (path parameter): ID do carrinho.

- **Body:**
```bash
json
{
  "id": 103,
  "amount": 3
}
```

- **Resposta:**

```bash
json
{
  "id": 1,
  "items": [
    {
      "id": 101,
      "amount": 2
    },
    {
      "id": 102,
      "amount": 1
    },
    {
      "id": 103,
      "amount": 3
    }
  ]
}
```

#### 2. Consultar o carrinho por ID

 - **Método:** GET

- **Endpoint:** /api/carts/{id}

- **Descrição:** Retorna o carrinho de compras com base no ID.

- **Parâmetros:**
  - id (path parameter): ID do carrinho.

- **Exemplo de resposta:**

```bash
json
{
  "id": 1,
  "items": [
    {
      "id": 101,
      "amount": 2
    },
    {
      "id": 102,
      "amount": 1
    }
  ]
}

```
#### 3. Excluir o carrinho

 - **Método:** DELETE

- **Endpoint:** /api/carts/{id}

- **Descrição:** Exclui o carrinho de compras com base no ID.

- **Parâmetros:**
  - id (path parameter): ID do carrinho a ser excluído.

- **Resposta:** Status HTTP 204 (sem conteúdo) se a exclusão for bem-sucedida.

### Configuração do Elasticsearch

Este microserviço está configurado para se conectar a uma instância do Redis rodando localmente na porta 6379. Se o seu Redis estiver em um servidor diferente, altere a configuração no arquivo application.properties:

```bash
java

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		
		RedisTemplate<String, Object>template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory());
		return template;
	}
}
```

### Documentação da API

A documentação da API está disponível via Swagger. Acesse:

```bash
http://localhost:8082/swagger-ui/index.html
```

## Config-Server
- URL Base: http://localhost:8888
- Suporta configuração via Git no repositório: https://github.com/TiagoFerreirago/store-mx/tree/main
- Formato: .yml
#### Endpoint Acesso
  - GET /{application.yml}/default:
#### Endpoint Health
  - GET /actuator
  - GET /actuator/health
#### Dependencias
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependencia-config0server.png" width="500" heigth="250" />
<h3>Discovery-Server</h3>  

+ URL base do Eureka Server: http://localhost:9000/
<h4>Configuração básica:</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/application-discovery.png" width="500" heigth="250" />
<h4>Propósito do Eureka:</h4>

-  O Service Discovery facilita as chamadas entre microserviços, fornecendo informações dinâmicas sobre os serviços registrados. Ele mantém um cache temporário das instâncias disponíveis e facilita o balanceamento de carga, garantindo a distribuição eficiente de requisições entre as instâncias.
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/Spring-Eureka.png" width="800" heigth="800" />
<h4>Dependencias:</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/eureka-dependencies.png" width="500" heigth="250" />

<h3>Gateway</h3>

- URL base: http://localhost:8080/
<h4>Endpoint Health</h4>

  - GET /actuator
  - GET /actuator/health
<h4>Configuração básica</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/app-gateway2.png" width="500" heigth="250" />
<h4>Propósito do Gateway</h4>

- Gateway está atuando como um ponto central de entrada para os microserviços, gerenciando requisições de forma eficiente e segura. Ele simplifica a comunicação entre clientes (como frontend ou aplicativos móveis) e os serviços backend.
<h4>Rotas</h4>

| Path   | Serviço       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `/product/**`      | `Product-Catalog	` | Rota para gerenciamento de produtos.|
| `/cart/**	`      | `Shopping-Cart` |Rota para gerenciamento do carrinho.|
<h4>Dependencias</h4>
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependecia-gateway-part1.png" width="500" heigth="250" />
<img src="https://github.com/TiagoFerreirago/Repositoryphoto/blob/main/dependecia-gateway-part2.png" width="500" heigth="250" />


