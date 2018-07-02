package com.apoorvasingh2810.piechart;

import android.Manifest;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

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

        addDataSet();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value select from chart");
                Log.d(TAG,"onValueSelected "+ e.toString());
                Log.d(TAG,"onValueSelected "+ h.toString());

                int pos1 = e.toString().indexOf("y: "); // total characters in ": " = 1(One)
                String followers= e.toString().substring(pos1 + 3);

                Log.d(TAG,"Followers: "+followers);

                for (int i=0;i<yData.length;i++){
                    if(yData[i]==Float.parseFloat(followers)){
                        pos1=i;
                        break;
                    }
                }
                String celebrity =xData[pos1 + 1];
                Toast.makeText(MainActivity.this,"Celebrity "+celebrity+"\n"+"Followers: "+followers+" Million",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });

    }

    private void addDataSet() {

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

        //Completed_TODO create the data set
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


        //Completed_TODO - Add a legend to chart

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }
}
