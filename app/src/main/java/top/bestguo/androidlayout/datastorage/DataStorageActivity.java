package top.bestguo.androidlayout.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.bestguo.androidlayout.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        buttonSharedPreferences = (Button) findViewById(R.id.btn_sharedPreference);
        buttonSharedPreferences.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_sharedPreference:
                intent = new Intent(DataStorageActivity.this, SharedPreferenceActivity.class);
                break;
        }
        startActivity(intent);
    }
}
