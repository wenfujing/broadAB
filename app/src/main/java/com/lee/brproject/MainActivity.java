package com.lee.brproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lee.aarlib.InvokeUtils;

public class MainActivity extends AppCompatActivity {
    InvokeUtils invokeUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        invokeUtils = new InvokeUtils();

        findViewById(R.id.btClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeUtils.init(MainActivity.this);
            }
        });

        findViewById(R.id.btClick2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeUtils.interferce1();
            }
        });

    }
}