package com.skyparking.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et1, et2;
    CheckBox ch1, ch2;
    String n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        et1 = findViewById ( R.id.editText );
        et1.getText ( ).toString ( );
        et2 = findViewById ( R.id.editText2 );
        et2.getText ( ).toString ( );
        ch1.findViewById ( R.id.checkBox );
        ch1.setOnClickListener ( this );
        ch2 = findViewById ( R.id.checkBox2 );
        ch2.setOnClickListener ( this );
    }



    @Override
    public void onClick(View view) {
        n1=et1.getText ().toString ();
        n2=et2.getText ().toString ();
        if (ch1.isChecked ()==true)
        {

            Toast.makeText ( this, "Greater than "+n1, Toast.LENGTH_SHORT ).show ( );
        }
        else
        {
            if (ch2.isChecked ()==true)
            {
                Toast.makeText ( this, "Lesser than  "+n2, Toast.LENGTH_SHORT ).show ( );
            }
        }
    }
}

