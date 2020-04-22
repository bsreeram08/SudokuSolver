package com.sree.sudokusolver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_camera extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup conrainer, @Nullable Bundle savedInstanceState) {
        return(inflater.inflate(R.layout.fragment_choice_camera,conrainer,false));
    }
}
