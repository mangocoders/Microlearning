package com.example.shandro.microlearning;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
public class Result extends Activity {

    int score = 0;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        score = Integer.valueOf(getIntent().getExtras().getString("VALUE"));
        SQLiteOpenHelper database = new DatabaseLogin(this);
        db = database.getReadableDatabase();

        Cursor cursor = db.query("score", new String[] {"pin", "high"}, "pin = ?", new String[]{Integer.toString(MainActivity.pi)}, null, null, null);
        if(cursor == null)
        {
            ContentValues content1 = new ContentValues();
            content1.put("pin", Integer.toString(MainActivity.pi));
            content1.put("high", Integer.toString(score));
            db.insert("score", null, content1);
            changeText(score, score);
            ContentValues c = new ContentValues();
            c.put("high", score);

        }
        else
        {

            Log.v("here", "here");
            if(cursor.moveToFirst())
            {
                int sc = Integer.parseInt(cursor.getString(1));
                Log.v("hereval", sc + "");
                if(sc < score)
                {
                    changeText(score, sc);
                }
                else
                {
                    changeText(sc, sc);
                    ContentValues c = new ContentValues();
                    c.put("high", score);

                    db.update("score", c, "pin = ?", new String[]{String.valueOf(MainActivity.pi)});
                }
            }
            else
            {
                ContentValues content1 = new ContentValues();
                content1.put("pin", Integer.toString(MainActivity.pi));
                content1.put("high", Integer.toString(score));
                db.insert("score", null, content1);
                changeText(score, score);
                ContentValues c = new ContentValues();
                c.put("high", score);

            }
        }
    }

    public void changeText(final int n1,final int n2)
    {
        final TextView t1 = (TextView)findViewById(R.id.sc);

        final TextView t2 = (TextView)findViewById(R.id.best);
        final Handler handler = new Handler();
        handler.post(new Runnable()
        {

            @Override
            public void run() {
                t1.setText(n1 + "  ");
                t2.setText(n2 + "  ");
            }
        });
    }

    public void goHome(View v)
    {
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
