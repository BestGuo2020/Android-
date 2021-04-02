package com.example.viewpager2study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;

import com.example.viewpager2study.adapter.ViewPager2Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化值
        List<Item> list = new ArrayList<>();
        list.add(new Item(Color.RED, "1", Color.WHITE));
        list.add(new Item(Color.parseColor("#FFA500"), "2", Color.WHITE));
        list.add(new Item(Color.YELLOW, "3", Color.BLACK));
        list.add(new Item(Color.GREEN, "4", Color.WHITE));
        list.add(new Item(Color.BLUE, "5", Color.WHITE));
        list.add(new Item(Color.parseColor("#4B0082"), "6", Color.WHITE));
        list.add(new Item(Color.parseColor("#800080"), "7", Color.WHITE));

        viewPager2 = findViewById(R.id.view_pager2);
        // 设置排列方式
//        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(new ViewPager2Adapter(list));

        // recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ViewPager2Adapter(list));
    }
}