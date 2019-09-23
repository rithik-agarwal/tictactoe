package com.example.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int i=0;
    int k;
    int[] arr={2,2,2,2,2,2,2,2,2};
    int[][] win={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};


    public void fill(View view)
    {
        ImageView im1=(ImageView) view;
        int tag = Integer.parseInt(im1.getTag().toString());
        if(arr[tag]==2) {
            if (i == 0) {
                im1.setImageResource(R.drawable.white);
                im1.animate().rotation(360).setDuration(1000);
                i = 1;
                arr[tag] = 0;
            } else {
                im1.setImageResource(R.drawable.black);
                im1.animate().rotation(360f).setDuration(1000);
                i = 0;
                arr[tag] = 1;
            }
        }
        else
        {
            Toast.makeText(this, "this part is already filled", Toast.LENGTH_SHORT).show();
        }
        LinearLayout l=(LinearLayout) findViewById(R.id.linear);
        TextView t=(TextView) findViewById(R.id.textView);
        Button btn=(Button) findViewById(R.id.button);
        for(int j=0;j<8;j++)
        {
            if(arr[win[j][0]-1]==arr[win[j][1]-1] && arr[win[j][1]-1]==arr[win[j][2]-1]) {
                if (arr[win[j][0] - 1] == 0) {
                    t.setText("congrats white wins!!!");
                    l.setVisibility(View.VISIBLE);
                    btn.setClickable(true);
                }
                if (arr[win[j][0] - 1] == 1) {
                    t.setText("congrats black wins!!!");
                    l.setVisibility(View.VISIBLE);
                    btn.setClickable(true);

                }
            }


        }
        for(k=0;k<9;k++)
            if(arr[k]==2)
                break;

            if(k==9)
            {
                t.setText("Its a draw");
                l.setVisibility(View.VISIBLE);
                btn.setClickable(true);


            }



    }
    public void play(View view)
    {
        i=0;
        for(int j=0;j<9;j++)
            arr[j]=2;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
