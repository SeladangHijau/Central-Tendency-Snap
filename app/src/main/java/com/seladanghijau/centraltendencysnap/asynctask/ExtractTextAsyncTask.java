package com.seladanghijau.centraltendencysnap.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.seladanghijau.centraltendencysnap.manager.OCRManager;
import com.seladanghijau.centraltendencysnap.provider.OCRProvider;

import java.io.File;

/**
 * Created by seladanghijau on 14/8/2016.
 */
public class ExtractTextAsyncTask extends AsyncTask<Void, Void, Void> {
    private ProgressDialog progressDialog;
    private Context context;
    private OCRManager ocrManager;
    private Bitmap image;
    private String result;

    public ExtractTextAsyncTask(Context context, OCRManager ocrManager, Bitmap image) {
        this.context = context;
        this.ocrManager = ocrManager;
        this.image = image;
    }

    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Please wait...");
        progressDialog.show();
    }

    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        ocrManager.onLoad(result);

        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }

    protected Void doInBackground(Void... params) {
        TessBaseAPI tessBaseAPI;

        try {
            tessBaseAPI = new TessBaseAPI();
            tessBaseAPI.init(OCRProvider.TESSDATA_DIR_PATH + "/", OCRProvider.LANGUAGE);
            tessBaseAPI.setImage(image);

            result = tessBaseAPI.getUTF8Text();

            tessBaseAPI.end();
        } catch (Exception e) { e.printStackTrace(); }

        return null;
    }
}