package com.example.gson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gson.R;
import com.example.gson.activity.MainActivity;
import com.example.gson.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {

    private List<User> list;
    private LayoutInflater layoutInflater;

    public UserAdapter(Context context, List<User> list){
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_view, parent, false);
        }

        User user = getUserModel(position);

        TextView texttitle = (TextView) view.findViewById(R.id.textview_title);
        texttitle.setText(user.getTitle());
        TextView textid = (TextView) view.findViewById(R.id.textview_id);
        textid.setText(user.getID());


        return view;
    }

    private User getUserModel(int position){

        return (User) getItem(position);

    }
}
