package com.example.shandro.microlearning;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Question2 extends ActionBarActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

            Intent i = getIntent();
            if (i.getExtras().containsKey("YES")) {
                score = Integer.parseInt(i.getExtras().getString("YES")) + 1;
            } else {
                try {
                    score = Integer.parseInt(i.getExtras().getString("NO"));
                } catch (Exception e) {

                }
            }
        }



    public void yes(View v) {

        if (v.getId() == R.id.yes2) {
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("VALUE", (score + 1) + "");
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        } else {
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("VALUE", score + "");
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question2, menu);
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
