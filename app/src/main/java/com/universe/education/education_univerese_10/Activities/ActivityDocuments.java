package com.universe.education.education_univerese_10.Activities;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.universe.education.education_univerese_10.Adapters.AdapterDocuments;
import com.universe.education.education_univerese_10.Classes.ClassConexion;
import com.universe.education.education_univerese_10.Classes.ClassZohoJSONDocuments;
import com.universe.education.education_univerese_10.Classes.Document;
import com.universe.education.education_univerese_10.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ActivityDocuments extends AppCompatActivity {

    RecyclerView recycler;
    private String idDoc;
    private String docName;
    private String docSize;
    private View vi;
    private String ext;
    private int posPunto;
    private int lengthName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_screen_toolbar_documento);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                Intent intent = new Intent(getApplicationContext(), ActivitySesion.class);
                startActivity(intent);
                finish();
            }
        });

        recycler = (RecyclerView)findViewById(R.id.rvDoc);
        recycler.setHasFixedSize(true);
        final GridLayoutManager lManager = new GridLayoutManager(ActivityDocuments.this, 2);
        final AdapterDocuments adapter = new AdapterDocuments(ClassZohoJSONDocuments.listDocument);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(lManager);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vi = v;
                int posAct = recycler.getChildAdapterPosition(v);
                Document docAux;

                docAux = ClassZohoJSONDocuments.listDocument.get(posAct);

                idDoc = docAux.getIdDoc();
                docName = docAux.getDocName();
                docSize = docAux.getDocSize();

                posPunto = docName.indexOf(".");
                lengthName = docName.length();

                try{
                    ext = docName.substring(posPunto, lengthName);
                } catch (Exception e){
                    ext = "noData";
                }
                ShowDialog();
            }
        });
    }

    private class TareaAsincrona extends AsyncTask<String, Integer, Boolean> {

        Boolean control = false;

        private Context context;
        private NotificationManager mNotificationManager;
        private android.support.v4.app.NotificationCompat.Builder mNotifyBuilder;
        private int numMessages;

        public TareaAsincrona(Context context) {
            this.context = context;
        }

        @Override
        protected Boolean doInBackground(String... params) {

            String urlStr = "https://crm.zoho.com/crm/private/xml/Potentials/downloadFile?" +
                    "authtoken=8b49fd4b66f4a9e2098d9c2d79652405&scope=crmapi&id="+idDoc;

            //realizar la operación aquí
            if (ClassConexion.isNetworkConnected(getApplicationContext())) {
                new ClassConexion(urlStr);
            }

            if (ClassConexion.msj){
                Boolean isBo;
                InputStream is;
                try {
                    is = ClassConexion.getInputStream();
                    isBo = true;
                } catch (Exception e){
                    is = null;
                    isBo = false;
                }

                if (isBo){
                    try {
                        File dir = new File(Environment.getExternalStorageDirectory() + "/DownloadUniverse");
                        dir.mkdirs();
                        File file  = new File(dir,docName);
                        if (!file.exists() || ext.equals("noData")){
                            FileOutputStream fileOutput = new FileOutputStream(file);

                            int downloadedSize = 0;

                            byte[] buffer = new byte[1024];

                            int bufferLength;

                            control = true;

                            int docPorc;
                            assert is != null;
                            while ( (bufferLength = is.read(buffer)) > 0 ) {
                                fileOutput.write(buffer, 0, bufferLength);
                                downloadedSize += bufferLength;
                                docPorc = (downloadedSize * 100) / Integer.parseInt(docSize) ;
                                publishProgress(docPorc);
                            }

                            fileOutput.close();
                       } else{
                           ClassConexion.mensaje = "El archivo ya existe";
                            control = false;
                       }
                    } catch (Exception e) {
                        ClassConexion.mensaje = "No se pudo descargar documento";
                        control = false;
                    }

                } else{
                    ClassConexion.mensaje = "Imposible descargar documento";
                    control = false;
                }
            }
            return true;
        }

        @SuppressLint("NewApi")
        @Override
        protected void onProgressUpdate(Integer... values) {
            // Actualiza la barra de progreso
            mNotifyBuilder.setProgress(100, values[0], false);
            mNotificationManager.notify(numMessages, mNotifyBuilder.build());

        }

        protected void onPreExecute() {


            mNotificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            // Establece un ID para la notificación, para que se pueda actualizar
            mNotifyBuilder = new NotificationCompat.Builder(context)
                    .setContentTitle(docName)
                    .setContentText(docName)
                    .setSmallIcon(R.drawable.ic_download);

            // Comienza un bucle que procesa los datos y luego notifica al usuario
            mNotifyBuilder.setContentText("Descarga en curso...");
            // Debido a que el ID se mantiene sin cambios, la notificación
            // existente se actualiza
            mNotificationManager.notify(numMessages, mNotifyBuilder.build());
        }

        @Override
        protected void onPostExecute(Boolean resultado) {
            if (control)
            {
                // Muestra el resultado en la notificación si fue exitoso o no
                if (resultado) {
                    mNotifyBuilder.setContentText("Archivo descargado correctamente");
                    Toast.makeText(ActivityDocuments.this, "Archivo guardado en la memoria externa en la carpeta /DownloadUniverse", Toast.LENGTH_LONG).show();
                } else {
                    mNotifyBuilder.setContentText("El archivo no se pudo descargar");
                }
                // Elimina la barra de progreso

                /*Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,"Hola");
                sharingIntent.setPackage("com.whatsapp");
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, sharingIntent, 0);*/

                //Toast.makeText(this, "Leyendo documento", Toast.LENGTH_LONG).show();

                String mime;
                if (ext.equals(".pdf")){
                    mime = "application/pdf";
                } else if (ext.equals(".docx") || ext.equals(".docm") ||
                        ext.equals(".dotx") || ext.equals(".dotm")){
                    mime = "application/msword";
                } else if (ext.equals(".xls") || ext.equals(".xlt") ||
                        ext.equals(".xls") || ext.equals(".xml")){
                    mime = "application/vnd.ms-powerpoint";
                } else if (ext.equals(".thmx") || ext.equals(".pps") ||
                        ext.equals(".ppsx") || ext.equals(".ppsm") || ext.equals(".ppt")){
                    mime = "application/vnd.ms-excel";
                } else {
                    mime = "text/plain";
                }

                Intent intent = new Intent(Intent.ACTION_VIEW);
                File f = new File(Environment.getExternalStorageDirectory() + "/DownloadUniverse", docName);
                intent.setDataAndType(Uri.fromFile(f),mime);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                mNotifyBuilder.setProgress(0, 0, false);

                mNotifyBuilder.setContentIntent(pendingIntent);

                mNotifyBuilder.setProgress(0, 0, false);
                mNotificationManager.notify(numMessages, mNotifyBuilder.build());
            }
            else
            {
                mNotificationManager.cancelAll();
                Snackbar.make(vi,ClassConexion.mensaje, Snackbar.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ActivityDocuments.this, ActivitySesion.class);
        startActivity(intent);
        finish();
    }

    public void ShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Descargar Archivo");
        builder.setMessage("¿Descargar el archivo: "+docName+"?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id) {
                TareaAsincrona task = new TareaAsincrona(getApplicationContext());
                task.execute();
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }); // Create the AlertDialog object and return it
        builder.create().show();
    }

}
