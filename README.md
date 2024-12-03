<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - Projeto CRUD de Clientes</title>
</head>
<body>
    <h1>Projeto CRUD de Clientes</h1>
    <p>
        Este é um projeto de exemplo para gerenciar um CRUD de clientes, desenvolvido utilizando 
        <strong>JSF</strong> (Java Server Faces), <strong>JPA</strong> (Java Persistence API) e 
        banco de dados <strong>H2</strong>. O projeto foi construído com <strong>Java 8</strong> e testado 
        no servidor <strong>Tomcat 9</strong>, com gerenciamento de dependências via <strong>Maven</strong>.
    </p>

   <h2>Funcionalidades</h2>
    <ul>
        <li>Listar clientes</li>
        <li>Adicionar novos clientes</li>
        <li>Editar informações de clientes</li>
        <li>Remover clientes do sistema</li>
    </ul>

  <h2>Tecnologias Utilizadas</h2>
    <ul>
        <li>Java 8</li>
        <li>JSF</li>
        <li>JPA</li>
        <li>Banco de Dados H2</li>
        <li>Servidor Apache Tomcat 9</li>
        <li>Maven</li>
    </ul>

   <h2>Pré-requisitos</h2>
    <p>Certifique-se de ter os seguintes itens instalados em sua máquina:</p>
    <ul>
        <li><strong>JDK 8</strong> ou superior</li>
        <li><strong>Eclipse IDE</strong> ou outra IDE compatível com projetos Maven</li>
        <li><strong>Apache Tomcat 9</strong> configurado</li>
        <li><strong>Maven</strong> configurado no ambiente</li>
    </ul>

  <h2>Configuração e Execução</h2>
    <ol>
        <li>
            <strong>Clone o repositório</strong><br>
            Faça o clone do projeto para sua máquina local:
            <pre><code>git clone https://github.com/brenanwanderley/clientes-app.git</code></pre>
        </li>
        <li>
            <strong>Importe o projeto para sua IDE</strong><br>
            Abra o Eclipse ou a IDE de sua preferência e importe o projeto como um <strong>Projeto Maven existente</strong>.
        </li>
        <li>
            <strong>Atualize as dependências Maven</strong><br>
            Antes de executar o projeto, certifique-se de atualizar as dependências Maven:
            <ol>
                <li>Clique com o botão direito no projeto na IDE.</li>
                <li>Selecione <strong>Maven &gt; Update Project</strong>.</li>
            </ol>
        </li>
        <li>
            <strong>Configure o servidor Tomcat</strong><br>
            Adicione o Tomcat 9 à sua IDE e configure o projeto para ser executado no servidor.
        </li>
        <li>
            <strong>Execute o projeto</strong><br>
            Inicie o servidor e acesse a aplicação no navegador pelo seguinte endereço:
            <pre><code>http://localhost:8080/clientes-app/index.xhtml</code></pre>
        </li>
    </ol>

   <h2>Banco de Dados H2</h2>
    <p>
        O projeto utiliza o banco de dados em memória <strong>H2</strong>, configurado no arquivo 
        <code>persistence.xml</code>. Ao iniciar a aplicação, o banco de dados é automaticamente 
        inicializado, e todas as operações CRUD são realizadas em memória.
    </p>

  <h2>Estrutura do Projeto</h2>
    <ul>
        <li><strong>src/main/java</strong>: Contém o código-fonte Java (entidades, DAOs, serviços e beans).</li>
        <li><strong>src/main/webapp</strong>: Contém os arquivos XHTML (interface JSF) e recursos estáticos (CSS, JS).</li>
        <li><strong>pom.xml</strong>: Arquivo de configuração do Maven.</li>
    </ul>

  <h2>Contribuição</h2>
    <p>
        Contribuições são bem-vindas! Para contribuir:
    </p>
    <ol>
        <li>Faça um fork do repositório.</li>
        <li>Crie um branch para sua feature ou correção de bug (<code>git checkout -b minha-feature</code>).</li>
        <li>Faça o commit de suas alterações (<code>git commit -m 'Descrição da minha feature'</code>).</li>
        <li>Envie um push para o branch (<code>git push origin minha-feature</code>).</li>
        <li>Abra um pull request.</li>
    </ol>

  <h2>Licença</h2>
    <p>
        Este projeto está licenciado sob a licença MIT. Consulte o arquivo <code>LICENSE</code> para mais informações.
    </p>
</body>
</html>
