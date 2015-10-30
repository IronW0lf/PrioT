package com.vald.priot;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CommunicationFragment_1 extends Fragment implements View.OnClickListener {

    Button button;
    int counter = 0;
    Communicator communicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_communication_1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator) getActivity();
        button = (Button) getActivity().findViewById(R.id.button_in_fragment_1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter++;
        communicator.respond("The button was clicked " + counter + " times");
    }
}
