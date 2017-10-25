package com.example.personalaccounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.personalaccounting.Helper.AllTableController;
import com.example.personalaccounting.Model.Kredit;

import java.util.List;

public class ActivityShowKredit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_kredit);

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.layout_kredit);
        linearLayoutRecords.removeAllViews();

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
