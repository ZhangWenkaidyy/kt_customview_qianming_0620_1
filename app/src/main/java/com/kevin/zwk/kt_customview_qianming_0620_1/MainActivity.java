package com.kevin.zwk.kt_customview_qianming_0620_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyCustomView mycustomview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mycustomview = (MyCustomView) findViewById(R.id.mycustomview);
    }

    public void click(View view) {
        mycustomview.reset();


    }
}
