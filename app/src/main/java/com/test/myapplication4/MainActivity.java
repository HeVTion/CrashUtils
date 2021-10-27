package com.test.myapplication4;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ColorUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.test.myapplication4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

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

        boolean a = ColorUtils.isLightColor(Color.BLACK);
        LogUtils.e("BLACK is light " + a);
        boolean b = ColorUtils.isLightColor(Color.RED);
        LogUtils.e("RED is light " + b);
        boolean c = ColorUtils.isLightColor(Color.WHITE);
        LogUtils.e("WHITE is light " + c);
        boolean d = ColorUtils.isLightColor(Color.YELLOW);
        LogUtils.e("YELLOW is light " + d);
        boolean e = ColorUtils.isLightColor(Color.GREEN);
        LogUtils.e("GREEN is light " + e);
        boolean f = ColorUtils.isLightColor(Color.BLUE);
        LogUtils.e("BLUE is light " + f);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtils.finishAllActivities(true);
    }
}