package com.example.usermanagment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.UserViewHolder> {
    Context context;
    List list;


    public AdapterUser(Context context,List list)
    {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_user,null);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user=(User) list.get(position);
           holder.t1.setText(user.getFullname());
           holder.t2.setText(user.email);
           holder.t5.setText(user.getPassword());


    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder  {
        TextView t1;
        TextView t2;
        TextView t5;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
            t5=itemView.findViewById(R.id.textView5);


        }

    }}
