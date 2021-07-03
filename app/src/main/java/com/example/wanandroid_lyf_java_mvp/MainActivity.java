package com.example.wanandroid_lyf_java_mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wanandroid_lyf_java_mvp.ui.fragment.HomeFragment;
import com.example.wanandroid_lyf_java_mvp.ui.fragment.MainFragment;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()    //
                .beginTransaction()
                .add(R.id.fl_container,new MainFragment())
                .commit();
    }
}