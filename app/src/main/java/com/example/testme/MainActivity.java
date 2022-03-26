package com.example.testme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login_btn = (Button) findViewById(R.id.go_to_login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
        Button signup_btn = (Button) findViewById(R.id.go_to_signup);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });
        Button home_btn = (Button) findViewById(R.id.btn_home);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
        Button recycler_btw = (Button) findViewById(R.id.view);
        recycler_btw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRecyclerView();
            }
        });
    }

    public void openLogin() {
        Intent intent = new Intent(this,login_in.class);
        startActivity(intent);
    }

    public void openSignup() {
        Intent intent = new Intent(this,sign_up.class);
        startActivity(intent);
    }

    public void openHome() {
        Intent intent = new Intent(this,home.class);
        startActivity(intent);
    }

    public void openRecyclerView() {
        Intent intent = new Intent(this,relative_layout.class);
        startActivity(intent);
    }
}