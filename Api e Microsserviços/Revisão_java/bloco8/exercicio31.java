package bloco8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class exercicio31 {
    public static class AnalisadorDeClasse{
        public static void inspecionar(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("Classe: " + clazz.getName());

        System.out.println("\nCampos (atributos):");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            String mod = Modifier.toString(f.getModifiers());
            System.out.printf("  %s %s %s%n", mod, f.getType().getSimpleName(), f.getName());
        }

        System.out.println("\nMétodos:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            m.setAccessible(true);
            String mod = Modifier.toString(m.getModifiers());
            System.out.printf("  %s %s %s(%s)%n",
                    mod,
                    m.getReturnType().getSimpleName(),
                    m.getName(),
                    parameterTypesToString(m.getParameterTypes()));
        }
    }

        private static String parameterTypesToString(Class<?>[] params) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            sb.append(params[i].getSimpleName());
            if (i < params.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
    }

    

    public static class Produto {
        private int codigo;
        public String nome;
        protected double preco;

        public Produto(int codigo, String nome, double preco) {
            this.codigo = codigo;
            this.nome = nome;
            this.preco = preco;
        }

        private double calcularImposto() {
            return preco * 0.1;
        }
    }

    public static void main(String[] args) {
        Produto p = new Produto(101, "Notebook Gamer", 8500.0);
        AnalisadorDeClasse.inspecionar(p);
    }
}
