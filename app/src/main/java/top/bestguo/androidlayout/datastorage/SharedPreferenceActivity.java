package top.bestguo.androidlayout.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import top.bestguo.androidlayout.R;

public class SharedPreferenceActivity extends AppCompatActivity {

    // 基本组件声明
    private EditText etName;
    private Button btnSave, btnShow;
    private TextView tvShow;

    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        etName = (EditText) findViewById(R.id.et_name);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnShow = (Button) findViewById(R.id.btn_show);
        tvShow = (TextView) findViewById(R.id.tv_show);

        // 文件名称，直接使用 MODE_PRIVATE
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        // 开始编辑
        sEditor = sharedPreferences.edit();

        // 写文件
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 写入数据
                sEditor.putString("name", etName.getText().toString());
                // 提交数据，提交数据有两种方式，一个是 commit，一个是 apply
                sEditor.apply();
            }
        });

        // 读文件
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 读取数据，将数据展示到 TextView 中
                tvShow.setText(sharedPreferences.getString("name", ""));
            }
        });
    }
}
