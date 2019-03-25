package com.gzeinnumer.swipewithrecyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //todo 5
    AdapterRV adapter;
    List<DataNo> data;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 6
        data= new ArrayList<>();
        rv = findViewById(R.id.rv);
        for (int i=0; i<10; i++){
            data.add(new DataNo(i));
        }

        adapter = new AdapterRV(this, data);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


        //todo 7
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder drag, @NonNull RecyclerView.ViewHolder drop) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder target, int i) {
                int position  = target.getAdapterPosition();
                data.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(rv);

    }
}
