package com.example.ruhealthytwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//private FirebaseAuth mAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button registerButton;
    private FirebaseAuth mAuth;




    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);
        mAuth = FirebaseAuth.getInstance();


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtxt = email.getText().toString();
                String passwordtxt = password.getText().toString();

                if(TextUtils.isEmpty(emailtxt) || TextUtils.isEmpty(passwordtxt)) {
                    Toast.makeText(SignUpActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(SignUpActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    registerUser(emailtxt, passwordtxt);
                } 
            }
        });

    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            //FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            if(password.length() < 6) {
                                Toast.makeText(SignUpActivity.this, "Choose a password above 6 letters", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }

                            //updateUI(null);
                        }
                    }
                });

    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
////        FirebaseUser currentUser = mAuth.getCurrentUser();
////        if(currentUser != null){
////            reload();
////        }
//    }


    private void updateUI(FirebaseUser user) {
    }
//
//    private void reload() {
//    }
}