package com.exmaple.casper.androidappdevelopment.ch4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex410MainActivity extends Activity {
    MediaRecorder mRecorder;
    Button startBtn, stopBtn;
    String path;


    //申请录音权限
    private static final int GET_RECODE_AUDIO = 1;
    private static String[] PERMISSION_AUDIO = {
            Manifest.permission.RECORD_AUDIO
    };

    /*
     * 申请录音权限*/
    public static void verifyAudioPermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.RECORD_AUDIO);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSION_AUDIO,
                    GET_RECODE_AUDIO);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex410_main);
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        path += "/audio.amr";

        startBtn = (Button) findViewById(R.id.button1);
        stopBtn = (Button) findViewById(R.id.button2);
        startBtn.setOnClickListener(new mClick());
        stopBtn.setOnClickListener(new mClick());
        verifyAudioPermissions(this);
    }

    class mClick implements OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == startBtn) {
                startRecordAudio(path);
            } else if (v == stopBtn) {
                stopRecord();
            }
        }
    }

    void startRecordAudio(String path) {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        mRecorder.setOutputFormat(
                MediaRecorder.OutputFormat.THREE_GPP);

        mRecorder.setAudioEncoder(
                MediaRecorder.AudioEncoder.AMR_NB);

        mRecorder.setOutputFile(path);
        try {
            mRecorder.prepare();
        } catch (Exception e) {
            System.out.println("Recorder err ... ");
        }
        mRecorder.start();
    }

    void stopRecord() {
        mRecorder.stop();   //停止录制
        mRecorder.reset();  //重置
        mRecorder.release();//释放播放器有关资源
    }
}
