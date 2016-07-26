package com.example.lsx.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lsx.chat.Bean.Msg;
import com.example.lsx.chat.Bean.MsgArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Msg> mMsgList;
    private MsgArrayAdapter mAdpater;
    private ListView mListView;
private Button mButton;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        mAdpater=new MsgArrayAdapter(MainActivity.this,R.layout.list_item_msg,mMsgList);
        mListView= (ListView) findViewById(R.id.activity_main_list_view);
        mListView.setAdapter(mAdpater);
mButton= (Button) findViewById(R.id.activity_main_send_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     mEditText= (EditText) findViewById(R.id.activity_main_send_text_view);
                String content=mEditText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SEND);
                    mMsgList.add(msg);
                    mAdpater.notifyDataSetChanged();
                    mListView.setSelection(mMsgList.size());
                    mEditText.setText("");

                }
            }
        });
    }

    private void initMsgs() {
       mMsgList =new ArrayList<Msg>();
        Msg msg=new Msg("Hellp guy.",Msg.TYPE_RECEIVED);
        mMsgList.add(msg);
        msg=new Msg("Hello Who is that?",Msg.TYPE_SEND);
        mMsgList.add(msg);
        msg=new Msg("This is Tom,Nice talking to you",Msg.TYPE_RECEIVED);
        mMsgList.add(msg);
    }
}
