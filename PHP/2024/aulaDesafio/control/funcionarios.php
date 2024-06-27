<?php 

    class Funcionarios{
        //private $cxlogin;
        //private $cxsenha;
        //private $cxusu;

        /* public function getLogin($log){
            $this->cxlogin = $log;
        }
        
        public function setLogin(){
            return $this->cxlogin;
        }

        public function getSenha($sen){
            $this->cxsenha = $sen;
        }
        
        public function setSenha(){
            return $this->cxsenha;
        }
        
        public function getUsuario($usu){
            $this->cxusu = $usu;
        }
        
        public function setUsuario(){
            return $this->cxusu;
        } */
        
        
        
        
        public function entrar($login, $senha, $usuario){
            if($login == "Anselmo" && $senha== "mario" && $usuario == "prof"){
                $_SESSION['idAnselmo'] = $login;

                return true;
            }else{
                unset($_SESSION['idAnselmo']);
                return false;
            }
        }
    }





?>