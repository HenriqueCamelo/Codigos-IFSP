package bloco8;

public class exercicio32 {
    public class Configuracao {
        private String urlConexao = "localhost:5432";
    }

    public static void main(String[] args) {
        try {
            Configuracao cfg = new Configuracao();
            Class<?> clazz = cfg.getClass();

            Field field = clazz.getDeclaredField("urlConexao");
            field.setAccessible(true); // Permite acesso ao campo privado

            // Lendo o valor anterior
            String oldValue = (String) field.get(cfg);
            System.out.println("Antes: " + oldValue);

            // Alterando o valor para o novo
            field.set(cfg, "db.producao.com:5432");

            // Lendo o valor atualizado
            String newValue = (String) field.get(cfg);
            System.out.println("Depois: " + newValue);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
