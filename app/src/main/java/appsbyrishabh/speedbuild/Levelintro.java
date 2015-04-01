package appsbyrishabh.speedbuild;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;



public class Levelintro extends Activity  {

	Overview v;
    static int pos = 1;
    static int increment = 0;
	Bitmap pic[] = new Bitmap[16];
    Bitmap p;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new Overview(this);
		p = BitmapFactory.decodeResource(getResources(), R.drawable.p);
		pic[0] = BitmapFactory.decodeResource(getResources(), R.drawable.p1);
        pic[1] = BitmapFactory.decodeResource(getResources(), R.drawable.p2);
        pic[2] = BitmapFactory.decodeResource(getResources(), R.drawable.p3);
        pic[3] = BitmapFactory.decodeResource(getResources(), R.drawable.p4);
        pic[4]= BitmapFactory.decodeResource(getResources(), R.drawable.p5);
        pic[5] = BitmapFactory.decodeResource(getResources(), R.drawable.p6);
        pic[6] = BitmapFactory.decodeResource(getResources(), R.drawable.p7);
        pic[7] = BitmapFactory.decodeResource(getResources(), R.drawable.p8);
        pic[8] = BitmapFactory.decodeResource(getResources(), R.drawable.p9);
        pic[9] = BitmapFactory.decodeResource(getResources(), R.drawable.p10);
        pic[10] = BitmapFactory.decodeResource(getResources(), R.drawable.p11);
        pic[11] = BitmapFactory.decodeResource(getResources(), R.drawable.p12);
        pic[12] = BitmapFactory.decodeResource(getResources(), R.drawable.p13);
        pic[13] = BitmapFactory.decodeResource(getResources(), R.drawable.p14);
        pic[14] = BitmapFactory.decodeResource(getResources(), R.drawable.p15);
        pic[15]= BitmapFactory.decodeResource(getResources(), R.drawable.p16);
		setContentView(v);

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}
	

 class Overview extends SurfaceView implements Runnable {

	Thread t = null;
	SurfaceHolder holder;
	boolean isItOk = false;
	int i;
   int puzzleNo;

	
	public Overview(Context context) {
		super(context);
		holder = getHolder();
		// TODO Auto-generated constructor stub
		
		
	}
	
	public void draw (int pos)
	{ Bitmap img=p;
        if(pos==0)
            img=p;
        else
            img=pic[pos-1];

		

		Canvas c = holder.lockCanvas();
		Bitmap imgS = Bitmap.createScaledBitmap(img,c.getWidth(), c.getHeight()/2, true);
		
		c.drawARGB(0, 0, 0, 0);
		
		c.drawBitmap(imgS, (c.getWidth()-imgS.getWidth())/2, (c.getHeight()-imgS.getHeight())/2, null);
		
		holder.unlockCanvasAndPost(c);	
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(isItOk==true){
			
			if(!holder.getSurface().isValid())
				continue;
			for(i=0;i<increment;i++)
				{draw(pos);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pos++;
                if(pos==17)
                    pos=1;}
				
			for( i=0;i<15;i++)
				{
				draw(pos);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				draw(0);
				}
			
		
		if(pos%4==1)
			puzzleNo=1;
		else if(pos%4==2)
			puzzleNo=2;
		else if(pos%4==3)
			puzzleNo=3;
		else if(pos%4==0)
			puzzleNo=4;
		
			
			Intent myIntent = new Intent(Levelintro.this,Game.class);
			myIntent.putExtra("puzzleNo", puzzleNo);
			startActivity(myIntent);
		    
		}
			/*try  {
				Thread.sleep(time);
				
			cnt++;
				
				if(time==50)
					time=1400;
				if(cnt==1)
					{time=time-20;
					cnt=0;}
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Math.abs(x1-x)<80  && Math.abs(y- y1)<80)
				score++;
			else
				{ 
					MAX=score;
					score=0;
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Bundle b = new Bundle();
				b.putString("score", MAX+"");
				Intent i = new Intent(Surfaces.this,GameOver.class);
				i.putExtras(b);
				startActivity(i);
				}
			
		}
			*/
		
	}
	
				
			
			public void pause() {
				isItOk = false;
			
				try{t.join();
				}
				catch(InterruptedException e)
				{e.printStackTrace();}
				
				t= null;
			}
			
			public void resume() {
				
				isItOk = true;
				t = new Thread(this);
				t.start();

			}
				
			}
}