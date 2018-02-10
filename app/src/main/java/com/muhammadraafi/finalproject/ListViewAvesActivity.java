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

public class ListViewAvesActivity extends AppCompatActivity {
    int pilih;
    ListView lvMacam;
    int[] arrImage = {R.drawable.ayam, R.drawable.bangau, R.drawable.brcendrawasih, R.drawable.brhantu,R.drawable.brunta,
    R.drawable.gereja,R.drawable.kakaktua,R.drawable.kasuari,R.drawable.pinguin};
    String[] arrNama = {"Ayam", "Burung bangau", "Cendrawasih", "Burung hantu", "Burung unta","Burung gereja","Burung kakatua","Kasuari","Pinguin"};
    String[] arrLatin = {"Gallus gallus", "Leptiptolus javanicus", "Paradisea regiana", "Ninox scutulata", "Struthio camelus",
    "Passer montanus","Cacatua sulphurea","Casuarius casuarius","Spheniscus humboldti"};
    String[] arrPesan = {"Merupakan golongan aves yang sering kita jumpai dan menjadi sumber makanan bagi manusia",
            "Sering berada di rawa-rawa atau pinggir sungai mencari makan berupa ikan-ikan kecil",
    "Biasa disebut burung surga karena keindahan bulu dan tarianya, sudah mulai punah harus dijaga dan dilestarikan",
    "Pemakan tikus ini mencari makan pada malam hari dengan penglihatanya yang sangat tajam",
            "Merupakan jenis aves dengan ukuran yang besar dan dapat berlari dengan cepat",
    "Biasa bergerombol terbang di ranting-ranting pohon dan mencari makan berupa biji-bijian",
            "Burung pandai dengan berbagai spesies yang mempunyai warna yang bermacam-macam",
    "Populasinya terus berkurang karena perburuan, salah satu burung yang dilindungi",
    "Jenis aves yang tinggal ditempat yang dingin dan dapat menyelam kedalam air"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_aves);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvMacam = (ListView) findViewById(R.id.tv_aves);
        Adapter_mamalia list_item = new Adapter_mamalia(getBaseContext(), arrImage,arrNama,arrLatin,arrPesan);
        lvMacam.setAdapter(list_item);

        lvMacam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Itu hewan aves bernama "+arrNama[position],Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewAvesActivity.this);
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
        AlertDialog.Builder builder =new AlertDialog.Builder(ListViewAvesActivity.this);
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
