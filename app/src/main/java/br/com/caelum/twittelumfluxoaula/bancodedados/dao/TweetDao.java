package br.com.caelum.twittelumfluxoaula.bancodedados.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.caelum.twittelumfluxoaula.modelos.Tweet;

@Dao
public interface TweetDao {

    @Insert
    void salva(Tweet tweet);

    @Query("select * from Tweet")
    List<Tweet> lista();

    @Delete
    void deleta(Tweet tweet);
}
