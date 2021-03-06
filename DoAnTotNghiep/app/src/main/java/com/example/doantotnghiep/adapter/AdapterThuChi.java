package com.example.doantotnghiep.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.doantotnghiep.R;
import com.example.doantotnghiep.model.ArrayThuChi;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdapterThuChi extends ArrayAdapter<ArrayThuChi> {
    private Activity a;
    private int id;
    private ArrayList<ArrayThuChi> arr;
    private TextView ngay, tien, danhmucthuchi, vi, loaikhoan, mota, nhanthongbao; //moi

    public AdapterThuChi(Activity context, int resource, ArrayList<ArrayThuChi> objects) {
        super(context, resource, objects);
        this.a = context;
        this.id = resource;
        this.arr = objects;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater in = a.getLayoutInflater();
        view = in.inflate(id, null);
        if (arr.size()>0 && position>=0) {
            ngay = view.findViewById(R.id.txtNgayThuChi);
            tien = view.findViewById(R.id.txtTienThuChi);
            danhmucthuchi = view.findViewById(R.id.txtDanhMucThuChi);
            vi = view.findViewById(R.id.txtViThuChi);
            loaikhoan = view.findViewById(R.id.txtLoaiKhoanThuChi);
            mota = view.findViewById(R.id.txtMoTaThuChi);
            nhanthongbao = view.findViewById(R.id.txtThongBao); //moi

            ngay.setText(""+ arr.get(position).thoigian);
            tien.setText(DoiSoSangTien(arr.get(position).tien));
            danhmucthuchi.setText(arr.get(position).danhmucthuchi);
            vi.setText(arr.get(position).vi);
            loaikhoan.setText(arr.get(position).loaikhoan + ":");
            mota.setText(arr.get(position).mota);
            nhanthongbao.setText(arr.get(position).nhanthongbao); //moi
        }
        return view;
    }

    public static String DoiSoSangTien(Double so) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("#,###,###,###");
        return decimalFormat.format((so)) + " đ";
    }
}
