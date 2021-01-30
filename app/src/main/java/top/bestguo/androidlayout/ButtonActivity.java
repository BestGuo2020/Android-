package top.bestguo.androidlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button btn3;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "btn3被点击了", Toast.LENGTH_SHORT).show();
            }
        });

        // TextView 的点击事件
        tv = (TextView) findViewById(R.id.tv1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "TextView被点击了", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void showToast(View view) {
        // 消息提示框
        Toast.makeText(this, "BestGuo, 吓了你一跳哦，并提示btn4被点击了", Toast.LENGTH_SHORT).show();
    }
}
