package com.ihongqiqu.androidschemedemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//h5打开的链接
//tuiyouqianapp://tuiyouqianapp.com/open/scheme?name=google09&page=1
public class SchemeActivity extends AppCompatActivity {

    TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);
        tv_data = (TextView) findViewById(R.id.tv_data);
        //以下可以不用写也能跳进来
        Uri uri = getIntent().getData();
        StringBuilder sb = new StringBuilder();
        // 唤起链接
        sb.append("string : ").append(getIntent().getDataString()).append("\n");
        sb.append("scheme : ").append(uri.getScheme()).append("\n");
        sb.append("host : ").append(uri.getHost()).append("\n");
        sb.append("port : ").append(uri.getPort()).append("\n");
        sb.append("path : ").append(uri.getPath()).append("\n");
        // 接收唤起的参数
        sb.append("name : ").append(uri.getQueryParameter("name")).append("\n");
        sb.append("page : ").append(uri.getQueryParameter("page"));

        tv_data.setText(sb.toString());
    }
}
