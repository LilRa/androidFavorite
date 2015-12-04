package com.board.mediaapp.video;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.VideoView;

import com.board.mediaapp.R;

/**
 * Created by jhmfrd on 2015-10-27.
 */
public class VideoMainActivity extends Activity{
    VideoView videoView;
    android.widget.MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);

        videoView=(VideoView)findViewById(R.id.videoView);
        mediaController = new android.widget.MediaController(this);

        String path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/20140828_163621.mp4";
        videoView.setVideoPath(path);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
