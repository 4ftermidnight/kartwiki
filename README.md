#KartWiki

##Ambiente
1. Oracle JDK 7+ (https://www.digitalocean.com/community/tutorials/how-to-install-java-on-ubuntu-with-apt-get)
2. Maven (https://maven.apache.org/download.cgi) ou `sudo apt-get install maven`
2. Eclipse IDE for Java EE Developers (https://eclipse.org/downloads/) 
3. Apache Tomcat 8 (https://tomcat.apache.org/download-80.cgi)

###O que há no projeto
 - CDI 
 - JPA / Hibernate
 - JUnit 
 - JSF (primefaces)

##Caminho Feliz
**Passo 1:** Importando o projeto do GIT  no eclipse

1. File > Import > Project from Git > Clone URI > URI:https://github.com/nicolas0liveira/kartwiki.git, Next > Selecionar Master, Next > Escolher o diretório destino, Finish
2. Clicar botão direito no projeto, Maven > Update Project

Neste momento o maven irá interpretar o **pom.xml** e baixar as dependências, pode levar algum tempo da primeira vez.
**_O projeto deve estar sem nenhum sinal de erro._**


**Passo 2:** Adicionar o servidor ao eclipse

1. File > New > Server > Selecionar Apache Tomcat 8 > Apache Instalation Directory: `diretório de instalação`, Next até o final


**Passo 3:** 

1. Iniciar o tomcat
2. acessar 127.0.0.1:8080/kartwiki (padrão configurado no tomcat)


#Possíveis Problemas

1.Unbound classpath container: 'JRE System Library [JavaSE-1.8]' in project 'kartwiki'	kartwiki		Build path	Build Path Problem:

Pode ocorrer problema com o JRE instalado. Caso isso ocorra, acesse as propriedades do projeto e escolha a manualmente em: Java Build Path > Aba libraries


















