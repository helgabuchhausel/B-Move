package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Buttons> options= new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_research, container, false);

        options.add(new Buttons("facts and figures", new FactsAndFiguresFragment())); // ready
        options.add(new Buttons("comparision", new ComparisionFragment())); // ready
         options.add(new Buttons("language",new  LanguageFragment())); // click
        options.add(new Buttons("cities", new CitiesFragment())); // pciture plus click
        options.add(new Buttons("work",new  WorkFragment())); // click
        options.add(new Buttons("transport",new TransportationFragment())); // click
        options.add(new Buttons("food an bevrages", new FoodAndBevragesFragment())); // click  maybe convert it to card
        options.add(new Buttons("apartments", new ApartmentsFragment())); // TOO DOOO the whole thing or disable
        options.add(new Buttons("taxes", new TaxesFragment())); // TOO DOOO the whole thing or disable
        options.add(new Buttons("housing", new HousingFragment()));// TOO DOOO the whole thing or disable
        options.add(new Buttons("insurances", new InsurancesFragment()));// TOO DOOO the whole thing or disable
        options.add(new Buttons("registration", new RegistrationFragment()));// TOO DOOO the whole thing or disable

        recyclerView = (RecyclerView) view.findViewById(R.id.buttonsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final ButtonRecyclerView adapter = new ButtonRecyclerView(getContext(), options);
        recyclerView.setAdapter(adapter);

        return view;

    }
}