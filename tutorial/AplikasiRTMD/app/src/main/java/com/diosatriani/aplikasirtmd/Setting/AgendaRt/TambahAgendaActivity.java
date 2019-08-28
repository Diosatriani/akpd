package com.diosatriani.aplikasirtmd.Setting.AgendaRt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.diosatriani.aplikasirtmd.R;
import com.diosatriani.aplikasirtmd.Root;
import com.diosatriani.aplikasirtmd.Setting.Agenda;

public class TambahAgendaActivity extends AppCompatActivity {

    private Button btnTambahAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_agenda);
        initView();
        btnTambahAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TambahAgendaActivity.this, Root.class));
            }
        });
    }

    private void initView() {
        btnTambahAgenda = (Button) findViewById(R.id.btn_tambah_agenda);
    }
}
