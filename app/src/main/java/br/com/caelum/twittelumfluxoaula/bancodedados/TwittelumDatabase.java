package br.com.caelum.twittelumfluxoaula.bancodedados;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import br.com.caelum.twittelumfluxoaula.bancodedados.conversor.LocalDateTimeConverter;
import br.com.caelum.twittelumfluxoaula.bancodedados.dao.TweetDao;
import br.com.caelum.twittelumfluxoaula.modelos.Tweet;

@Database(entities = {Tweet.class}, version = 1)
@TypeConverters(value = {LocalDateTimeConverter.class})
public abstract class TwittelumDatabase extends RoomDatabase {

    public abstract TweetDao getTweetDao();
}
