package com.example.personalaccounting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personalaccounting.Helper.TableControllerDebit;
import com.example.personalaccounting.Model.Debit;

public class ActivityDebit extends AppCompatActivity{

    private EditText editText_debit,editText_kode,editText_tgl,editText_ket;
    private Button btn;
    public Debit debit_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit);
        editText_kode = (EditText) findViewById(R.id.editText_kode);
        editText_tgl = (EditText) findViewById(R.id.editText_tgl);
        editText_debit = (EditText) findViewById(R.id.editText_debit);
        editText_ket = (EditText) findViewById(R.id.editText_ket);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getRootView().getContext();

                String kode = editText_kode.getText().toString();
                String tgl = editText_tgl.getText().toString();
                String debit = editText_debit.getText().toString();
                String ket = editText_ket.getText().toString();

                debit_db = new Debit();
                debit_db.kode = kode;
                debit_db.tanggal = tgl;
                debit_db.debit = debit;
                debit_db.ket = ket;

                boolean createSuccessful = new TableControllerDebit(context).create(debit_db);

                if(createSuccessful){
                    Toast.makeText(context, "Debit was saved.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Unable to save debit information.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }






}
