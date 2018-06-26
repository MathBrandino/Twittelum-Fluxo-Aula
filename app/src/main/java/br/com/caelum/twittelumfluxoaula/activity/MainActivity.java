package br.com.caelum.twittelumfluxoaula.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.twittelumfluxoaula.R;
import br.com.caelum.twittelumfluxoaula.adapter.ViewPagerAdapter;
import br.com.caelum.twittelumfluxoaula.fragment.BuscaTweetFragment;
import br.com.caelum.twittelumfluxoaula.fragment.ListaTweetsFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TWITTELUM = "Twittelum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.main_view_pager);

        FragmentManager manager = getSupportFragmentManager();
        List<Fragment> fragments = Arrays.asList(new ListaTweetsFragment(), new BuscaTweetFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(manager, fragments);
        pager.setAdapter(adapter);

        Log.i(TWITTELUM, "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TWITTELUM, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TWITTELUM, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TWITTELUM, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TWITTELUM, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TWITTELUM, "onDestroy");
    }
}
