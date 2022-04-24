package com.example.doctorslistain_2_20abdylmanapkyzyakmaral;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MainViewHolder> {

    public ArrayList<Consult> list;
    public Context context;
  //  private ItemClickListener listener ;
    private PopupMenu popMenu;


    public MainAdapter(ArrayList<Consult> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void addData(Consult consult){
        list.add(consult);
        notifyDataSetChanged();
    }
    public void changeData(Consult consult, int position) {
        list.set(position, consult);
        notifyItemChanged(position);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_doctor,parent,false);
        return new MainViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.onBind(list.get(position));

        holder.popMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.appoint_to_doctor:
                                Toast.makeText(context, "Уважаемый пользователь" +
                                        "Вы можете записаться к врачу, " +
                                        "в удобное для Вас время, " +
                                        "по телефону регистратуры " +
                                        "нашей клиники 0312 66 32 45", Toast.LENGTH_LONG).show();;
                                break;
                            case R.id.call:
                                String number = list.get(position).getRoom();
                                Uri call = Uri.parse("Телефон: " + number);
                                Intent intent = new Intent(Intent.ACTION_DIAL, call);
                                context.startActivity(intent);
                                break;
                        }
                        return false;
                    }
                });
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName;
        TextView txtRoom;
        ImageView imageView;
        ImageView popMenu;
        Consult consult;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtRoom = itemView.findViewById(R.id.txtRoom);
            imageView = itemView.findViewById(R.id.iv_25);
            popMenu = itemView.findViewById(R.id.pop_menu);
            itemView.setOnClickListener(this);
        }
        public void onBind(Consult consult) {
            this.consult = consult;
            txtRoom.setText(consult.getRoom());
            txtName.setText(consult.getName());

            if (consult.getImageVIew() != 0) {
                Glide.with(context)
                        .load(consult.getImageVIew())
                        .apply(RequestOptions.circleCropTransform())
                        .into(imageView);
            }
        }

        @Override
        public void onClick(View view) {

        }
    }

//        @Override
//        public void onClick(View view) {
//            if (listener !=null){
//                listener.onItemClick(getLayoutPosition());
//            }
//        }
//    }
//
//    public void setOnClickListener(ItemClickListener mListener){
//        this.listener = mListener;
//    }
//
//    public interface ItemClickListener{
//        void onItemClick(int position);
//    }
}
