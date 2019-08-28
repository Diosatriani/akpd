package com.diosatriani.reservashotel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.diosatriani.reservashotel.R;
import com.diosatriani.reservashotel.model.Hotel;

import java.util.ArrayList;

public class AdapterDaftarHotel extends RecyclerView.Adapter<AdapterDaftarHotel.AdapterHolder> {


    private ArrayList<Hotel> hotels;
    private Context context;

    public AdapterDaftarHotel(Context context, ArrayList<Hotel> hotels) {
        this.hotels = hotels;
        this.context = context;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_list, viewGroup, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder,final int i) {
        Hotel hotel =  hotels.get(i);
        holder.etNamaList.setText(hotel.getNamaHotel());
        holder.etAlamatList.setText(hotel.getAlamatHotel());

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        private ImageView ivListGambar;
        private EditText etNamaList, etAlamatList;
        private Button btnKontakList;
        public AdapterHolder(View itemView) {
            super(itemView);
            ivListGambar = (ImageView) itemView.findViewById(R.id.iv_list_gambar);
            etNamaList = (EditText) itemView.findViewById(R.id.et_nama_list);
            etAlamatList = (EditText) itemView.findViewById(R.id.et_alamat_list);
            btnKontakList = (Button) itemView.findViewById(R.id.btn_kontak_list);
        }
    }
}
