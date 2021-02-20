package top.bestguo.androidlayout.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import top.bestguo.androidlayout.R;

/**
 * Created by He Guo on 2021/2/19.
 */

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.GridViewHolder> {

    private Context context;
    private ItemOnClickListener clickListener;
    private ItemOnLongClickListener longClickListener;

    // 构造方法，用于传递 Activity 类
    public GridRecyclerViewAdapter(Context context){
        this.context = context;
    }
    // 构造方法，一个用于传递 Activity 类，一个用于传入一个已实现的该接口的点击类
    public GridRecyclerViewAdapter(Context context, ItemOnClickListener clickListener){
        this.context = context;
        this.clickListener = clickListener;
    }
    // 构造方法，一个用于传递 Activity 类，一个用于传入一个已实现的该接口长按的点击类
    public GridRecyclerViewAdapter(Context context, ItemOnLongClickListener longClickListener){
        this.context = context;
        this.longClickListener = longClickListener;
    }
    // 构造方法，一个用于传递 Activity 类，一个用于传入一个已实现的该接口的点击类，另一个用于传入一个已实现的该接口长按的点击类
    public GridRecyclerViewAdapter(Context context, ItemOnClickListener clickListener, ItemOnLongClickListener longClickListener){
        this.context = context;
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;
    }

    @Override
    public GridRecyclerViewAdapter.GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(GridRecyclerViewAdapter.GridViewHolder holder, final int position) {
        // 加载网络图片
        Glide.with(context).load("http://www.topacg.com/wp-content/uploads" +
                "/2020/03/frc-11c619718c036bf579c246cdd07e6d77.jpeg").into(holder.imageView);
        holder.textView.setText("灶门祢豆子");
        // 短按事件
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 短按事件接口回调
                clickListener.click(v, position);
            }
        });
        // 长按事件
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // 长按事件接口回调
                return longClickListener.click(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GridViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.header);
            textView = itemView.findViewById(R.id.name);
        }
    }

    /**
     * 点击事件
     */
    interface ItemOnClickListener{
        void click(View v, int position);
    }

    /**
     * 长按点击事件
     */
    interface ItemOnLongClickListener{
        boolean click(View v, int position);
    }
}
