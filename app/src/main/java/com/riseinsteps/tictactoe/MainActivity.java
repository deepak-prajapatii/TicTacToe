package com.riseinsteps.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean activeGame = true;
    int activePlayer = 0;
    int gameState[] = {2,2,2,2,2,2,2,2,2};
    int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{6,4,2}
    };

    public void clickPlayer(View view){
        ImageView img = (ImageView) view;
        int cell = Integer.parseInt(img.getTag().toString());

        if(!activeGame){
            gameReset(view);
        }

        if(gameState[cell] == 2 && activeGame){
            gameState[cell] = activePlayer;
            img.setTranslationY(-1000f);

            if(activePlayer == 0){
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView result = findViewById(R.id.result);
                result.setText("O's Turn");
            } else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView result = findViewById(R.id.result);
                result.setText("X's Turn");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }


        for(int[] winpos: winPositions){
            String winner = "";
            if(gameState[winpos[0]] == gameState[winpos[1]] && gameState[winpos[1]] == gameState[winpos[2]]
            && gameState[winpos[0]]!=2){
                if(gameState[winpos[0]] == 0){
                    winner = "X won";
                } else{
                    winner ="O won";
                }
                TextView result = findViewById(R.id.result);
                result.setText(winner);
                activeGame = false;
            }
        }
    }

    public void gameReset(View view){
        activeGame = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }
        TextView result = findViewById(R.id.result);
        result.setText("Tap to Play");

        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}