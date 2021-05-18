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
import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.RelaxActivity;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailGapBung;

import java.util.ArrayList;

public class GapBungAdapter extends
        RecyclerView.Adapter<GapBungAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<GapBung> mGapBung;

    public GapBungAdapter(Context mContext, ArrayList<GapBung> mGapBung) {
        this.mContext = mContext;
        this.mGapBung = mGapBung;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View gapbungView = inflater.inflate(R.layout.ngaytap_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(gapbungView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GapBung gapBung = mGapBung.get(position);
        holder.mTextNgay.setText(gapBung.getNgay());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick(View view, int position) {
                if(gapBung.getNgay() == "Ngày 4: nghỉ ngơi"||gapBung.getNgay() == "Ngày 8: nghỉ ngơi" ){
                    //Toast.makeText(mContext,"Click to "+ gapBung.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, RelaxActivity.class);
                    mContext.startActivity(i);
                }
                else {
                    //Toast.makeText(mContext,"Click to "+ hitdat.getNgay(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClass(mContext, DetailGapBung.class);
                    mContext.startActivity(i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mGapBung.size();
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
