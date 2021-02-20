package top.bestguo.androidlayout.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.bestguo.androidlayout.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mListBtn, mGridBtn, mPuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // RecyclerView 中的List布局
        mListBtn = findViewById(R.id.llm);
        mListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class));
            }
        });

        // RecyclerView 中的Grid布局
        mGridBtn = findViewById(R.id.glm);
        mGridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class));
            }
        });

        // RecyclerView 中的瀑布流
        mPuBtn = findViewById(R.id.pu);
        mPuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewActivity.this, PuRecyclerViewActivity.class));
            }
        });

    }
}
