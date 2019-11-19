package com.example.desafiomarvel.view.fragment.detalhe;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.pojos.herois.Result;
import com.squareup.picasso.Picasso;

import static com.example.desafiomarvel.view.fragment.recycler.HeroisFragment.HEROI_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalhesHeroisFragment extends Fragment {
    private ImageView imgFundo;
    private ImageView imgFrente;
    private TextView txtDescricao;
    private TextView txtPublicacao;
    private TextView txtPaginas;
    private TextView txtTitulo;
    private TextView txtPreco;



    public DetalhesHeroisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhes_herois, container, false);

        initView(view);

        if (getArguments() != null) {

            Result result = getArguments().getParcelable(HEROI_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFrente);
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFundo);

            txtDescricao.setText(result.getDescription());
            txtPublicacao.setText(result.getModified());
            txtTitulo.setText(result.getName());

        }


        return view;
    }

    private void initView(View view) {
        txtDescricao = view.findViewById(R.id.text_descrecaoHeroi);
        imgFrente = view.findViewById(R.id.imageFrenteHeroi);
        imgFundo = view.findViewById(R.id.imageFundoHeroi);
        txtPublicacao = view.findViewById(R.id.text_publicacaoHeroi);
        txtTitulo = view.findViewById(R.id.text_titulo_descricaoHeroi);

    }

}
