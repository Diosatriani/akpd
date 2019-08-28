package com.diosatriani.kppn_ii;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TanggalSpmActivity extends AppCompatActivity {

    private Button btnOpenDatePicker;
    private Calendar myCalendar;
    private EditText etTgllhpp;
    private Button btnTgl;
    private Toolbar mActionToolbar;
    private int tahun, bulan,hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanggal_spm);
        initView();

        myCalendar = Calendar.getInstance();
        mActionToolbar = (Toolbar) findViewById(R.id.tabs_tanggalspm);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("Tanggal Spm");


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
//        btnOpenDatePicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tahun = myCalendar.get(Calendar.YEAR);
//                bulan = myCalendar.get(Calendar.MONTH)+1;
//                hari  =  myCalendar.get(Calendar.DAY_OF_MONTH);
//
//                String formatTgl = tahun +"-"+bulan+"-"+hari;
//                etTgllhpp.setText(formatTgl);
//            }
//        });
        btnOpenDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(TanggalSpmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.get(Calendar.YEAR);
                        myCalendar.get(Calendar.MONTH);
                        myCalendar.get(Calendar.DAY_OF_MONTH);

                        String formatTanggal = "yyyy-MM-dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(formatTanggal);
                        etTgllhpp.setText(sdf.format(myCalendar.getTime()));
                    }
                },
                        myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        btnTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TanggalSpmActivity.this, DaftarBookingActivity.class));
            }
        });


    }

    private void initView() {
        btnOpenDatePicker = (Button) findViewById(R.id.btnOpenDatePicker);
        etTgllhpp = (EditText) findViewById(R.id.et_tgllhpp);
        btnTgl = (Button) findViewById(R.id.btn_tgl);
    }
    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
