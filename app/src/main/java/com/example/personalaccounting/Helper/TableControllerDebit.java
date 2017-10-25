package com.example.personalaccounting.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.personalaccounting.DATAHELPER;
import com.example.personalaccounting.Model.Debit;

/**
 * Created by rizal on 10/23/17.
 */

public class TableControllerDebit extends DATAHELPER {

    public TableControllerDebit(Context context) {
        super(context);
    }

    public boolean create(Debit debit){

        ContentValues values = new ContentValues();

        values.put("kode",debit.kode);
        values.put("tgl", debit.tanggal);
        values.put("debit", debit.debit);
        values.put("ket", debit.ket);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("tbl_debit", null, values) > 0;
        db.close();

        return createSuccessful;
    }
}
