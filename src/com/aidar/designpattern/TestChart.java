package com.aidar.designpattern;

/**
 * @desc
 * @date 17-6-27
 */
public class TestChart {

    public static void main(String[] args) {
        ChartDisplay chartDisplay = new ChartDisplay();
        PieChart pieChart = new PieChart();
        BarChart barChart = new BarChart();
        chartDisplay.setChart(pieChart);
        chartDisplay.display();
        chartDisplay.setChart(barChart);
        chartDisplay.display();
    }

}
