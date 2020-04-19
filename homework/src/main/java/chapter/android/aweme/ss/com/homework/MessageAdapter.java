package chapter.android.aweme.ss.com.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.msgViewHolder>{

    private static final String TAG = "MsgAdapter";
    private List<Message> MsgList;

    private final ListItemClickListener mOnClickListener;

    public MessageAdapter(List<Message> msgList, ListItemClickListener listener){
        MsgList = msgList;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public msgViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item,viewGroup,false);
        return new msgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull msgViewHolder holder, int position) {
        Message msg = MsgList.get(position);
        holder.tv_time.setText(msg.getTime());
        holder.tv_description.setText(msg.getDescription());
        holder.tv_title.setText(msg.getTitle());
        if(msg.isOfficial()){
            holder.robot_notice.setVisibility(View.VISIBLE);
        }
        else {
            holder.robot_notice.setVisibility(View.GONE);
        }
        switch(msg.getIcon()){
            case "TYPE_ROBOT":
                holder.avatarImageView.setImageResource(R.drawable.session_robot);
                break;
            case "TYPE_GAME":
                holder.avatarImageView.setImageResource(R.drawable.icon_micro_game_comment);
                break;
            case "TYPE_SYSTEM":
                holder.avatarImageView.setImageResource(R.drawable.session_system_notice);
                break;
            case "TYPE_STRANGER":
                holder.avatarImageView.setImageResource(R.drawable.session_stranger);
                break;
            default:
                holder.avatarImageView.setImageResource(R.drawable.icon_girl);
                break;
        };


    }

    @Override
    public int getItemCount() {
        return MsgList.size();
    }

    public class msgViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final CircleImageView avatarImageView;
        private final ImageView robot_notice;
        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_time;

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            Log.d(TAG,clickedPosition + " has been clicked");
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }

        }

        public msgViewHolder(@NonNull View view){
            super(view);
            avatarImageView = (CircleImageView) view.findViewById(R.id.iv_avatar);
            robot_notice = (ImageView) view.findViewById(R.id.robot_notice);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_description = (TextView) view.findViewById(R.id.tv_description);
            tv_time = (TextView) view.findViewById(R.id.tv_time);
            view.setOnClickListener(this);
        }
    }

    //用于响应的接口
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

}
