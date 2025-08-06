package bloco8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class exercicio33 {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Teste {
    }

    public static class MinhaClasseDeTeste {
    @Teste
    public void testeSoma() {
        System.out.println("Executando testeSoma: SUCESSO");
    }

    public void metodoComum() {
        System.out.println("Este não é um teste.");
    }

    @Teste
    public void testeLogin() {
        System.out.println("Executando testeLogin: SUCESSO");
    }
}

    public class ExecutorDeTestes {
    public static void executarTestes(Object obj) {
            Class<?> clazz = obj.getClass();
            Method[] methods = clazz.getDeclaredMethods();

            System.out.println("Executando testes da classe: " + clazz.getSimpleName());
            for (Method m : methods) {
                if (m.isAnnotationPresent(Teste.class)) {
                    m.setAccessible(true);
                    System.out.println("Invocando: " + m.getName());
                    try {
                        m.invoke(obj);
                    } catch (Exception e) {
                        System.out.println("  ❌ Falha ao executar " + m.getName() +
                                ": " + e.getCause());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MinhaClasseDeTeste testes = new MinhaClasseDeTeste();
        ExecutorDeTestes.executarTestes(testes);
    }
}
