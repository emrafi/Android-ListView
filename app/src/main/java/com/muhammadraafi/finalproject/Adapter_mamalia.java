package com.muhammadraafi.finalproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_mamalia extends BaseAdapter {

    int[] arrImage;
    String[] arrNama;
    String[] arrLatin;
    String[] arrPesan;

    LayoutInflater inflater = null;

    public Adapter_mamalia(Context c, int[] img, String[] nama, String[] latin, String[] pesan){
        arrImage = img;
        arrNama = nama;
        arrLatin = latin;
        arrPesan = pesan;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrNama.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class Intake{
        ImageView imgUser;
        TextView tvNama, tvlatin, tvPesan;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Intake intake = new Intake();
        convertView = inflater.inflate(R.layout.activity_adapter_mamalia,null);
        intake.imgUser = (ImageView) convertView.findViewById(R.id.img_user);
        intake.tvNama = (TextView) convertView.findViewById(R.id.tv_nama);
        intake.tvlatin = (TextView) convertView.findViewById(R.id.tv_latin);
        intake.tvPesan = (TextView) convertView.findViewById(R.id.tv_pesan);

        intake.imgUser.setImageResource(arrImage[position]);
        intake.tvNama.setText(arrNama[position]);
        intake.tvlatin.setText(arrLatin[position]);
        intake.tvPesan.setText(arrPesan[position]);

        return convertView;
    }

}
