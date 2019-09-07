package com.bersama.aplikasiakpd.logRes;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bersama.aplikasiakpd.MainActivity;
import com.bersama.aplikasiakpd.R;
import com.bersama.aplikasiakpd.api.BaseApi;
import com.bersama.aplikasiakpd.api.RetrofitClient;
import com.bersama.aplikasiakpd.guru.MenuGuruActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginGuruActivity extends AppCompatActivity {

    private EditText etNip;
    private EditText etPasswordg;
    private TextView tvTipe ;
    private Button btnLoging;
    private Context mContext;
    public static final String my_shared_preferences = "login";
    public static final String session_status = "session_status";
    private String nama;
    private String nip;
    private String alamat;
    private String notelp;
    private String jabatan;
    private String tipe = "0";
    private String access_token;
    private SharedPreferences sharedpreferences;
    private String expires_at;
    Boolean session = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_guru);
        initView();
        sharedpreferences = getSharedPreferences(my_shared_preferences, MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        nip = sharedpreferences.getString("nip", null);
        nama = sharedpreferences.getString("nama", null);
        alamat = sharedpreferences.getString("email", null);
        jabatan = sharedpreferences.getString("jabatan", null);
        notelp = sharedpreferences.getString("notelp", null);
        tipe = sharedpreferences.getString("tipe", "0");
        access_token = sharedpreferences.getString("acces_token", null);
        expires_at = sharedpreferences.getString("expires_at", null);


        if (session) {
            Intent intent = new Intent(LoginGuruActivity.this, MenuGuruActivity.class);
            intent.putExtra(access_token, "acces_token");
            finish();
            startActivity(intent);
        }

        if (ContextCompat.checkSelfPermission(
                LoginGuruActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginGuruActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginGuruActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginGuruActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginGuruActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginGuruActivity.this, Manifest.permission.WAKE_LOCK) != PackageManager.PERMISSION_GRANTED) {

        }
        btnLoging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        if (!validasilog()){
            return;
        }

        BaseApi api = RetrofitClient.getInstanceRetrofit();
        api.loginGuru(etNip.getText().toString(), etPasswordg.getText().toString(),
                tipe).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        JSONObject jsonObject1 =jsonObject.optJSONObject("user");
                        String nip = jsonObject1.optString("nip");
                        String nama = jsonObject1.optString("nama");
                        String alamat = jsonObject1.optString("alamat");
                        String notelp = jsonObject1.optString("notelp");
                        String jabatan = jsonObject1.optString("jabatan");
                        String tipe = jsonObject1.optString("tipe");
                        String acces_token = jsonObject.optString("access_token");
                        String expires_at = jsonObject.getString("expires_at");

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean(session_status, true);
                        editor.putString("nip",nip);
                        editor.putString("nama",nama);
                        editor.putString("alamat", alamat);
                        editor.putString("notelp",notelp);
                        editor.putString("jabatan", jabatan);
                        editor.putString("tipe", tipe);
                        editor.putString("access_token", acces_token);
                        editor.commit();

                        Intent intent = new Intent(LoginGuruActivity.this, MenuGuruActivity.class);
                        intent.putExtra("acces_token",access_token);
                        finish();
                        startActivity(intent);
                        Toast.makeText(mContext, "Berhasil Login", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Password Atau Nip Salah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validasilog() {
        if (etNip.getText().toString().isEmpty()) {
            etNip.setError("Nip tidak boleh kosong");
            etNip.requestFocus();
            return false;
        }
        if (etPasswordg.getText().toString().isEmpty()) {
            etPasswordg.setError("Password tidak boleh kosong");
            etPasswordg.requestFocus();
            return false;
        }
        return true;
    }

    private void initView() {
        etNip = (EditText) findViewById(R.id.et_nip);
        etPasswordg = (EditText) findViewById(R.id.et_passwordg);
        tvTipe = (TextView) findViewById(R.id.tv_tipe);
        btnLoging = (Button) findViewById(R.id.btn_loging);
    }
}
