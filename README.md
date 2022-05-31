# projeto-brilhador-backend

<h2> Recomendação: sempre garantir que a branch de sua equipe está atualizada com o que tiver mais novo na branch "development", faça um merge toda vez antes de iniciar alguma alteração para garantir que terá a versão mais atual e possivelmente a mais estável de cada módulo.</h2>

<h3> Inicializando o projeto: (Assumindo que tenha docker instalado)</h3>

```
 docker-compose up
```
<h4>Caso esteja utilizando máquina Windows e houver problema ao utilizar o comando acima, verifique se o "End of Line Sequence" está em "LF" dos arquivos "mvnw" </h4>


<h2> Adicionando um novo serviço </h2>

<h3> Primeiro, adicione o serviço ao docker-compose.yml</h3>

<h3>Atenção sempre a identação, arquivos yml dependem de estarem corretamente formatados para funcionar.</h3>
 
 ```
  nome-do-servico:                     # grupo-servico-brilhador 
  
    container_name: nome-do-container  # grupo-servico-brilhador (será a url mais tarde, não use "_")
    
    image: openjdk:11.0.15-slim-buster # depende a versão java utilizada. Use alguma de outro serviço ou caso 
                                       # tenha uma versão java diferente busque em https://hub.docker.com/_/openjdk?tab=tags&page=1
                                       # na busca use versaoJava.patch.revisao.build-slim-buster
                                       # o resultado deve ser algo como: openjdk: openjdk:XX.X.X.X-slim-buster
                                       
    volumes:
      - './pasta-projeto:/app'         # Atente-se a escrever exatamente o diretório root do seu projeto, aonde o
                                       # arquivo "mvnw" se encontra.
                                       
    working_dir: /app
    expose:
      - 80
    command: sh mvnw spring-boot:run -X # Geralmente esse ou "./mvnw spring-boot:run -X" devem funcionar normalmente.
    networks:
      - brilhador
 ```
 
 <h3>Depois, mude a porta do seu projeto adicionando a seguinte configuração</h3>
 <p>seu-projeto/src/main/resources/application.properties</p>
 
 ```
 server.port=80
 ```
 
 <h3>Após isso, é necessário incluir ao Api Gateway sua aplicação para que ela seja mapeada e acessível.</h3>
 <h2>Adicione ao arquivo a url e nome do container</h2>
 
 <p>api-gateway/src/main/java/com/apigateway/gateway/configuration/UriConfiguration.java</p>
 
 <img width="901" alt="image" src="https://user-images.githubusercontent.com/47763156/167319460-f5dfe021-b08b-4be3-9e31-1b213c087bb8.png">

 <h3> Reinicie seu docker compose e você já deverá ter acesso a sua aplicação através da url:</h3>
 
 ``` 
 http://localhost:4000/base-da-url/sua-rota 
 
 ```


<h2>Grupos: </h2>

  <h3> Relacionamento com o cliente</h3>
   <h5>Vinícius Lojhan Martinez Hernandes - 12855073</h5>
   <h5>Jorge de Oliveira Neto -RGM 12969371</h5>
   <h5>Lucas Raulin Lunik - RGM 12857815<h5>
   <h5>Gabriel Marchiorato Oliveira - RGM 13022474</h5>
   <h5><s>Douglas Gorges - 12851469 </s> - transfered</h5>
   <h5>Igor Mateus Rodrigues de Oliveira - @imigoroliveira  - 12861324</h5>
   <h5>Lucas Rocha Cardoso da Silva - 12849472</h5>
   <h5>Marco Lopes - 12861987</h5>
   <h5>Bruno Vasquez - 12806170</h5>
  
  <h3> Gestão da cadeia de suprimentos</h3>
   <h5>Antonio Eduardo Oliveira - 12777366</h5>
   <h5> Vinícius Lisboa - 13197347 </h5>
   <h5> Raphael Marangoni - 13178130 </h5>
   <h5> Igor Cristian - 13188062 </h5>
   <h5> Aluno - RGM </h5>

  <h3> Estoque e produção</h3>
   <h5>Lucas Volkmann - 13375890 </h5>
   <h5>Milena Rodrigues Milicio - RGM 13335545</h5>
   <h5>Aramis Chang Chain - RGM 8813440250</h5>
   <h5>Gabriel Branco de Azevedo - RGM 13322737</h5>
   <h5>Luiz Felipe A. Oliveira - RGM 13216082</h5>
  
  <h3>  Recursos humanos</h3>
   <h5>Pedro Kappes - 12904937</h5>
   <h5>Eliane - 13313851</h5>
   <h5>Maicon Businari - 13359444</h5>
   <h5>Guilherme Ghisi - 12564621 </h5>
   <h5>Matheus Zalamena e Souza - 12948128 </h5>
   <h5>Naiara de Mello Martins - 11934603 </h5>
   <h5>André da Silva Rocco - 12235296 </h5>
  
  <h3> Financeiro, contábil e ativos</h3>
   <h5>Rafael Romig - 13180894</h5>
   <h5>Samuel Diel - 13177770 </h5>
   <h5>Lucas Goulart Bunhak Santos - 29470757 </h5>
   <h5>Ana Maria Vargas - 13322842 </h5>
   <h5>Yuri Valeixo - 8813442643 </h5>
   <h5>Graziela Rudinger - 8812980820 </h5>
   <h5>Gustavo - ??? </h5>
   <h5>Felipe Macchi - 8813350919 </h5>
   <h5>Felipe Tsuchiya - 13371720 </h5>
   <h5>Gabriel Teixeira - 13332473 </h5>
   <h5>Lucas Damião - 8813331787 </h5>
   <h5>Matheus - ??? </h5>
  
  <h3> Compras e vendas</h3>
   <h5>Lucas Rodrigues Leite - 8813279432</h5>
   <h5>Vinícius Kruchelski Gugelmin - 8813365614</h5>
   <h5>Garbriel Fernando Cazeque Zanin - 8813372831</h5>
   <h5>Carlos Roberto Pereira Neres Filho - 8813207156</h5>
   <h5>Luis Fernando Rezende Santos - 12468631</h5>

  <h3> Sistemas estratégicos</h3>
    <h5>Anna Cruz @AnnaCzt - 12222062</h5>
    <h5>Hellen Gurgacz @hellengurgaczz - 13360051</h5>
    <h5> Julia Scheffer @juliascheffer - 13219073 </h5>
    <h5> Sara Alves @saralves9 - 13164139 </h5>
    <h5> Rafaela Barbosa @rafaelabarb - 12196894 </h5>
