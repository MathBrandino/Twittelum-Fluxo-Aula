package br.com.caelum.twittelumfluxoaula.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.twittelumfluxoaula.R;
import br.com.caelum.twittelumfluxoaula.activity.TweetActivity;
import br.com.caelum.twittelumfluxoaula.application.TwittelumApplication;
import br.com.caelum.twittelumfluxoaula.bancodedados.dao.TweetDao;
import br.com.caelum.twittelumfluxoaula.modelos.Tweet;

public class ListaTweetsFragment extends Fragment {


    private ListView lista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_tweets, container, false);

        lista = view.findViewById(R.id.fragment_lista_tweets);


        FloatingActionButton fab = view.findViewById(R.id.fragment_lista_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), TweetActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(lista);

        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        carregaTweets();
    }

    private void carregaTweets() {
        TweetDao tweetDao = TwittelumApplication.getInstance().getTweetDao();
        List<Tweet> tweets = tweetDao.lista();
        ArrayAdapter<Tweet> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, tweets);
        lista.setAdapter(adapter);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == lista) {

            final Tweet tweet = recuperaTweet(menuInfo);

            MenuItem deletar = menu.add("Deletar");
            MenuItem compartilhar = menu.add("Compartilhar");


            deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {

                    TweetDao tweetDao = TwittelumApplication.getInstance().getTweetDao();
                    tweetDao.deleta(tweet);

                    carregaTweets();

                    return true;
                }
            });


        }

    }

    private Tweet recuperaTweet(ContextMenu.ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        int position = info.position;

        return (Tweet) lista.getItemAtPosition(position);
    }
}
