package com.example.shandro.microlearning;

/**
 * Created by shandro on 12/4/2015.
 */
public class BValues {
    private int imageRes;
    public static final BValues[] bVals = {new BValues(R.drawable.brac03), new BValues(R.drawable.brac04), new BValues(R.drawable.brac05),
    new BValues(R.drawable.brac06), new BValues(R.drawable.q), new BValues(R.drawable.score)};

    public BValues(int imageRes)
    {
        this.imageRes = imageRes;
    }


    public int getImageRes()
    {
        return imageRes;
    }


}
