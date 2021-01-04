package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {


    private String userName;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        final TextView name = view.findViewById(R.id.nameTextView);
        final TextView date = view.findViewById(R.id.joinedTextView);

        ImageButton belgium = view.findViewById(R.id.belgianFlag);
        ImageButton uk = view.findViewById(R.id.ukFlag);
        ImageButton france = view.findViewById(R.id.franceFlag);
        ImageButton germany = view.findViewById(R.id.germanFlag);

        Button changeName = view.findViewById(R.id.changeNameButton);
        final EditText nameInput = view.findViewById(R.id.nameInput);
        final Button nameInputButton = view.findViewById(R.id.nameInputButton);


        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users").child("0");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name.setText(snapshot.child("name").getValue(String.class));
                date.setText(snapshot.child("joined").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("CANCELLED", "Failed to load msgs.", error.toException());
            }
        });


        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput.setVisibility(View.VISIBLE);
                nameInputButton.setVisibility(View.VISIBLE);

                nameInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (s.toString().trim().length() > 0) {
                            nameInputButton.setEnabled(true);
                            userName = s.toString().trim();
                        } else {
                            nameInputButton.setEnabled(false);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                nameInputButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nameInput.setVisibility(View.INVISIBLE);
                        nameInputButton.setVisibility(View.INVISIBLE);
                        reference.child("users").child("0").child("username").setValue(userName);
                    }
                });
            }
        });

        belgium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentChoice();
            }
        });

        uk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notAvailable();
            }
        });

        france.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notAvailable();
            }
        });

        germany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notAvailable();
            }
        });

        return view;
    }

    public void notAvailable(){
        Toast.makeText(getActivity(), "Currently not available", Toast.LENGTH_SHORT).show();
    }

    public void currentChoice(){
        Toast.makeText(getActivity(), "Your current choice is Belgium", Toast.LENGTH_SHORT).show();
    }
}