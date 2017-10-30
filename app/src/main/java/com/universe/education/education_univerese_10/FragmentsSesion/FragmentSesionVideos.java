package com.universe.education.education_univerese_10.FragmentsSesion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.universe.education.education_univerese_10.Activities.ActivityProceso;
import com.universe.education.education_univerese_10.Classes.ClassConexion;
import com.universe.education.education_univerese_10.Classes.Potential;
import com.universe.education.education_univerese_10.R;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class FragmentSesionVideos extends Fragment{

        String idVideo;

        Button btnVid1;
        Button btnVid2;
        Button btnVid3;
        Button btnVid4;
        Button btnVid5;
        Button btnVid6;
        Button btnVid7;

        ImageView imgVThum1;
        ImageView imgVThum2;
        ImageView imgVThum3;
        ImageView imgVThum4;
        ImageView imgVThum5;
        ImageView imgVThum6;
        ImageView imgVThum7;
        Bitmap bm;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_sesion_videos, container, false);

            imgVThum1 = (ImageView) view.findViewById(R.id.imgVThum1);
            imgVThum2 = (ImageView) view.findViewById(R.id.imgVThum2);
            imgVThum3 = (ImageView) view.findViewById(R.id.imgVThum3);
            imgVThum4 = (ImageView) view.findViewById(R.id.imgVThum4);
            imgVThum5 = (ImageView) view.findViewById(R.id.imgVThum5);
            imgVThum6 = (ImageView) view.findViewById(R.id.imgVThum6);
            imgVThum7 = (ImageView) view.findViewById(R.id.imgVThum7);

            btnVid1 = (Button) view.findViewById(R.id.btnVid1);
            btnVid2 = (Button) view.findViewById(R.id.btnVid2);
            btnVid3 = (Button) view.findViewById(R.id.btnVid3);
            btnVid4 = (Button) view.findViewById(R.id.btnVid4);
            btnVid5 = (Button) view.findViewById(R.id.btnVid5);
            btnVid6 = (Button) view.findViewById(R.id.btnVid6);
            btnVid7 = (Button) view.findViewById(R.id.btnVid7);

            TareaAsincrona task1 = new TareaAsincrona();
            task1.execute("http://img.youtube.com/vi/lzwWiIPHxJ4/0.jpg", "1");

            TareaAsincrona task2 = new TareaAsincrona();
            task2.execute("http://img.youtube.com/vi/Ir1UFs4bSyA/0.jpg", "2");

            TareaAsincrona task3 = new TareaAsincrona();
            task3.execute("http://img.youtube.com/vi/59K0vkE1bZE/0.jpg", "3");

            TareaAsincrona task4 = new TareaAsincrona();
            task4.execute("http://img.youtube.com/vi/QnHTE-8DdxU/0.jpg", "4");

            TareaAsincrona task5 = new TareaAsincrona();
            task5.execute("http://img.youtube.com/vi/BMXbWnXYaAM/0.jpg", "5");

            TareaAsincrona task6 = new TareaAsincrona();
            task6.execute("http://img.youtube.com/vi/8iYtQ4Gnx0o/0.jpg", "6");

            TareaAsincrona task7 = new TareaAsincrona();
            task7.execute("http://img.youtube.com/vi/GRSLTqDE_jo/0.jpg", "7");


            btnVid1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idVideo = "lzwWiIPHxJ4";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
                }
            });

            btnVid2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idVideo = "Ir1UFs4bSyA";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
                }
            });

            btnVid3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idVideo = "59K0vkE1bZE";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
                }
            });

            btnVid4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idVideo = "QnHTE-8DdxU";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
                }
            });

            btnVid5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idVideo = "BMXbWnXYaAM";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
                }
            });

            btnVid6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idVideo = "8iYtQ4Gnx0o";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
                }
            });

            btnVid7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idVideo = "GRSLTqDE_jo";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ idVideo)));
                }
            });

            return view;
        }

    public interface OnFragmentInteractionListener {
    }

    private class TareaAsincrona extends AsyncTask<String, Integer, String> {

        Boolean control = false;

        @Override
        public void onPreExecute()
        {
            //aquí se puede colocar código a ejecutarse previo
            //a la operación
        }

        @Override
        protected void onPostExecute(String result)
        {
            //aquí se puede colocar código que
            //se ejecutará tras finalizar
            //progressDialog.dismiss();
            try {
                switch (result) {
                    case "1":
                        imgVThum1.setImageBitmap(bm);
                        imgVThum1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "2":
                        imgVThum2.setImageBitmap(bm);
                        imgVThum2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "3":
                        imgVThum3.setImageBitmap(bm);
                        imgVThum3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "4":
                        imgVThum4.setImageBitmap(bm);
                        imgVThum4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "5":
                        imgVThum5.setImageBitmap(bm);
                        imgVThum5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "6":
                        imgVThum6.setImageBitmap(bm);
                        imgVThum6.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case "7":
                        imgVThum7.setImageBitmap(bm);
                        imgVThum7.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                }
            } catch (Exception e){
                Toast.makeText(getContext().getApplicationContext(), ClassConexion.mensaje,Toast.LENGTH_SHORT).show();
            }



        }
        @Override
        protected String doInBackground(String... params) {
            control = false;
            //realizar la operación aquí
            bm = get_imagen(params[0]);
            return params[1];
        }
    }

    private Bitmap get_imagen(String url) {
        Bitmap bm = null;
        try {
            URL _url = new URL(url);
            URLConnection con = _url.openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (Exception e) {
            ClassConexion.mensaje = "Error al obtener los datos";
        }
        return bm;
    }



}
