package com.apoorvasingh2810.piechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private float[] yData = {23.9f,11.8f,68.2f,49.7f,46.23f,17.06f,23.9f};

    private String[] xData = {"Virat Kohli","Taylor Swift","Amanda Cerny","Robert","Cristiano Ronaldo","Alexandra","Bhuvan Bam"};

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate: starting to create chart");

        pieChart=(PieChart)findViewById(R.id.pieChart);

        pieChart.setContentDescription("Popularity (in Millons Followers)");
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Popularity Chart");
        pieChart.setCenterTextSize(10);
        pieChart.setDrawEntryLabels(true);
//        pieChart.setUsePercentValues(true);
//        pieChart.setHoleColor(Color.BLUE);
//        pieChart.setCenterTextColor(Color.BLACK);
//        pieChart.setEntryLabelTextSize(20);

        addDataSet(pieChart);

    }

    private void addDataSet(PieChart pieChart) {

        Log.d(TAG,"addDataSet: Started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i=0;i< yData.length;i++)
        {
            yEntrys.add(new PieEntry(yData[i],i));
        }


        for(int i=0;i< xData.length;i++)
        {
            xEntrys.add(xData[i]);
        }

        // TODO create the data set
        PieDataSet pieDataSet= new PieDataSet(yEntrys,"Popularity");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);


        //Adding Colors to DataSet
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.CYAN);
        colors.add(Color.GRAY);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);


        //TODO - Add a legend to chart


    }
}
