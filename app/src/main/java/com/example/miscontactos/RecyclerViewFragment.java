package com.example.miscontactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Pet> petList;
    private RecyclerView recyclerView;
    private PetAdapter adaptador;
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
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return v;
    }


    public void inicializarAdaptador(){
        adaptador = new PerfilAdapter(petList);
        recyclerView.setAdapter(adaptador);
    }

    public void inicializarPets(){
        petList = new ArrayList<Pet>();
        petList.add(new Pet("Punch",0, R.drawable.pet1));
        petList.add(new Pet("Snow",0, R.drawable.pet2));
        petList.add(new Pet("Lolo",0, R.drawable.pet3));
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new  LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        inicializarPets();
        inicializarAdaptador();

    }

}
