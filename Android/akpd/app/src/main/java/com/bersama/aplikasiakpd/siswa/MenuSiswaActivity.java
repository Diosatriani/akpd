package com.bersama.aplikasiakpd.siswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bersama.aplikasiakpd.R;

public class MenuSiswaActivity extends AppCompatActivity {

    private LinearLayout soalSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_siswa);
        initView();
    }

    private void initView() {
        soalSiswa = (LinearLayout) findViewById(R.id.soal_siswa);
    }
}
