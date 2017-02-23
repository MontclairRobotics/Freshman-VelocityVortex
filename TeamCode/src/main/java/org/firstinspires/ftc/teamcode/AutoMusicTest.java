package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.content.Intent;
import android.widget.Button;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 01/19/17.
 */


//Fixed
@Autonomous(name="Music", group="147")
public class AutoMusicTest extends Activity{

    
    public void init() {

    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftc_controller);

        final MediaPlayer music =  MediaPlayer.create(this, R.raw.cookingbtb);

        music.start();
    }

}
