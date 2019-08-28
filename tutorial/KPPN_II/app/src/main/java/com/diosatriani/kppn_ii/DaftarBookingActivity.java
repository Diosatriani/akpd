package com.diosatriani.kppn_ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DaftarBookingActivity extends AppCompatActivity {

    private Button btnBooking;
    private Toolbar mActionToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_booking);
        mActionToolbar = (Toolbar) findViewById(R.id.tabs_daftarboing);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("Daftar Booking");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        initView();

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaftarBookingActivity.this, BarcodeActivity.class));
            }
        });
    }

    private void initView() {
        btnBooking = (Button) findViewById(R.id.btn_booking);
    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
