package com.example.shandro.microlearning;

        import java.io.IOException;
        import java.io.UnsupportedEncodingException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Vector;

        import org.apache.http.HttpResponse;
        import org.apache.http.NameValuePair;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;

        import android.app.Activity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;


public class MainActivity extends Activity {

    private SQLiteDatabase db;
    private EditText id;
    private EditText pass;
    public static int pi = -1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

                //set the new Content of your activity
        setContentView(R.layout.activity_main );


        SQLiteOpenHelper database = new DatabaseLogin(this);
        db = database.getReadableDatabase();




    }

    public void onLoginClick(View v)
    {
        Log.v("mylog", new String("hello"));
        id = (EditText)findViewById(R.id.mypin);
        pass = (EditText)findViewById(R.id.mylogin);

        String myid = id.getText().toString();

        String mypassword = pass.getText().toString();
        Log.v("check3", myid);
        Log.v("check4", mypassword);
        Cursor cursor = db.query("login", new String[] {"pin", "password"}, "pin = ? AND password = ?", new String[]{myid, mypassword}, null, null, null);

        if(myid != null && mypassword != null) {
            if (cursor.getCount() != 0) {
                Log.v("check1", new String("found it"));
                pi = Integer.valueOf(myid);
                Intent intent = new Intent(this, MyActivity.class);

                startActivity(intent);
            } else {
                Toast toast = new Toast(this).makeText(this, "Wrong password", Toast.LENGTH_LONG);
                toast.show();
            }
        }
        else
        {
            Toast toast = new Toast(this).makeText(this, "Wrong password", Toast.LENGTH_LONG);
            toast.show();

        }
    }


//    private void makePostRequest() {
//
//
//        HttpClient httpClient = new DefaultHttpClient();
//        // replace with your url
//        HttpPost httpPost = new HttpPost("www.example.com");
//
//
//        //Post Data
//        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
//        nameValuePair.add(new BasicNameValuePair("username", "test_user"));
//        nameValuePair.add(new BasicNameValuePair("password", "123456789"));
//
//
//        //Encoding POST data
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
//        } catch (UnsupportedEncodingException e) {
//            // log exception
//            e.printStackTrace();
//        }
//
//        //making POST request.
//        try {
//            HttpResponse response = httpClient.execute(httpPost);
//            // write response to log
//            Log.d("Http Post Response:", response.toString());
//        } catch (ClientProtocolException e) {
//            // Log exception
//            e.printStackTrace();
//        } catch (IOException e) {
//            // Log exception
//            e.printStackTrace();
//        }
//
//    }

}