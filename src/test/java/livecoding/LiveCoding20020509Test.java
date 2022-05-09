package livecoding;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiveCoding20020509Test {

    static Encriptador encriptador;

    @BeforeAll
    public static void criarEncriptador() {
        var sequencia = "acdfgijloprtuxv";
        encriptador = new Encriptador(sequencia);
    }

    @Test
    void test() {
        assertEquals("L125z0", encriptador.encripte("Luiza"));
        assertEquals("F781050nó9875s", encriptador.encripte("Florianópolis"));
    }

}
