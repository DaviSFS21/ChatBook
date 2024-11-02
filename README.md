# ChatBook  🤖

**ChatBot** é um bot interativo no Telegram que gera e apresenta o código
HTML e CSS de uma imagem fornecida pelo usuário. Utilizando a API Llama e
o modelo mistral do Ollama, o bot interpreta a imagem recebida, cria um 
código HTML e CSS correspondente, e responde ao usuário no chat. Essa 
aplicação facilita a criação de estrutura de páginas web com base em 
imagens e serve como um recurso educativo e prático para iniciantes e 
desenvolvedores em CSS e HTML.

<img src="https://github.com/user-attachments/assets/8c199d3f-7a7f-4d5a-90dc-45071ea43b40" alt="imageBot" width="300"/>



## Como fazer funcionar localmente ⚙️


1. Em sua máquina, instale o Ollama ```sudo snap install ollama```
2. Em seguida instale o modelo `mistral` do ollama ```ollama run mistral```
3. Clone o repositório
4. Aguarde o arquivo `pom.xml` baixar as dependências
5. Crie um bot no Telegram seguindo este passo a passo<br>
   5.1. Procure o `BotFather` no Telegram, ele terá um símbolo de verificado e 2,4 milhões de usuários mensais<br>
   5.2. Digite `/start`, veja as opções e crie um novo bot com `/newbot`<br>
   5.3. Nomeie o seu bot e crie um usurname para ele<br>
   5.4. Gere um token com `/token` <br>
7. Substitua o TOKEN pelo seu gerado durante o tutorial
8. Vá ao arquivo `Main.java` e execute
