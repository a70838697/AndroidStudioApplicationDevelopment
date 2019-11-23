package com.exmaple.casper.androidappdevelopment.ch4;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex411MainActivity extends Activity
        implements SurfaceHolder.Callback {
    Camera mCamera = null;
    SurfaceView surfaceView;
    SurfaceHolder holder;
    ImageView mImageView;
    Button cameraBtn, exitBtn;
    String path = "/sdcard/camera.jpg";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex411_main);
        mImageView = (ImageView) findViewById(R.id.imageView1);
        cameraBtn = (Button) findViewById(R.id.button1);
        exitBtn = (Button) findViewById(R.id.button2);
        cameraBtn.setOnClickListener(new mClick());
        exitBtn.setOnClickListener(new mClick());
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
        //创建SurfaceHolder对象
        holder = surfaceView.getHolder();
        //注册回调监听器
        holder.addCallback(this);
        //设置SurfaceHolder的类型
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    class mClick implements OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == cameraBtn)
                /* 拍照并显示相片 */
                mCamera.takePicture(null, null, new jpegCallback());
            else if (v == exitBtn)
                exit();
        }
    }

    void exit() {
        mCamera.release();
        mCamera = null;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width, int height) {
        /* 调用设置照相机取景参数的方法 */
        initCamera();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        /* 打开相机 */
        mCamera = Camera.open();
        try {
            /* 设置预览 */
            mCamera.setPreviewDisplay(holder);
        } catch (IOException e) {
            System.out.println("预览错误");
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    /* 设置照相机取景参数 */
    private void initCamera() {
        /* 创建Camera.Parameters对象 */
        Camera.Parameters parameters = mCamera.getParameters();
        /* 设置相片为JPEG格式 */
        parameters.setPictureFormat(PixelFormat.JPEG);
        /* 指定preview的屏幕大小 */
        parameters.setPreviewSize(320, 240);
        /* 设置图片分辨率大小 */
        parameters.setPictureSize(320, 240);
        /* 将Camera.Parameters的设置作用于Camera对象 */
        mCamera.setParameters(parameters);
        /* 打开预览 */
        mCamera.startPreview();
    }

    /* 通过PictureCallback接口进一步处理照相机所得到的图像数据 */
    class jpegCallback implements PictureCallback {
        /**
         * 下面onPictureTaken()方法将图像转换成jpg格式后保存并预览，
         * 其中第一个参数data为存放相片数据的字节数组，
         * 第二个参数camera为相片对象
         */
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Bitmap bitmap =
                    BitmapFactory.decodeByteArray(data, 0, data.length);
            try {
                BufferedOutputStream outStream = new
                        BufferedOutputStream(new FileOutputStream(path));
                /* 采用压缩转档方法 */
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outStream);
                outStream.flush();
                outStream.close();
                /* 显示拍照的图像 */
                mImageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                Log.e("err", e.getMessage());
            }
        }
    }
}
