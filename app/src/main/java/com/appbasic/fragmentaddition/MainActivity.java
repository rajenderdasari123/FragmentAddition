package com.appbasic.fragmentaddition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtno1, txtno2;
    TextView txtSum;
    int firstNo = 0, secondNo = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.fragment1);


        FragmentB fragmentB = (FragmentB) fragmentA.getChildFragmentManager().findFragmentById(R.id.fragment2);

        FragmentC fragmentC = (FragmentC) fragmentB.getChildFragmentManager().findFragmentById(R.id.fragment3);

        txtno1 = (EditText) fragmentA.getView().findViewById(R.id.txtno1);

        txtno2 = (EditText) fragmentB.getView().findViewById(R.id.txtno2);

        txtSum = (TextView) fragmentC.getView().findViewById(R.id.txtsum);


        txtno1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().isEmpty())
                    firstNo = 0;
                else
                    firstNo = Integer.parseInt(editable.toString());

                txtSum.setText("Results :" + (firstNo + secondNo));
            }
        });

        txtno2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty())
                    secondNo = 0;
                else
                    secondNo = Integer.parseInt(editable.toString());
                txtSum.setText("Sum :" + (firstNo + secondNo));
            }
        });

    }

}
