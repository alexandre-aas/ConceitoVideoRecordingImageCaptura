package com.s.d.a.a.conceitovideorecordingimagecaptura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.widget.Button;

public class VideoRecording_ImageCapture_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_recording__image_capture_);

        Button btnGravarVideo = findViewById(R.id.btnGravarVideo);

        if (!temCamera())
            btnGravarVideo.setEnabled(false);
    }

    private boolean temCamera() {
        return (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY));
    }
}
