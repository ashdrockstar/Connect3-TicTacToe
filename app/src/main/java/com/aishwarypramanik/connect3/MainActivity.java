package com.aishwarypramanik.connect3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static int player=1;

    List p1=new ArrayList();
    List p2=new ArrayList();

    static int dropCount=0;


    public void exit(View view)
    {
        System.exit(0);
    }

    public void reset(View view)
    {
//        ImageView im1= (ImageView)findViewById(R.id.imageView);
//        ImageView im2= (ImageView)findViewById(R.id.imageView11);
//        ImageView im3= (ImageView)findViewById(R.id.imageView3);
//        ImageView im4= (ImageView)findViewById(R.id.imageView4);
//        ImageView im5= (ImageView)findViewById(R.id.imageView5);
//        ImageView im6= (ImageView)findViewById(R.id.imageView6);
//        ImageView im7= (ImageView)findViewById(R.id.imageView10);
//        ImageView im8= (ImageView)findViewById(R.id.imageView8);
//        ImageView im9= (ImageView)findViewById(R.id.imageView9);
//
//        im1.animate().alpha(0);
//        im2.animate().alpha(0);
//        im3.animate().alpha(0);
//        im4.animate().alpha(0);
//        im5.animate().alpha(0);
//        im6.animate().alpha(0);
//        im7.animate().alpha(0);
//        im8.animate().alpha(0);
//        im9.animate().alpha(0);

        GridLayout grid=(GridLayout) findViewById(R.id.gridLayout);
        for(int     i=0;i<grid.getChildCount();i++)
        {
            ImageView im=(ImageView)grid.getChildAt(i);
            im.setImageResource(0);
            im.animate().alpha(0);
        }
        player=1;
        p1.clear();
        p2.clear();
        dropCount=0;
    }

    public boolean playerWins(List list)
    {

//        Toast.makeText(this,list+"",Toast.LENGTH_LONG).show();
        if(list.contains("1") && list.contains("5") && list.contains("9"))
            return true;

        if(list.contains("3") && list.contains("5") && list.contains("7"))
            return true;

        if(list.contains("1") && list.contains("2") && list.contains("3"))
            return true;

        if(list.contains("4") && list.contains("5") && list.contains("6"))
            return true;

        if(list.contains("7") && list.contains("8") && list.contains("9"))
            return true;

        if(list.contains("1") && list.contains("4") && list.contains("7"))
            return true;

        if(list.contains("2") && list.contains("5") && list.contains("8"))
            return true;

        if(list.contains("3") && list.contains("6") && list.contains("9"))
            return true;

        return false;
    }
    public void drop(View view)  {
        ImageView coin=(ImageView) view;

        if(coin.getAlpha()!=1) {
            dropCount++;
            if (player == 1) {
                coin.setImageResource(R.drawable.coin1);
                p1.add(coin.getTag());
//                Toast.makeText(this,p1+"",Toast.LENGTH_LONG).show();
                if(playerWins(p1)) {
                    Toast.makeText(this, "PLAYER1 Wins: Congrats!", Toast.LENGTH_LONG).show();
                }

                player = 2;
            } else {
                coin.setImageResource(R.drawable.coin2);
                p2.add(coin.getTag());
//                Toast.makeText(this,p2+"",Toast.LENGTH_LONG).show();
                if(playerWins(p2)) {
                    Toast.makeText(this, "PLAYER2 Wins: Congrats!", Toast.LENGTH_LONG).show();

                }
                player = 1;
            }
            if (dropCount==9)
            {
                Toast.makeText(this, "GAME OVER: DRAW!", Toast.LENGTH_LONG).show();
            }


            coin.animate().alpha(1f).setDuration(300);
        }
        else
            Toast.makeText(this,"Not Allowed!",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
