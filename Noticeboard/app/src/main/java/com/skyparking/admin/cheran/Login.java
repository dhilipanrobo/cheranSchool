package com.skyparking.admin.cheran;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button bt3;EditText et1,et2;
    String user,pass,id;
String URL_msg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        bt3 = (Button) findViewById(R.id.button14);
        et1 = (EditText) findViewById(R.id.editText4);
        et2 = (EditText) findViewById(R.id.editText5);
        bt3.setOnClickListener(this);

        ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if(nInfo!=null && nInfo.isConnected()) {
            // Toast.makeText(this, "Network is available", Toast.LENGTH_LONG).show();
        } else {
            // Toast.makeText(this, "Network is not available", Toast.LENGTH_LONG).show();
        }


        SharedPreferences sharedPreferences = getSharedPreferences("userlog", Context.MODE_PRIVATE);
        id=sharedPreferences.getString("username","");
        if(id.isEmpty ()){}
        else{
            Intent v=new Intent(this,Mainpage.class);


            startActivity(v);
            finish();}


    }

    @Override
    public void onClick(View view) {
        Toast.makeText ( this, "Please wait....", Toast.LENGTH_SHORT ).show ( );
        user= et1.getText().toString();
        pass=   et2.getText().toString();
URL_msg="https://www.welleservices.com/noticeboard/cslog.php?term=" + user;
//msgsyz ();
        getJSON1("https://www.welleservices.com/noticeboard/cslog.php?term=" + user);
        //  Toast.makeText(this, "user: "+user, Toast.LENGTH_LONG).show();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] tamil = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            tamil[i] = obj.getString("pass");
            //  Toast.makeText(this, "pass"+tamil[0], Toast.LENGTH_LONG).show();

        }



        int no=0;
        try {


            String pass1=tamil[0];

            if (pass.equals(pass1)) {
                SharedPreferences sharedPreferences = getSharedPreferences("userlog", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("username",user);

                editor.apply();
                editor.commit();


                Intent v=new Intent(this,Mainpage.class);


               startActivity(v);
                finish();
            } else {

            }

        }catch (Exception e) {

            Toast.makeText(this, "User Name Or Password Incorrect", Toast.LENGTH_LONG).show();

        }
    }






    private void getJSON1(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                String sno1=s;



                //   Toast.makeText(getApplicationContext(), sno3, Toast.LENGTH_SHORT).show();
                try {

                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            protected String doInBackground(Void... voids) {



                try {
                    //creating a URL
                    URL url = new URL(urlWebService);

                    //Opening the URL using HttpURLConnection
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    //StringBuilder object to read the string from the service
                    StringBuilder sb = new StringBuilder();

                    //We will use a buffered reader to read the string from service
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader (con.getInputStream()));

                    //A simple string to read values from each line
                    String json;

                    //reading until we don't find null
                    while ((json = bufferedReader.readLine()) != null) {

                        //appending it to string builder
                        sb.append(json + "\n");
                    }

                    //finally returning the read string
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }

            }
        }

        //creating asynctask object and executing it
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    void msgsyz(){

        //    Toast.makeText ( this, ""+mapk, Toast.LENGTH_SHORT ).show ( );
        StringRequest request =new StringRequest ( StringRequest.Method.POST, URL_msg, new Response.Listener<String> ( ) {
            @Override
            public void onResponse(String response) {
                Toast.makeText ( Login.this, "msg: "+response, Toast.LENGTH_SHORT ).show ( );

            }
        } , new Response.ErrorListener ( ) {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        } ){


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<> (  );


                return params;
            }
        };
        Volley.newRequestQueue ( this ).add ( request );

    }
}
