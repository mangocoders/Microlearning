package com.example.shandro.microlearning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Question1 extends Activity {

    boolean flag = false;
    int val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

            Intent i = getIntent();
        try {
            if (i.getExtras().containsKey("YES")) {
                val = 1;
            } else {
                val = 0;
            }
        }
        catch (Exception e)
        {

        }
        }




    public void yes(View v) {
        Log.v("here", "on");
        if (v.getId() == R.id.yes1) {
            Intent intent = new Intent(this, Question2.class);
            intent.putExtra("YES", "1");
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        } else {

            Log.v("hereat", "noo!!");
            Intent intent = new Intent(this, Question2.class);
            intent.putExtra("NO", val);
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question1, menu);
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
