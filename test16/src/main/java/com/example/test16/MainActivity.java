package com.example.test16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearLayout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "서버 전송");
        menu.add(0, 1, 0, "보관함에 보관");
        menu.add(0, 2, 0, "삭제");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0)
            showToast("서버 전송 완료");
        else if (item.getItemId() == 1)
            showToast("보관함에 보관됨");
        else if (item.getItemId() == 2)
            showToast("삭제됨");
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
