package com.mukul.randomuserdetails;


import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.mukul.randomuserdetails.models.Result;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViweHolder> {

    List<Result> resultList;


    public AdapterClass(List<Result> resultList) {
        this.resultList = resultList;


    }

    @NonNull

    @Override
    public ViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViweHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.details_and_url, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViweHolder holder, int position) {

        Result object = resultList.get(position);


        holder.name.setText("Name - " + object.getName().getTitle() + " " + object.getName().getFirst().toString() + " " + object.getName().getLast().toString());
        holder.email.setText("Email - "+object.getEmail().toString());
        holder.age.setText(object.getGender().toString()+","+object.getDob().getAge().toString());

        holder.phone.setText("Mob No.- "+object.getPhone().toString());
        holder.location.setText("Add. - "+object.getLocation());



        //String time = convertDate(object.getProperties().getTime().toString(), "dd/MM/yyyy hh:mm:ss");
        //holder.timeTV.setText("Time - " + time);

        Glide
                .with(holder.imageView)
                .load(object.getPicture().getLarge())
                .circleCrop()
                .placeholder(R.drawable.dp)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViweHolder extends RecyclerView.ViewHolder {
        TextView name,age, email,phone,location;
        ImageView imageView;

        public ViweHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTV);
            imageView = itemView.findViewById(R.id.image);
            email = itemView.findViewById(R.id.emailTV);
            age = itemView.findViewById(R.id.ageTV);

            phone = itemView.findViewById(R.id.phoneTV);
            location = itemView.findViewById(R.id.locationTV);


        }
    }

    public static String convertDate(String dateInMilliseconds, String dateFormat) {
        return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString();
    }


}
