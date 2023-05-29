package com.example.miscontactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//import android.widget.ImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private ArrayList<Pet> petList;
    private RecyclerView rvContactos;
    private TextView perfil;
    //private ImageView imageP;
    private de.hdodenhof.circleimageview.CircleImageView imageP;
    private PerfilAdapter adaptador;
    private String param1;
    private String param2;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString("param1");
            param2 = getArguments().getString("param2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new PetAdapter(petList);
        rvContactos.setAdapter(adaptador);
    }

    public void inicializarPets(){
        petList = new ArrayList<Pet>();
        petList.add(new Pet("Punch",6, R.drawable.pet2));
        petList.add(new Pet("Snow",5, R.drawable.pet2));
        petList.add(new Pet("Lolo",8, R.drawable.pet2));
        petList.add(new Pet("Hush",9, R.drawable.pet2));

    }


     public static FirstFragment newInstance(String param1,
                                                String param2)
        {
            FirstFragment fragment = new FirstFragment();
            Bundle args = new Bundle();
            args.putString("param1", param1);
            args.putString("param2", param2);
            fragment.setArguments(args);
            return fragment;
        }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rvContactos = (RecyclerView) view.findViewById(R.id.rvContactos);
        perfil = (TextView) view.findViewById(R.id.perfil);
        imageP = (de.hdodenhof.circleimageview.CircleImageView) view.findViewById(R.id.imageP);


        GridLayoutManager glm = new  GridLayoutManager(getContext(),3);


        rvContactos.setLayoutManager(glm);
        inicializarPets();
        inicializarAdaptador();

    }

}

