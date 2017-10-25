package com.example.personalaccounting.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.personalaccounting.DATAHELPER;
import com.example.personalaccounting.Model.Debit;
import com.example.personalaccounting.Model.Kredit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rizal on 10/23/17.
 */

public class AllTableController extends DATAHELPER {

    public Debit debit_db;
    public Kredit kredit_db;

    public AllTableController(Context context) {
        super(context);
    }

    public List<Debit> read_debit(){
        List<Debit> recordsList = new ArrayList<Debit>();

        String sql = "SELECT * FROM tbl_debit ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                String kode = cursor.getString(cursor.getColumnIndex("kode"));
                String tgl = cursor.getString(cursor.getColumnIndex("tgl"));
                String debit = cursor.getString(cursor.getColumnIndex("debit"));
                String ket = cursor.getString(cursor.getColumnIndex("ket"));

                debit_db = new Debit();
                debit_db.kode = kode;
                debit_db.tanggal = tgl;
                debit_db.debit = debit;
                debit_db.ket = ket;

                recordsList.add(debit_db);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

    public List<Kredit> read_kredit(){
        List<Kredit> recordsList = new ArrayList<Kredit>();

        String sql = "SELECT * FROM tbl_kredit ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                String kode = cursor.getString(cursor.getColumnIndex("kode"));
                String tgl = cursor.getString(cursor.getColumnIndex("tgl_k"));
                String kredit = cursor.getString(cursor.getColumnIndex("kredit"));
                String ket = cursor.getString(cursor.getColumnIndex("ket_k"));

                kredit_db = new Kredit();
                kredit_db.kode = kode;
                kredit_db.tanggal = tgl;
                kredit_db.kredit = kredit;
                kredit_db.ket = ket;

                recordsList.add(kredit_db);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }
}
