package com.diosatriani.aplikasirtmd.Setting;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.diosatriani.aplikasirtmd.R;
import com.diosatriani.aplikasirtmd.Setting.AgendaRt.TambahAgendaActivity;

//import android.support.v4.app.Fragment;

public class Agenda extends Fragment {
    private CardView cvAddAgenda;

    public Agenda() {
    }

    LinearLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (LinearLayout) inflater.inflate(R.layout.agenda, container, false);
        initView();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cvAddAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TambahAgendaActivity.class);
                getActivity().startActivity(intent);
            }
        });


    }

    private void initView() {
        cvAddAgenda = (CardView) view.findViewById(R.id.cv_add_agenda);
    }
}
