package br.com.pedropavanello.bigo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> participantes = args.length == 0
                ? List.of("Ana", "Bruno", "Carlos", "Diana")
                : List.of(args);

        GeradorConfrontos gerador =  new GeradorConfrontos();
        List<Confronto> confrontos = gerador.gerar(participantes);

        System.out.printf(
                "Participantes (N = %d): %s%n",
                participantes.size(),
                String.join(", ", participantes)
        );

        System.out.println("\nConfrontos gerados:");

        for (int i = 0; i<confrontos.size(); i++) {
            Confronto confronto = confrontos.get(i);

            System.out.printf(
                    "%d. %s x %s%n",
                    i + 1,
                    confronto.participanteA(),
                    confronto.participanteB()
            );
        }
        System.out.printf(
                "%nTotal de confrontos: %d%n",
                confrontos.size()
        );
    }
}
