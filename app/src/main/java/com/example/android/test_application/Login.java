package com.example.android.test_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void verify(View V2) {
        EditText password_verify = (EditText) findViewById(R.id.editText_password_input);
        EditText username_verify = (EditText) findViewById(R.id.editText_user_name_input);
        if ((password_verify.getText().toString().equals("DE123")) && (username_verify.getText().toString().equals("ADMIN")))
        {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...", Toast.LENGTH_SHORT).show();

            Intent intent_to_database = new Intent(this,database.class);
            startActivity(intent_to_database);
            password_verify.setText("");
            username_verify.setText("");
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "PLEASE RETRY", Toast.LENGTH_SHORT).show();

            password_verify.setText("");
            username_verify.setText("");
        }

    }
}