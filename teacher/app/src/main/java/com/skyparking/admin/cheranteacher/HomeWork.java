package com.skyparking.admin.cheranteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class  HomeWork extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home_work );
        bt1=(Button) findViewById(R.id.button2);

        bt3=(Button) findViewById(R.id.button4);
        bt1.setOnClickListener(this);

        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id== R.id.button2){


            Intent vv=new Intent(this,Home_work.class);

            startActivity(vv);


        }
        else if(id== R.id.button4){
            Intent vv=new Intent(this,DeleteHomeWork.class);

            startActivity(vv);



        }


    }
}

