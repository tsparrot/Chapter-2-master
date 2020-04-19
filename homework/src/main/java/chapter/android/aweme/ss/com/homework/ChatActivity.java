package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = "tsparrot";

    private ChatAdapter chatAdapter;
    private RecyclerView chatRecycleView;
    private EditText inputText;
    private List<Message> chatMessages = new ArrayList<>();
    private ImageView send;
    private TextView title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        ActionBar actionBar =getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        Intent intent = getIntent();

        String HelloMessage = intent.getStringExtra("Hello_msg");
        String icon = intent.getStringExtra("icon");
        String chat_title = intent.getStringExtra("title");
        Boolean is_official = intent.getBooleanExtra("is_official",false);

        inputText = findViewById(R.id.ed_say);
        send = findViewById(R.id.btn_send_info);
        title = findViewById(R.id.tv_with_name);
        title.setText(chat_title);

        Message chat_msg = new Message();
        chat_msg.setDescription(HelloMessage);
        //Log.d(TAG,HelloMessage);
        chat_msg.setIcon(icon);
        chat_msg.setTitle(chat_title);
        chat_msg.setOfficial(is_official);
        chat_msg.setTime("04:04");
        chatMessages.add(chat_msg);

        chatRecycleView = findViewById(R.id.chat_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        chatRecycleView.setLayoutManager(layoutManager);

        chatAdapter = new ChatAdapter(chatMessages);
        chatRecycleView.setAdapter(chatAdapter);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chat_content = inputText.getText().toString();
                if(!"".equals(chat_content)){
                    Message msg = new Message();
                    msg.setOfficial(false);
                    msg.setDescription(chat_content);
                    msg.setIcon("TYPE_SELF");
                    chatMessages.add(msg);
                    Log.d(TAG,String.valueOf(chatMessages.size() - 1));
                    chatAdapter.notifyItemInserted(chatMessages.size() - 1);
                    inputText.setText("");
                }
            }
        });



    }
}