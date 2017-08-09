package com.aidar.designpattern;

/**
 * @desc
 * @date 17-6-27
 */
public class ChartDisplay {
    public AbstractChar chart;
    public void setChart(AbstractChar chart1){
        this.chart = chart1;
    }
    public void display(){
        chart.display();
    }
}
