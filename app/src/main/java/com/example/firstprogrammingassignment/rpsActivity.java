package com.example.firstprogrammingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class rpsActivity extends AppCompatActivity {
    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        Intent intent = getIntent();
        int AInum = intent.getIntExtra(HomeActivity.EXTRA_NUM2, 0);
        int userNum = intent.getIntExtra(HomeActivity.EXTRA_NUM1, 0);

        if (userNum == 0) {
            if (AInum == 1) {
                Toast.makeText(rpsActivity.this, "You lose! Paper beats rock.", Toast.LENGTH_SHORT).show();
            } else if (AInum == 2) {
                Toast.makeText(rpsActivity.this, "You win! Rock beats scissors.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(rpsActivity.this, "Tie.", Toast.LENGTH_SHORT).show();
            }
        } else if (userNum == 1) {
            if (AInum == 1) {
                Toast.makeText(rpsActivity.this, "Tie.", Toast.LENGTH_SHORT).show();
            } else if (AInum == 2) {
                Toast.makeText(rpsActivity.this, "You lose! Scissors beat paper.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(rpsActivity.this, "You win! Paper beats rock.", Toast.LENGTH_SHORT).show();
            }
        } else if (userNum == 2) {
            if (AInum == 1) {
                Toast.makeText(rpsActivity.this, "You win! Scissors beat paper.", Toast.LENGTH_SHORT).show();
            } else if (AInum == 2) {
                Toast.makeText(rpsActivity.this, "Tie.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(rpsActivity.this, "You lose! Rock beats scissors.", Toast.LENGTH_SHORT).show();
            }
        }

        returnButton = findViewById(R.id.button7);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(rpsActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });

    }
}
