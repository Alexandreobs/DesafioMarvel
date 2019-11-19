package com.example.desafiomarvel.view.fragment.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.pojos.esqcritores.Result;
import com.squareup.picasso.Picasso;

import static com.example.desafiomarvel.view.fragment.recycler.AutoresFragment.CRIADOR_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheCriadorFragment extends Fragment {
    private ImageView imgFundo;
    private ImageView imgFrente;
    private TextView txtDescricao;
    private TextView txtPublicacao;
    private TextView txtTitulo;
    private TextView txtPreco;


    public DetalheCriadorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhe_criador, container, false);


        initView(view);

        if (getArguments() != null) {

            Result result = getArguments().getParcelable(CRIADOR_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFrente);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFundo);

            txtDescricao.setText(result.getModified());
            txtTitulo.setText(result.getFullName());

        }


        return view;
    }

    private void initView(View view) {
        txtDescricao = view.findViewById(R.id.text_descrecaoCriador);
        imgFrente = view.findViewById(R.id.imageFrenteCriador);
        imgFundo = view.findViewById(R.id.imageFundoCriador);
        txtTitulo = view.findViewById(R.id.text_titulo_descricaoCriador);

    }

}
