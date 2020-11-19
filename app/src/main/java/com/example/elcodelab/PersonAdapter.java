package com.example.elcodelab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
private Context context;

private List<PersonReference> personReferenceList;

protected static class PersonViewHolder extends RecyclerView.ViewHolder{
    protected TextView viewName;
    protected RatingBar viewRating;


    public PersonViewHolder (View itemView){
        super(itemView);
        viewName = (TextView) itemView.findViewById(R.id.nameView);
        viewRating = (RatingBar) itemView.findViewById(R.id.ratingView);
    }
}


    public PersonAdapter(List<PersonReference> list){

        this.personReferenceList = list;
    }

    public PersonAdapter(Context context, List<PersonReference> personReferenceList){
        this.context = context;
        this.personReferenceList = personReferenceList;
        Collections.reverse(personReferenceList);
    }

    public void setPersonReferenceList(List<PersonReference> personReferenceList) {
        this.personReferenceList = personReferenceList;
        notifyDataSetChanged();
    }


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int index){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.ref_row, parent, false);

        PersonViewHolder viewHolder = new PersonViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder viewHolder, int index){
        PersonReference person = personReferenceList.get(index);
        viewHolder.viewName.setText(person.getReferenceName());
        viewHolder.viewRating.setRating(person.getRate());
    }

    @Override
    public int getItemCount() {

        return personReferenceList.size();
    }

}
