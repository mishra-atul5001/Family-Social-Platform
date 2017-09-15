package com.example.mishr.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FreindsFragment extends Fragment {


    public FreindsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_freinds, container, false);
    }
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(),"Please Tell the Developer About how You feel..!!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(),MainActivity.class);
        startActivity(intent);
    }

}
