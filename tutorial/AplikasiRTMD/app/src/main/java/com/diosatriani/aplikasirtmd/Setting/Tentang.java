package com.diosatriani.aplikasirtmd.Setting;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.diosatriani.aplikasirtmd.R;
import com.diosatriani.aplikasirtmd.Setting.TentangRt.PengurusRtActivity;

//import android.support.v4.app.Fragment;

public class Tentang extends Fragment {

    private CardView cvKontakPengurusRt;

    public Tentang() {
    }

    LinearLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (LinearLayout) inflater.inflate(R.layout.tentang_rt, container, false);
        initView();

        cvKontakPengurusRt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PengurusRtActivity.class));
            }
        });

        getActivity().setTitle("Tentang");

        return view;
    }

    private void initView() {
        cvKontakPengurusRt = (CardView) view.findViewById(R.id.cv_kontak_pengurus_rt);
    }
}
