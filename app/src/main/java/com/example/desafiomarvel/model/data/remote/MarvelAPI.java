package com.example.desafiomarvel.model.data.remote;

import com.example.desafiomarvel.model.pojos.Quadrinhos.Quadrinhos;
import com.example.desafiomarvel.model.pojos.herois.Personagem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApi {

    @GET("comics?")
    Observable<Quadrinhos> getAllQuadrinhos(
                    @Query("format") String format,
                    @Query("formatType") String formatType,
                    @Query("noVariants") boolean noVariants,
                    @Query("orderBy") String orderBy,
                    @Query("ts") String ts,
                    @Query("hash") String hash,
                    @Query("apikey") String apikey
    );

    @GET ("characters?")
    Observable<Personagem> getALLPersonagens(

            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey

    );

}
