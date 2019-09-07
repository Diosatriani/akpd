package com.bersama.aplikasiakpd.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BaseApi {

    @FormUrlEncoded
    @POST("login/guru")
    Call<ResponseBody> loginGuru(
            @Field("credential")String crendential,
            @Field("password")String password,
            @Field("tipe")String tipe);

    @FormUrlEncoded
    @POST("login/siswa")
    Call<ResponseBody> loginSiswa(
            @Field("credential")String crendential,
            @Field("password")String password,
            @Field("tipe")String tipe);

    @FormUrlEncoded
    @POST("create/siswa")
    Call<ResponseBody> createSiswa(
            @Header("Authorization") String acces_token,
            @Field("nis")String nis,
            @Field("nama")String nama,
            @Field("kelas")String kelas,
            @Field("alamat")String alamat,
            @Field("notelp")String notelp,
            @Field("password")String password,
            @Field("password_confirmation")String password_confirmation);

    @FormUrlEncoded
    @POST("angket/jawab")
    Call<ResponseBody> jawabanSiswa(
            @Header("Authorization") String acces_token,
            @Field("a_1")String a_1,@Field("a_2")String a_2,@Field("a_3")String a_3,@Field("a_4")String a_4,
            @Field("a_5")String a_5,@Field("a_6")String a_6,@Field("a_7")String a_7,@Field("a_8")String a_8,
            @Field("a_9")String a_9,@Field("a_10")String a_10,@Field("a_11")String a_11,@Field("a_12")String a_12,
            @Field("a_13")String a_13,@Field("a_14")String a_14,@Field("a_15")String a_15,@Field("a_16")String a_17,
            @Field("a_18")String a_18,@Field("a_19")String a_19,@Field("a_20")String a_20,@Field("a_21")String a_21,
            @Field("a_22")String a_22,@Field("a_23")String a_23,@Field("a_24")String a_24,@Field("a_25")String a_25,
            @Field("a_26")String a_26,@Field("a_27")String a_27,@Field("a_28")String a_28,@Field("a_29")String a_29,
            @Field("a_30")String a_30,@Field("a_31")String a_31,@Field("a_32")String a_32,@Field("a_33")String a_33,
            @Field("a_34")String a_34,@Field("a_35")String a_35,@Field("a_36")String a_36,@Field("a_37")String a_37,
            @Field("a_38")String a_38,@Field("a_39")String a_39,@Field("a_40")String a_40,@Field("a_41")String a_41,
            @Field("a_42")String a_42,@Field("a_43")String a_43,@Field("a_44")String a_44,
            @Field("a_45")String a_45,@Field("a_46")String a_46,@Field("a_47")String a_47,@Field("a_48")String a_48,
            @Field("a_49")String a_49,@Field("a_50")String a_50);

    @GET("angket/tampilkan")
    Call<ResponseBody> hasilAngket(@Header("Authorization") String acces_token);

}
