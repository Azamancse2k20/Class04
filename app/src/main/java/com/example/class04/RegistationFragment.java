package com.example.class04;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistationFragment extends Fragment {
    View mainView;
    private EditText nameText,numberText,passText;
    public boolean isCompleted = false;

    private Button button;


    public RegistationFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_registation, container, false);

        nameText = mainView.findViewById(R.id.nameTextId);
        numberText = mainView.findViewById(R.id.numberTextId);
        passText = mainView.findViewById(R.id.passTextId);
        button = mainView.findViewById(R.id.textViewId);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!nameText.getText().toString().isEmpty()&&!numberText.getText().toString().isEmpty()&&
                        !passText.getText().toString().isEmpty()){


                    ((MainActivity)getActivity()).nextState();
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Plece fail up all the field", Toast.LENGTH_SHORT).show();
                }


            }
        });



        return mainView;

    }

}
