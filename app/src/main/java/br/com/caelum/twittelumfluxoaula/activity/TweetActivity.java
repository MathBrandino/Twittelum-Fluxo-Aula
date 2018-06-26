package br.com.caelum.twittelumfluxoaula.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.com.caelum.twittelumfluxoaula.R;
import br.com.caelum.twittelumfluxoaula.application.TwittelumApplication;
import br.com.caelum.twittelumfluxoaula.bancodedados.dao.TweetDao;
import br.com.caelum.twittelumfluxoaula.modelos.Tweet;

public class TweetActivity extends AppCompatActivity {

    private EditText campoConteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        campoConteudo = findViewById(R.id.conteudo);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_tweet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_salvar:
                String conteudo = campoConteudo.getText().toString();
                if (!conteudo.trim().isEmpty()) {

                    Tweet tweet = new Tweet(conteudo);

                    TweetDao tweetDao = TwittelumApplication.getInstance().getTweetDao();

                    tweetDao.salva(tweet);

                    Toast.makeText(TweetActivity.this, "Tweet salvo", Toast.LENGTH_SHORT).show();

                    finish();
                } else {
                    campoConteudo.setError("Campo precisa ter algo");
                }

                return true;

            case android.R.id.home:
                finish();
        }

        return true;
    }
}
