package com.muhammadraafi.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Button btnMamalialv, btnReptilialv, btnAveslv, btnPisceslv, btnAmphibialv;
    FloatingActionButton fapExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMamalialv = (Button) findViewById(R.id.btn_lv_mamalia);
        btnReptilialv = (Button) findViewById(R.id.btn_lv_reptilia);
        btnAveslv = (Button) findViewById(R.id.btn_lv_aves);
        btnPisceslv = (Button) findViewById(R.id.btn_lv_pisces);
        btnAmphibialv = (Button) findViewById(R.id.btn_lv_amphibia);
        fapExit = (FloatingActionButton) findViewById(R.id.fap_exit);

        btnMamalialv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ListViewMamaliaActivity.class));
            }
        });
        btnMamalialv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               DisplayDialog();
                return true;
            }
        });

        btnAmphibialv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ListViewAmphibiaActivity.class));
            }
        });
        btnAmphibialv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DisplayDialog1();
                return true;
            }
        });

        btnPisceslv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ListViewPiscesActivity.class));
            }
        });
        btnPisceslv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DisplayDialog2();
                return true;
            }
        });
       btnAveslv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getBaseContext(),ListViewAvesActivity.class));
           }
       });
        btnAveslv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DisplayDialog4();
                return true;
            }
        });

        btnReptilialv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ListViewReptiliaActivity.class));
            }
        });
        btnReptilialv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DisplayDialog3();
                return true;
            }
        });
        fapExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
    public void DisplayDialog(){

        String[] options = {"Lihat ciri-ciri"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        startActivity(new Intent(getBaseContext(),MamaliaActivity.class));
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }
    public void DisplayDialog1(){

        String[] options = {"Lihat ciri-ciri"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        startActivity(new Intent(getBaseContext(),AmphibiActivity.class));
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }
    public void DisplayDialog2(){

        String[] options = {"Lihat ciri-ciri"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        startActivity(new Intent(getBaseContext(),PiscesActivity.class));
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }
    public void DisplayDialog3(){

        String[] options = {"Lihat ciri-ciri"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        startActivity(new Intent(getBaseContext(),ReptiliaActivity.class));

                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }
    public void DisplayDialog4(){

        String[] options = {"Lihat ciri-ciri"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        startActivity(new Intent(getBaseContext(),AvesActivity.class));
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }
}
