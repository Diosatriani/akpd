package com.diosatriani.kppn_ii.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diosatriani.kppn_ii.Model.DummyData;
import com.diosatriani.kppn_ii.R;

import java.util.ArrayList;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.AdapterViewHolder> {

    private ArrayList<DummyData> list;
    private Context context;

    public TableAdapter(Context context,ArrayList<DummyData> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TableAdapter.AdapterViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_table_spm, viewGroup, false);
        return new AdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( TableAdapter.AdapterViewHolder holder, int i) {
            DummyData data =list.get(i);
            holder.tv_nospm.setText(data.getNomerSpm());
            holder.tv_nominal.setText(data.getNominal());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_nospm, tv_nominal;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            tv_nospm =(TextView) itemView.findViewById(R.id.tv_nospm);
            tv_nominal = (TextView) itemView.findViewById(R.id.tv_nominal);
        }
    }
}
