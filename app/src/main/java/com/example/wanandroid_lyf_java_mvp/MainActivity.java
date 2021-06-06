package com.example.wanandroid_lyf_java_mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wanandroid_lyf_java_mvp.ui.fragment.HomeFragment;
import com.example.wanandroid_lyf_java_mvp.ui.fragment.MainFragment;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragmentation.builder()
                // show stack view. Mode: BUBBLE, SHAKE, NONE
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
             .install();

        if (findFragment(HomeFragment.class) == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());  //load root Fragment
        }
    }
}