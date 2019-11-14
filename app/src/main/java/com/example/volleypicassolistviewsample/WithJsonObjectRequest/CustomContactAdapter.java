package com.example.volleypicassolistviewsample.WithJsonObjectRequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.volleypicassolistviewsample.R;

import java.util.ArrayList;

public class CustomContactAdapter extends BaseAdapter {

    ArrayList<ContactInfo> contactInfoList;
    Context context;

    public CustomContactAdapter(Context context, ArrayList<ContactInfo> contactInfoList) {
        this.context = context;
        this.contactInfoList = contactInfoList;
    }

    @Override
    public int getCount() {
        return contactInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder{
        TextView textViewName, textViewEmail, textViewMobile;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.contact_list_item, null);

            holder = new ViewHolder();
            holder.textViewEmail = convertView.findViewById(R.id.item_view_email);
            holder.textViewName = convertView.findViewById(R.id.item_view_name);
            holder.textViewMobile = convertView.findViewById(R.id.item_view_mobile);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ContactInfo contactInfo = contactInfoList.get(i);
        holder.textViewName.setText(contactInfo.getName());
        holder.textViewEmail.setText(contactInfo.getEmailId());
        holder.textViewMobile.setText(contactInfo.getPhNo());

        return convertView;
    }
}
