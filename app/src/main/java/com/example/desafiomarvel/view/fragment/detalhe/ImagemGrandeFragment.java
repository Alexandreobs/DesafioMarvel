package com.example.desafiomarvel.view.fragment.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.pojos.Quadrinhos.Result;
import com.squareup.picasso.Picasso;

import static com.example.desafiomarvel.view.fragment.recycler.QuadrinhosFragment.COMICS_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagemGrandeFragment extends Fragment {
    private ImageView imgGrande;


    public ImagemGrandeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imagem_grande, container, false);

        imgGrande = view.findViewById(R.id.imageGrande);

        if (getArguments() != null) {

            Result result = getArguments().getParcelable(COMICS_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgGrande);

        }

        return view;

    }

}
