<?php
    
    class Pessoa{    
        public $nome; // atributo do tipo público
        public $email;
        public $idade; //sófunciona dentro deste encapsulamento, deste arquivo
        public $fone;
    
        
        public function exibirnome(){
            echo "Nome: ". $this->nome = "Universo Cândido <br/>";
            echo "Email: ". $this->email = "universo.com <br/>";
            echo "Idade: ". $this->idade = "18 <br>";
            echo "Fone: ". $this->idade = "(11)99999-9994<br>";
        }

        public function cadastroAluno(){
            echo "Nome: ". $this->nome = "Giovana Pavanatto <br/>";
            echo "Email: ". $this->email = "pavanatto@gmail.com <br/>";
            echo "Idade: ". $this->idade = "19 <br>";
            echo "Fone: ". $this->idade = "(11)99999-9999<br>";
            echo "<br>";
            echo "Nome: ". $this->nome = "Arthur Filho <br/>";
            echo "Email: ". $this->email = "filho@gmail.com <br/>";
            echo "Idade: ". $this->idade = "19 <br>";
            echo "Fone: ". $this->idade = "(11)99999-1999<br>";
        }

        public function cadastroProfessor(){
            echo "Nome: ". $this->nome = "Cladebalto Mendes <br/>";
            echo "Email: ". $this->email = "mendes@gmail.com <br/>";
            echo "Idade: ". $this->idade = "49 <br>";
            echo "Fone: ". $this->idade = "(11)99999-9991<br>";
            echo "<br>";
            echo "Nome: ". $this->nome = "Mirts Alemida <br/>";
            echo "Email: ". $this->email = "alemida@gmail.com <br/>";
            echo "Idade: ". $this->idade = "69 <br>";
            echo "Fone: ". $this->idade = "(11)99999-9909<br>";
        }

        public function cadastroPendente(){
            echo "Nome: ". $this->nome = "Vicente Mais ou  Menos de Souza<br>";
            echo "Email: ". $this->email = "maisoumenos@gmail.com <br/>";
            echo "Idade: ". $this->idade = "59<br>";
            echo "Fone: ". $this->idade = "(11)99999-9990<br>";
            echo "<br>";
            echo "Nome: ". $this->nome = "Haroldo Batman<br>";
            echo "Email: ". $this->email = "brucewaine@gmail.com <br/>";
            echo "Idade: ". $this->idade = "??<br>";
            echo "Fone: ". $this->idade = "(11)99999-9993<br>";
        }


    }

    





?>