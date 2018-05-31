package com.attra.wirecard.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.attra.wirecard.R;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportsFragment extends Fragment {

    private static int[] COLORS = new int[] { Color.LTGRAY, Color.BLUE, Color.CYAN, Color.DKGRAY,Color.BLACK, Color.RED};

    private static double[] VALUES = new double[] { 23.17, 5.55, 10.64, 22.46, 21.28, 5.91 };

    private static String[] NAME_LIST = new String[] { "Transfer Money", "E-commerce", "Shopping", "Restaurants", "Fuel", "Miscellaneous" };

    private CategorySeries mSeries = new CategorySeries("");

    private DefaultRenderer mRenderer = new DefaultRenderer();

    private GraphicalView mChartView;
    LinearLayout layout;
    public ReportsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.argb(100, 50, 50, 50));*/
        mRenderer.setChartTitleTextSize(25);
        mRenderer.setLabelsTextSize(30);
        mRenderer.setLabelsColor(R.color.black);
        mRenderer.setLegendTextSize(40);
        mRenderer.setMargins(new int[] { 20, 30, 15, 0 });
        mRenderer.setClickEnabled(false);
        /*mRenderer.setZoomButtonsVisible(true);*/
        /*mRenderer.setSt(90);*/

        for (int i = 0; i < VALUES.length; i++) {
            mSeries.add(NAME_LIST[i] + " " + VALUES[i], VALUES[i]);
            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
            renderer.setColor(COLORS[(mSeries.getItemCount() - 1) % COLORS.length]);
            mRenderer.addSeriesRenderer(renderer);
        }

        if (mChartView != null) {
            mChartView.repaint();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        if (mChartView == null) {

            mChartView = ChartFactory.getPieChartView(getActivity().getApplicationContext(), mSeries, mRenderer);
            mRenderer.setClickEnabled(true);
            mRenderer.setSelectableBuffer(10);

            mChartView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SeriesSelection seriesSelection = mChartView.getCurrentSeriesAndPoint();

                    if (seriesSelection == null) {
/*
                        Toast.makeText(getActivity().getApplicationContext(),"No bobgraphland element was clicked",Toast.LENGTH_SHORT).show();
*/
                    }
                    else {
                        Toast.makeText(getActivity().getApplicationContext(),"Chart element data point index "+ (seriesSelection.getPointIndex()+1) + " was clicked" + " point value="+ seriesSelection.getValue(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            mChartView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    SeriesSelection seriesSelection = mChartView.getCurrentSeriesAndPoint();
                    if (seriesSelection == null) {
/*
                        Toast.makeText(getActivity().getApplicationContext(),"No bobgraphland element was long pressed", Toast.LENGTH_SHORT);
*/
                        return false;
                    }
                    else {
                        Toast.makeText(getActivity().getApplicationContext(),"Chart element data point index "+ seriesSelection.getPointIndex()+ " was long pressed", Toast.LENGTH_SHORT);
                        return true;
                    }
                }
            });
            layout.addView(mChartView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        else {
            mChartView.repaint();
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reports, container, false);
        layout = (LinearLayout) view.findViewById(R.id.chart);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Reports");

    }
}
