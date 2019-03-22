package com.example.android.test_application;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Context ctx=this;
    public String name;
    public String college_name;
    public String college_address;
    public String phone_number;
    public String email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent_register=getIntent();
        name=intent_register.getStringExtra(MainActivity.NAME);
        college_name=intent_register.getStringExtra(MainActivity.COLLEGE_NAME);
        college_address=intent_register.getStringExtra(MainActivity.COLLEGE_ADDRESS);
        phone_number=intent_register.getStringExtra(MainActivity.NUMBER);
        email=intent_register.getStringExtra(MainActivity.EMAIL);

        TextView textView_name= (TextView)findViewById(R.id.textView_registered_name_input);
        textView_name.setText(name);

        TextView textView_college_name=(TextView)findViewById(R.id.textView_registered_college_name_input);
        textView_college_name.setText(college_name);

        TextView textView_college_address=(TextView)findViewById(R.id.textView_registered_college_address_input);
        textView_college_address.setText(college_address);

        TextView textView_phone_number=(TextView)findViewById(R.id.textView_registered_phone_number_input);
        textView_phone_number.setText(phone_number);

        TextView textView_email=(TextView)findViewById(R.id.textView_registered_email_input);
        textView_email.setText(email);

    }

    void confirm(View v){

        DatabaseOperations DB=new DatabaseOperations(ctx);
        DB.putInformation(DB,name,college_name,college_address,phone_number,email);

        Toast.makeText(getBaseContext(),"REGISTRATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }




    public void return_to_main(View V1)
    {
        Intent intent_to_main=new Intent(this,MainActivity.class);
        startActivity(intent_to_main);
    }

}
