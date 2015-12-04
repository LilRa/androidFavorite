package favorite.com.galleryupload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.File;
import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {
    String TAG = this.getClass().getName();
    Bitmap[] bitmap;
    ImageView imageView;
    int count;
    Animation animation;
    UploadAsync uploadAsync;
    File[] list;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView);
        /*앱이 구동되자마자, SD 카드/ MyGallery 하위의 사진들의 정보를 담은 후 구중하나를 보여주자!!*/
        animation= AnimationUtils.loadAnimation(this,R.anim.trans);
        imageView.setAnimation(animation);

        init();
    }

    public void init() {
        File dir = Environment.getExternalStorageDirectory();
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            Log.d(TAG, files[i].getAbsolutePath());
            /*MyGallery가 발견되면.*/
            if (files[i].getName().equals("MyGallery")) {
                list = files[i].listFiles();
                bitmap=new Bitmap[list.length];

                /*디렉토리가 아니라면...즉 파일인 경우만.. */
                for (int a = 0; a < list.length; a++) {

                    if (list[a].isFile()) {
                        Log.d(TAG, list[a].getAbsolutePath());
                        bitmap[a]= BitmapFactory.decodeFile(list[a].getAbsolutePath());
                    }
                }
            }
        }
        showImage();
    }
    /*비트맵을 이용한 이미지 처리*/
    public void showImage(){
        count++;
        if(count >= bitmap.length){
            count=0;
        }
        imageView.setImageBitmap(bitmap[0]);
        imageView.invalidate();
        imageView.startAnimation(animation);
    }
    /*서버에 사진 업로드*/
    public void upload(){
        uploadAsync = new UploadAsync(progressBar);
        uploadAsync.execute(list[count].getAbsolutePath());
    }
    public void btnClick(View view){
        if(view.getId()==R.id.bt_next){
            showImage();
        }else if(view.getId()==R.id.bt_upload){
            upload();
        }
    }
}
