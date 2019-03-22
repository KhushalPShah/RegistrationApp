package com.example.android.test_application;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Environment;

import android.util.Log;
import java.io.FileWriter;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.drm.DrmStore;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import android.os.Environment;
import android.database.SQLException;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.IOException;
import android.os.AsyncTask;

public class database extends AppCompatActivity {
    Context CTX = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_database);
        DatabaseOperations DOP = new DatabaseOperations(CTX);
        Cursor CR = DOP.getInformation(DOP);
        CR.moveToFirst();
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.Relative1);
        int id = 1;
        int count = 1;
        do {
            String NAME = CR.getString(0);
            String COLLEGE = CR.getString(1);
            String COLLEGE_ADD = CR.getString(2);
            String NUMBER = CR.getString(3);
            String EMAIL = CR.getString(4);

            TextView TV_Id = new TextView(this);
            TV_Id.setId(id);
            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(100, RelativeLayout.LayoutParams.WRAP_CONTENT);
            if (id == 1) {
                TV_Id.setText(Integer.toString(count));
                params1.addRule(RelativeLayout.BELOW, R.id.textView_header_id);

            } else {
                TV_Id.setText(Integer.toString(count));
                params1.addRule(RelativeLayout.BELOW, id - 6);
            }
            mainLayout.addView(TV_Id, params1);
            count++;
            id++;


            //TextView for Name
            TextView TV_name = new TextView(this);
            TV_name.setId(id);
            TV_name.setText(NAME);
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(700, RelativeLayout.LayoutParams.WRAP_CONTENT);
            if (id == 2) {
                params2.addRule(RelativeLayout.BELOW, R.id.textView_header_name);
                params2.addRule(RelativeLayout.RIGHT_OF, id - 1);
            } else {
                params2.addRule(RelativeLayout.BELOW, id - 6);
                params2.addRule(RelativeLayout.RIGHT_OF, id - 1);
            }
            mainLayout.addView(TV_name, params2);
            id++;

            //TextView for COLLEGE-NAME
            TextView TV_college = new TextView(this);
            TV_college.setId(id);
            TV_college.setText(COLLEGE);
            RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(700, RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (id == 3) {
                params3.addRule(RelativeLayout.BELOW, R.id.textView_header_college);
                params3.addRule(RelativeLayout.RIGHT_OF, id - 1);
            } else {
                params3.addRule(RelativeLayout.BELOW, id - 6);
                params3.addRule(RelativeLayout.RIGHT_OF, id - 1);
            }
            mainLayout.addView(TV_college, params3);
            id++;

            //TextView for COLLEGE-ADDRESS
            TextView TV_colg_add = new TextView(this);
            TV_colg_add.setId(id);
            TV_colg_add.setText(COLLEGE_ADD);
            RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(700, RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (id == 4) {
                params4.addRule(RelativeLayout.BELOW, R.id.textView_header_college_address);
                params4.addRule(RelativeLayout.RIGHT_OF, id - 1);
            } else {
                params4.addRule(RelativeLayout.BELOW, id - 6);
                params4.addRule(RelativeLayout.RIGHT_OF, id - 1);
            }
            mainLayout.addView(TV_colg_add, params4);
            id++;

            //TextView for PHONE-NUMBER
            TextView TV_phone = new TextView(this);
            TV_phone.setId(id);
            TV_phone.setText(NUMBER);
            RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(500, RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (id == 5) {
                params5.addRule(RelativeLayout.BELOW, R.id.textView_header_phone_number);
                params5.addRule(RelativeLayout.RIGHT_OF, id - 1);
            } else {
                params5.addRule(RelativeLayout.BELOW, id - 6);
                params5.addRule(RelativeLayout.RIGHT_OF, id - 1);
            }
            mainLayout.addView(TV_phone, params5);
            id++;

            //TextView for EMAIL-ID
            TextView TV_email = new TextView(this);
            TV_email.setId(id);
            TV_email.setText(EMAIL);
            RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(1000, RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (id == 6) {
                params6.addRule(RelativeLayout.BELOW, R.id.textView_header_email);
                params6.addRule(RelativeLayout.RIGHT_OF, id - 1);
            } else {
                params6.addRule(RelativeLayout.BELOW, id - 6);
                params6.addRule(RelativeLayout.RIGHT_OF, id - 1);
            }
            mainLayout.addView(TV_email, params6);
            id++;


        } while (CR.moveToNext());

    }


    public void export_to_excel(View V1)
    {
            Toast.makeText(getApplicationContext(),
                    "COMING SOON!", Toast.LENGTH_LONG).show();



    }


}






