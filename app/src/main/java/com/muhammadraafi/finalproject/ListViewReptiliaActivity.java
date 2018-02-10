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

public class ListViewReptiliaActivity extends AppCompatActivity {
    int pilih;
    ListView lvMacam;
    int[] arrImage = {R.drawable.aligator, R.drawable.biawak, R.drawable.buaya, R.drawable.iguana, R.drawable.kadal,R.drawable.komodo,
            R.drawable.kura,R.drawable.penyu,R.drawable.sanca,R.drawable.tokek};
    String[] arrNama = {"Aligator", "Biawak", "Buaya", "Iguana", "Kadal","Komodo","Kura-kura","Penyu","Ular","Tokek"};
    String[] arrLatin = {"Alligator mississipiensis","Varanus nebulosus","Crocodylus porosus","Iguana iguana","Lacerta agilis","Varanus komodoensis","Trachemys scripta elegans",
            "Chelonia mydas","Chondropython viridis","Gecho gecho"};
    String[] arrPesan = {"Mirip buaya tetapi ukuran tubuh lebih kecil","Hidup di pinggir sungai memakan ikan dan binatang kecil lainnya",
    "Banyak berendam dan berjemur,salah satu predator yang ganas","Pemakan tumbuhan biasanya dijadikan peliharaan karena pintar dan warnanya yang menarik",
    "Spesies reptil yang paling banyak ditemui habitatnya sama dengan manusia","Kadal raksasa asli dari Indonesia ini merupakan pembunuh yang mengerikan",
            "Hewan yang berjalan sangat pelan mempunyai tempurung yang keras biasa dijadikan peliharaan","Hidup di laut, salah satu hewan yang dilindungi dan biasanya ditangkarkan agar tetap terjaga kelestarianya",
    "Reptil yang berjalan dengan perutnya tidak mempunyai kaki, ada yang berbisa dan tidak",
    "Menempel pada tembok dengan kaki yang lengket,biasa dijadikan obat untuk suatu penyakit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_reptilia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvMacam = (ListView) findViewById(R.id.tv_reptilia);
        Adapter_mamalia list_item = new Adapter_mamalia(getBaseContext(), arrImage,arrNama,arrLatin,arrPesan);
        lvMacam.setAdapter(list_item);
        lvMacam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Itu hewan reptil bernama "+arrNama[position],Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewReptiliaActivity.this);
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
        AlertDialog.Builder builder =new AlertDialog.Builder(ListViewReptiliaActivity.this);
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
