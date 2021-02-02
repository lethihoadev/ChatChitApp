package com.example.chatchit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatchit.R;
import com.example.chatchit.model.Chat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private Context context;
    private List<Chat> chats;
    private String avatar;

    FirebaseUser firebaseUser;

    public static final int MESSAGE_LEFT = 0, MESSAGE_RIGHT = 1;

    public MessageAdapter(Context context, List<Chat> chats, String avatar) {
        this.context = context;
        this.chats = chats;
        this.avatar = avatar;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == MESSAGE_RIGHT){
            view = LayoutInflater.from(context).inflate(R.layout.chat_item_right, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.chat_item_left, parent, false);
        }
        return new MessageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.lblMessage.setText(chat.getMessage());
        if (avatar.equals("no")){
            holder.imgAvatar.setImageResource(R.mipmap.ic_launcher);
        } else {
            Picasso.get().load(avatar).into(holder.imgAvatar);
        }
        if (position == chats.size() - 1){
            if (chat.getIsSeen()){
                holder.lblSeen.setText("Seen");
            } else {
                holder.lblSeen.setText("Sent");
            }
        }
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView lblMessage, lblSeen;
        public ImageView imgAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblMessage = itemView.findViewById(R.id.lblMessage);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            lblSeen = itemView.findViewById(R.id.lblSeen);
        }
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (chats.get(position).getSenderId().equals(firebaseUser.getUid())){
            return MESSAGE_RIGHT;
        } else {
            return MESSAGE_LEFT;
        }
    }
}
