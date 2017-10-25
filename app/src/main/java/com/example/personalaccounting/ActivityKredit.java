package com.example.personalaccounting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personalaccounting.Helper.TableControllerKredit;
import com.example.personalaccounting.Model.Kredit;

public class ActivityKredit extends AppCompatActivity {

    private EditText editText_kredit,editText_kode,editText_tgl,editText_ket;
    private Button btn;
    public Kredit kredit_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kredit);
        editText_kode = (EditText) findViewById(R.id.editText_kode);
        editText_tgl = (EditText) findViewById(R.id.editText_tgl);
        editText_kredit = (EditText) findViewById(R.id.editText_kredit);
        editText_ket = (EditText) findViewById(R.id.editText_ket);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getRootView().getContext();

                String kode = editText_kode.getText().toString();
                String tgl = editText_tgl.getText().toString();
                String kredit = editText_kredit.getText().toString();
                String ket = editText_ket.getText().toString();

                kredit_db = new Kredit();
                kredit_db.kode = kode;
                kredit_db.tanggal = tgl;
                kredit_db.kredit = kredit;
                kredit_db.ket = ket;

                boolean createSuccessful = new TableControllerKredit(context).create(kredit_db);

                if(createSuccessful){
                    Toast.makeText(context, "Kredit was saved.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Unable to save kredit information.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
