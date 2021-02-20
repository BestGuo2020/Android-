package top.bestguo.androidlayout.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import top.bestguo.androidlayout.R;

/**
 * Created by He Guo on 2021/2/19.
 */

class PuAdapter extends RecyclerView.Adapter<PuAdapter.PuViewHolder> {

    private Context context;

    public PuAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PuViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_pu_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(PuViewHolder holder, int position) {
        switch (position % 3) {
            case 1:
                Glide.with(context).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2F201501%2F15%2F1" +
                        "05418z33cyjacahzodgc3.jpg&refer=http%3A%2F%2Fattachments.gfan.com&a" +
                        "pp=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg").into(holder.imageView);
                break;
            case 2:
                Glide.with(context).load("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF" +
                        "6hhy/zhidao/pic/item/4610b912c8fcc3ce1a3113699045d688d53f20f3.jpg").into(holder.imageView);
                break;
            default:
                Glide.with(context).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201307%2F" +
                        "23%2F20130723121038_WxiVJ.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app" +
                        "=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg").into(holder.imageView);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 21;
    }

    static class PuViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public PuViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_asd);
        }
    }
}
