package com.example.android.test_application;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * Created by khushal shah on 19-02-2017.
 */
public class ExportToCSV {


    Context context;
    public ExportToCSV(Context context) {
        this.context=context;
    }


    public void exportDataBaseIntoCSV(){


        DatabaseOperations db = new DatabaseOperations(context);//here CredentialDb is my database. you can create your db object.
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");

        if (!exportDir.exists())
        {
            exportDir.mkdirs();
        }

        File file = new File(exportDir, "csvfilename.csv");

        try
        {
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            SQLiteDatabase sql_db = db.getReadableDatabase();//here create a method ,and return SQLiteDatabaseObject.getReadableDatabase();
            Cursor curCSV = sql_db.rawQuery("SELECT * FROM "+TableData.TableInfo.TABLE_NAME,null);
            csvWrite.writeNext(curCSV.getColumnNames());

            while(curCSV.moveToNext())
            {
                //Which column you want to export you can add over here...
                String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2)};
                csvWrite.writeNext(arrStr);
            }

            csvWrite.close();
            curCSV.close();
        }
        catch(Exception sqlEx)
        {
            Log.e("Error:", sqlEx.getMessage(), sqlEx);
        }
    }
}
