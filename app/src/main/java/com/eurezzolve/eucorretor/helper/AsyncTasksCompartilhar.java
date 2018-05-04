package com.eurezzolve.eucorretor.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.google.firebase.database.DatabaseReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;

import livroandroid.lib.fragment.BaseFragment;
import livroandroid.lib.utils.IOUtils;
import livroandroid.lib.utils.SDCardUtils;

public class AsyncTasksCompartilhar extends AsyncTask<List<String>, Void, ArrayList<Uri>>{

    private ArrayList<Uri> imageUris = new ArrayList<Uri>();
    private final List<String> listaSelecionada;
    private Context context;

    public AsyncTasksCompartilhar(List<String> listaSelecionada, Context context){
        imageUris = null;
        this.listaSelecionada = listaSelecionada;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Uri> doInBackground(List<String>... voids) {
        for (String s : listaSelecionada){
            String url = s;
            String filename = url.substring(url.lastIndexOf("/"));
            /*Cria o arquivo no SD Card*/
            File file = SDCardUtils.getPrivateFile(context, "imagens", filename);
            IOUtils.downloadToFile(s, file);
            /*Salva para comparilhar a foto*/
            imageUris.add(Uri.fromFile(file));
        }

        return imageUris;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<Uri> imagens) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imagens);
        shareIntent.setType("image/*");


        super.onPostExecute(imagens);
    }

}
