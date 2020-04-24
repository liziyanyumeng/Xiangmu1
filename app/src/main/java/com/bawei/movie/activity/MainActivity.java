package com.bawei.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.movie.R;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private TextView textNumvber;
    private Handler handler = new Handler() {
        //定义一个跳转秒数
        private int i = 3;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //判断发过来的消息
            if (msg.what == 0) {
                i--;
                if (i==0){
                    Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    //更改UI
                    textNumvber.setText(i+"S");
                    //发送消息
                    handler.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        image = (ImageView) findViewById(R.id.image);
        textNumvber = (TextView) findViewById(R.id.text_numvber);
        handler.sendEmptyMessageDelayed(0, 1000);
    }

}
