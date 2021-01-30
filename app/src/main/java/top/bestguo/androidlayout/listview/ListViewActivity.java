package top.bestguo.androidlayout.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import top.bestguo.androidlayout.R;

/**
 * Created by BestGuo on 2021/1/28.
 */

public class ListViewActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);

        // 设置一个适配器
        listView.setAdapter(new MyListAdapter(this));
        // 设置点击某一项的监听事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "点击的是第" + i + "项！", Toast.LENGTH_SHORT).show();
            }
        });
        // 设置点击某一项长按的监听事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "长按的是第" + i + "项！", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
