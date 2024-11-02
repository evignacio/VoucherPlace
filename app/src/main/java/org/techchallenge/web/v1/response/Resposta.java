package org.techchallenge.web.v1.response;

import lombok.Getter;

@Getter
public class Resposta {
    private final Mensagem mensagem;

    private Resposta(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public static Resposta criar() {
        return new Resposta(new Mensagem(0, "Operacao realizada com sucesso"));
    }

    public static Resposta criar(int codigo, String mensagem) {
        return new Resposta(new Mensagem(codigo, mensagem));
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
