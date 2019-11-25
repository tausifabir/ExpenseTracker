package com.example.expensetracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    private Context context;
    private List<Expense>expenseList;


    public ExpenseAdapter(@NonNull Context context, List<Expense>expenseslist) {
        super(context, R.layout.expense_row, expenseslist);
        this.context = context;
        this.expenseList = expenseslist;
    }



    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.expense_row,parent,false);


        final TextView typeTV = convertView.findViewById(R.id.inputType);
        final TextView amountTV = convertView.findViewById(R.id.amountselect);
        final TextView dateshow = convertView.findViewById(R.id.selected_date);





        typeTV.setText(expenseList.get(position).getInputType());
        amountTV.setText(expenseList.get(position).getAmount());
        dateshow.setText(expenseList.get(position).getDate());




        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expense expense = Expense.expenseList.get(position);
                context.startActivity(new Intent(context, HomeActivity.class)
                        .putExtra("expense", expense));
            }
        });

        return convertView;
    }
}
