package com.example.android.test_application;

/**
 * Created by khushal shah on 03-01-2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION=9;
    public String CREATE_QUERY="CREATE TABLE "+TableData.TableInfo.TABLE_NAME+"("+TableData.TableInfo.PARTICIPANT_NAME+" TEXT,"+TableData.TableInfo.PARTICIPANT_COLLEGE+" TEXT,"+ TableData.TableInfo.PARTICIPANT_COLLEGE_ADDRESS+" TEXT,"+TableData.TableInfo.PARTICIPANT_NUMBER+" TEXT,"+TableData.TableInfo.PARTICIPANT_EMAIL+" TEXT);";
    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database operations","DATABASE CREATED");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations","TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0,int arg1,int arg2){
    }

    public void putInformation(DatabaseOperations dop,String name,String College_name,String college_add,String phone,String email)
    {
        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableData.TableInfo.PARTICIPANT_NAME,name);
        cv.put(TableData.TableInfo.PARTICIPANT_COLLEGE,College_name);
        cv.put(TableData.TableInfo.PARTICIPANT_COLLEGE_ADDRESS,college_add);
        cv.put(TableData.TableInfo.PARTICIPANT_NUMBER,phone);
        cv.put(TableData.TableInfo.PARTICIPANT_EMAIL,email);
        SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations","ONE ROW CREATED");
    }

    public Cursor getInformation(DatabaseOperations dop)
    {
    SQLiteDatabase SQ=dop.getReadableDatabase();
        String[] colomns={TableData.TableInfo.PARTICIPANT_NAME, TableData.TableInfo.PARTICIPANT_COLLEGE, TableData.TableInfo.PARTICIPANT_COLLEGE_ADDRESS, TableData.TableInfo.PARTICIPANT_NUMBER, TableData.TableInfo.PARTICIPANT_EMAIL};
        Cursor CR= SQ.query(TableData.TableInfo.TABLE_NAME,colomns,null,null,null,null,null);
        return CR;
    }
}



