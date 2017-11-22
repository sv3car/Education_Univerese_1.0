package com.universe.education.education_univerese_10.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.universe.education.education_univerese_10.Classes.Document;
import com.universe.education.education_univerese_10.R;

import java.text.DecimalFormat;
import java.util.List;


public class AdapterDocuments extends RecyclerView.Adapter<AdapterDocuments.vViewHolder> implements View.OnClickListener{

    private List<Document> items;
    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    public static class vViewHolder extends RecyclerView.ViewHolder {

        // Campos respectivos de un item

        public TextView nameDoc;
        public TextView sizeDoc;
        public ImageView iViewDoc;

        public vViewHolder(View v) {
            super(v);
            nameDoc = (TextView) v.findViewById(R.id.tvNameDoc);
            sizeDoc = (TextView) v.findViewById(R.id.tvSizeDoc);
            iViewDoc = (ImageView) v.findViewById(R.id.iViewDoc);
        }
    }

    public AdapterDocuments(List<Document> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public vViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.items_documents, viewGroup, false);
        v.setOnClickListener(this);
        return new vViewHolder(v);
    }

    @Override
    public void onBindViewHolder(vViewHolder viewHolder, int i) {

        /*String sizeStr = items.get(i).getDocSize();
        String nameStr = items.get(i).getDocName();

        int posPunto = nameStr.indexOf(".");
        int lengthName = nameStr.length();

        String ext;
        try{
            ext = nameStr.substring(posPunto, lengthName);
        } catch (Exception e){
            ext = "noData";
        }*/

        viewHolder.nameDoc.setText(items.get(i).getDocName());
        viewHolder.sizeDoc.setText(size(Integer.parseInt(items.get(i).getDocSize())));
        viewHolder.iViewDoc.setImageResource(R.drawable.img_doc);

        /*if (ext.equals(".pdf")){
            viewHolder.iViewDoc.setImageResource(R.drawable.img_pdf);
        } else if (ext.equals(".docx") || ext.equals(".docm") ||
                    ext.equals(".dotx") || ext.equals(".dotm")){
            viewHolder.iViewDoc.setImageResource(R.drawable.img_word);
        } else if (ext.equals(".xls") || ext.equals(".xlt") ||
                ext.equals(".xls") || ext.equals(".xml")){
            viewHolder.iViewDoc.setImageResource(R.drawable.img_excel);
        } else if (ext.equals(".thmx") || ext.equals(".pps") ||
                ext.equals(".ppsx") || ext.equals(".ppsm") || ext.equals(".ppt")){
            viewHolder.iViewDoc.setImageResource(R.drawable.img_powerpoint);
        } else {
            viewHolder.iViewDoc.setImageResource(R.drawable.img_desco);
        }*/

    }
    public String size(int size){
        String hrSize = "";
        int b = size;
        double k = size/1024;
        double m = size/1048576;
        double g = size/1073741824;

        DecimalFormat dec = new DecimalFormat("0.00");

        if (b>0){
            hrSize = dec.format(b).concat("Bytes");
        }
        if (k>0){
            hrSize = dec.format(k).concat("KB");
        }
        if (m>0){
            hrSize = dec.format(m).concat("MB");
        }
        if (g>0){
            hrSize = dec.format(g).concat("GB");
        }
        return hrSize;
    }
}
