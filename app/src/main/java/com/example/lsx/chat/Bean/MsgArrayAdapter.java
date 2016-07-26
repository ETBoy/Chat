package com.example.lsx.chat.Bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lsx.chat.R;

import java.util.List;

/**
 * Created by lsx on 2016/7/24.
 */

public class MsgArrayAdapter extends ArrayAdapter<Msg> {
    public MsgArrayAdapter(Context context, int resourceID, List<Msg> objects){
        super(context,resourceID,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    Msg msg=getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item_msg,parent,false);
viewHolder=new ViewHolder();
            viewHolder.leftMsg= (TextView) convertView.findViewById(R.id.list_item_msg_left_text_view);
            viewHolder.rightMsg= (TextView) convertView.findViewById(R.id.list_item_msg_right_text_view);
            convertView.setTag(viewHolder);
        } else

        {
viewHolder= (ViewHolder) convertView.getTag();

        }
        if(msg.getType()==Msg.TYPE_RECEIVED){
            viewHolder.leftMsg.setVisibility(View.VISIBLE);
            viewHolder.leftMsg.setText(msg.getContent());
            viewHolder.rightMsg.setVisibility(View.GONE);
        }else
        {
            viewHolder.leftMsg.setVisibility(View.GONE);
            viewHolder.rightMsg.setVisibility(View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return convertView;
    }
}

class ViewHolder{
    TextView leftMsg;
    TextView rightMsg;
}
