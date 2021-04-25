package com.skyparking.admin.rpcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    CheckBox ch1;
    String n1, n2;
    int a, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        et1 = findViewById ( R.id.editText );
        et1.getText ( ).toString ( );
        et2 = findViewById ( R.id.editText2 );
        et2.getText ( ).toString ( );
        ch1 = findViewById ( R.id.checkBox2 );

        ch1.setOnCheckedChangeListener ( new CompoundButton.OnCheckedChangeListener ( ) {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                n1 = et1.getText ( ).toString ( );
                n2 = et2.getText ( ).toString ( );
                a = Integer.parseInt ( n1 );
                c = Integer.parseInt ( n2 );
                if (a > c) {
                    Toast.makeText ( MainActivity.this, "greater than  " + a, Toast.LENGTH_SHORT ).show ( );
                }
                else
                {
                    if (a<c)
                    {
                        Toast.makeText ( MainActivity.this, "greater than "+c, Toast.LENGTH_SHORT ).show ( );
                    }
                }
            }
        } );
    }
}










