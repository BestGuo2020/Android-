package top.bestguo.androidlayout.datastorage;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.bestguo.androidlayout.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSharedPreferences, fileStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        // SharedPreferences
        buttonSharedPreferences = (Button) findViewById(R.id.btn_sharedPreference);
        buttonSharedPreferences.setOnClickListener(this);
        // FileStorage
        fileStorage = findViewById(R.id.btn_fileStorage);
        fileStorage.setOnClickListener(this);

        // 权限请求
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_sharedPreference:
                intent = new Intent(DataStorageActivity.this, SharedPreferenceActivity.class);
                break;
            case R.id.btn_fileStorage:
                intent = new Intent(DataStorageActivity.this, FileStorageActivity.class);
                break;
        }
        startActivity(intent);
    }
}
