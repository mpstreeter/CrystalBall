package com.example.crystalball;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.*;

public class MainActivity extends Activity 
{
	//Make one crystal ball for the whole time the app is running
	//If it's created in the click listener, then you will make lots of them
	//That would slow down the runtime of the app
	private CrystalBall crystalBall = new CrystalBall();
	
	private TextView answerLabel;
	private Button getAnswerButton;
	private ImageView crystalBallImage;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Declare our view variables
        answerLabel = (TextView) findViewById( R.id.textView1 );
        getAnswerButton = (Button) findViewById( R.id.button1 );
        crystalBallImage = (ImageView) findViewById( R.id.imageView1 );
        
        //Add click listener to button
        getAnswerButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String answer = crystalBall.getAnswer();
				
				//Update our label with our dynamic answer
				answerLabel.setText( answer );
				
				animateCrystalBall();
				animateAnswer();
				playSound();
			}
		} );
    }

    private void animateCrystalBall()
    {
    	crystalBallImage.setImageResource( R.drawable.ball_animation );
    	AnimationDrawable ballAnimation = (AnimationDrawable) crystalBallImage.getDrawable();
    	
    	if( ballAnimation.isRunning() )
    	{
    		ballAnimation.stop();
    	}
    	ballAnimation.start();
    	
    }
    
    private void animateAnswer()
    {
    	AlphaAnimation fadeInAnimation = new AlphaAnimation(0,1);
    	fadeInAnimation.setDuration(1500);
    	fadeInAnimation.setFillAfter(true);
    	answerLabel.setAnimation( fadeInAnimation );
    }

    private void playSound()
    {
    	MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
    	player.start();
    	
    	player.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) 
			{
				mp.release();
			}
		} );
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
