package top.bestguo.androidlayout.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import top.bestguo.androidlayout.R;

/**
 * Created by BestGuo on 2021/1/28.
 */

public class MyListAdapter extends BaseAdapter {

    // 传入的 Activity，也就是 ListItemActivity
    private Context context;
    // 获取自己设置的布局
    private LayoutInflater layoutInflater;

    public MyListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 列表的长度是多少
     * @return 整型
     */
    @Override
    public int getCount() {
        return 15;
    }

    // 通过索引获取内容，但是我们目前没有内容，因此先放一下
    @Override
    public Object getItem(int i) {
        return null;
    }

    // 获取id，具体是什么样的id还需要看什么场景
    @Override
    public long getItemId(int i) {
        return 0;
    }

    // 自定义的内部类，用它来将 layout_list_item 中的组件将其保存起来
    private static class ViewHolder {
        ImageView imageView;
        TextView tvClock, tvContent, tvTitle;
    }

    /**
     * 列表中的样式每一项的设置
     *
     * @param i 每一个 item 中的第几项
     * @param view 对应的 item 布局
     * @param viewGroup 不知道，到时候用到在介绍
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            view = layoutInflater.inflate(R.layout.layout_list_item, null);

            viewHolder = new ViewHolder();

            viewHolder.imageView = view.findViewById(R.id.iv);
            viewHolder.tvClock = view.findViewById(R.id.tv_time);
            viewHolder.tvTitle = view.findViewById(R.id.tv_title);
            viewHolder.tvContent = view.findViewById(R.id.tv_content);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        // 给控件赋值
        viewHolder.tvClock.setText("2021-1-28");
        viewHolder.tvTitle.setText("Hello！");
        viewHolder.tvContent.setText("我是可爱的祢豆子 n(*≧▽≦*)n");
        // 添加网络图片
        if(i%2 != 0)
            Glide.with(context).load("http://www.topacg.com/wp-content/uploads" +
                "/2020/03/frc-11c619718c036bf579c246cdd07e6d77.jpeg").into(viewHolder.imageView);
        else
            Glide.with(context).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl." +
                    "duitang.com%2Fuploads%2Fitem%2F201912%2F10%2F20191210915" +
                    "02_8PjP3.thumb.700_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang." +
                    "com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg").into(viewHolder.imageView);

        Log.d("id=", i+"");

        return view;
    }
}
