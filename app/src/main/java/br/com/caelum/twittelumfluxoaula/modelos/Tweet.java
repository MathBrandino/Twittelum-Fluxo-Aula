package br.com.caelum.twittelumfluxoaula.modelos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity
public class Tweet {

    @PrimaryKey(autoGenerate = true)
    private Long id;

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

    @Deprecated
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Deprecated
    public void setId(Long id) {
        this.id = id;
    }

    @Deprecated
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }
}
