package com.example.androidsecondprojectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidsecondprojectdemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private Button button_login;
    private EditText edit_text_email, edit_text_password;

    List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }

    public void login(){
        button_login = (Button) findViewById(R.id.button_login);
        edit_text_email = (EditText) findViewById(R.id.edit_text_email);
        edit_text_password = (EditText) findViewById(R.id.edit_text_password);

        User user1 = new User(1,"Cung", "cung@gmail.com","password" );
        User user2 = new User(2,"Ha", "ha@gmail.com","password" );
        users.add(user1);
        users.add(user2);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit_text_email.getText().toString();
                String password = edit_text_password.getText().toString();

                if (checkLogin(email,password)){
                    Intent loginIntent = new Intent(view.getContext(), HomeActivity.class);
                    loginIntent.putExtra("email", email);
                    loginIntent.putExtra("password", password);
                    startActivityForResult(loginIntent,0);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Email or password incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkLogin(String email, String password){
        boolean check = false;
        for (User user : users){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                check = true;
                break;
            }
        }
        return check;
    }
}
