package com.example.personalaccounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.personalaccounting.Helper.AllTableController;
import com.example.personalaccounting.Model.Debit;

import java.util.List;

public class ActivityShowDebit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_debit);

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.layout_debit);
        linearLayoutRecords.removeAllViews();

        List<Debit> debits = new AllTableController(this).read_debit();

        if (debits.size() > 0) {

            for (Debit debit : debits) {

                String kode = debit.kode;
                String tgl = debit.tanggal;
                String debit_col = debit.debit;
                String ket = debit.ket;


                String textViewContents = kode + " - " + tgl + " - " +debit_col + " - " + ket;

                TextView textViewStudentItem= new TextView(this);
                textViewStudentItem.setPadding(0, 10, 0, 10);
                textViewStudentItem.setTextSize(20);
                textViewStudentItem.setText(textViewContents);
                textViewStudentItem.setTag(kode);


                linearLayoutRecords.addView(textViewStudentItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);
        }
    }
}
