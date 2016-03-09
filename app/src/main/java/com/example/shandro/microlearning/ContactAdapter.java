package com.example.shandro.microlearning;

/**
 * Created by shandro on 12/4/2015.
 */
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private BValues contactList[];

    public ContactAdapter(BValues[] contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.length;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder,int i) {
        BValues ci = contactList[i];
        Log.v("checker", Integer.toString(ci.getImageRes()));
        contactViewHolder.image.setImageResource(ci.getImageRes());
        CardView cardView = contactViewHolder.cardView;
        cardView.setTag(i);

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardView itemView = (CardView)LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }



    public static class ContactViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        protected ImageView image;
        private CardView cardView;

        public ContactViewHolder(View v) {
            super(v);
            image = (ImageView)v.findViewById(R.id.image);
            cardView = (CardView)v.findViewById(R.id.card_view);

            cardView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            String position = (int)v.getTag() + "";
            if(Integer.valueOf(position) < 4) {
                Intent intent = new Intent(cardView.getContext(), DetailActivity.class);
                intent.putExtra("POSITION", position);
                cardView.getContext().startActivity(intent);
                Log.v("here2", "at lead");
            }
            else if(Integer.valueOf(position) == 4)
            {

                Intent intent = new Intent(cardView.getContext(), OptionsActivity.class);
                cardView.getContext().startActivity(intent);
            }
            else
            {

                Intent intent = new Intent(cardView.getContext(), LeaderBoard.class);
                cardView.getContext().startActivity(intent);
            }
        }
    }
}