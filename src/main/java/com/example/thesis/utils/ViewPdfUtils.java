package com.example.thesis.utils;

import static android.os.Environment.getExternalStoragePublicDirectory;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ViewPdfUtils {


    public static void viewPdf(Context context, String imageUrl){

        String file_url = imageUrl;
        URL url = null;
        try{
            url = new URL(file_url);
        } catch(MalformedURLException e){
            Log.d("urlFile", "Check url file");
        }

        String filename = url.getPath();
        filename = filename.substring(filename.lastIndexOf('/') + 1);

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url +""));
        request.setTitle(filename);
        request.setMimeType("application/pdf");
        request.allowScanningByMediaScanner();
        request.setAllowedOverMetered(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        dm.enqueue(request);


        File file = new File(getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename);

        Uri uri = FileProvider.getUriForFile(context, "com.example.thesis" + ".provider", file);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(uri, "application/pdf");
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(i);
    }
}
