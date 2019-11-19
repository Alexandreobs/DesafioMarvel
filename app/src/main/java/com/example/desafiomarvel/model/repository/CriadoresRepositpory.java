package com.example.desafiomarvel.model.repository;

import com.example.desafiomarvel.model.pojos.esqcritores.Criadores;

import io.reactivex.Observable;

import static com.example.desafiomarvel.model.data.remote.Retrofit.getApiService;

public class CriadoresRepositpory {

    public Observable<Criadores> getPersonagemRepositori(

            String orderBy,
            String ts,
            String hash,
            String apikey){

        return getApiService().getALLCriadores(orderBy, ts, hash, apikey);
    }
}
