package com.example.alvinpranata.projectpeniruas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button b,c;
    EditText username,password;
    boolean login =false,adaUser=false;
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
        username = (EditText) findViewById(R.id.txtUsername);
        password = (EditText) findViewById(R.id.txtPassword);
        b = (Button) findViewById(R.id.btnSignUp);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                halamanSignUp(v);
            }
        });

        c = (Button) findViewById(R.id.btnLogin);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass = password.getText().toString();
                for(Login user :logins){
                    if(user.getUsername().equals(name)){
                        adaUser=true;
                    }
                }
                if (adaUser) {
                    for(Login user :logins){
                        if(user.getPassword().equals(pass)){
                            login=true;
                        }
                    }
                    if(login){
                        halamanActivity(v);
                        finish();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Password salah",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplicationContext(),"Username tidak ada",Toast.LENGTH_SHORT).show();

            }
        });

        //Setup ReadData
        ReadData readData = new ReadData(this);
        readData.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=login");
        loginActivity=this;
        this.setTitle(null);

    }

    public static ArrayList<Login> logins;
    public static  LoginActivity loginActivity=null;
    public static void readDataFinish(Context context, String result){
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            logins = new ArrayList<>();
            //iterasi sebanytak jumlah JSONObject pada JSonArray
            for(int i=0; i<jsonArray.length();i++){
                JSONObject user = jsonArray.getJSONObject(i);
                String nama = user.getString("nama");
                int id = user.getInt("id");
                String password = user.getString("pass");
                String username = user.getString("user");
                logins.add(new Login(id,username,nama,password,false));
            }
            for (Login user : logins) {
                Log.d("test", user.toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
