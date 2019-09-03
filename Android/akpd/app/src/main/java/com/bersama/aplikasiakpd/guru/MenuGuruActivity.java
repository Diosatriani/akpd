package com.bersama.aplikasiakpd.guru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bersama.aplikasiakpd.R;

public class MenuGuruActivity extends AppCompatActivity {

    private LinearLayout tambahSiswa;
    private LinearLayout laporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_guru);
        initView();
    }

    private void initView() {
        tambahSiswa = (LinearLayout) findViewById(R.id.tambah_siswa);
        laporan = (LinearLayout) findViewById(R.id.laporan);
    }
}
