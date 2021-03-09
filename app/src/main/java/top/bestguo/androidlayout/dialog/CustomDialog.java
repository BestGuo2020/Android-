package top.bestguo.androidlayout.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import top.bestguo.androidlayout.R;
import top.bestguo.androidlayout.utils.OtherUtils;

/**
 * 自定义弹出对话框
 */
public class CustomDialog extends Dialog{

    // 获取文本控件
    private TextView mTitle, mMessage, mCancel, mOk;
    // 字体设置
    private String title, message, cancel, ok;
    // 退出事件接口
    private OnCancelListener cancelListener;
    // 确定事件接口
    private OnOkListener okListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    /**
     * 设置弹窗标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 设置弹窗消息
     *
     * @param message 消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 设置退出按钮以及监听事件
     *
     * @param cancel 退出按钮文字
     * @param cancelListener 按钮点击事件
     */
    public void setCancel(String cancel, OnCancelListener cancelListener) {
        this.cancel = cancel;
        this.cancelListener = cancelListener;
    }

    /**
     * 设置 OK 按钮以及监听事件
     *
     * @param ok 确定按钮文字
     * @param okListener 确定按钮事件
     */
    public void setOk(String ok, OnOkListener okListener) {
        this.ok = ok;
        this.okListener = okListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 自适应宽高
        OtherUtils.adjustDialog(Objects.requireNonNull(getWindow()));
        // 载入自定义的对话框样式
        this.setContentView(R.layout.custom_dialog_layout);
        // 获取
        mTitle = findViewById(R.id.dialog_title);
        mMessage = findViewById(R.id.dialog_content);
        mCancel = findViewById(R.id.dialog_cancel);
        mOk = findViewById(R.id.dialog_ok);
        // 设置相关文字
        if(!TextUtils.isEmpty(title)){
            mTitle.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            mMessage.setText(message);
        }
        if(!TextUtils.isEmpty(cancel)){
            mCancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(ok)){
            mOk.setText(ok);
        }
        // 设置监听事件
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cancelListener != null){
                    cancelListener.onClick(CustomDialog.this);
                }
                dismiss();
            }
        });
        // 设置监听事件
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(okListener != null){
                    okListener.onClick(CustomDialog.this);
                }
                dismiss();
            }
        });
    }

    public interface OnCancelListener {
        void onClick(CustomDialog dialog);
    }

    public interface OnOkListener {
        void onClick(CustomDialog dialog);
    }
}
