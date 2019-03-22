package com.example.android.test_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public final static String NAME="NAME";
    public final static String COLLEGE_NAME="COLLEGE_NAME";
    public final static String COLLEGE_ADDRESS="COLLEGE_ADDRESS";
    public final static String NUMBER="NUMBER";
    public final static String EMAIL="EMAIL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void register(View view)
    {
        EditText input_name =(EditText)findViewById(R.id.editText_name);
        String name = input_name.getText().toString();

        EditText input_college_name = (EditText)findViewById(R.id.editText_college_name);
        String college_name= input_college_name.getText().toString();

        EditText input_college_address=(EditText)findViewById(R.id.editText_college_address);
        String college_address=input_college_address.getText().toString();

        EditText input_number=(EditText)findViewById(R.id.editText_phone_number);
        String number=input_number.getText().toString();

        EditText input_email=(EditText)findViewById(R.id.editText_email);
        String email=input_email.getText().toString();

       if((input_name.getText().toString().equals("")) || (input_college_name.getText().toString().equals("")) || (input_college_address.getText().toString().equals("")) || (input_email.getText().toString().equals("")) || (input_number.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(),
                    "PLEASE ENTER ALL FIELDS", Toast.LENGTH_SHORT).show();



        }
        else
       {

           Intent intent_to_register = new Intent(this, Register.class);

           intent_to_register.putExtra(NAME, name);
           intent_to_register.putExtra(COLLEGE_NAME, college_name);
           intent_to_register.putExtra(COLLEGE_ADDRESS, college_address);
           intent_to_register.putExtra(NUMBER, number);
           intent_to_register.putExtra(EMAIL, email);
           startActivity(intent_to_register);
            input_name.setText("");
            input_college_name.setText("");
           input_college_address.setText("");
           input_number.setText("");
           input_email.setText("");


       }


    }
    public void login(View V)
    {
        Intent intent_to_login=new Intent(this,Login.class);
        startActivity(intent_to_login);
    }


}
