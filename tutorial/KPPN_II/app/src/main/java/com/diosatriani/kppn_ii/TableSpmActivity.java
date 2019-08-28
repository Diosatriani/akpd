package com.diosatriani.kppn_ii;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.diosatriani.kppn_ii.Adapter.TableAdapter;
import com.diosatriani.kppn_ii.Input.InputActivity;
import com.diosatriani.kppn_ii.Model.DummyData;

import java.util.ArrayList;

public class TableSpmActivity extends AppCompatActivity {

    private ArrayList<DummyData> listdata;
    private RecyclerView recyclerView;
    private Toolbar mActionToolbar;
    private Context context;
    private Toolbar tabsTable;
    private ImageView ivTambahspm;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_spm);

        mActionToolbar = (Toolbar) findViewById(R.id.tabs_table);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("Table");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

//        recyclerView = findViewById(R.id.rv_table);
//        recyclerView.setHasFixedSize(true);
//        final LinearLayoutManager mLayoutManager;
//        mLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(mLayoutManager);
//        listdata = new ArrayList<>();

        getData();
        initView();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TableSpmActivity.this, TanggalSpmActivity.class));
            }
        });

        ivTambahspm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TableSpmActivity.this, InputActivity.class));
            }
        });
    }

    private void getData() {
//        DummyData data = new DummyData();
//        data.setNomerSpm("0000001");
//        data.setNominal("10101010");
//
//        listdata.add(data);
//        TableAdapter adapter = new TableAdapter(TableSpmActivity.this, listdata);
//        recyclerView.setAdapter(adapter);
    }



    private void initView() {
        tabsTable = (Toolbar) findViewById(R.id.tabs_table);
        ivTambahspm = (ImageView) findViewById(R.id.iv_tambahspm);
        btnNext = (Button) findViewById(R.id.btn_next);
    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
