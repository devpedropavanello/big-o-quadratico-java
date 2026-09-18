package br.com.pedropavanello.bigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class GeradorConfrontos {

    public List<Confronto> gerar(List<String> participantes) {
        Objects.requireNonNull(
                participantes,
                "A lista de participantes não pode ser nula."
                );

        List<Confronto> confrontos = new ArrayList<>();

        for (int i = 0; i < participantes.size(); i++) {
            for (int j = i + 1; j < participantes.size(); j++) {
                confrontos.add(
                        new Confronto(
                                participantes.get(i),
                                participantes.get(j)
                        )
                );
            }
        }
        return List.copyOf(confrontos);
    }
}
