package com.example.ahsannaveed.foodpandaappclone;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Build;
import android.os.Vibrator;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.core.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;

public class Login extends AppCompatActivity {
    private static final String TAG = "Login";
    private static final int RC_SIGN_IN = 2;

    private ImageView crossImage;
    private LoginButton facebookLoginButton;
    CallbackManager callbackManager;
    private FirebaseAuth mAuth;
    private Button signInButton;
    private TextView forgetPassword;
    private TextView creat_Account_Text;
    EditText email;
    EditText password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        crossImage = findViewById(R.id.cross_image);
        facebookLoginButton = findViewById(R.id.login_button);
        forgetPassword = findViewById(R.id.forgot_password);
        email = findViewById(R.id.email_et);
        password = findViewById(R.id.password_et);
        crossImage = findViewById(R.id.cross_image);
        creat_Account_Text = findViewById(R.id.new_user);
        mAuth = FirebaseAuth.getInstance();




        //facebook login Button
        facebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackManager = CallbackManager.Factory.create();
                facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                        showMenuItem();
                    }

                    @Override
                    public void onCancel() {
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(Login.this, "Something went wrong,Please check and try again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signInButton = findViewById(R.id.sign_in_btn);
        //setting listener on Sign in Button
        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().getCurrentUser();
                String email_et = email.getText().toString().trim();
                String pass_et = password.getText().toString().trim();

                if (TextUtils.isEmpty(email_et)) {
                    Toast.makeText(Login.this, "Please enter Email", Toast.LENGTH_SHORT).show();

                }
                if (TextUtils.isEmpty(pass_et)) {
                    Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
                else onAuthSuccessful();

                }
        });
        //forget password
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);

            }
        });
//create account text setting listener
        creat_Account_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, CreateNewAccount.class);
                startActivity(intent);
            }
        });


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//// ...
//// Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//
//
//
//    }
    public void onAuthSuccessful(){
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            final ProgressDialog progressDialog = new ProgressDialog(Login.this);
                            progressDialog.setMessage("Loading..");
                            progressDialog.setCancelable(false);
                            progressDialog.show();
                            //creating progress dialog while signing in

                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(Login.this,MainActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            /*Intent intent = new Intent(Login.this,Login.class);
                            startActivity(intent);*/
                        }

                        // ...
                    }
                });
    }
}


