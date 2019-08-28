package com.bersama.databasefirebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateActivity extends AppCompatActivity {

    private DatabaseReference database;
    private EditText etNamabarang;
    private EditText etMerkbarang;
    private EditText etHargabarang;
    private EditText etJumlahbarang;
    private EditText etTotalbarang;
    private Button btSubmit;
    private int jumlah, harga;

    double inpHarga = 0, inpJml= 0;
    String total = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        initView();

        //mengambil referensi ke firebase database
        database = FirebaseDatabase.getInstance().getReference();

        final Barang barang = (Barang) getIntent().getSerializableExtra("data");

        if (barang != null) {
            etNamabarang.setText(barang.getNama());
            etMerkbarang.setText(barang.getMerk());
            etHargabarang.setText(barang.getHarga());
            etJumlahbarang.setText(barang.getJumlah());
//            etTotalbarang.setText(total);
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    barang.setNama(etNamabarang.getText().toString());
                    barang.setMerk(etMerkbarang.getText().toString());
                    barang.setHarga(etHargabarang.getText().toString());
                    barang.setJumlah(etJumlahbarang.getText().toString());
//                    barang.setTotal(etTotalbarang.getText().toString());

                    updateBarang(barang);
                }
            });
        } else {

            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isEmpty(etNamabarang.getText().toString()) && !isEmpty(etMerkbarang.getText().toString()) && !isEmpty(etHargabarang.getText().toString())
                    && !isEmpty(etJumlahbarang.getText().toString()))
                        submitBarang(new Barang(etNamabarang.getText().toString(), etMerkbarang.getText().toString(), etHargabarang.getText().toString(),
                                etJumlahbarang.getText().toString(), etTotalbarang.getText().toString().trim()));
                    else
                        Snackbar.make(findViewById(R.id.bt_submit), "Data barang tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            etNamabarang.getWindowToken(), 0);
                }

            });
        }
    }

    private boolean isEmpty(String s){
        //Cek apakah ada fields yang kosong, sebelum submit
        return TextUtils.isEmpty(s);
    }
    private void updateBarang(Barang barang){

        database.child("barang") //akses parent index, ibaratnya seperti nama tabel
                .child(barang.getKey()) //select barang berdasarkan key
                .setValue(barang) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        /**
                         * Baris kode yang akan dipanggil apabila proses update barang sukses
                         */
                        Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        }).show();
                    }
                });

    }
    private void submitBarang(Barang barang){
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("barang").push().setValue(barang).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNamabarang.setText("");
//                etHargabarang.setText("");
                etMerkbarang.setText("");
//                etJumlahbarang.setText("");
                inpHarga = Double.parseDouble(etHargabarang.getText().toString());
                inpJml = Double.parseDouble(etJumlahbarang.getText().toString());
//
                total =inpHarga*inpJml+"";

                etTotalbarang.setText(total);
                Snackbar.make(findViewById(R.id.bt_submit), "Data Berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });

    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, CreateActivity.class);
    }

    private void initView() {
        etNamabarang = (EditText) findViewById(R.id.et_namabarang);
        etMerkbarang = (EditText) findViewById(R.id.et_merkbarang);
        etHargabarang = (EditText) findViewById(R.id.et_hargabarang);
        etJumlahbarang = (EditText) findViewById(R.id.et_jumlah);
        etTotalbarang = (EditText
                ) findViewById(R.id.et_total);
        btSubmit = (Button) findViewById(R.id.bt_submit);
    }
}
