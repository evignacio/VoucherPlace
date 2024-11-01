package org.techchallenge.gestaocontas.web.v1.response;

import lombok.Getter;

@Getter
public class Response {
    private final Mensagem mensagem;

    private Response(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public static Response sucesso() {
        return new Response(new Mensagem(0, "Operacao realizada com sucesso"));
    }

    @Getter
    private static class Mensagem {
        private final int codigo;
        private final String descricao;

        public Mensagem(int codigo, String descricao) {
            this.codigo = codigo;
            this.descricao = descricao;
        }
    }
}
