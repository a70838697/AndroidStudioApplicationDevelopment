package com.exmaple.casper.androidappdevelopment.ch4;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex42MainActivity extends Activity
{
    int x1=150,y1=50;
    Ex42TestView testView;
    Button btn;
    EditText  edit_y;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex42_main);
        testView=(Ex42TestView)findViewById(R.id.testView1);
        testView.setXY(x1, y1);
        btn=(Button)findViewById(R.id.button1);
        edit_y=(EditText)findViewById(R.id.editText1);
        btn.setOnClickListener(new mClick());
    }
    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View arg0)
        {
            y1 = Integer.parseInt(edit_y.getText().toString());
            testView.setXY(x1, y1);
            testView.invalidate();
        }
    }
}
