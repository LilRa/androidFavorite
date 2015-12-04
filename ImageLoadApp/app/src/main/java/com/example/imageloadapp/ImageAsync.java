package com.example.imageloadapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jhmfrd on 2015-10-28.
 */
public class ImageAsync extends AsyncTask<String,Void,Bitmap>{
    ImageLoadActivity imageLoadActivity;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public ImageAsync(ImageLoadActivity imageLoadActivity) {
        this.imageLoadActivity = imageLoadActivity;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap=null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            bitmap = BitmapFactory.decodeStream(con.getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        ImageView imageView=new ImageView(imageLoadActivity);
        imageView.setImageBitmap(bitmap);
        ViewGroup.LayoutParams p=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(p);
        imageLoadActivity.layout.addView(imageView);
    }
}
