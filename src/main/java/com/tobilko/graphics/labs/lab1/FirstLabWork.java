package com.tobilko.graphics.labs.lab1;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.tobilko.graphics.config.CurrentLab;
import com.tobilko.graphics.config.Lab;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Scanner;

/**
 *
 * Created by Andrew Tobilko on 18/09/16.
 *
 */
@Component
@CurrentLab
public class FirstLabWork implements Lab {

    private void draw(XYZSeries firstSeries, XYZSeries secondSeries) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        XYZSeriesCollection data = new XYZSeriesCollection();

        data.add(firstSeries);
        data.add(secondSeries);
        Chart3D chart = Chart3DFactory.createScatterChart("", "", data, "X", "Y", "Z");

        Chart3DPanel chartPanel = new Chart3DPanel(chart);

        frame.setContentPane(chartPanel);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    //do not try to deal with this mess
    public @Override void perform() {
        double a = 2, b = 2, c = 3, d = 4, k = 10, x = 0, step = 0.1, xt, yt, zt;
        Scanner in = new Scanner(System.in);
        XYZSeries xyz1 = new XYZSeries("accurate");
        XYZSeries tpoint = new XYZSeries("vcxz");

        System.out.println("T(x, y, z) = ");

        tpoint.add(xt = in.nextDouble(), yt = in.nextDouble(), zt = in.nextDouble());
        for (int i = 0; i < k; i++, x += step) xyz1.add(x, a * x + b, c * x + d);
        draw(xyz1, tpoint);

        System.out.println("The length: " + (step * xt + a * step * yt + c * step * zt));
    }

}
