package com.diosatriani.aplikasirtmd.Setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.diosatriani.aplikasirtmd.Logres.LoginActivity;
import com.diosatriani.aplikasirtmd.R;

public class ProfileActivity extends AppCompatActivity {

    private Button btnSimpanpsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();

        btnSimpanpsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            }
        });
    }

    private void initView() {
        btnSimpanpsr = (Button) findViewById(R.id.btn_simpanpsr);
    }
}
