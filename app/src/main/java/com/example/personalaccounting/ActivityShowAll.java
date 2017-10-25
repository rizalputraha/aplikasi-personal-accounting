package com.example.personalaccounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.personalaccounting.Helper.AllTableController;
import com.example.personalaccounting.Model.Debit;
import com.example.personalaccounting.Model.Kredit;

import java.util.List;

public class ActivityShowAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_root);
        debit();
        kredit();
    }

    public void debit(){
        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.show_debit_root);

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

    public void kredit(){
        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.show_kredit_root);

        List<Kredit> kredits = new AllTableController(this).read_kredit();

        if (kredits.size() > 0) {

            for (Kredit kredit : kredits) {

                String kode = kredit.kode;
                String tgl = kredit.tanggal;
                String debit_col = kredit.kredit;
                String ket = kredit.ket;


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
