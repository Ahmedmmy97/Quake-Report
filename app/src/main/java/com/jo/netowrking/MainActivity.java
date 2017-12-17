package com.jo.netowrking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
        EarthQuakesAsync task = new EarthQuakesAsync();
        task.execute(QueryUtils.createHTTPRequest());

    }
    private   class EarthQuakesAsync extends AsyncTask<URL, Void, List<EarthQuake>> {

        @Override
        protected List<EarthQuake> doInBackground(URL... params) {
            String Json=null;
            try {
               // URL url = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10");
                Json = QueryUtils.makeHttpRequest(params[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return QueryUtils.getjsonObjects(Json);
        }

        @Override
        protected void onPostExecute(List<EarthQuake> earthQuakes) {
            adapter = new Adapter(MainActivity.this,earthQuakes);
            manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false);
            rv.setLayoutManager(manager);
            rv.setAdapter(adapter);
        }
    }

}
