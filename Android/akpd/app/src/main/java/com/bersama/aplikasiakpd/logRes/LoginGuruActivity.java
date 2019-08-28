package com.bersama.aplikasiakpd.logRes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bersama.aplikasiakpd.R;

public class LoginGuruActivity extends AppCompatActivity {

    private EditText etNip;
    private EditText etPasswordg;
    private TextView tvTokeng;
    private Button btnLoging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_guru);
        initView();
    }

    private void initView() {
        etNip = (EditText) findViewById(R.id.et_nip);
        etPasswordg = (EditText) findViewById(R.id.et_passwordg);
        tvTokeng = (TextView) findViewById(R.id.tv_tokeng);
        btnLoging = (Button) findViewById(R.id.btn_loging);
    }
}
