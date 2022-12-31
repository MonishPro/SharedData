package com.example.shareddata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;

    public MainActivity() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textview);
        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
                SharedPreferences sharedPreferences=getSharedPreferences("datab",MODE_PRIVATE);
                SharedPreferences.Editor ed= sharedPreferences.edit();

                ed.putString("name",editText.getText().toString());
                ed.apply();
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("datab",MODE_PRIVATE);
        String name=sharedPreferences.getString("name","no value as of now");
        textView.setText(name);

    }
}