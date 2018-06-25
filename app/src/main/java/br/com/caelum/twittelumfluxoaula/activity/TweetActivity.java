package br.com.caelum.twittelumfluxoaula.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.com.caelum.twittelumfluxoaula.R;
import br.com.caelum.twittelumfluxoaula.modelos.Tweet;

public class TweetActivity extends AppCompatActivity {

    private EditText conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        conteudo = findViewById(R.id.conteudo);

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
                Tweet tweet = new Tweet(conteudo.getText().toString());
                Toast.makeText(TweetActivity.this, tweet.getConteudo(), Toast.LENGTH_SHORT).show();
        }


        return true;
    }
}
