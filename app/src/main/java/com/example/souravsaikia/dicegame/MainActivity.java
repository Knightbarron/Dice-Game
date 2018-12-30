package com.example.souravsaikia.dicegame;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String TAG="EEE";
    Button rollBtn;
    Button restartBtn;
    ImageView imageViewTop;
    ImageView imageViewBottom;
    TextView tvYOU;
    TextView score;
    TextView tvTotal;
    TextView total;
    TextView tvCPU;
    TextView CPUscore;
    TextView CPUtotal;
    TextView tvTotalCPU;
    Random r;
    int mark=20;


    int cpuPoints=0,turnPoints=0,cpuTotal=0,turnTotal=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollBtn = findViewById(R.id.rollButton);
        restartBtn = findViewById(R.id.restartButton);
        imageViewTop = findViewById(R.id.imageView);
        imageViewBottom = findViewById(R.id.imageView2);
        tvYOU = findViewById(R.id.tvYourScore);
        score = findViewById(R.id.yourScore);
        tvTotal = findViewById(R.id.tvTotalScore);
        total = findViewById(R.id.totalScore);
        tvCPU=findViewById(R.id.tvCPUScore);
        CPUscore = findViewById(R.id.CPUScore);
        tvTotalCPU = findViewById(R.id.tvTotalScore);
        CPUtotal = findViewById(R.id.totalScore2);

        r=new Random();
        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpuPoints = r.nextInt(6)+1;
                turnPoints = r.nextInt(6)+1;
                turnTotal = turnTotal+turnPoints;
                cpuTotal=cpuTotal+cpuPoints;

                Log.d(TAG,"CPUPoints : " + cpuPoints);
                Log.d(TAG,"TurnPoints : " + turnPoints);
                setTexts();

                setImageCPU(cpuPoints);
                setImagePlayer(turnPoints);

                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imageViewTop.startAnimation(rotate);
                imageViewBottom.startAnimation(rotate);

                if(turnTotal>=mark || cpuTotal>=mark)
                    winner(turnTotal,cpuTotal);

            }
        });

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void winner(int turnTotal,int cpuTotal) {

        if(turnTotal>cpuTotal){
            Toast.makeText(MainActivity.this,"You won!!!",Toast.LENGTH_LONG).show();
        }
        else if(cpuTotal>turnTotal){
            Toast.makeText(MainActivity.this,"CPU won!!!",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Drawn!!!",Toast.LENGTH_SHORT).show();
        }

        FragmentDialog dialog = new FragmentDialog();
        Bundle data = new Bundle();
        data.putString("Turn Score", String.valueOf(turnTotal));
        data.putString("CPU Score", String.valueOf(cpuTotal));
        dialog.setArguments(data);
        dialog.show(getSupportFragmentManager(),TAG);
        reset();
    }

    private void setImageCPU(int num){
        switch (num){

            case 1:imageViewBottom.setImageResource(R.drawable.dice1original);
            break;
            case 2:imageViewBottom.setImageResource(R.drawable.dice2or);
                break;
            case 3:imageViewBottom.setImageResource(R.drawable.dice3original);
                break;
            case 4:imageViewBottom.setImageResource(R.drawable.dice4riginal);
                break;
            case 5:imageViewBottom.setImageResource(R.drawable.dicefive);
                break;
            case 6:imageViewBottom.setImageResource(R.drawable.dice6original);
                break;

        }
    }
    private void setImagePlayer(int num){
        switch (num){

            case 1:imageViewTop.setImageResource(R.drawable.dice1original);
                break;
            case 2:imageViewTop.setImageResource(R.drawable.dice2or);
                break;
            case 3:imageViewTop.setImageResource(R.drawable.dice3original);
                break;
            case 4:imageViewTop.setImageResource(R.drawable.dice4riginal);
                break;
            case 5:imageViewTop.setImageResource(R.drawable.dicefive);
                break;
            case 6:imageViewTop.setImageResource(R.drawable.dice6original);
                break;

        }
    }
    private void setTexts(){
        score.setText(String.valueOf(turnPoints));
        CPUscore.setText(String.valueOf(cpuPoints));
        total.setText(String.valueOf(turnTotal));
        CPUtotal.setText(String.valueOf(cpuTotal));
    }
    public void reset(){
        cpuPoints=0;
        turnPoints=0;
        cpuTotal=0;
        turnTotal=0;
        imageViewTop.setImageResource(R.drawable.twodices);
        imageViewBottom.setImageResource(R.drawable.twodices);
        setTexts();

    }
}
