package br.com.caelum.twittelumfluxoaula.bancodedados.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import br.com.caelum.twittelumfluxoaula.modelos.Tweet;

@Dao
public interface TweetDao {

    @Insert
    void salva(Tweet tweet);
}
