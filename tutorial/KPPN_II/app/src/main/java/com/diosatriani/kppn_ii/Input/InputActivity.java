package com.diosatriani.kppn_ii.Input;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.diosatriani.kppn_ii.R;
import com.diosatriani.kppn_ii.TableSpmActivity;

public class InputActivity extends AppCompatActivity {

    private Button btnKppnspm;
    private Toolbar mActionToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        mActionToolbar = (Toolbar) findViewById(R.id.tabs_input_kppn);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("KPPN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        initView();


        btnKppnspm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputActivity.this, TableSpmActivity.class));
            }
        });

    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        btnKppnspm = (Button) findViewById(R.id.btn_kppnspm);
    }
}
