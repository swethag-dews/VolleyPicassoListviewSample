package com.example.volleypicassolistviewsample.WithJsonArrayRequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.volleypicassolistviewsample.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    ArrayList<Data> dataList;
    Context context;

    public CustomListAdapter(Context context, ArrayList<Data> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder{
        TextView downloadCountText, viewCountText;
        ImageView imageUrl;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.downloadCountText = convertView.findViewById(R.id.text_downloads);
            holder.viewCountText = convertView.findViewById(R.id.text_views);
            holder.imageUrl = convertView.findViewById(R.id.image_view);


            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Data data = dataList.get(i);
        holder.downloadCountText.setText(data.getDownload_count());
        holder.viewCountText.setText(data.getView_count());

        Picasso.with(context)
                .load(data.getImageurl())
                .into(holder.imageUrl);
        return convertView;
    }
}
