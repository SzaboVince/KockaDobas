package com.example.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView kocka1;
    private ImageView kocka2;
    private Button kockagomb1;
    private Button kockagomb2;
    private Button dobas;
    private Button reset;
    private TextView szoveg;
    private String szovegecske;
    private int kocka1dobas;
    private int kocka2dobas;
    private LinearLayout linear;
    private Random rnd;
    private boolean kockavan;
    private AlertDialog.Builder alertvege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        kockagomb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kocka2.setVisibility(view.GONE);
                kockavan=false;
            }
        });
        kockagomb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kocka2.setVisibility(view.VISIBLE);
                kockavan=true;

            }
        });
        dobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int veletlen1=rnd.nextInt(6);
                int veletlen2=rnd.nextInt(6);
                if (kockavan==false){
                    switch (veletlen1){
                        case 0:
                            kocka1.setImageResource(R.drawable.kocka1);
                            break;
                        case 1:
                            kocka1.setImageResource(R.drawable.kocka2);
                            break;
                        case 2:
                            kocka1.setImageResource(R.drawable.kocka3);
                            break;
                        case 3:
                            kocka1.setImageResource(R.drawable.kocka4);
                            break;
                        case 4:
                            kocka1.setImageResource(R.drawable.kocka5);
                            break;
                        case 5:
                            kocka1.setImageResource(R.drawable.kocka6);
                            break;
                    }
                    Toast.makeText(MainActivity.this,"Dobás:"+(veletlen1+1),Toast.LENGTH_SHORT).show();
                        veletlen1++;
                        szovegecske+=veletlen1+"\n";
                        szoveg.setText(szovegecske);

                }
                else{
                    switch (veletlen1) {
                        case 0:
                            kocka1.setImageResource(R.drawable.kocka1);
                            break;
                        case 1:
                            kocka1.setImageResource(R.drawable.kocka2);
                            break;
                        case 2:
                            kocka1.setImageResource(R.drawable.kocka3);
                            break;
                        case 3:
                            kocka1.setImageResource(R.drawable.kocka4);
                            break;
                        case 4:
                            kocka1.setImageResource(R.drawable.kocka5);
                            break;
                        case 5:
                            kocka1.setImageResource(R.drawable.kocka6);
                            break;
                    }
                    switch (veletlen2) {
                        case 0:
                            kocka2.setImageResource(R.drawable.kocka1);
                            break;
                        case 1:
                            kocka2.setImageResource(R.drawable.kocka2);
                            break;
                        case 2:
                            kocka2.setImageResource(R.drawable.kocka3);
                            break;
                        case 3:
                            kocka2.setImageResource(R.drawable.kocka4);
                            break;
                        case 4:
                            kocka2.setImageResource(R.drawable.kocka5);
                            break;
                        case 5:
                            kocka2.setImageResource(R.drawable.kocka6);
                            break;
                    }
                    Toast.makeText(MainActivity.this,"Dobás:"+(veletlen1+1)+" és "+(veletlen2+1),Toast.LENGTH_SHORT).show();
                        int osszeg=veletlen1+veletlen2+2;
                        veletlen1++;
                        veletlen2++;
                        szovegecske+=osszeg+" ("+veletlen1+"+"+veletlen2+")\n";
                        szoveg.setText(szovegecske);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertvege.show();
            }
        });
    }

    public void init(){
        kocka1=findViewById(R.id.kocka1);
        kocka2=findViewById(R.id.kocka2);
        kockagomb1=findViewById(R.id.kockagomb1);
        kockagomb2=findViewById(R.id.kockagomb2);
        dobas=findViewById(R.id.dobas);
        reset=findViewById(R.id.reset);
        szoveg=findViewById(R.id.szoveg);
        kocka1dobas=1;
        kocka2dobas=1;
        linear=findViewById(R.id.linear);
        rnd=new Random();
        kockavan=true;
        szovegecske="";
        alertvege=new AlertDialog.Builder(MainActivity.this);
        alertvege.setTitle("Reset");
        alertvege.setMessage("Biztos hogy törölni szeretné az eddigi dobásokat?");
        alertvege.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newgame();
            }
        });
        alertvege.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }
    public void newgame(){
        kockavan=true;
        init();
        kocka1.setImageResource(R.drawable.kocka1);
        kocka2.setImageResource(R.drawable.kocka1);
        szoveg.setText("");
    }
}