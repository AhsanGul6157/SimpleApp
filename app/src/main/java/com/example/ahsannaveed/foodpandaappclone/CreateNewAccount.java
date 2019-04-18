package com.example.ahsannaveed.foodpandaappclone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class CreateNewAccount extends AppCompatActivity {
    private TextView alreadyText;
    private LoginButton facebookLoginButton;
    CallbackManager callbackManager;
    private ImageView crossImageCreateAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
        LinearLayout sign_up_with_Email_btn = findViewById(R.id.sign_up_mail);
        alreadyText = findViewById(R.id.already_member_log_in);
        facebookLoginButton = findViewById(R.id.login_button);
        crossImageCreateAccount = findViewById(R.id.create_account_cross_image);
        //setting listener on cross image Button
        crossImageCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        //setting listener on signup with email button
        sign_up_with_Email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
        //setting listener on already a member
        alreadyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        //setting listener on facebook log in Button
        //facebook login Button
        facebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackManager = CallbackManager.Factory.create();
                facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        setFinishOnTouchOutside(false);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(getApplicationContext(), "Something went wrong,Please check and try again", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }
}
