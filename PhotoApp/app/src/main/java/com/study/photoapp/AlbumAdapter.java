package com.study.photoapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by student on 2015-11-17.
 */
public class AlbumAdapter extends BaseAdapter {
    Context context;
    ArrayList<ImageView> list = new ArrayList<ImageView>();

    public AlbumAdapter(Context context) {
        this.context = context;
        init();
    }

    /* sd카드내의 사진이 있는 경로를 조사하여, ArrayList에 담아서 사진출력!!*/
    public void init(){
        File dir = Environment.getExternalStorageDirectory();
        String path = dir.getAbsolutePath() + "/MyMedia/photo/";
        File file = new File(path);

        File[] files = file.listFiles();

        for(int i=0; i<files.length; i++){
            if(files[i].isFile()){ // 디렉토리가 아닌 파일이라면...
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize=16;
                Bitmap bitmap = BitmapFactory.decodeFile(files[i].getAbsolutePath(),options);
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(bitmap);

                list.add(imageView);
            }
        }
    }
    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {

        return null;
    }

    public long getItemId(int position) {

        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        view = list.get(position);
        return view;
    }
}