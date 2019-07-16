package com.montini.teamsports;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LocationsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_locations, container, false);
    }

    // @Override
    // public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    //     super.onViewCreated(R.layout.fragment_locations, savedInstanceState);
    // }
}