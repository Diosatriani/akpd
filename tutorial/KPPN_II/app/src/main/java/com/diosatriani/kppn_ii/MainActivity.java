package com.diosatriani.kppn_ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.diosatriani.kppn_ii.Profil.ProfilActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    private CircleImageView civProfil;
    private CheckBox cbSpm;
    private CheckBox cbSpmKontrak;
    private CheckBox cbSp2d;
    private CheckBox cbSkpp;
    private CheckBox cbSktb;
    private CheckBox cbCso;
    private Button btnLanjut;
    private CheckBox cbCsService;
    private Toolbar mActionToolbar;
    private Toolbar tabsMenu;
    private CircleImageView civPotop;
    private Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mActionToolbar = (Toolbar) findViewById(R.id.tabs_menu);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("KPPN");

        civPotop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfilActivity.class));
            }
        });
        setCheckBoxListener();
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = "\n Customer Service Check" + cbCsService.isChecked()
                        + "\n SPM check" + cbSpm.isChecked()
                        + "\n SPM Kontrak check" + cbSpmKontrak.isChecked()
                        + "\n SP2D check" + cbSp2d.isChecked()
                        + "\n SKPP check" + cbSkpp.isChecked()
                        + "\n SKTB check" + cbSktb.isChecked()
                        + "\n CSO check" + cbCso.isChecked();
                Intent intent = new Intent(MainActivity.this, TableSpmActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, status, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCheckBoxListener() {
        cbSpm = (CheckBox) findViewById(R.id.cb_spm);
        cbSpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "Sudah Benarkah ?", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initView() {

        cbSpm = (CheckBox) findViewById(R.id.cb_spm);
        cbSpmKontrak = (CheckBox) findViewById(R.id.cb_spm_kontrak);
        cbSp2d = (CheckBox) findViewById(R.id.cb_sp2d);
        cbSkpp = (CheckBox) findViewById(R.id.cb_skpp);
        cbSktb = (CheckBox) findViewById(R.id.cb_sktb);
        cbCso = (CheckBox) findViewById(R.id.cb_cso);
        btnLanjut = (Button) findViewById(R.id.btn_lanjut);
        cbCsService = (CheckBox) findViewById(R.id.cb_cs_service);
        tabsMenu = (Toolbar) findViewById(R.id.tabs_menu);
        civPotop = (CircleImageView) findViewById(R.id.civ_potop);
        btnPesan = (Button) findViewById(R.id.btn_pesan);
    }
}
