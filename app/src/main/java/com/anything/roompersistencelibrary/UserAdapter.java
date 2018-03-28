package com.anything.roompersistencelibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ambar on 27/3/18.
 */

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.firstName.setText(users.get(position).getFirstName());
        holder.email.setText("Email: "+users.get(position).getEmail());
        holder.content.setText("Description: "+users.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstName;
        public TextView email;
        public TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = (TextView) itemView.findViewById(R.id.firstName);
            email = (TextView) itemView.findViewById(R.id.email);
            content = (TextView) itemView.findViewById(R.id.content);

        }
    }
}
