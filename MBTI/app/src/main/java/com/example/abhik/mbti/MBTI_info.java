package com.example.abhik.mbti;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MBTI_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_info);

        TextView tv_header = (TextView) findViewById(R.id.tv_header);
        Typeface myCustomFont1 = Typeface.createFromAsset(getAssets(), "fonts/Acme/Acme-Regular.ttf");
        tv_header.setTypeface(myCustomFont1);
        Button btn = (Button) findViewById(R.id.btn_test);


        TextView tv_detail = (TextView) findViewById(R.id.tv_detail);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "fonts/Dosis-Light.ttf");
        tv_detail.setTypeface(myCustomFont2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MBTI_info.this, MBTIquestionarre.class);
                startActivity(intent);
            }
        });
    }
}
