package com.example.desafiomarvel.model.data.remote;

// chave publica 490ed832d947694ac569e523de0ffe38
// chave privada 54c01da469d7212b6a2dc678ff2ca4e69455d3b7

import com.example.desafiomarvel.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    private static final String BASE_URL = "https://gateway.marvel.com:443/v1/public/";
    private static retrofit2.Retrofit retrofit;

    private static retrofit2.Retrofit getRetrofit() {

        // Se a variavéml retrofit estiver nula inicializamos
        if (retrofit == null) {

            // Configuração de parametros de conexão
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);

            // Se estivermos em modo DEBUG habilitamos os logs
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
                httpClient.addNetworkInterceptor(new StethoInterceptor());
            }

            // inicializamos o retrofit com as configurações
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    // Retornamos a api criada com o retrofit
    public static MarvelApi getApiService() {
        return getRetrofit().create(MarvelApi.class);
    }
}

