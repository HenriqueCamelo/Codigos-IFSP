<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            margin: 0; /* Remover a margem padrão do body */
            text-align: center;
        }

        main {
            flex: 1;
        }

        .btn {
        margin-top: 15px;
        background-color: hsl(59, 91%, 63%);
        color: rgb(20,22,31);
        font-size: 1rem;
        padding: 10px;
        border-radius: 15px;
        width: fit-content;
        font-family: inherit;
        text-align: center;
        margin-bottom: 15px;
        font-weight: bold;    
        }

        .btn:hover {
        padding: 12px;
        color: rgb(48, 74, 192);
        }

        .LGFsenha {
            margin-left: -0.2rem;
        }

        /* style.css */
        .produtos {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            margin-left: 350px;
            margin-right: 350px;
            margin-bottom: 50px;
        }

        .linha {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap; /* Adicionado para que os produtos quebrem para a próxima linha */
        }

        .produto {
            width: 300px;
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px;
        }

        .produto img {
            width: 100%;
            height: auto;
        }

        .produto button {
            background-color: #333;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 10px; /* Adicionado espaço superior */
        }

        .produto button:hover {
            background-color: #555;
        }

        footer {
            background-color: #f7f44b;
            color: rgb(20,22,31);
            text-align: center;
            padding: 10px;
            position: relative; /* Alterado para relativo */
            width: 100%;
            margin-top: auto; /* Adicionado para garantir que o rodapé fique no fundo */
        }
    </style>
</head>
<body>
    <main>
        <!-- Seu conteúdo principal aqui -->
    </main>

    <footer class="page-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-sm-12">
                    <h4 class="white-text">Eletrify</h4>
                    <p class="grey-text text-lighten-4">O melhor da tecnologia em aparelhos sustentáveis e inovadores que levam a diversão a outro nível.</p>
                </div>
                <div class="col-lg-4 offset-lg-2 col-sm-12">
                    <ul class="list-unstyled text-left">
                        <li><h5 class="white-text">Links</h5></li>
                        <li><a class="grey-text text-lighten-3 d-block" href="../Projeto2FullStack/ProjetoFinal/index.php">Home</a></li>
                        <li><a class="grey-text text-lighten-3 d-block" href="carrinho.php?codigo=">Produtos</a></li>
                        <li><a class="grey-text text-lighten-3 d-block" href="login_funcionario.php">Funcionários</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer-copyright">
            <div class="container">
                2023 ©Eletrify Todos os direitos reservados
                <a class="grey-text text-lighten-4 right" href="#!">Outros Links</a>
            </div>
        </div>
    </footer>

    <!-- Adicione os scripts do Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
