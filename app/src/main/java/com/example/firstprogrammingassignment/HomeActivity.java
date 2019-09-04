package com.example.firstprogrammingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout;
    Button rockButton;
    Button paperButton;
    Button scissorsButton;
    public static final String EXTRA_NUM1 = "com.example.application.example.EXTRA_NUM1";
    public static final String EXTRA_NUM2 = "com.example.application.example.EXTRA_NUM2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout = findViewById(R.id.button3);
        rockButton = findViewById(R.id.button4);
        paperButton = findViewById(R.id.button5);
        scissorsButton = findViewById(R.id.button6);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent toLogin = new Intent(HomeActivity.this, MainActivity.class);
                Toast.makeText(HomeActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
                startActivity(toLogin);
            }
        });

        final int randomno = (int) (Math.random()*9) % 3;

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, rpsActivity.class);
                int num = 0;
                intent.putExtra(EXTRA_NUM1, num);
                intent.putExtra(EXTRA_NUM2, randomno);
                startActivity(intent);
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, rpsActivity.class);
                int num = 1;
                intent.putExtra(EXTRA_NUM1, num);
                intent.putExtra(EXTRA_NUM2, randomno);
                startActivity(intent);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, rpsActivity.class);
                int num = 2;
                intent.putExtra(EXTRA_NUM1, num);
                intent.putExtra(EXTRA_NUM2, randomno);
                startActivity(intent);
            }
        });



    }
}
