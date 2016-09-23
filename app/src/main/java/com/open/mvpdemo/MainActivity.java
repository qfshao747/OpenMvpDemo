package com.open.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mListviewBtn;
    private Button mTextViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListviewBtn = (Button) findViewById(R.id.listview_btn);
        mTextViewBtn = (Button) findViewById(R.id.textview_btn);
        mListviewBtn.setOnClickListener(this);
        mTextViewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listview_btn:
                ListViewActivity.open(this,"params");
                break;
            case R.id.textview_btn:
                TextViewActivity.open(this);
                break;
        }
    }
}
