package com.unitapplications.memeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaMetadata;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.unitapplications.memeapp.Api_Package.ApiClient;
import com.unitapplications.memeapp.Api_Package.ApiSet;
import com.unitapplications.memeapp.Models.MemeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    List<MemeModel> memeList;
    ApiSet apiSet;
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        Retrofit retrofit = ApiClient.getClient();
        apiSet = retrofit.create(ApiSet.class);

        button.setOnClickListener(view -> {
            makeApiCall();
        });


    }
    public void makeApiCall(){
        apiSet.getMemes().enqueue(new Callback<MemeModel>() {
            @Override
            public void onResponse(Call<MemeModel> call, Response<MemeModel> response) {
                //memeList.add(response.body());
                Glide.with(MainActivity.this)
                        .load(response.body().getUrl())
                        .placeholder(R.drawable.ic_baseline_image_search_24)
                        .into(imageView);
                //  Log.d("tag4", "onResponse: "+response.body().getUrl());

            }

            @Override
            public void onFailure(Call<MemeModel> call, Throwable t) {

            }
        });

    }

}