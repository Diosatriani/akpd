package com.diosatriani.aplikasirtmd.Setting;

import android.app.Fragment;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.diosatriani.aplikasirtmd.R;

public class Saran extends Fragment {
    public Saran(){}
    LinearLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (LinearLayout) inflater.inflate(R.layout.saran, container, false);

        getActivity().setTitle("Saran");

        return view;
    }
}
