package com.example.chap16;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        final ActionBar actionBar = getSupportActionBar();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionBar.hide();
            }
        });
    }
}
