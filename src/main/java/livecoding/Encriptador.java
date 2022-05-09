package livecoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class Encriptador {

    private final HashMap<String, Integer> mapa;
    private String sequencia;

    Encriptador(String sequencia) {
        this.sequencia = sequencia;
        this.mapa = new HashMap<String, Integer>();
        var letras = sequencia.split("");
        for (int index = 0; index < letras.length; index++) {
            this.mapa.put(letras[index], index);
        }
    }

    public String encripte(String texto){
        return encripteFuncionalUsandoMethodReference(texto);
    }

    public String encripteFuncionalUsandoLambda(String texto){
        return Arrays.stream(texto.split(""))
                .map(letra->transformar(letra))
                .collect(Collectors.joining());
    }

    public String encripteFuncionalUsandoMethodReference(String texto){
        return Arrays.stream(texto.split(""))
                .map(this::transformar)
                .collect(Collectors.joining());
    }

    public String encripteExemplo1(String texto) {

        StringBuilder saida = new StringBuilder();

        String[] split = texto.split("");

        for (int i = 0; i < split.length; i++) {
            String letra = split[i];
            saida.append(transformar(letra));
        }


        return saida.toString();
    }

    public String encripteExemplo2(String texto) {

        StringBuilder saida = new StringBuilder();

        String[] split = texto.split("");

        for (String letra : split) {
            saida.append(transformar(letra));
        }

        return saida.toString();
    }

    private String transformar(String letra) {

//        List<String> retorno = List.of(this.sequencia.split(""));
//        var index = retorno.indexOf(letra);
//        return index < 0 ? letra : String.valueOf(index);

//        var indice = this.mapa.getOrDefault(letra, -1);
//        if (indice != -1) {
//            return String.valueOf(indice);
//        }

        return Optional.ofNullable(letra)
                .map(l->Optional.ofNullable(this.mapa.get(l))
                        .map(String::valueOf)
                        .orElse(letra))
                .orElse("");
    }
}
