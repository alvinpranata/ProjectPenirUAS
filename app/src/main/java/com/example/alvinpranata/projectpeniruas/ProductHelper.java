package com.example.alvinpranata.projectpeniruas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by tc4b03 on 5/16/2017.
 */

/*public class ProductHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME="TokoOnline.db";

    private static final String SQL_CREATE =
            "CREATE TABLE `Product` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `Ddscription` Text, `price` INTEGER)";
    private static final String SQL_DELETE =
            "DROP TABLE ID EXISTS `Product`";

    public ProductHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }

    public void addNewProduct(String name, String desc, int price){
        String query = "Insert into `Product`(`name`,`description`,`price`)" +
                " values(\""+name+"\",\""+desc+"\","+price+")";

        //atau dengan menggunakan string format
        //%s= string, %d = integer
        query = String.format("Insert into `Product`(`name`,`Ddscription`,`price`)" +
                " values(\"%s\",\"%s\",%d)",name,desc,price);

        //Buat objek SQLiteDatabase
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(query);
        }catch (Exception ex){
            Log.d("addNewProductException", ex.getMessage());
        }
    }

    public ArrayList<Product> selectAllProducts(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            //Buat SQLiteDatabase
            SQLiteDatabase db = this.getReadableDatabase();
            //Query select
            String query = "Select * from `Product` order by `id` ASC";

            //Jalankan dan simpan ke sebuah cursor
            Cursor cursor = db.rawQuery(query,  null);
            //Pindahkan cursor ke awal row
            cursor.moveToFirst();
            //Lakukan loop selama cursor masih mengembalikan row
            do{
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String deskripsi = cursor.getString(2);
                int harga = cursor.getInt(3);
                products.add(new Product(nama,id,harga,deskripsi));
            }while (cursor.moveToNext());

            //tutup cursor setelah selesai digunakan
            cursor.close();

        }catch (Exception ex){
            Log.d("selectAllProductsEx",ex.getMessage());
        }
        return  products;
    }
    public ArrayList<Product> selectProduct(String where){
        ArrayList<Product> products = new ArrayList<>();

        try {
            //Buat SQLiteDatabase
            SQLiteDatabase db = this.getReadableDatabase();
            //Query select
            String query = String.format("Select * from `Product` where ",where);

            //Jalankan dan simpan ke sebuah cursor
            Cursor cursor = db.rawQuery(query,  null);
            //Pindahkan cursor ke awal row
            cursor.moveToFirst();
            //Lakukan loop selama cursor masih mengembalikan row
            do{
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String deskripsi = cursor.getString(2);
                int harga = cursor.getInt(3);
                products.add(new Product(nama,id,harga,deskripsi));
            }while (cursor.moveToNext());

            //tutup cursor setelah selesai digunakan
            cursor.close();

        }catch (Exception ex){
            Log.d("selectProductsEx",ex.getMessage());
        }
        return  products;
    }
}*/
