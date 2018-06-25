package br.com.caelum.twittelumfluxoaula.modelos;

import java.time.LocalDateTime;

public class Tweet {

    private String conteudo;
    private LocalDateTime data;

    public Tweet(String conteudo) {
        this.conteudo = conteudo;
        this.data = LocalDateTime.now();
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
