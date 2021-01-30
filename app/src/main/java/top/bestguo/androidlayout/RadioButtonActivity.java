package top.bestguo.androidlayout;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        rg1 = (RadioGroup) findViewById(R.id.rg1);
        // 设置 setOnCheckedChangeListener 监听事件
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                // 获取某个单选按钮的 id
                RadioButton radioButton = radioGroup.findViewById(i);
                Toast.makeText(RadioButtonActivity.this, "点击了“" + radioButton.getText() + "”", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
