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

import com.bersama.aplikasiakpd.R;
import com.bersama.aplikasiakpd.api.BaseApi;
import com.bersama.aplikasiakpd.guru.MenuGuruActivity;
import com.bersama.aplikasiakpd.siswa.MenuSiswaActivity;
import com.bersama.aplikasiakpd.api.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginSiswaActivity extends AppCompatActivity {

    private EditText etNis;
    private EditText etPasswords;
    private TextView tvTipeS;
    private Button btnLogins;
    private Context mContext;
    public static final String my_shared_preferences = "login";
    public static final String session_status = "session_status";
    private String nama;
    private String nis;
    private String alamat;
    private String notelp;
    private String kelas;
    private String tipeS = "1";
    private String access_token;
    private SharedPreferences sharedpreferences;
    private String expires_at;
    Boolean session = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_siswa);
        initView();
        sharedpreferences = getSharedPreferences(my_shared_preferences, MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        nis = sharedpreferences.getString("nis", null);
        nama = sharedpreferences.getString("nama", null);
        alamat = sharedpreferences.getString("email", null);
        kelas = sharedpreferences.getString("kelas", null);
        notelp = sharedpreferences.getString("notelp", null);
        tipeS = sharedpreferences.getString("tipe", "1");
        access_token = sharedpreferences.getString("acces_token", null);
        expires_at = sharedpreferences.getString("expires_at", null);


        if (session) {
            Intent intent = new Intent(LoginSiswaActivity.this, MenuSiswaActivity.class);
            intent.putExtra(access_token, "acces_token");
            finish();
            startActivity(intent);
        }

        if (ContextCompat.checkSelfPermission(
                LoginSiswaActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginSiswaActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginSiswaActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginSiswaActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginSiswaActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                LoginSiswaActivity.this, Manifest.permission.WAKE_LOCK) != PackageManager.PERMISSION_GRANTED) {

        }
        btnLogins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogins();
            }
        });

    }

    private void requestLogins() {
        if (!validasilog()){
            return;
        }
        BaseApi api = RetrofitClient.getInstanceRetrofit();
        api.loginSiswa(etNis.getText().toString(),
                etPasswords.getText().toString(), tipeS).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        JSONObject jsonObject1 =jsonObject.optJSONObject("user");
                        String nis = jsonObject1.optString("nis");
                        String nama = jsonObject1.optString("nama");
                        String alamat = jsonObject1.optString("alamat");
                        String notelp = jsonObject1.optString("notelp");
                        String kelas = jsonObject1.optString("kelas");
                        String tipe = jsonObject1.optString("tipe");
                        String acces_token = jsonObject.optString("access_token");
                        String expires_at = jsonObject.getString("expires_at");

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean(session_status, true);
                        editor.putString("nis",nis);
                        editor.putString("nama",nama);
                        editor.putString("alamat", alamat);
                        editor.putString("notelp",notelp);
                        editor.putString("kelas", kelas);
                        editor.putString("tipe", tipe);
                        editor.putString("access_token", acces_token);
                        editor.commit();

                        Intent intent = new Intent(LoginSiswaActivity.this, MenuSiswaActivity.class);
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
        if (etNis.getText().toString().isEmpty()) {
            etNis.setError("Nip tidak boleh kosong");
            etNis.requestFocus();
            return false;
        }
        if (etPasswords.getText().toString().isEmpty()) {
            etPasswords.setError("Password tidak boleh kosong");
            etPasswords.requestFocus();
            return false;
        }
        return true;
    }

    private void initView() {
        etNis = (EditText) findViewById(R.id.et_nis);
        etPasswords = (EditText) findViewById(R.id.et_passwords);
        tvTipeS = (TextView) findViewById(R.id.tv_tipes);
        btnLogins = (Button) findViewById(R.id.btn_logins);
    }
}
