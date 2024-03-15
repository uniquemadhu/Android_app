package com.example.project;

import static com.example.project.R.id.selectMenuButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R.id;

public class layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button selectMenuButton = findViewById(id.selectMenuButton);
        selectMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(layout.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
