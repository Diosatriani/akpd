package com.bersama.aplikasiakpd.logRes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bersama.aplikasiakpd.R;

public class LoginSiswaActivity extends AppCompatActivity {

    private EditText etNis;
    private EditText etPasswords;
    private TextView tvTokens;
    private Button btnLogins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_siswa);
        initView();
    }

    private void initView() {
        etNis = (EditText) findViewById(R.id.et_nis);
        etPasswords = (EditText) findViewById(R.id.et_passwords);
        tvTokens = (TextView) findViewById(R.id.tv_tokens);
        btnLogins = (Button) findViewById(R.id.btn_logins);
    }
}
