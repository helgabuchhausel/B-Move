package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComparisionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComparisionFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ComparisionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComparisionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComparisionFragment newInstance(String param1, String param2) {
        ComparisionFragment fragment = new ComparisionFragment();
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


        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                FragmentManager fragmentManager = ((AppCompatActivity)getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFrameLayout ,new InfoFragment());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comparison, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        WebView myVrtWebView = (WebView) getView().findViewById(R.id.ComparisonWebView);
        myVrtWebView.loadUrl("https://www.numbeo.com/cost-of-living/comparison.jsp");
    }
}