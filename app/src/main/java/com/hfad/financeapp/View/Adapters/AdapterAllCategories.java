package com.hfad.financeapp.View.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.financeapp.Repository.CategoryClass;

import java.util.ArrayList;

import static com.hfad.financeapp.R.id;
import static com.hfad.financeapp.R.layout;


    // адаптер
    public class AdapterAllCategories extends RecyclerView.Adapter <AdapterAllCategories.ViewHolder> {


    public View view;
    public LayoutInflater layoutInflater;
    private ArrayList <CategoryClass> arrayCategory;


        // конструктор
    public AdapterAllCategories(Context context, ArrayList<CategoryClass> arrayCategory){
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayCategory = arrayCategory;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = layoutInflater.inflate(layout.category_card, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final CategoryClass categoryObj = arrayCategory.get(position);

        holder.textNameCategory.setText(categoryObj.getName());

        holder.textValues.setText(Integer.toString(categoryObj.getSummValue()));

    }


    @Override
    public int getItemCount() {
        return arrayCategory.size();
    }


    // класс держатель вида
    class ViewHolder extends RecyclerView.ViewHolder{

        final TextView textNameCategory;
        final TextView textValues;
        final LinearLayout layoutItemCategory;

        // конструктор класса
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNameCategory = itemView.findViewById(id.textNameCategory);
            textValues = itemView.findViewById(id.textValues);
            layoutItemCategory = itemView.findViewById(id.layoutItemCategory);
        }
    }

}
