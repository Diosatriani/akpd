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
import com.diosatriani.aplikasirtmd.Setting.AgendaRt.TambahAgendaActivity;

//import android.support.v4.app.Fragment;

public class Polling extends Fragment {
    private CardView cvPolling;

    public Polling() {
    }

    LinearLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (LinearLayout) inflater.inflate(R.layout.polling, container, false);
        initView();

        cvPolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TambahAgendaActivity.class);
                getActivity().startActivity(intent);
            }
        });

        getActivity().setTitle("Polling");

        return view;
    }

    private void initView() {
        cvPolling = (CardView) view.findViewById(R.id.cv_polling);
    }
}
