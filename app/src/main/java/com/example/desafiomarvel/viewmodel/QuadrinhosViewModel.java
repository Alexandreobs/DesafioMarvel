package com.example.desafiomarvel.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.desafiomarvel.model.pojos.Result;
import com.example.desafiomarvel.model.repository.ComicsRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.desafiomarvel.util.AppUtils.md5;

public class QuadrinhosViewModel extends AndroidViewModel {


    private MutableLiveData<List<Result>> listaComics = new MutableLiveData<>();
    private ComicsRepository comicsRepository = new ComicsRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";

    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";

    String ts = Long.toString(System.currentTimeMillis() / 1000);

    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);

    public QuadrinhosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaComics(){
        return this.listaComics;
    }

    public void getComics() {

        disposable.add(
                comicsRepository.getComicsRepository("magazine", "comic", true, "focDate", ts, hash, PUBLIC_KEY)

                        .subscribeOn(Schedulers.newThread())

                        .observeOn(AndroidSchedulers.mainThread())

                        .subscribe(response -> {

                            Log.i("LOG", "Success: " +response);
                        }, throwable -> {

                            Log.i("LOG", "Error: " + throwable.getMessage());
                        }));
    }
}





