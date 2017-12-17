package com.jo.netowrking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Adapter adapter;
    LinearLayoutManager manager;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView)findViewById(R.id.rv);

       /* for(int i=0;i<50;i++)
        items.add(new EarthQuake(2.2,"6.4km from ","Cairo, Egypt", new Date()));
*/

        adapter = new Adapter(this,QueryUtils.getjsonObjects());
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

    }


}
