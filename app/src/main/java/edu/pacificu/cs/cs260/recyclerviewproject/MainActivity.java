package edu.pacificu.cs.cs260.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRV = findViewById(R.id.rvList);
        mRV.setHasFixedSize(true);
        mRV.setLayoutManager(new LinearLayoutManager(this));
        List<DataModel> allData = new ArrayList();

        allData.add(new DataModel("CS", "Pacific"));
        allData.add(new DataModel("Go", "Boxers"));
        allData.add(new DataModel("Strain", "Price"));
        allData.add(new DataModel("Marsh", "Scott"));
        allData.add(new DataModel("Math", "Oregon"));
        allData.add(new DataModel("Data Science", "Forest Grove"));
        allData.add(new DataModel("Red", "Black"));
        allData.add(new DataModel("Up", "Down"));
        allData.add(new DataModel("Left", "Right"));
        allData.add(new DataModel("Table", "Chair"));
        allData.add(new DataModel("Android", "Phone"));

        DataModelRecyclerViewAdapter adapter = new DataModelRecyclerViewAdapter (allData);

        mRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}