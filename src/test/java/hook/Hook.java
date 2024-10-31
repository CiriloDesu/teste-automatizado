package hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Hook {
    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Configuração global antes de todos os testes.");
        executarComandoMavenWrapper(List.of("clean"));
        executarComandoMavenWrapper(List.of("install"));
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("Limpeza global após todos os testes.");
        executarComandoMavenWrapper(List.of("clean"));
    }

    @Before
    public void setUp() {
        System.out.println("Iniciando um novo cenário de teste...");
        executarComandoMavenWrapper(List.of("compile"));
    }

    @After
    public void tearDown() {
        System.out.println("Finalizando o cenário de teste...");
        executarComandoMavenWrapper(List.of("test"));
    }

    private static void executarComandoMavenWrapper(List<String> fases) {
        String mvnwCommand = System.getProperty("os.name").toLowerCase().contains("win") ? "mvnw.cmd" : "./mvnw";

        for (String fase : fases) {
            ProcessBuilder processBuilder = new ProcessBuilder(mvnwCommand, fase);
            processBuilder.redirectErrorStream(true);

            try {
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linha;
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
