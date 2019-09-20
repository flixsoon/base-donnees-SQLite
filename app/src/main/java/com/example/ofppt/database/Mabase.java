package com.example.ofppt.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ofppt on 30/05/2019.
 */

public class Mabase extends SQLiteOpenHelper {

    public Mabase(Context context) {
        super(context, "gestionstagiaire.com.example.ofppt.database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase base) {
        base.execSQL("create table stagiaire (num Integer primary key,nom text,prenom text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase base, int i, int i1) {
        base.execSQL("DROP table if exists stagiaire");

        onCreate(base);
    }


    public boolean insertion(Integer n,String nom,String pre){
        SQLiteDatabase base=getWritableDatabase();
        ContentValues myvalues=new ContentValues();

        myvalues.put("num",n);
        myvalues.put("nom",nom);
        myvalues.put("prenom",pre);

        long result=base.insert("stagiaire",null,myvalues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }


    public Cursor lister(){
        SQLiteDatabase base=getReadableDatabase();
        Cursor c=base.rawQuery("select * from stagiaire",null);

        return c;
    }

    public Integer supprimer(String id){
        SQLiteDatabase base=getWritableDatabase();

        return   base.delete("stagiaire","num=?",new String[]{id});
    }
}
