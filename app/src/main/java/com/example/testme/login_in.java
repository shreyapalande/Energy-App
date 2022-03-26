package com.example.testme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class login_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        TextView click_here = findViewById(R.id.click_here);
        SpannableString content1 = new SpannableString(" Click here");
        content1.setSpan( new UnderlineSpan() , 0 , content1.length() , 0 ) ;
        click_here.setText(content1) ;

        TextView forgot_pass = findViewById(R.id.forgot_pass);
        SpannableString content2 = new SpannableString("Forgot your password?");
        content2.setSpan( new UnderlineSpan() , 0 , content2.length() , 0 ) ;
        forgot_pass.setText(content2) ;
    }
}