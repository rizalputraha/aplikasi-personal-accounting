package com.example.personalaccounting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dioputra on 19/10/2017.
 */

public class DATAHELPER extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "transaksi.db";
    private static final int DATABASE_VERSION = 1;

    public DATAHELPER(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_debit = "create table tbl_debit(id integer primary key,kode text null, tgl text null, debit text null" +
                ", ket text null);";
        String create_kredit= "create table tbl_kredit(id integer primary key,kode text null, tgl_k text null, kredit text null" +
                ", ket_k text null);";
        Log.d("Data", "onCreate: " + create_debit);
        Log.d("Data", "onCreate: " + create_kredit);
        db.execSQL(create_debit);
        db.execSQL(create_kredit);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS tbl_debit");
        db.execSQL("DROP TABLE IF EXISTS tbl_kredit");

        onCreate(db);
    }

}