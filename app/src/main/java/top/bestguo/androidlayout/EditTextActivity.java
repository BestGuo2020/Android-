package top.bestguo.androidlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText userEdit, passwordEdit;

    // 设置用户名和密码
    private String user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        // 得到用户名和密码的文本框
        userEdit = (EditText) findViewById(R.id.user);
        passwordEdit = (EditText) findViewById(R.id.password);

        userEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                user = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 得到登录按钮
        loginBtn = (Button) findViewById(R.id.login);
        // 通过点击事件获取用户名和密码
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 将用户名和密码通过提示框来展示
                Toast.makeText(EditTextActivity.this, "用户名为：" + user + "，密码为：" + password, Toast.LENGTH_LONG).show();
            }
        });
    }
}
