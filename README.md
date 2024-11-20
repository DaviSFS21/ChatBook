# ChatBot  🤖

**ChatBot** é um bot interativo no Telegram que gera e apresenta o código
HTML e CSS de uma imagem fornecida pelo usuário. Utilizando a API Llama e
o modelo mistral do Ollama, o bot interpreta a imagem recebida, cria um 
código HTML e CSS correspondente, e responde ao usuário no chat. Essa 
aplicação facilita a criação de estrutura de páginas web com base em 
imagens e serve como um recurso educativo e prático para iniciantes e 
desenvolvedores em CSS e HTML.

<img src="https://github.com/user-attachments/assets/8c199d3f-7a7f-4d5a-90dc-45071ea43b40" alt="imageBot" width="300"/>

Link das previews: https://frontend-chat-preview.vercel.app

## Como fazer funcionar localmente ⚙️

1. Em sua máquina, instale o Ollama ```sudo snap install ollama```
2. Em seguida instale o modelo `llama2:7b` do ollama ```ollama run llama2:7b```
3. Clone o repositório
4. Aguarde o arquivo `pom.xml` baixar as dependências
5. Crie um bot no Telegram seguindo este passo a passo<br>
   5.1. Procure o `BotFather` no Telegram, ele terá um símbolo de verificado e 2,4 milhões de usuários mensais<br>
   5.2. Digite `/start`, veja as opções e crie um novo bot com `/newbot`<br>
   5.3. Nomeie o seu bot e crie um usurname para ele<br>
   5.4. Gere um token com `/token` <br>
7. Substitua o `botToken` no arquivo `Main.java` pelo seu token gerado durante o tutorial
   7.1. Você pode também criar um arquivo `.env` e colocar o seu TOKEN no `TELEGRAM_TOKEN`, assim como mostra o `.env.example`
8. Vá ao arquivo `Main.java` e execute

## Prompts bem sucedidos

```
Generate responsive HTML and CSS code for a web app interface with these features:
- A purple and white color scheme.
- Top section: user profile with the name 'Jonathan' and a placeholder profile picture.
- Middle section: three cards for 'posts', 'events', and 'products', each with a thumbnail, title, and description.
- Bottom section: navigation menu on the left with items like 'Dashboard', 'Settings', 'Notifications', and 'Logout'. Include a search bar in the top-right corner.
Only return the HTML and CSS code. Exclude explanations, comments, and JavaScript. Limit the response to a maximum of 3000 characters
```

Resposta: 
```
html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jonathan's Web App</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <header class="top-section">
            <h1 class="profile-name">Jonathan</h1>
            <img src="profile-picture.jpg" alt="Profile Picture">
        </header>
        <main class="middle-section">
            <card class="post" id="post-card">
                <figure class="thumbnail">
                    <img src="post-image.jpg" alt="Post Image">
                </figure>
                <h2 class="post-title">Post Title</h2>
                <p class="post-description">Post Description</p>
            </card>
            <card class="event" id="event-card">
                <figure class="thumbnail">
                    <img src="event-image.jpg" alt="Event Image">
                </figure>
                <h2 class="event-title">Event Title</h2>
                <p class="event-description">Event Description</p>
            </card>
            <card class="product" id="product-card">
                <figure class="thumbnail">
                    <img src="product-image.jpg" alt="Product Image">
                </figure>
                <h2 class="product-title">Product Title</h2>
                <p class="product-description">Product Description</p>
            </card>
        </main>
        <nav class="bottom-section">
            <ul class="navigation">
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="#">Notifications</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </nav>
    </div>
</body>
</html>


css
body {
    font-family: Arial, sans-serif;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
}

.top-section {
    background-color: #333;
    padding: 20px;
}

.profile-name {
    font-weight: bold;
    margin-bottom: 10px;
}

.profile-picture {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    margin-bottom: 10px;
}

.middle-section {
    display: flex;
    flex-wrap: wrap;
}

.card {
    margin: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.thumbnail {
    width: 100%;
    height: 300px;
    object-fit: cover;
    border-radius: 5px;
}

.post-title {
    margin-bottom: 20px;
}

.post-description {
    margin-bottom: 20px;
}

.event-title {
    margin-bottom: 20px;
}

.event-description {
    margin-bottom: 20px;
}

.product-title {
    margin-bottom: 20px;
}

.product-description {
    margin-bottom: 20px;
}

.bottom-section {
    background-color: #f9f9f9;
    padding: 20px;
}

.navigation {
    list-style: none;
    margin: 0;
    padding: 0;
}

.navigation li {
    margin-right: 20px;
}

Note that this code is just a starting point, and you may need to adjust the CSS to fit your specific design needs. Additionally, this code does not include any JavaScript or interactivity, so you will need to add that if you want to create a more dynamic user experience.
```
