package com.diosatriani.aplikasirtmd.Logres;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.diosatriani.aplikasirtmd.R;
import com.diosatriani.aplikasirtmd.Setting.ProfileActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, ProfileActivity.class));
            }
        });
    }

    private void initView() {
        btnRegister = (Button) findViewById(R.id.btn_register);
    }
}
