package top.bestguo.androidlayout.recyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import top.bestguo.androidlayout.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        recyclerView = findViewById(R.id.recycler_view_grid);
        recyclerView.setAdapter(new GridRecyclerViewAdapter(this, new ClickListener(), new LongClickListener()));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int gap = getResources().getDimensionPixelOffset(R.dimen.space);
                outRect.set(gap, gap, gap, gap);
            }
        });

    }

    // 实现短按的点击事件接口
    private class ClickListener implements GridRecyclerViewAdapter.ItemOnClickListener {
        @Override
        public void click(View v, int position) {
            Toast.makeText(GridRecyclerViewActivity.this, "我是祢豆子 " + (position + 1) + " 号", Toast.LENGTH_SHORT).show();
        }
    }

    // 实现长按的点击事件接口
    private class LongClickListener implements GridRecyclerViewAdapter.ItemOnLongClickListener {
        @Override
        public boolean click(View v, int position) {
            ImageView imageView = v.findViewById(R.id.header);
            Glide.with(GridRecyclerViewActivity.this).load("http://pic.17qq.com/img_qqtouxiang/87450489.jpeg").into(imageView);
            Toast.makeText(GridRecyclerViewActivity.this, "嘻嘻，偷偷抱走" + (position + 1) + "号祢豆子", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
