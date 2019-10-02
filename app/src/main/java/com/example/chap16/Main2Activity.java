package com.example.chap16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.img);
        registerForContextMenu(imageView); // 이미지뷰에 컨텍스트 메뉴 등록
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
        if(item.getItemId() == 0)
            showToast("서버 전송 완료");
        else if (item.getItemId() == 1)
            showToast("보관함에 보관됨");
        else if(item.getItemId() == 2)
            showToast("삭제됨");
        else
            showToast("오류: ID 값을 확인하세요.");
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Java 코드로 생성하기
//        MenuItem menuItem1 = menu.add(0,0,0,"메뉴 0");
//        MenuItem menuItem2 = menu.add(0,1,0,"메뉴 1");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        try {
            Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            method.setAccessible(true);
            method.invoke(menu, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("검색어를 입력하세요.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showToast("검색어 : " + query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == 0)
//            showToast("선택...이 선택되었습니다.");
//        else if(item.getItemId() == 1)
//            showToast("레이아웃이 선택되었습니다.");
        if (item.getItemId() == R.id.menu0)
            showToast("선택...이 선택되었습니다.");
        else if (item.getItemId() == R.id.menu1)
            showToast("레이아웃이 선택되었습니다.");
        else if (item.getItemId() == R.id.file)
            showToast("SubMenu 가 선택되었습니다.");
        else if (item.getItemId() == R.id.sub0)
            showToast("SubMenu > Sub 0이 선택되었습니다.");
        else if (item.getItemId() == R.id.sub1)
            showToast("SubMenu > Sub 1이 선택되었습니다.");
        else if (item.getItemId() == R.id.menu2)
            showToast("menu");
        else
            showToast("오류: ID 값을 확인하세요.");
        return true;
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
