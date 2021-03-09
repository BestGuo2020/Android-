package top.bestguo.androidlayout.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

import top.bestguo.androidlayout.R;

public class AlertDialogActivity extends AppCompatActivity {

    private Button btnAlertDialog1, btnAlertDialog2, btnAlertDialog3, btnAlertDialog4, btnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btnAlertDialog1 = findViewById(R.id.btn_alert_dialog_1); // 简单的弹出框
        btnAlertDialog2 = findViewById(R.id.btn_alert_dialog_2); // 单选按钮，无默认指定选中
        btnAlertDialog3 = findViewById(R.id.btn_alert_dialog_3); // 单选按钮，可默认指定选中
        btnAlertDialog4 = findViewById(R.id.btn_alert_dialog_4); // 多选按钮，可默认指定多个选中
        btnCustomDialog = findViewById(R.id.btn_custom_dialog); // 自定义对话框

        buttonClick();
    }

    private void buttonClick() {
        OnClick onClick = new OnClick();
        btnAlertDialog1.setOnClickListener(onClick);
        btnAlertDialog2.setOnClickListener(onClick);
        btnAlertDialog3.setOnClickListener(onClick);
        btnAlertDialog4.setOnClickListener(onClick);
        btnCustomDialog.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_alert_dialog_1:
                    // 基本的对话框
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("请回答").setMessage("你觉得《工作细胞》全系列好看吗？")
                            .setNeutralButton("一般", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "谢谢，看来还需要多改进才是！", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setPositiveButton("好看", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "谢谢，我们会做的越来越好！", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setNegativeButton("难看", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "谢谢，血小板好桑心呢，555～", Toast.LENGTH_LONG).show();
                                }
                            }).show();
                    break;
                case R.id.btn_alert_dialog_2:
                    // 单选对话框，但默认不选中
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] genders = {"男", "女"};
                    builder1.setItems(genders, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this, "你选择了：" + genders[which], Toast.LENGTH_LONG).show();
                        }
                    }).setTitle("请选择性别").show();
                    break;
                case R.id.btn_alert_dialog_3:
                    // 单选对话框，但是默认有选择的
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] genders2 = {"男", "女"};
                    builder2.setSingleChoiceItems(genders2, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this, "你选择了：" + genders2[which], Toast.LENGTH_LONG).show();
                            dialog.dismiss(); // 选中完成之后才会消失
                        }
                    }).setTitle("请选择性别").show().setCancelable(false); // 这里设置了点击对话框以外的部分不消失
                    break;
                case R.id.btn_alert_dialog_4:
                    // 多选对话框
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] multiChoices = {"AcFun", "bilibili", "嘀哩嘀哩", "樱花动漫"};
                    final boolean[] multiChecked = new boolean[multiChoices.length];
                    builder3.setTitle("你喜欢在哪个网站追番").setMultiChoiceItems(multiChoices, multiChecked, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            String msg = isChecked ? "你选择了：" + multiChoices[which] : "你反选了：" + multiChoices[which];
                            Toast.makeText(AlertDialogActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < multiChecked.length; i++) {
                                if(multiChecked[i]){
                                    sb.append(i == multiChecked.length - 1 ? multiChoices[i] : multiChoices[i] + "，");
                                }
                            }
                            Toast.makeText(AlertDialogActivity.this, "你喜欢在“" + sb.toString() + "”追番", Toast.LENGTH_LONG).show();
                        }
                    }).show();
                    break;
                case R.id.btn_custom_dialog:
                    CustomDialog customDialog = new CustomDialog(AlertDialogActivity.this, R.style.CustomDialog);
                    customDialog.setTitle("警告");
                    customDialog.setMessage("你的手机电量过低，请充电");
                    customDialog.setCancel("取消", new CustomDialog.OnCancelListener() {
                        @Override
                        public void onClick(CustomDialog dialog) {
                            Toast.makeText(AlertDialogActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                        }
                    });
                    customDialog.setOk("确定", new CustomDialog.OnOkListener() {
                        @Override
                        public void onClick(CustomDialog dialog) {
                            Toast.makeText(AlertDialogActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
                        }
                    });
                    customDialog.show();
                    break;
            }
        }
    }
}
