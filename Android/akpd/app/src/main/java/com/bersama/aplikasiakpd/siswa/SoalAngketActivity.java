package com.bersama.aplikasiakpd.siswa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bersama.aplikasiakpd.R;

public class SoalAngketActivity extends AppCompatActivity {

    private LinearLayout lineSkor;
    private TextView tvSkor;
    private LinearLayout lineSoal;
    private TextView tvSoal;
    private LinearLayout linePilihanJawaban;
    private RadioGroup rgPilihanJawaban;
    private RadioButton rbPilihanJawaban1;
    private RadioButton rbPilihanJawaban2;
    private Button btnSubmit;
    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x;   //menunjukkan konten sekarang
    String jawaban; //menampung jawaban benar

    //membuat objek dari kelas SoalAngket
    SoalAngket soalAngket = new SoalAngket();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_angket);
        initView();

        tvSkor.setText(""+skor);
        setKonten();

        //membuat aksi pada button submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aksinya disini
                //aksinya adalah ketika button tersebut diklik maka
                //akan mengecek jawaban benar atau salah
                //kemudian konten akan berubah (next konten)
                cekJawaban();
            }
        });

    }

    private void cekJawaban() {
        if (rbPilihanJawaban1.isChecked()) {//jika radio button 1 diklik
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if (rbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 0;
                tvSkor.setText(""+skor); //set nilai sskor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
            tvSkor.setText(""+skor);
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
            setKonten();
        }
        }else if (rbPilihanJawaban2.isChecked()){
            if (rbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor +0;
                tvSkor.setText(""+skor);	//mtvSkor diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                tvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else {
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }

    }

    //method untuk mengambil dan update konten dari SoalAngket
    //kemudian disetting/ditempatkan pada tempat yang telah disediakan
    private void setKonten() {
        rgPilihanJawaban.clearCheck();
        arr = soalAngket.pertanyaan.length;
        if (x >= arr){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (Hasil)
            String jumlahSkor = String.valueOf(skor);	//menjadikan skor menjadi string
            Intent i = new Intent(SoalAngketActivity.this, HasilActivity.class);
            //waktu pindah activity, sekalian membawa nilai jumlahSkor yang ditampung dengan inisial skorAkhir
            //singkatnya skorAkhir = jumlahSkor
            //jika masih belum jelas silahkan bertanya
            i.putExtra("skorAkhir",jumlahSkor);
            i.putExtra("activity","PilihanSoal");
            startActivity(i);
        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalPilihanGanda
            tvSoal.setText(soalAngket.getPertanyaan(x));
            rbPilihanJawaban1.setText(soalAngket.getPilihanJawaban1(x));
            rbPilihanJawaban2.setText(soalAngket.getPilihanJawaban2(x));
            jawaban = soalAngket.getJawabanBenar(x);

        }
        x++;

    }

    private void initView() {
        lineSkor = (LinearLayout) findViewById(R.id.lineSkor);
        tvSkor = (TextView) findViewById(R.id.tvSkor);
        lineSoal = (LinearLayout) findViewById(R.id.lineSoal);
        tvSoal = (TextView) findViewById(R.id.tvSoal);
        linePilihanJawaban = (LinearLayout) findViewById(R.id.linePilihanJawaban);
        rgPilihanJawaban = (RadioGroup) findViewById(R.id.rgPilihanJawaban);
        rbPilihanJawaban1 = (RadioButton) findViewById(R.id.rbPilihanJawaban1);
        rbPilihanJawaban2 = (RadioButton) findViewById(R.id.rbPilihanJawaban2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
    }
}
