package br.com.caelum.twittelumfluxoaula.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.twittelumfluxoaula.R;
import br.com.caelum.twittelumfluxoaula.adapter.ViewPagerAdapter;
import br.com.caelum.twittelumfluxoaula.fragment.BuscaTweetFragment;
import br.com.caelum.twittelumfluxoaula.fragment.ListaTweetsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.main_view_pager);

        FragmentManager manager = getSupportFragmentManager();
        List<Fragment> fragments = Arrays.asList(new ListaTweetsFragment(), new BuscaTweetFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(manager, fragments);
        pager.setAdapter(adapter);
    }
}
