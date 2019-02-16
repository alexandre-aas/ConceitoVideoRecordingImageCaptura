package com.s.d.a.a.conceitovideorecordingimagecaptura;

import java.io.File;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.widget.Button;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class VideoRecording_ImageCapture_Activity extends AppCompatActivity {

    private static final int VIDEO_CAPTURE = 87;
    //private Uri fileUri;
    //private static final String AUTORIDADE="com.s.d.a.a.conceitovideorecordingimagecaptura";

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

    public void iniciarGravacao(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, VIDEO_CAPTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Uri videoUri = data.getData();

        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Local do arquivo de vídeo:\n" +
                        videoUri, Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Video recording cancelled.",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Falha na gravação do vídeo",
                        Toast.LENGTH_LONG).show();
            }
        }

    }
}
