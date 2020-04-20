package com.skteam.unitopper.common;


import com.skteam.unitopper.retrofit.RetrofitApi;
import com.skteam.unitopper.retrofit.RetrofitClient;

public class Common {

    private static final String BASE_URL = "https://flattish-detent.000webhostapp.com/Unitopper/";
//    public static final String IMAGE_URL = "https://lyricsfuse.com/TheSquad/Images/";

    public static RetrofitApi getAPI(){
        return RetrofitClient.getClient(BASE_URL).create(RetrofitApi.class);
    }
}

