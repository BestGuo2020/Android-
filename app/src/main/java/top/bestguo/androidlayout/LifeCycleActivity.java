package top.bestguo.androidlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by He Guo on 2021/1/31.
 */

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycle", "----onCreate----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "----onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "----onResume----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "----onPause----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "----onStop----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "----onDestroy----");
    }
}
