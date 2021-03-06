package com.fatrain.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.fatrain.android.twoactivites.extra.REPLY";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    TextView mTextMessage;
    EditText mReply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        mTextMessage = findViewById(R.id.text_message);
        mReply = findViewById(R.id.editText_second);
        mTextMessage.setText(message);
        
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString().trim();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
        
    }
}
