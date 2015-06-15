package appewtc.masterung.testflashled;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.android.IOIOActivity;

public class MainActivity extends IOIOActivity{

    private ImageView greenImageView, orangeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();

        greenController();

    }   // onCreate

    class Looper extends BaseIOIOLooper {

        

    }   //Looper class

    private void greenController() {

        greenImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    greenImageView.setImageAlpha(50);
                    soundEffect1();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    greenImageView.setImageAlpha(255);
                    soundEffect2();
                }

                return true;
            }
        });

    }   //greenController

    private void soundEffect2() {
        MediaPlayer sound2Player = MediaPlayer.create(getBaseContext(), R.raw.phonton2);
        sound2Player.start();
    }

    private void soundEffect1() {
        MediaPlayer sound1Player = MediaPlayer.create(getBaseContext(), R.raw.phonton1);
        sound1Player.start();
    }

    private void bindWidget() {
        greenImageView = (ImageView) findViewById(R.id.imageView);
        orangeImageView = (ImageView) findViewById(R.id.imageView2);
    }


}   // Main Class
