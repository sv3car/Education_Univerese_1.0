package com.universe.education.education_univerese_10.FragmentsSesion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universe.education.education_univerese_10.Classes.ClassZohoVar;
import com.universe.education.education_univerese_10.R;


public class FragmentSesion4 extends Fragment {

    TextView TvNom;
    TextView TvCorreoFrag;
    TextView TvNivEst;
    TextView TvNumPasa;
    TextView TvNac;
    TextView TvViaja;
    TextView TvFecViaja;
    TextView TvNivIng;
    TextView TvAplicVisa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sesion4, container, false);



        TvNom = (TextView) view.findViewById(R.id.TvNom);
        TvCorreoFrag = (TextView) view.findViewById(R.id.TvCorreoFrag);
        TvNivEst = (TextView) view.findViewById(R.id.TvNivEst);
        TvNumPasa = (TextView) view.findViewById(R.id.TvNumPasa);
        TvNac = (TextView) view.findViewById(R.id.TvNac);
        TvViaja = (TextView) view.findViewById(R.id.TvViaja);
        TvFecViaja = (TextView) view.findViewById(R.id.TvFecViaja);
        TvNivIng = (TextView) view.findViewById(R.id.TvNivIng);
        TvAplicVisa = (TextView) view.findViewById(R.id.TvAplicVisa);

        TvNom.setText(ClassZohoVar.getName());
        TvCorreoFrag.setText(ClassZohoVar.getCorreo());
        TvNivEst.setText(ClassZohoVar.getNEst());
        TvNumPasa.setText(ClassZohoVar.getNPass());
        TvNac.setText(ClassZohoVar.getNacEst());
        TvViaja.setText(ClassZohoVar.getViaja());
        TvFecViaja.setText(ClassZohoVar.getFecAp());
        TvNivIng.setText(ClassZohoVar.getIngles());
        TvAplicVisa.setText(ClassZohoVar.getEstVisa());

        return view;
    }

    public interface OnFragmentInteractionListener {


    }
}
