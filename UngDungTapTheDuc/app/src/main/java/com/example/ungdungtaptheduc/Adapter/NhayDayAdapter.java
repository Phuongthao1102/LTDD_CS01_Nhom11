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
import com.example.ungdungtaptheduc.Model.GapBung;
import com.example.ungdungtaptheduc.Model.NhayDay;
import com.example.ungdungtaptheduc.Model.Squat;
import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.RelaxActivity;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailGapBung;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailNhayDay;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailSquat;

import java.util.ArrayList;

public class NhayDayAdapter extends
        RecyclerView.Adapter<NhayDayAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<NhayDay> mNhayDay;

    public NhayDayAdapter(Context mContext, ArrayList<NhayDay> mNhayDay) {
        this.mContext = mContext;
        this.mNhayDay = mNhayDay;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View squatView = inflater.inflate(R.layout.ngaytap_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(squatView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NhayDay nhayDay = mNhayDay.get(position);
        holder.mTextNgay.setText(nhayDay.getNgay());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick(View view, int position) {
                if(nhayDay.getNgay() == "Ngày 4: nghỉ ngơi" || nhayDay.getNgay() == "Ngày 8: nghỉ ngơi"){
                    //Toast.makeText(mContext,"Click to "+ nhayDay.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, RelaxActivity.class);
                    mContext.startActivity(i);
                }
                else {
                    //Toast.makeText(mContext,"Click to "+ hitdat.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, DetailNhayDay.class);
                    mContext.startActivity(i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mNhayDay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ItemClickListener itemClickListener;
        private TextView mTextNgay;

        private TextView mTest;

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
