package appsbyrishabh.speedbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SlidingDrawer;
import android.widget.TextView;



public class Game extends Activity implements View.OnClickListener {

    TextView question, answer1, answer2, answer3, answer4, answer5, answer6;
    TextView answers[] = new TextView[6];
    EditText answer;
    View go;int i;
    String a[] = new String[6];
    String ans;
    static int score = 0;
    int puzzleNo;
   static int set[][] = new int[4][6];

    int row=0;


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.game);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            puzzleNo = extras.getInt("puzzleNo");
        }
        question = (TextView) findViewById(R.id.question1);
        answer = (EditText) findViewById(R.id.response);
        answers[0] = (TextView) findViewById(R.id.answer1);
        answers[1] = (TextView) findViewById(R.id.answer2);
        answers[2] = (TextView) findViewById(R.id.answer3);
        answers[3] = (TextView) findViewById(R.id.answer4);
        answers[4] = (TextView) findViewById(R.id.answer5);
        answers[5] = (TextView) findViewById(R.id.answer6);
        go=findViewById(R.id.button1);
        go.setOnClickListener(this);
        answer.setOnClickListener( this);


        switch (puzzleNo) {

            case 1: {
                question.setText("Tell me an animal that starts with the letter \"T.\" ");
                a[0] = "TORTOISE";
                a[1] = "TIGER";
                a[2] = "TOAD";
                a[3] = "TOMCAT";
                a[4] = "TARANTULA";
                a[5] = "TURKEY";

                row=0;

            }
            break;

            case 2:
                question.setText("Name something people fall out of.");
                a[0]="BOAT";
                a[1]="LOVE";
                a[2]="BED";
                a[3]="CHAIR";
                a[4]="AIRPLANE";
                a[5]="CAR";

                row=1;
                break;

            case 3:
                question.setText("Tell me a profession that charges by the hour.");
                a[0]="PSYCHIATRIST";
                a[2]="LAWYER";
                a[2]="THERAPIST";
                a[3]="PLUMBER";
                a[4]="PROSTITUTE";
                a[5]="CARPENTER";
                row=2;
                break;

            case 4:
                question.setText( "Name something that's big and yellow.");
                a[0]="SCHOOL BUS";
                a[1]="BIG BIRD";
                a[2]="SUN";
                a[3]="BANANA";
                a[4]="SQUASH";
                a[5]="TAXI";
                row=3;
        }

        for(i=0;i<6;i++)
         if(set[row][i]==1)
                answers[i].setText(a[i]);

        }






    public void onClick(View v)
    {
        switch(v.getId())
        {

            case(R.id.button1) :
                ans = String.valueOf(answer.getText());
                for(i=0;i<6;i++)
                if(ans.equalsIgnoreCase(a[i]) )
                {

                    score += i+1;
                    set[row][i]=1;
                    Levelintro.increment=i+1;

                    answers[i].setText(a[i]+"  "+score+" "+Levelintro.increment+"  "+Levelintro.pos);

                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Game.this, Levelintro.class));
                break;
        }


    }

}

