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
import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.RelaxActivity;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailHitDat;

import java.util.ArrayList;

public class HitDatAdapter extends
        RecyclerView.Adapter<HitDatAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<HitDat> mHitDat;

    public HitDatAdapter(Context mContext, ArrayList<HitDat> mHitDat) {
        this.mContext = mContext;
        this.mHitDat = mHitDat;
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
        HitDat hitdat = mHitDat.get(position);
        holder.mTextNgay.setText(hitdat.getNgay());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick(View view, int position) {
                if(hitdat.getNgay() == "Ngày 4: nghỉ ngơi" ||hitdat.getNgay() == "Ngày 8: nghỉ ngơi"||hitdat.getNgay() == "Ngày 14: nghỉ ngơi"){
                    //Toast.makeText(mContext,"Click to "+ hitdat.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, RelaxActivity.class);
                    mContext.startActivity(i);
                }
                else {
                    //Toast.makeText(mContext,"Click to "+ hitdat.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, DetailHitDat.class);
                    mContext.startActivity(i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mHitDat.size();
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
