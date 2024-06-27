

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="Estilos/Estilo2.css" />
    <link href="https://fonts.googleapis.com/css2?family=Share+Tech&display=swap" rel="stylesheet">
    <link rel="icon" href="Imagens/LogoEletrify (2).png" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <title>Eletrify - Conectando Pessoas e Lugares</title>
</head>
<body>
 
    <div class="nav">
       
        <div id="itens">
            <a href="Paginas/sobre.html" onclick="return clickMenu()">A Eletrify</a>
            <a href="#pro" onclick="return clickMenu()" >Produtos</a>
            <a href="#exp" onclick="return clickMenu()">Experience</a>
            <a href="#eti" onclick="return clickMenu()">Ética e Conduta</a>
            <a href="../login_funcionario.php"onclick="return clickMenu()">Entrar como Funcionário</a>
            <a href="../form_cadastrar_clientes.php"onclick="return clickMenu()">Entrar como Cliente</a>
            </a>
        </div>
        <a id="barra" class="material-symbols-outlined" onclick="return clickMenu()">menu</a>
        <a href="Index.html"><img src="Imagens/LogoEletrify (2).png" alt="logo" class="mini_e"></a>
      </div>

    <main>
        <div class="content">

        <div  class="topo">
           <video src="Imagens/Apresentação.mp4" autoplay muted loop class="video"></video>
            <div class="slogan"> O melhor da tecnologia em aparelhos sustentáveis e inovadores que levam a diversão a outro nível. <br><br><a href="Paginas/sobre.html" class="botao">Saiba mais</a>
            </div>   
        </div>

        <h3 class="texto" id="pro">Produtos </h3>
        <p>Clique e veja a descrição</p>
        <div class="galeria">
            <img src="../imagens/patins.jpeg" class="produtos produto-1" alt="Os queridinhos! Modelo Inline com 3 rodas, se adaptando aos seus tênis.   Modo Econômico e Automático com o exclusivo controle." />
            <img src="../imagens/bike.jpeg" class="produtos produto-2" alt="Bicicleta Elétrica dobrável, leve e compacta, com a resistência que suas aventuras precisam! " />
            <img src="../imagens/patinete.jpeg" class="produtos produto-3" alt="Patinete Elétrico com painel informativo em tempo real, sistema antifuro, freio elétrico e acesso ao app exclusivo." />
            <img src="../imagens/skate.jpeg" class="produtos produto-4" alt="Skate Elétrico com rodas Off Road 9' e presilha para os pés, tornando você sempre pronto para a próxima." />
        </div>
        <div id="div_exibe_desc"> </div>

        <div class="fundo">
            <div class="texto" id="exp">Eletrify Experience</div>
            <p>Tenha toda a vivência de um ambiente imersivo, familiar e altamente tecnológico. <br><br></p>
            <div class="imagens_loja"></div>
            <p> Dísponivel no Morumbi Shopping</p>
        </div>

        <h3 class="texto">Pontos Móveis</h3>
        <p>Nos pontos móveis presentes nos principais parques de São Paulo, você tem toda a experiência Eletrify por um preço acessível.<p>
        <div class="container">
            <div class="img img_1">
                <img src="Imagens/pqibirapuera.jpg" alt="Ibirapuera" class="img">
                <h3>Parque Ibirapuera</h3>
            </div>
            <div class="img img_3">
                <img src="Imagens/independencia.jpg" alt="Independência" class="img">
                <h3>Parque da Independência</h3>
            </div>
            <div class="img img_2">
                <img src="Imagens/villalobos1.jpg" alt="Villa-Lobos" class="img">
                <h3>Parque Villa-Lobos</h3>
            </div>
            <p>Disponível aos finais de semana e feriados, das 8 às 19h</p>
        </div>
        
        <h3 class="texto" id="eti">Código de Ética e Conduta <br><br></h3>    
        <div class="codigo"> 
         O código de ética e conduta representa regras, princípios e valores da organização. Sendo o regimento da empresa, tem como objetivo que os colaboradores estejam alinhados e tenham a postura que acreditamos, criando um ambiente confortável para todos.
         <br><br><a href="Paginas/Etica.html" class="botao">Leia na íntegra</a> </div>
        
        <form  name="form" method="post" onsubmit="return validarForms()">
            <p>Cadastre-se e receba informações sobre o melhor da tecnologia</p>
            <input type="text" id="nome" name="nome" maxlength="40" required placeholder="Insira seu nome" />
            <input type="email" id="email" name="email" maxlength="40" required placeholder="Insira seu E-mail" />
            <input type="text" id="fone" name="fone" maxlength="14" placeholder="Insira seu telefone (opcional)" />
            <input type="submit" class="botao" value="Enviar">
        </form>
    </div>


    </main>
    <footer>
        <div class="container2">
            <div>
                <div">
                    <h1>Eletrify</h1>
                    <p class = "desc2">O melhor da tecnologia em aparelhos sustentáveis e inovadores que levam a diversão a outro nível.</p>
                </div>
                <div>
                    <ul class = "ul2">
                        <li><h2>Links</h2></li>
                        <li><a href="index.php">Home</a></li>
                        <li><a>Produtos</a></li>
                        <li><a href="../login_funcionario.php">Funcionários</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div>
            <div>
            2023 ©Eletrify Todos os direitos reservados
    
            </div>
        </div>
    </footer>

    <script src="Scripts/Script.js"></script> 

</body>
</html>
