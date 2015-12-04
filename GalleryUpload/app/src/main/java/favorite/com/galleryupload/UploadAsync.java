package favorite.com.galleryupload;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jhmfrd on 2015-12-04.
 */
public class UploadAsync extends AsyncTask<String, Void, Void> {
    String charset="utf-8";
    File binaryFile = new File("D:/new_webworkspace/UploadApp/WebContent/data/photo.jpg");
    String boundary = Long.toHexString(System.currentTimeMillis());
    String CRLF = "\r\n"; // Line separator required by multipart/form-data.
    HttpURLConnection con;
    FileInputStream fis;
    String TAG = this.getClass().getName();
    ProgressBar progressBar;
    public UploadAsync(ProgressBar progressBar){this.progressBar=progressBar;}


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {
        String path = params[0]; //보낸쪽에서
        binaryFile = new File(path);

        try {
            URL url = new URL("http://70.12.109.79:9090/upload/save.jsp");
            con = (HttpURLConnection) url.openConnection();

            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            con.setRequestProperty("Connection", "keep-alive");
            con.setRequestProperty("Cache-Control", "max-age=0");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            OutputStream output = con.getOutputStream();

            con.connect();

            PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
            // Send normal param.
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"id\"").append(CRLF);
            writer.append("Content-Type: text/plain; charset=" + charset).append(CRLF);
            writer.append(CRLF).append("zino").append(CRLF).flush();

            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"binaryFile\"; filename=\"" + binaryFile.getName() + "\"").append(CRLF);
            writer.append("Content-Type: " + HttpURLConnection.guessContentTypeFromName(binaryFile.getName())).append(CRLF);
            writer.append("Content-Transfer-Encoding: binary").append(CRLF);
            writer.append(CRLF).flush();

            byte[] b=new byte[1024];

            fis=new FileInputStream(binaryFile);
            int data=-1;
            while(true) {
                data=fis.read(b);
                if(data==-1)break;
                output.write(b);
                output.flush(); // Important before continuing with writer!
            }

            writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.


            // End of multipart/form-data.
            writer.append("--" + boundary + "--").append(CRLF).flush();
            writer.close();

            int code = 0;
            code = con.getResponseCode();
            //System.out.println(code);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, path);
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressBar.setVisibility(View.GONE);
        super.onPostExecute(aVoid);
    }
}
