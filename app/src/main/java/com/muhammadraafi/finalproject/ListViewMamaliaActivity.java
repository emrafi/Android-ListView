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

public class ListViewMamaliaActivity extends AppCompatActivity {
    int pilih;
    ListView lvMacam;
    int[] arrImage = {R.drawable.badak,R.drawable.beruang,R.drawable.gajah,R.drawable.harimau,R.drawable.jerapah,R.drawable.kanguru,
    R.drawable.kelelawar,R.drawable.kelinci,R.drawable.kerbau,R.drawable.kuda,R.drawable.sapi
    ,R.drawable.lumba,R.drawable.orgutan,R.drawable.tupai};
    String[] arrNama = {"Badak","Beruang","Gajah","Harimau","Jerapah","Kanguru","Kelelawar","Kelinci","Kerbau","Kuda","Sapi"
    ,"Lumba-lumba","Orang utan","Tupai"};
    String[] arrLatin = {"Rhinoceros sonaicus","Ursus Arctos","Elephas indicus","Panthera tigris","Giraffa cameliopardalis","Dendrogalus ursinus",
    "Chiropetra","Lepus curpaeums","Bubalus bubalis","Equus caballus","Bos taurus",
            "Pesut Orcaella brevirostris","Mawas Pongo pygmaeus","Tupaia javanica"};
    String[] arrPesan = {"Merupakan hewan mamalia dengan status dilindungi yang mempunyai cula dibagian kepala dan kulit yang tebal",
    "Hewan mamalia yang memakan daging dengan habitat di hutan dan kutub, bulunya tebal dan hangat",
            "Hewan mamalia yang mempunyai ukuran sangat besar hidup dihutan dan memakan tumbuhan",
            "Salah satu mamalia yang menjadi predator di hutan dengan memangsa hewan lainya",
    "Hewan mamalia yang mempunyai leher panjang untuk memakan daun pada pohon yang tinggi",
            "Hewan mamalia yang berasal dari Australia ini memiliki kantong diperutnya untuk menyimpan anak ketika masih kecil",
    "Merupakan satu-satunya hewan mamalia yang bisa terbang","Hewan mamalia satu ini lucu dan menggemaskan biasanya menjadi hewan peliharaan",
    "Hewan mamalia yang biasanya dimanfaatkan tenaganya untuk membajak sawah","Banyak dimanfaatkan masyarakat untuk tunggangan atau balapan dalam pacu kuda",
    "Hewan ini salah satu sumber makanan bagi manusia, sering diambil susu dan dagingnya",
    "Salah satu mamalia yang hidup di air selain ikan paus","Hewan mamalia ini hampir punah di habitatnya patut untuk dijaga kelestarianya",
    "Mamalia satu ini memiliki tubuh mungil, hidup dipohon dan suka melompat ke tangkai pohon lainnya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_mamalia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvMacam = (ListView) findViewById(R.id.tv_mamalia);
        Adapter_mamalia list_item = new Adapter_mamalia(getBaseContext(), arrImage,arrNama,arrLatin,arrPesan);
        lvMacam.setAdapter(list_item);
        lvMacam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Itu hewan mamalia bernama "+arrNama[position],Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(ListViewMamaliaActivity.this);
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
        AlertDialog.Builder builder =new AlertDialog.Builder(ListViewMamaliaActivity.this);
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
