# <font color="lightblue">**Aquacare - Global Solution 2024**</font>

## <font color="orange">**Integrantes do Projeto**</font> 
- RM96685 - BRUNO BARBOSA BRAGA DOS SANTOS - [GitHub](https://github.com/Dannzini)
- RM97012 - IGOR AUGUSTO TAKESHIGUE LEMOS - [GitHub](https://github.com/igoorlemoos)
- RM97192 - JOEDERSON OLIVEIRA PEREIRA - [GitHub](https://github.com/JoePereira)
- RM96950 - MARIO ITO BOCCHINI - [GitHub](https://github.com/mario-ito)

<br>

## <font color="orange">**SPRING SECURITY**</font> 

- Neste projeto está implementado o Spring Security, para testes deverá ser utilizada as seguinetes credenciais:
Usuário: Aquacare ; Senha: 123321 .

- Caso seja necessário alterar as credenciais, as credenciais estão salvas na classe `WebSecurityConfig`, que está localizada em `src/main/java/br.com.aquacare.api_aquacare`.

<br>

## <font color="orange">**COMO RODAR A APLICAÇÃO**</font> 
### Configurar o Arquivo de Configuração

- Abra o projeto no seu IDE (por exemplo, Eclipse, IntelliJ) e navegue até a pasta `src/main/resources`.
- Localize o arquivo `application.properties` e abra-o.
- Dentro do arquivo, você encontrará propriedades relacionadas ao banco de dados. Geralmente, as propriedades são semelhantes a isso:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/meubanco
   spring.datasource.username=seuUsuario
   spring.datasource.password=suaSenha
- Altere as informações do banco de dados de acordo com as configurações do seu banco de dados. Substitua seuUsuario, suaSenha e jdbc:mysql://localhost:3306/meubanco pelo seu nome de usuário, senha e URL do banco de dados. Depois salve o arquivo.

<br>

### Executar e Testar a Aplicação
- Abra a classe `ApiAquacareApplication` que está localizada em `src/main/java/br.com.aquacare.api_aquacare`.
- Dentro dessa classe, você encontrará o método main. Clique com o botão direito do mouse sobre esse método e selecione "Run" para executar a aplicação Spring Boot.

- A aplicação agora deverá iniciar. Ela irá se conectar ao banco de dados usando as informações configuradas no `application.properties`. Durante a inicialização, o Spring Boot automaticamente executará scripts SQL para criar as tabelas no banco de dados

- Neste projeto está implementado o Spring Security, para testes deverá ser utilizada as seguinetes credenciais:
Usuário: Aquacare ; Senha: 123321 .

<br>


## <font color="orange">**Endpoints API**</font>

### **Cidade**

<b>Descrição dos endpoints de Cidade</b>

- `POST` /cidade: cadastrar uma nova Cidade
- `GET` /cidade: listar todos as Cidades
- `GET` /cidade/{id}: retornar uma Cidade pelo seu id (codigoCidade)
- `PUT` /cidade/{id}: atualizar uma Cidade pelo seu id (codigoCidade)
- `DELETE` /cidade/{id}: apagar uma Cidade pelo seu id (codigoCidade)

<br>

### **Local**

<b>Descrição dos endpoints de Local:</b>

- `POST` /local: cadastrar um novo Local
- `GET` /local: listar todos os Locais
- `GET` /local/{id}: retornar um Local pelo seu id (codigoLocal)
- `PUT` /local/{id}: atualizar um Local pelo seu id (codigoLocal)
- `DELETE` /local/{id}: apagar um Local pelo seu id (codigoLocal)

<br>

### **Indicador**

<b>Descrição dos endpoints de Indicador:</b>

- `POST` /indicador: cadastrar um novo Indicador
- `GET` /proindicadorduto: listar todos os Indicadores
- `GET` /indicador/{id}: retornar um Indicador pelo seu id (codigoIndicador)
- `PUT` /indicador/{id}: atualizar um Indicador pelo seu id (codigoIndicador)
- `DELETE` /indicador/{id}: apagar um Indicador pelo seu id (codigoIndicador)

<br>

### **Usuario**

<b>Descrição dos endpoints de Usuario:</b>

- `POST` /usuario: cadastrar um novo Usuario
- `GET` /usuario: listar todos os Usuarios
- `GET` /usuario/{id}: retornar um Usuario pelo seu id (codigoUsuario)
- `PUT` /usuario/{id}: atualizar um Usuario pelo seu id (codigoUsuario)
- `DELETE` /usuario/{id}: apagar um Usuario pelo seu id (codigoUsuario)

<br>

## <font color="orange">**VIDEO**</font>

