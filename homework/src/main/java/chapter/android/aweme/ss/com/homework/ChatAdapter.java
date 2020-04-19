package chapter.android.aweme.ss.com.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.chatViewHolder> {

    private static final String TAG = "ChatAdapter";
    private List<Message> MsgList;

    public ChatAdapter(List<Message> msgList){
        MsgList = msgList;
    }

    @NonNull
    @Override
    public chatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_item,viewGroup,false);
        return new chatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatViewHolder viewHolder, int i) {
        Message msg = MsgList.get(i);
        Log.d(TAG,"用户类型：" + msg.getIcon());
        if(msg.getIcon() == "TYPE_SELF"){
            viewHolder.left_layout.setVisibility(View.GONE);
            viewHolder.me_icon.setImageResource(R.mipmap.ic_launcher);
            viewHolder.right_msg.setText(msg.getDescription());
        }
        else{
            viewHolder.right_layout.setVisibility(View.GONE);
            Log.d(TAG,"对方发来的消息：" + msg.getDescription());
            switch(msg.getIcon()){
                case "TYPE_ROBOT":
                    viewHolder.avatar_icon.setImageResource(R.drawable.session_robot);
                    break;
                case "TYPE_GAME":
                    viewHolder.avatar_icon.setImageResource(R.drawable.icon_micro_game_comment);
                    break;
                case "TYPE_SYSTEM":
                    viewHolder.avatar_icon.setImageResource(R.drawable.session_system_notice);
                    break;
                case "TYPE_STRANGER":
                    viewHolder.avatar_icon.setImageResource(R.drawable.session_stranger);
                    break;
                default:
                    viewHolder.avatar_icon.setImageResource(R.drawable.icon_girl);
                    break;
            };

            viewHolder.left_msg.setText(msg.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return MsgList.size();
    }

    public class chatViewHolder extends RecyclerView.ViewHolder {

        private  final LinearLayout left_layout;
        private  final LinearLayout right_layout;
        private final CircleImageView avatar_icon;
        private final CircleImageView me_icon;
        private final TextView left_msg;
        private final TextView right_msg;

        public chatViewHolder(@NonNull View view){
            super(view);
            left_layout = (LinearLayout) view.findViewById(R.id.left_layout);
            right_layout = (LinearLayout) view.findViewById(R.id.right_layout);
            avatar_icon = (CircleImageView) view.findViewById(R.id.iv_icon);
            me_icon = (CircleImageView) view.findViewById(R.id.iv_me);
            left_msg = (TextView) view.findViewById(R.id.left_msg);
            right_msg = (TextView) view.findViewById(R.id.right_msg);
        }
    }
}
