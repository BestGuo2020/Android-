package top.bestguo.androidlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        imageView = (ImageView) findViewById(R.id.network);


        Glide.with(this).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-" +
                "ssl.duitang.com%2Fuploads%2Fitem%2F202005%2F13%2F20200513102628_rkgmf.thumb.1000_0." +
                "jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002" +
                "&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg").into(imageView);

    }
}
