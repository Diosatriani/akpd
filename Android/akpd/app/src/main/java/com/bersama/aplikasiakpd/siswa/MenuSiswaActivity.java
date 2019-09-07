package com.bersama.aplikasiakpd.siswa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.bersama.aplikasiakpd.R;

public class MenuSiswaActivity extends AppCompatActivity {

    private LinearLayout soalSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_siswa);
        initView();

        soalSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuSiswaActivity.this, SoalAngketActivity.class));
            }
        });
    }

    private void initView() {
        soalSiswa = (LinearLayout) findViewById(R.id.soal_siswa);
    }
}
