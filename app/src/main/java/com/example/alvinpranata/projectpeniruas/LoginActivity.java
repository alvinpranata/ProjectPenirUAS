package com.example.alvinpranata.projectpeniruas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public void halamanSignUp(View view) {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);

    }
    public void halamanActivity(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Setup ReadData
      /*  ReadData readData = new ReadData(this);
        readData.execute("http://penir.jitusolution.com");
        LoginActivity=this;
        this.setTitle(null);*/

        Button b = (Button) findViewById(R.id.btnSignUp);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halamanSignUp(v);
            }
        });

        Button c = (Button) findViewById(R.id.btnLogin);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halamanActivity(v);
            }
        });


    }

    public static ArrayList<Login> logins;
    public static  LoginActivity loginActivity=null;
   /* public static void readDataFinish(Context context, String result){
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            logins = new ArrayList<>();
            *//*ProductHelper helper = new ProductHelper(context);
            helper.getWritableDatabase();*//*
            //iterasi sebanytak jumlah JSONObject pada JSonArray
            for(int i=0; i<jsonArray.length();i++){
                JSONObject user = jsonArray.getJSONObject(i);
                String nama = user.getString("nama");
                int id = user.getInt("id");
                String password = user.getString("pass");
                String username = user.getString("user");
                logins.add(new Login(username,nama,password,id));
                //coba database


                //helper.addNewProduct(nama,desc,harga);
            }
            // ------------------- //
            *//*ArrayList<Login> arrayListUser = helper.selectAllProducts();
            for(Login l:arrayListUser){

                Log.d("cobaTampilSemua", l.toString());
            }
            loginActivity.setupViewPager();
            System.out.println(products);*//*
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/
}
