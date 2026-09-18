package br.com.pedropavanello.bigo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeradorConfrontosTest {

    private final GeradorConfrontos gerador = new GeradorConfrontos();

    @Test
    void deveGerarTodosOsConfrontosUnicos() {
        List<String> participantes = List.of(
                "Ana",
                "Bruno",
                "Carlos",
                "Diana"
        );

        List<Confronto> confrontos = gerador.gerar(participantes);

        List<Confronto> confrontosEsperados = List.of(
                new Confronto("Ana", "Bruno"),
                new Confronto("Ana", "Carlos"),
                new Confronto("Ana", "Diana"),
                new Confronto("Bruno", "Carlos"),
                new Confronto("Bruno", "Diana"),
                new Confronto("Carlos", "Diana")
        );

        assertEquals(confrontosEsperados, confrontos);
    }

    @Test
    void deveGerarQuantidadeEsperadaDeConfrontos() {
        List<String> participantes = List.of(
                "Ana",
                "Bruno",
                "Carlos",
                "Diana",
                "Eduardo"
        );

        int quantidadeEsperada =
                participantes.size() * (participantes.size() - 1) / 2;

        List<Confronto> confrontos = gerador.gerar(participantes);

        assertEquals(quantidadeEsperada, confrontos.size());
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoForPossivelFormarConfronto() {
        List<Confronto> confrontos = gerador.gerar(List.of("Ana"));

        assertTrue(confrontos.isEmpty());
    }

    @Test
    void deveRejeitarListaNula() {
        assertThrows(
                NullPointerException.class,
                () -> gerador.gerar(null)
        );
    }
}