package top.bestguo.androidlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox acfun, bilibili, niconico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        // 分别获取 AcFun、bilibili 和 niconico 的复选框
        acfun = (CheckBox) findViewById(R.id.acfun);
        bilibili = (CheckBox) findViewById(R.id.bilibili);
        niconico = (CheckBox) findViewById(R.id.niconico);

        // 为 AcFun 设置选中事件
        acfun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // 选中了就提示"你选了AcFun" ，反选就提示"你反选了AcFun"
                Toast.makeText(CheckBoxActivity.this, b ? "你选了AcFun" : "你反选了AcFun", Toast.LENGTH_SHORT).show();
            }
        });

        // 为 bilibili 设置点击事件
        bilibili.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this, b ? "你选了bilibili" : "你反选了bilibili", Toast.LENGTH_SHORT).show();
            }
        });

        // 为 niconico 设置点击事件
        niconico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this, b ? "你选了niconico" : "你反选了niconico", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
