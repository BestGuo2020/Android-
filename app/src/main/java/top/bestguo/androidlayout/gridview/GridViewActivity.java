package top.bestguo.androidlayout.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import top.bestguo.androidlayout.R;

/**
 * Created by He Guo on 2021/1/29.
 */

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new MyGridViewAdapter(this));

        // 点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "我是祢豆子 " + (i+1) + " 号", Toast.LENGTH_SHORT).show();
            }
        });

        // 长按事件
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView = view.findViewById(R.id.header);
                TextView textView = view.findViewById(R.id.name);

                Glide.with(GridViewActivity.this).load("http://pic.17qq.com/img_qqtouxiang/87450489.jpeg").into(imageView);
                textView.setText("我妻善逸");
                Toast.makeText(GridViewActivity.this, "嘻嘻，偷偷抱走" + (i+1) + "号祢豆子", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
