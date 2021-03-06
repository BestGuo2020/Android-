package top.bestguo.androidlayout.datastorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import top.bestguo.androidlayout.R;

public class FileStorageActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnSave, btnShow, btnDelete, getAllPath;
    private TextView tvShow;
    private String fileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);

        etName = findViewById(R.id.et_name);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);
        btnDelete = findViewById(R.id.btn_delete);
        getAllPath = findViewById(R.id.get_all_path);
        tvShow = findViewById(R.id.tv_show);

        // 写文件
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // saveInternal(etName.getText().toString());
                saveOuter(etName.getText().toString());
            }
        });

        // 读文件
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // tvShow.setText(readInternal());
                tvShow.setText(readOuter());
            }
        });

        // 删除文件
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDeleted = deleteFile(fileName);
                if(isDeleted){
                    Toast.makeText(FileStorageActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FileStorageActivity.this, "删除失败，该文件可能不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 获取外部的全部路径
        getAllPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File[] files = getExternalFilesDirs("");
                for (File file : files){
                    Log.d("outer storage", file.toString());
                }
            }
        });
    }

    // 存储数据到内部存储
    private void saveInternal(String content){
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(fileName, MODE_PRIVATE);
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 从内部存储读取数据
    private String readInternal() {
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try {
            fis = openFileInput(fileName);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) > 0) {
                sb.append(new String(bytes, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return null;
    }

    private void saveOuter(String context) {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        FileOutputStream fos = null;
        try {
            // 获取外部存储的路径
            File dir = new File(Environment.getExternalStorageDirectory(), "bestguo");
            // 创建文件夹
            if(!dir.exists()) {
                Log.d("isCreatedDir", dir.mkdirs() + "");
            }
            // 创建文件
            File file = new File(dir, fileName);
            Log.d("file_path", file.toString());
            if(!file.exists()){
                Log.d("isCreatedDir", "" + file.createNewFile());
            }
            // 创建输入流
            fos = new FileOutputStream(file);
            fos.write(context.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String readOuter() {
        FileInputStream fos = null;
        // 获取外部存储目录
        String path = Environment.getExternalStorageDirectory().toString();
        // 创建文件类
        File file = new File(path + File.separator + "bestguo", fileName);
        try {
            StringBuilder sb = new StringBuilder();
            // 创建字节流对象
            fos = new FileInputStream(file);
            int len;
            byte[] bytes = new byte[1024];
            while((len = fos.read(bytes)) > 0) {
                sb.append(new String(bytes, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}