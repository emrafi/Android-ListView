package com.muhammadraafi.finalproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewAmphibiaActivity extends AppCompatActivity {
    ListView lvMacam;
    int[] arrImage = {R.drawable.axolot, R.drawable.caecilian, R.drawable.diplocaulus, R.drawable.kodok, R.drawable.salamander};
    String[] arrNama = {"Axolotl", "Caecilian", "Diplocaulus", "Kodok", "Salamander"};
    String[] arrLatin = {"Ambystoma mexicanum", "Ichthyophis bernisi", "Not found", "Rana macrodon", "Salamandra salamandra"};
    String[] arrPesan = {"Hewan amphibi ini berasal dari meksiko, tubuhnya menyerupai naga dengan dua kaki dibelakang dan didepan",
            "Hewan amphibi yang satu ini menyerupai cacing besar mirip ular spesiesnya mencapai 200 jenis ",
            "Ini adalah hewan purba yang masuk golongan amphibi, tubuhnya seperti salamander tetapi kepalanya menyerupai bumerang hewan ini hidup sekitar 270 juta tahun yang lalu",
            "Hewan amphibi ini sering kita jumpai di daerah yang banyak airnya seperti sungai dan sawah-sawah",
            "Tubuhnya mirip kadal dengan hidung pendek dan ekor panjang, spesiesnya sekitar 550 jenis"};
    int pilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_amphibia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvMacam = (ListView) findViewById(R.id.tv_amphibia);
        Adapter_mamalia list_item = new Adapter_mamalia(getBaseContext(), arrImage,arrNama,arrLatin,arrPesan);
        lvMacam.setAdapter(list_item);


        lvMacam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Itu hewan amphibi bernama "+arrNama[position],Toast.LENGTH_SHORT).show();
            }
        });

        lvMacam.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                pilih=position;
                DisplayDialog(position);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DisplayDialog(final int pilihan){

        String[] options = {"Copy","Edit","Delete"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewAmphibiaActivity.this);
        builder.setTitle("Choose");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        Toast.makeText(getBaseContext(),"Saya mau copy : "+arrNama[pilihan] ,Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(),"Saya mau edit : "+arrNama[pilihan] ,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Konfirmasi();
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }
    private void Konfirmasi(){
        AlertDialog.Builder builder =new AlertDialog.Builder(ListViewAmphibiaActivity.this);
        builder.setMessage("Benar Hapus ?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"Anda menghapus : "+arrNama[pilih],Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"Anda batal menghapus : "+arrNama[pilih],Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }

}