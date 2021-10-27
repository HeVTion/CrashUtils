package com.hvx.crashlibrary;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.crashlibrary.R;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        TextView content = findViewById(R.id.content);
        content.setText(Html.fromHtml(CrashHandler.getInstance().readError()));
        content.setMovementMethod(ScrollingMovementMethod.getInstance());

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = CrashHandler.getInstance().readError();
                Log.e("", str);
                finish();
            }
        });


    }
}