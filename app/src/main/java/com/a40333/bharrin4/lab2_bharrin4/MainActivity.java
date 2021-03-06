package com.a40333.bharrin4.lab2_bharrin4;

//import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //specific game info
        final ArrayList <Team> arr = new ArrayList<Team>();
        arr.add(new Team(new String [] {"Saturday, February 11, 6:00pm", "Purcell Pavilion at the Joyce Center, Notre Dame, Indiana", "fsu_sports_logo",
        "Florida State", "Seminoles", "(21-5)", "72-84", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));
        arr.add(new Team(new String [] {"Tuesday, February 14, 7:00pm", "Silvio O. Conte Forum, Chestnut Hill, Massachusetts", "bc_logo",
                "Boston College", "Eagles", "(9-18)", "76-84", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));
        arr.add(new Team(new String [] {"Saturday, February 18, 12:00pm", "PNC Area, Raleigh, North Carolina", "nc_state",
                "North Carolina State", "Wolfpack", "(14-14)", "72-81", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));
        arr.add( new Team(new String [] {"Sunday, February 26, 6:30pm", "Purcell Pavilion at the Joyce Center, Notre Dame, Indiana", "gtech_logo",
                "Georgia Tech", "Yellow Jackets", "(15-11)", "@", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));
        arr.add( new Team(new String [] {"Wednesday, March 1, 8:00pm", "Purcell Pavilion at the Joyce Center, Notre Dame, Indiana", "bc_logo",
                "Boston College", "Eagles", "(9-18)", "@", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));
        arr.add( new Team(new String [] {"Saturday, March 4, 2:00pm", "KFC Yum! Center, Louisville, Kentucky", "louisville",
                "Louisville", "Cardinals", "(22-5)", "@", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));
        arr.add( new Team(new String [] {"Tuesday, March 7, 12:00pm", "Barclay's Center, New York, New York", "acc",
                "ACC Tournament", "N/A", "N/A", "@", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));
        arr.add( new Team(new String [] {"Thursday, March 16", "N/A", "ncaa",
                "NCAA Tournament", "N/A", "N/A", "@", "Final", "Notre Dame", "Fighting Irish", "(21-7)", "nd_logo", "Camera"}));

        MyCsvFileReader myCsvFileReader = new MyCsvFileReader(getApplicationContext());
        String mDrawableName = "schedule";
        int resID = getResources().getIdentifier(mDrawableName , "raw", getPackageName());
        Log.d("tag", "resID="+resID);
        final ArrayList <String []> al = myCsvFileReader.readCsvFile(resID);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getApplicationContext(), al);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);
        scheduleListView.setAdapter(scheduleAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra("team", arr.get(position));
                startActivity(mIntent);
            }
        };
        // this will automatically attach the listener to each item of the listview.
        scheduleListView.setOnItemClickListener (clickListener);
    }

}
