package top.bestguo.androidlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopupWindowActivity extends AppCompatActivity {

    private Button button;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        button = (Button) findViewById(R.id.button_pop);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop, null);
                TextView good = view.findViewById(R.id.good);
                TextView general = view.findViewById(R.id.general);
                TextView bad = view.findViewById(R.id.bad);

                good.setOnClickListener(new PopupItemClickListener());
                general.setOnClickListener(new PopupItemClickListener());
                bad.setOnClickListener(new PopupItemClickListener());

                popupWindow = new PopupWindow(view, button.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(button);
            }
        });
    }

    private class PopupItemClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView tv = (TextView) v;
            Toast.makeText(PopupWindowActivity.this, "你点击的是：" + tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
