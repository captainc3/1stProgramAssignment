package com.example.firstprogrammingassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText emailID, password, reemailID, repassword;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.emailEntry);
        reemailID = findViewById(R.id.emailEntry2);
        password = findViewById(R.id.passwordEntry);
        repassword = findViewById(R.id.passwordEntry2);
        btnSignUp = findViewById(R.id.button);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = emailID.getText().toString();
                String email2 = reemailID.getText().toString();
                String password1 = password.getText().toString();
                String password2 = repassword.getText().toString();
                if (email1.isEmpty() || email2.isEmpty()) {
                    emailID.setError("Please enter a valid email.");
                    reemailID.setError("Please enter a valid email.");
                    emailID.requestFocus();
                    reemailID.requestFocus();
                } else if (password1.isEmpty() || password2.isEmpty()) {
                    password.setError("Please enter a valid password.");
                    repassword.setError("Please enter a valid password.");
                    password.requestFocus();
                    repassword.requestFocus();
                } else if (email1.compareTo(email2) != 0) {
                    emailID.setError("Emails do not match.");
                    emailID.requestFocus();
                    reemailID.requestFocus();
                } else if (password1.compareTo(password2) != 0) {
                    password.setError("Passwords do not match.");
                    password.requestFocus();
                    repassword.requestFocus();
                } else {
                    mFirebaseAuth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegistrationActivity.this, "Registration unsuccessful; try again.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegistrationActivity.this, "Registration successful.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                            }
                        }
                    });
                }
            }
        });
    }
}
