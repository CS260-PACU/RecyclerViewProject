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

        DataModelRecyclerViewAdapter adapter = new DataModelRecyclerViewAdapter (allData);

        mRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}