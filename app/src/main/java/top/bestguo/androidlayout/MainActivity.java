package top.bestguo.androidlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.bestguo.androidlayout.gridview.GridViewActivity;
import top.bestguo.androidlayout.listview.ListViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 跳转到线性布局示例
        btn1 = (Button) findViewById(R.id.btn1);
        // 跳转到相对布局示例
        btn2 = (Button) findViewById(R.id.btn2);
        // 跳转到 TextView 组件示例
        btn3 = (Button) findViewById(R.id.btn3);
        // 跳转到 Button 组件示例
        btn4 = (Button) findViewById(R.id.btn4);
        // 跳转到 EditText 组件示例
        btn5 = (Button) findViewById(R.id.btn5);
        // 跳转到 RadioButton 组件示例
        btn6 = (Button) findViewById(R.id.btn6);
        // 跳转到 CheckBox 组件示例
        btn7 = (Button) findViewById(R.id.btn7);
        // 跳转到 ImageView 组件示例
        btn8 = (Button) findViewById(R.id.btn8);
        // 跳转到 ListView 组件示例
        btn9 = (Button) findViewById(R.id.btn9);
        // 跳转到 GridView 组件示例
        btn10 = (Button) findViewById(R.id.btn10);
        allButtonClick();

    }

    private void allButtonClick() {
        ButtonClick buttonClick = new ButtonClick();
        btn1.setOnClickListener(buttonClick);
        btn2.setOnClickListener(buttonClick);
        btn3.setOnClickListener(buttonClick);
        btn4.setOnClickListener(buttonClick);
        btn5.setOnClickListener(buttonClick);
        btn6.setOnClickListener(buttonClick);
        btn7.setOnClickListener(buttonClick);
        btn8.setOnClickListener(buttonClick);
        btn9.setOnClickListener(buttonClick);
        btn10.setOnClickListener(buttonClick);
    }

    private class ButtonClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn1:
                    intent = new Intent(MainActivity.this, LinearActivity.class);
                    break;
                case R.id.btn2:
                    intent = new Intent(MainActivity.this, RelativeActivity.class);
                    break;
                case R.id.btn3:
                    intent = new Intent(MainActivity.this, TextviewActivity.class);
                    break;
                case R.id.btn4:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn5:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn6:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn7:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn8:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn9:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn10:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
