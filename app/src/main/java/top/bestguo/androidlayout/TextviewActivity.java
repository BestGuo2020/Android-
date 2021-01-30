package top.bestguo.androidlayout;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextviewActivity extends AppCompatActivity {

    TextView tv3, tv4, tv5, tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        tv3 = (TextView) findViewById(R.id.textView3);
        // 获取 TextView 中的图片
        Drawable dw = tv3.getResources().getDrawable(R.drawable.down_arrow);
        dw.setBounds(0, -15, 45, 45);
        tv3.setCompoundDrawables(null, null, dw, null);

        // 设置中划线的代码
        tv4 = (TextView) findViewById(R.id.textView4);
        tv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); // 设置中划线

        // 设置下划线的代码
        tv5 = (TextView) findViewById(R.id.textView5);
        tv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        // 设置下划线的代码，使用 Html 的方式
        tv6 = (TextView) findViewById(R.id.textView6);
        tv6.setText(Html.fromHtml("<u>Hello，我是BestGuo</u>"));

    }
}
