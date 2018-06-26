package br.com.caelum.twittelumfluxoaula.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.twittelumfluxoaula.R;
import br.com.caelum.twittelumfluxoaula.application.TwittelumApplication;
import br.com.caelum.twittelumfluxoaula.bancodedados.dao.TweetDao;
import br.com.caelum.twittelumfluxoaula.modelos.Tweet;

public class ListaTweetsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_lista_tweets, container, false);

        ListView lista = view.findViewById(R.id.fragment_lista_tweets);

        TweetDao tweetDao = TwittelumApplication.getInstance().getTweetDao();
        List<Tweet> tweets = tweetDao.lista();
        ArrayAdapter<Tweet> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, tweets);
        lista.setAdapter(adapter);

        return view;

    }


}
