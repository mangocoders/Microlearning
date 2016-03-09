package com.example.shandro.microlearning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class DetailActivity extends Activity {

    int position;
    ImageView image1;
    ImageView image2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        position = Integer.valueOf(intent.getStringExtra("POSITION"));
        image1 = (ImageView)findViewById(R.id.dos);
        image2 = (ImageView)findViewById(R.id.donts);
        generateImages(position);
    }


    protected void onStart(View view)
    {
        super.onStart();
        generateImages(position);
    }

    public void generateImages(int pos)
    {
        if(pos == 0)
        {
            image1.setImageResource(R.drawable.integ1);
            image2.setImageResource(R.drawable.integ2);

        }
        else if(pos == 1)
        {
            image1.setImageResource(R.drawable.inclu1);
            image2.setImageResource(R.drawable.inclu2);

        }
        else if(pos == 2)
        {
            image1.setImageResource(R.drawable.inno1);
            image2.setImageResource(R.drawable.inno2);

        }
        else if(pos == 3)
        {
            image1.setImageResource(R.drawable.effe2);
            image2.setImageResource(R.drawable.effe1);

        }
        else
        {
            Intent intent = new Intent(this, LeaderBoard.class);
            startActivity(intent);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
