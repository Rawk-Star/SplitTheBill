package com.rawks.jeremy.splitthebill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(btnStartClick);
    }
    Button.OnClickListener btnStartClick = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            startActivity(new Intent(MainActivity.this, BillSplitActivity.class));
        }
    };
}
