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

import com.example.chatchit.MainActivity;
import com.example.chatchit.MessageActivity;
import com.example.chatchit.R;
import com.example.chatchit.model.User;
import com.squareup.picasso.Picasso;
import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context context;
    private List<User> users;
    private boolean isChat;
    public UserAdapter(Context context, List<User> users, boolean isChat) {
        this.context = context;
        this.users = users;
        this.isChat = isChat;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new UserAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.lblNickName.setText(user.getNickName());
        if (user.getAvatar().equals("no")){
            holder.imgAvatar.setImageResource(R.mipmap.ic_launcher);
        } else {
            Picasso.get().load(user.getAvatar()).into(holder.imgAvatar);
        }

        if (isChat){
            if (user.getStatus().equals("onl")){
                holder.imgOnline.setImageResource(R.drawable.presence_online);
            } else {
                holder.imgOnline.setImageResource(R.drawable.presence_offline);
            }
        } else {
            holder.imgOnline.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("userId", user.getId());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return users.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView lblNickName;
        public ImageView imgAvatar, imgOnline;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            lblNickName = itemView.findViewById(R.id.lblUserNickName);
            imgAvatar = itemView.findViewById(R.id.imgUserAvatar);
            imgOnline = itemView.findViewById(R.id.imgOnline);
        }
    }
}
