package com.exmaple.casper.androidappdevelopment.ch9;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

import java.util.List;

public class Ex92MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex92_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager =
                (SensorManager) this.getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList =
                sensorManager.getSensorList(Sensor.TYPE_ALL);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        TextView txt;
        for (Sensor s : sensorList) {
            txt = new TextView(this);
            txt.setText(s.getName());
            layout.addView(txt, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
        }
        setContentView(layout);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
    }

}
