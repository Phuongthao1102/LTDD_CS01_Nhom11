package com.example.ungdungtaptheduc.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Interface.ItemClickListener;
import com.example.ungdungtaptheduc.Model.HitDat;
import com.example.ungdungtaptheduc.Model.NangTa;
import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.RelaxActivity;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailHitDat;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailNangTa;

import java.util.ArrayList;

public class NangTaAdapter extends
        RecyclerView.Adapter<NangTaAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<NangTa> mNangTa;

    public NangTaAdapter(Context mContext, ArrayList<NangTa> mNangTa) {
        this.mContext = mContext;
        this.mNangTa = mNangTa;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View hitdatView = inflater.inflate(R.layout.ngaytap_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(hitdatView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NangTa nangTa = mNangTa.get(position);
        holder.mTextNgay.setText(nangTa.getNgay());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick(View view, int position) {
                if(nangTa.getNgay() == "Ngày 4: nghỉ ngơi" || nangTa.getNgay() == "Ngày 8: nghỉ ngơi" ){
                    //Toast.makeText(mContext,"Click to "+ nangTa.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, RelaxActivity.class);
                    mContext.startActivity(i);
                }
                else {
                    //Toast.makeText(mContext,"Click to "+ hitdat.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, DetailNangTa.class);
                    mContext.startActivity(i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mNangTa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ItemClickListener itemClickListener;
        private TextView mTextNgay;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextNgay= itemView.findViewById(R.id.text_ngay);
            itemView.setOnClickListener((View.OnClickListener) this);
        }
        public void onClick(View view){

            itemClickListener.OnClick(view,getAdapterPosition());
        }
        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }
    }
}
