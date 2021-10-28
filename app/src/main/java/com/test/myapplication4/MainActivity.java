package com.test.myapplication4;

import android.app.Activity;
import android.os.Bundle;

import com.test.myapplication4.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String str = null;
                    str.substring(10);
                }
            }).start();

        });

        binding.button2.setOnClickListener(view -> {
            String str = null;
            str.substring(10);
        });

    }
}