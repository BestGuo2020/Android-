package top.bestguo.androidlayout.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import top.bestguo.androidlayout.R;

/**
 * Created by He Guo on 2021/1/29.
 */

public class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyGridViewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.layout_grid_item, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.header);
            viewHolder.textView = view.findViewById(R.id.name);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        // 加载网络图片
        Glide.with(context).load("http://www.topacg.com/wp-content/uploads" +
                "/2020/03/frc-11c619718c036bf579c246cdd07e6d77.jpeg").into(viewHolder.imageView);
        // 加载本地图片
        // Glide.with(context).load("file:///android_asset/img/7.jpg").into(viewHolder.imageView);
        viewHolder.textView.setText("灶门祢豆子");
        return view;
    }
}
