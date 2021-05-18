package com.example.ungdungtaptheduc.ui.BaoCao;


import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ungdungtaptheduc.Database;
import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.ui.gallery.NotiFragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class BaoCaoFragment extends Fragment{
    public EditText etchieuCao, etcanNang;
    RadioButton rbNam, rbNu;
    Button tinhBMI;
    TextView tvChiSo,tvNhanXet;
    double chiso;
    LineChart lineChart;
    Database database;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        database = new Database(getActivity(), "Workout.db", null, 1);
        database.QueryData("Create Table If Not Exists BMI(Id Integer Primary Key Autoincrement,ChieuCao text,CanNang text,Bmi text" +
                ",Chon int,NhanXet String)");
        View root = inflater.inflate(R.layout.fragment_baocao, container, false);
        lineChart = root.findViewById(R.id.chart_line);
        double x = 0;
        int numDataPoint = 1000;

        ArrayList<String> xAXES = new ArrayList<>();
        xAXES.add("Tháng 1");
        xAXES.add("Tháng 2");
        xAXES.add("Tháng 3");
        xAXES.add("Tháng 4");
        xAXES.add("Tháng 5");
        ArrayList<Entry> ysin = new ArrayList<>();
        ArrayList<Entry> ycos = new ArrayList<>();
        for (int i = 0; i < numDataPoint; i++){
            float sinFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            float cosFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            x = x * 0.1;
            ysin.add(new Entry(sinFunction,i));
            ycos.add(new Entry(cosFunction,i));
            xAXES.add(i, String.valueOf(x));
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        LineDataSet lineDataSet1 = new LineDataSet(ycos,"cos");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);


        LineDataSet lineDataSet2 = new LineDataSet(ysin,"sin");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);
        lineChart.setData(new LineData(lineDataSets));
        lineChart.setVisibleXRangeMaximum(65f);

        etchieuCao = root.findViewById(R.id.et_chieucao);
        etchieuCao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() ==0) {
                    etchieuCao.setError("Bạn bắt buộc phải nhập chiều cao");
                } else {
                    etchieuCao.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etcanNang = root.findViewById(R.id.et_cannang);
        etcanNang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() ==0) {
                    etcanNang.setError("Bạn bắt buộc phải nhập cân nặng");
                } else {
                    etcanNang.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        tvNhanXet = root.findViewById(R.id.tv_nhanxet);
        rbNam = root.findViewById(R.id.rb_nam);
        rbNu = root.findViewById(R.id.rb_nu);
        tinhBMI = root.findViewById(R.id.btn_tinhBMI);
        tvChiSo = root.findViewById(R.id.tv_bmi);
        database = new Database(getActivity(), "Workout.db", null, 1);
        Cursor dataChiSo = database.GetData("Select * from BMI");
        if(dataChiSo.getCount() > 0) {
            while (dataChiSo.moveToNext()) {
                String cc = dataChiSo.getString(1);
                String cn = dataChiSo.getString(2);
                String Bmi = dataChiSo.getString(3);
                String Chon = dataChiSo.getString(4);
                String NhanXet = dataChiSo.getString(5);
//            Toast.makeText(getActivity(),cc,Toast.LENGTH_SHORT).show();
//            Toast.makeText(getActivity(),cn,Toast.LENGTH_SHORT).show();
//            Toast.makeText(getActivity(),Bmi,Toast.LENGTH_SHORT).show();
                etchieuCao.setText(cc);
                etcanNang.setText(cn);
                tvChiSo.setText(Bmi);
                tvNhanXet.setText(NhanXet);
            }
        }

        tinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etchieuCao.length() != 0){
                    if(etcanNang.length() != 0){
                        double chieuCao = Double.parseDouble(etchieuCao.getText().toString()) / 100;
                        double canNang = Double.parseDouble(etcanNang.getText().toString());
                        chiso = Math.round((canNang / Math.pow(chieuCao, 2)) * 1.0);

                        String chieucao = etchieuCao.getText().toString();
                        String cannang = etcanNang.getText().toString();
                        String bmi = String.valueOf(chiso);

                        //database = new Database(getActivity());
                        //database.QueryData("Drop Table BMI");
                        int chon;
                        if (rbNam.isChecked()) {
                            chon = 1;
                            if (chiso < 18.5) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                            } else if (chiso >= 18.5 && chiso <= 24.9) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn có chỉ số BMI bình thường");
                            } else if (chiso == 25) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang bị thừa cân");
                            } else if (chiso > 25 && chiso <= 29.9) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang ở giai đoạn tiền béo phì/béo phì mức độ thấp");
                            } else if (chiso >= 30 && chiso <= 34.9) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang bị béo phì độ 1");
                            } else if (chiso >= 35 && chiso <= 39.9) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang bị béo phì độ 2");
                            } else if (chiso >= 40) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang bị béo phì độ 3");
                            }
                            String nhanxet = tvNhanXet.getText().toString();
                            Boolean kiemTraThem = database.ThemBMI(chieucao,cannang,bmi,chon,nhanxet);

//                            Boolean kiemTraCapNhat = database.CapNhatBMI(chieucao,cannang,bmi,chon,nhanxet);
//                            if(kiemTraCapNhat == true){
//                                Toast.makeText(getActivity(),"cap nhat thanh cong",Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//                                Toast.makeText(getActivity(),"cap nhat that bai",Toast.LENGTH_SHORT).show();
//                           }
                        }
                        else if (rbNu.isChecked()) {
                            chon = 2;
                            if (chiso < 18.5) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                            } else if (chiso >= 18.5 && chiso <= 22.9) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn có chỉ số BMI bình thường");
                            } else if (chiso == 23) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang bị thừa cân");
                            } else if (chiso > 23 && chiso <= 24.9) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang ở giai đoạn tiền béo phì/béo phì mức độ thấp");
                            } else if (chiso >= 25 && chiso <= 29.9) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang bị béo phì độ 1");
                            } else if (chiso >= 30) {
                                tvChiSo.setText(String.valueOf(chiso));
                                tvNhanXet.setText("Bạn đang bị béo phì độ 2");
                            }

                            String nhanxet = tvNhanXet.getText().toString();
                            Boolean kiemTraThem = database.ThemBMI(chieucao,cannang,bmi,chon,nhanxet);

//                            Boolean kiemTraCapNhat = database.CapNhatBMI(chieucao,cannang,bmi,chon,nhanxet);
//                            if(kiemTraCapNhat == true){
//                                Toast.makeText(getActivity(),"cap nhat thanh cong",Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//                                Toast.makeText(getActivity(),"cap nhat that bai",Toast.LENGTH_SHORT).show();
//                            }
                        }
                        else {
                            Toast.makeText(getActivity(), "Vui lòng nhập giới tính", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        etcanNang.setError("Bạn bắt buộc phải nhập cân nặng");
                        //Toast.makeText(getActivity(),"phải nhập cân nặng",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    etchieuCao.setError("Bạn bắt buộc phải nhập chiều cao");
                    //Toast.makeText(getActivity(),"phải nhập chiều cao",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}

