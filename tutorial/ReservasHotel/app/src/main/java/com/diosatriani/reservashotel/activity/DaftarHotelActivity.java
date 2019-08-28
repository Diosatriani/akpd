package com.diosatriani.reservashotel.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.diosatriani.reservashotel.R;
import com.diosatriani.reservashotel.adapter.AdapterDaftarHotel;
import com.diosatriani.reservashotel.api.BaseApi;
import com.diosatriani.reservashotel.api.RetrofitClient;
import com.diosatriani.reservashotel.model.Hotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarHotelActivity extends AppCompatActivity {

    private ArrayList<Hotel> hotelll;
    private RecyclerView recyclerView;
    private Context context;
    private String nama, alamat,notelp,tarif,kelas;
    private Toolbar mActionToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_hotel);

        mActionToolbar = (Toolbar) findViewById(R.id.tabs_listho);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("Daftar Hotel");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        recyclerView = findViewById(R.id.rv_listho);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getData();
    }

    private void getData() {
        BaseApi api = RetrofitClient.getAPIService();
        api.list_hotel().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONArray jsonArray = new JSONArray(response.body().string());
                    for (int i = 0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.optJSONObject(i);
                        nama = object.optString("nama_hotel");
                        alamat = object.optString("alamat_hotel");
                        notelp = object.optString("notelp");
                        tarif = object.optString("tarif");
                        kelas = object.optString("kelas");

                        Hotel hotel = new Hotel();
                        hotel.setNamaHotel(nama);
                        hotel.setAlamatHotel(alamat);
                        hotel.setNotelp(notelp);
                        hotel.setTarif(tarif);
                        hotel.setKelas(kelas);
                        hotelll.add(hotel);
                        AdapterDaftarHotel adapterDaftarHotel = new AdapterDaftarHotel(DaftarHotelActivity.this, hotelll);
                        recyclerView.setAdapter(adapterDaftarHotel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

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
}
