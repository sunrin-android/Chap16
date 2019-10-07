package com.example.test16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    ActionBar actionBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearLayout);
        textView = findViewById(R.id.textView);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_launcher_foreground);
        actionBar.setDisplayShowTitleEnabled(false);

        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "RED");
        menu.add(0, 1, 0, "WHITE");
        menu.add(0, 2, 0, "BLACK");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0)
            textView.setTextColor(Color.RED);
        else if (item.getItemId() == 1)
            textView.setTextColor(Color.WHITE);
        else if (item.getItemId() == 2)
            textView.setTextColor(Color.BLACK);
        else
            showToast("오류: ID 값을 확인하세요.");
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        try {
            Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            method.setAccessible(true);
            method.invoke(menu, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_colorRed)
            layout.setBackgroundColor(Color.RED);
        else if (item.getItemId() == R.id.menu_colorBlue)
            layout.setBackgroundColor(Color.BLUE);
        else if (item.getItemId() == R.id.menu_colorCyan)
            layout.setBackgroundColor(Color.CYAN);
        else if (item.getItemId() == R.id.menu_colorGreen)
            layout.setBackgroundColor(Color.GREEN);
        else if (item.getItemId() == R.id.menu_colorYellow)
            layout.setBackgroundColor(Color.YELLOW);
        else if (item.getItemId() == R.id.menu_colorWhte)
            layout.setBackgroundColor(Color.WHITE);
        else
            showToast("오류: ID 값을 확인하세요.");
        return true;
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
