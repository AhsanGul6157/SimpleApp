package com.example.ahsannaveed.foodpandaappclone;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {
    private ImageView signup_Cross_Btn;
    private TextView already_Member_Text;
    TextInputLayout first_Name_et;
    TextInputLayout last_Name_et;
    private TextInputLayout email_address_et;
    private TextInputLayout phone_Number_et;
    private TextInputLayout email_Password_et;
    private Button join_Now_Button;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private TextView getalready_Member_Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup_Cross_Btn = findViewById(R.id.sign_up_cross_btn);
        already_Member_Text = findViewById(R.id.already_member_log_in);
        first_Name_et = findViewById(R.id.first_name);
        last_Name_et = findViewById(R.id.last_name);
        email_address_et = findViewById(R.id.sign_up_email_address);
        phone_Number_et = findViewById(R.id.sign_up_phone_number);
        email_Password_et = findViewById(R.id.sign_up_email_password);
        join_Now_Button = findViewById(R.id.join_now);
        getalready_Member_Text = findViewById(R.id.sing_up_already_member_log_in);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        //cross image listener
        signup_Cross_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crossIntent = new Intent(getApplicationContext(), CreateNewAccount.class);
                startActivity(crossIntent);
            }
        });



        join_Now_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String firstName = first_Name_et.getEditText().toString().trim();
                final String lastName = last_Name_et.getEditText().toString().trim();
                String email = email_address_et.getEditText().toString().trim();
                final String phoneNumber = phone_Number_et.getEditText().toString().trim();
                String password = email_Password_et.getEditText().toString().trim();

                if (TextUtils.isEmpty(firstName)) {
                    first_Name_et.setError("Required");
                }
                if (TextUtils.isEmpty(lastName)) {
                    last_Name_et.setError("Required");
                }
                if (TextUtils.isEmpty(email)) {
                    email_address_et.setError("Required");
                }
                if (TextUtils.isEmpty(phoneNumber)) {
                    phone_Number_et.setError("Required");
                }
                if (TextUtils.isEmpty(password)) {
                    email_Password_et.setError("Required");
                }
                if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(phoneNumber) && !TextUtils.isEmpty(password)) {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
//
                                // this line will giv eus access to uni id of the user
                                String user_id = mAuth.getCurrentUser().getUid();
                                DatabaseReference current_user_db = mDatabase.child(user_id);
                                current_user_db.child("FirstName").setValue(firstName);
                                current_user_db.child("LastName").setValue(lastName);
                                current_user_db.child("PhoneNumber").setValue(phoneNumber);
                                Intent loginIntent = new Intent(getApplicationContext(), Login.class);
                                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(loginIntent);

                            } else {
                                Toast.makeText(SignUp.this, "You got some error please check and try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    public void already_Member_Text_Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
}