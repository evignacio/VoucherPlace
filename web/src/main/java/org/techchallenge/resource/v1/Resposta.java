package org.techchallenge.resource.v1;

import lombok.Getter;

@Getter
public class Resposta<T> {
    private final Mensagem mensagem;
    private final T corpo;

    private Resposta(Mensagem mensagem, T corpo) {
        this.mensagem = mensagem;
        this.corpo = corpo;
    }

    public static Resposta criar() {
        return new Resposta(new Mensagem(0, "Operacao realizada com sucesso"), null);
    }

    public static <T> Resposta criar(T corpo) {
        return new Resposta(new Mensagem(0, "Operacao realizada com sucesso"), corpo);
    }

    public static Resposta criar(int codigo, String mensagem) {
        return new Resposta(new Mensagem(codigo, mensagem), null);
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
