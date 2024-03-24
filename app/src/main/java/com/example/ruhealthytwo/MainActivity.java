package com.example.ruhealthytwo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button loginButton;
    private TextView signUpText;

    private FirebaseAuth mAuth;

    private DatabaseReference mDatabase;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.registerButton);

        signUpText = findViewById(R.id.signupText);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtxt = email.getText().toString();
                String passwordtxt = password.getText().toString();

                if(TextUtils.isEmpty(emailtxt) || TextUtils.isEmpty(passwordtxt)) {
                    Toast.makeText(MainActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                    signInUser(emailtxt, passwordtxt);
                }
            }
        });



        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);

                startActivity(intent);
                finish();
            }
        });
    }

    private void signInUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(MainActivity.this, ProgramActivity.class));
                            finish();

                            writeNewUser(user.getUid(), user.getEmail());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    private void writeNewUser(String uid, String email) {
        //public User(String uid, String email, String aboutMe, ArrayList<String> interests, Uri photoUrl, float latitude, float longitude)
        User user = new User(uid, email, "", null, null, 0, 0);



    }

    private void updateUI(FirebaseUser user) {

    }
}