package com.diosatriani.reservashotel.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApi {

    @GET("list_hotel.php")
    Call<ResponseBody> list_hotel();
}
