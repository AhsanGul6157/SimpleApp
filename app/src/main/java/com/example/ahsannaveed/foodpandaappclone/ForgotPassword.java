package com.example.ahsannaveed.foodpandaappclone;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ForgotPassword extends AppCompatActivity {
    private ImageView crossBtn;
    private TextInputLayout forgot_email_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        crossBtn = findViewById(R.id.cross_btn_forgot_password);
        forgot_email_et = findViewById(R.id.email_et);
        //listener of cross imageview
        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
