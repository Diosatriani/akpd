package com.bersama.aplikasiakpd.guru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.bersama.aplikasiakpd.R;

public class TambahActivity extends AppCompatActivity {

    private EditText etNis;
    private EditText etNama;
    private EditText etAlamat;
    private EditText etTelpon;
    private Button btnSimpanCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        initView();
    }

    private void initView() {
        etNis = (EditText) findViewById(R.id.et_nis);
        etNama = (EditText) findViewById(R.id.et_nama);
        etAlamat = (EditText) findViewById(R.id.et_alamat);
        etTelpon = (EditText) findViewById(R.id.et_telpon);
        btnSimpanCreate = (Button) findViewById(R.id.btn_simpanCreate);
    }
}
