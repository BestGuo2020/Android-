package top.bestguo.androidlayout.recyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import top.bestguo.androidlayout.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        rv_list = findViewById(R.id.rv_list);
        // 添加布局管理器，这里添加的是线性布局管理器，默认为竖直方向
        // rv_list.setLayoutManager(new LinearLayoutManager(this));
        // 将其设置成水平方向，默认不逆序展示
        rv_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // 添加一个 Decoration
        rv_list.addItemDecoration(new MyDecoration());
        // 添加一个 Adapter 用于渲染全部的 item
        rv_list.setAdapter(new LinearAdapter());

    }

    // 新建的 Adapter
    private class LinearAdapter extends RecyclerView.Adapter<LinearViewHolder> {

        @Override
        public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new LinearViewHolder(LayoutInflater.from(LinearRecyclerViewActivity.this).inflate(R.layout.layout_list_recycler_item, parent, false));
        }

        @Override
        public void onBindViewHolder(LinearViewHolder holder, final int position) {
            holder.getTextView().setText("菜单选项_" + position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(LinearRecyclerViewActivity.this, "点击了第 " + position + " 项", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return 20;
        }


    }

    // 新建的 LinearViewHolder
    private class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_recycle_item);
        }

        TextView getTextView() {
            return textView;
        }
    }

    // 创建一个自己的 Decoration
    private class MyDecoration extends RecyclerView.ItemDecoration {
        // 设置偏移量
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.divideHeight));
        }
    }
}
