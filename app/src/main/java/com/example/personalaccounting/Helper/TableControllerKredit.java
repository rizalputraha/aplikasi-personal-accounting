package com.example.personalaccounting.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.personalaccounting.DATAHELPER;
import com.example.personalaccounting.Model.Kredit;

/**
 * Created by rizal on 10/23/17.
 */

public class TableControllerKredit extends DATAHELPER{

    public TableControllerKredit(Context context) {
        super(context);
    }

    public boolean create(Kredit kredit){

        ContentValues values = new ContentValues();

        values.put("kode",kredit.kode);
        values.put("tgl_k", kredit.tanggal);
        values.put("kredit", kredit.kredit);
        values.put("ket_k", kredit.ket);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("tbl_kredit", null, values) > 0;
        db.close();

        return createSuccessful;
    }
}
