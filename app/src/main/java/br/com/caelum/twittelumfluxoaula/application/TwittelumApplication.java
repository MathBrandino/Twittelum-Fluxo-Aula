package br.com.caelum.twittelumfluxoaula.application;

import android.app.Application;
import android.arch.persistence.room.Room;

import br.com.caelum.twittelumfluxoaula.bancodedados.TwittelumDatabase;
import br.com.caelum.twittelumfluxoaula.bancodedados.dao.TweetDao;

public class TwittelumApplication extends Application {

    private static TwittelumApplication instance;

    private TwittelumDatabase database;

    public static TwittelumApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        this.database = Room.databaseBuilder(this, TwittelumDatabase.class, "twittelum")
                .allowMainThreadQueries()
                .build();
    }

    public TweetDao getTweetDao() {
        return database.getTweetDao();
    }
}
