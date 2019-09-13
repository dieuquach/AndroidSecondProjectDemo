package com.example.androidsecondprojectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView text_view_hello, text_view_email, text_view_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showInfoUser();
    }

    public void showInfoUser(){
        text_view_hello = (TextView) findViewById(R.id.text_view_hello);
        text_view_email = (TextView) findViewById(R.id.text_view_email);
        text_view_password = (TextView) findViewById(R.id.text_view_password);

        final Intent homeIntent = this.getIntent();
        String email = homeIntent.getStringExtra("email");
        String password = homeIntent.getStringExtra("password");

        text_view_email.setText(email);
        text_view_password.setText(password);

        text_view_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, homeIntent);
                finish();
            }
        });
    }
}
