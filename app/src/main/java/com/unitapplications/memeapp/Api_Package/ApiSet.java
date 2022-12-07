package com.unitapplications.memeapp.Api_Package;

import com.unitapplications.memeapp.Models.MemeModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSet {
    @GET("/gimme")
    Call<MemeModel> getMemes();

}