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

public class ListViewPiscesActivity extends AppCompatActivity {
    int pilih;
    ListView lvMacam;
    int[] arrImage = {R.drawable.bandeng1,R.drawable.cucut1,R.drawable.hiu,R.drawable.kakap1,R.drawable.mas,R.drawable.pari1,R.drawable.tongkol1};
    String[] arrNama = {"Bandeng", "Ikan cucut", "Hiu", "Ikan kakap", "Ikan mas","Ikan pari","Tongkol"};
    String[] arrLatin = {"Chanos chanos", "Stegostama tigrinum", "Carcharhinus leucas", "Lates calcarifer", "Cyprinus caprio",
            "Manta birostris","Euthynnus affinis"};
    String[] arrPesan = {"Salah satu ikan yang digemari karena rasanya yang gurih dan daging yang lembut",
    "Mempunyai moncong di kepala, dijual dipasar sebagai bahan makanan",
    "Predator di laut, memangsa ikan-ikan lainya dan tidak jarang melukai manusia",
    "Salah satu pilihan menu direstoran, dagingnya enak tetapi harganya juga agak mahal",
    "Sebagai ikan peliharaan tetapi dapat juga untuk dikonsumsi mempunyai warna yang cantik",
    "Banyak ditemukan di pantai atau laut lepas, mempunyai ekor yang beracun untuk pertahanan",
    "Biasa dikonsumsi oleh masyarakat dan banyak dijual di pasar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_pisces);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvMacam = (ListView) findViewById(R.id.tv_pisces);
        Adapter_mamalia list_item = new Adapter_mamalia(getBaseContext(), arrImage,arrNama,arrLatin,arrPesan);
        lvMacam.setAdapter(list_item);
        lvMacam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Itu hewan pisces bernama "+arrNama[position],Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewPiscesActivity.this);
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
        AlertDialog.Builder builder =new AlertDialog.Builder(ListViewPiscesActivity.this);
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
