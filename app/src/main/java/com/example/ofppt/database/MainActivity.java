package com.example.ofppt.database;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1;
    Mabase base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base=new Mabase(this);

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        e3=(EditText) findViewById(R.id.e3);
        b1=(Button) findViewById(R.id.b1);

    }

        public void ajouter(View view){
           Integer a=Integer.parseInt(e1.getText()+"") ;
           String b=e2.getText()+"";
           String c=e3.getText()+"";

           boolean bo=base.insertion(a,b,c);
           if(bo==true){
               Toast.makeText(MainActivity.this,"Insertion réalisé !",Toast.LENGTH_SHORT).show();
               e1.setText("");
               e2.setText("");
               e3.setText("");
           }
           else {
               Toast.makeText(MainActivity.this,"Erreur d'insertion !",Toast.LENGTH_SHORT).show();
           }
    }

         public void lister(View view){
             Cursor c=base.lister();

             String ch="";

             while (c.moveToNext()){
                 ch +=c.getString(0)+" "+c.getString(1)+" "+c.getString(2)+"\n";
             }

             AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);

             a.setMessage(ch);
             a.setTitle("liste des stagiaires");
             a.show();
         }

         public void supprimer(View view){
             Integer x=base.supprimer(e1.getText()+"");

             if(x==1){
                 Toast.makeText(MainActivity.this,"Suppression réalisé !",Toast.LENGTH_SHORT).show();
             }
             else {
                 Toast.makeText(MainActivity.this,"Erreur de suppression !",Toast.LENGTH_SHORT).show();
             }
         }


    }

