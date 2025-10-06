package model;

public class MensagemUtil {

 
    public static String gerarAlerta(String status, String msg) {
        if ("sucesso".equals(status)) {
            return "<script type=\"text/javascript\">alert(\"Ação realizada com sucesso!\");</script>";
        } else if ("erro".equals(status)) {
            String mensagemErro = msg != null ? msg.replace("\"", "\\\"") : "Erro ao realizar ação. Verifique informações inseridas nos campos.";
            return "<script type=\"text/javascript\">alert(\"" + mensagemErro + "\");</script>";
        }
        return "";
    }
}