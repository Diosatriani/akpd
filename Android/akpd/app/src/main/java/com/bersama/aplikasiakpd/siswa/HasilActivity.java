package com.bersama.aplikasiakpd.siswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bersama.aplikasiakpd.R;

public class HasilActivity extends AppCompatActivity {

    private TextView tvSkorAkhir;
    private Button btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        initView();

        setSkor();
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setSkor() {
        //hasil lemparan (putExtra) dari activity sebelumnya ditampung dalam variabel lokal
        String activity = getIntent().getStringExtra("activity");
        String skorPilGan = getIntent().getStringExtra("skorAkhir");

        if (activity.equals("PilihanSoal")){
            //jika var activity bernilai PilihanGanda
            //dipastikan activity sebelumnya datang dari kelas KuisPilihanGanda
            //maka skornya diatur dari skorPilGan
            tvSkorAkhir.setText("SKOR : "+skorPilGan);
        }else {
            Toast.makeText(HasilActivity.this, "Horeee", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        tvSkorAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        btnKeluar = (Button) findViewById(R.id.btn_keluar);
    }
}
