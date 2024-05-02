package org.example;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartUtils;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import static org.junit.Assert.assertEquals;

public class tests {
    public long time_of_min(String fileName) throws IOException {
        long startTime = System.currentTimeMillis();
        long mn = Main._min(Main.read_File(fileName));
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    @Test
    public void testMin() throws IOException {
        assertEquals(1, Main._min(Main.read_File("numbers.txt")));
        assertEquals(1, Main._min(Main.read_File("test_numbers1.txt")));
    }

    @Test
    public void testMax() throws IOException {
        assertEquals(10, Main._max(Main.read_File("numbers.txt")));
        assertEquals(100, Main._max(Main.read_File("test_numbers1.txt")));
    }

    @Test
    public void testSum() throws IOException {
        assertEquals("23", Main._sum(Main.read_File("numbers.txt")));
        assertEquals("49850", Main._sum(Main.read_File("test_numbers1.txt")));
    }

    @Test
    public void testMult() throws IOException {
        assertEquals("420", Main._mult(Main.read_File("numbers.txt")));
        assertEquals("12987181909321218307957514313453316018900483108133415436327577987093870330088364075159658028151303610113394244450904976324001689163208378236624540691869018285971900162239970227929109242324102610093927983506019113800623847337508984936351977479957725436885007753858415452820221182273207324600663770471026269579112301155385840404833497875231601467539663995908124086349044822920299241382365209877816697185040302059904638087350771651396093544126701796728717522909341256798986136252499905606871076442958195915302304998685254380984590881583471899029282663183262814058800095929939891824761161754851116823922850881016914266593393443138557211055711105599577582030631374054748981529092661257597034242616936767555725449688182272800956641515924944292869193616608064111661653427620273303630591458142382145434644339599826743843187404289196335773864973248646940859911748851752403313487750406540989227813372949659164700279799513132622707092293793358589025719312025183042481678585694653197961126746441957023728714963262576992154430042484440164640823361876679986359714895119294971399484857427997978954821957124202048766053591710363512222273947968102633048046984348854654849540737386245062403144954238283067535670062589535682619586330764349107226589428531816556614075575522554563869938732355282302165211287345179264002765498095046066392068634369018218137420352716800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", Main._mult(Main.read_File("test_numbers1.txt")));
    }

    @Test
    public void testEven() throws IOException {
        assertEquals("2", Main._even(Main.read_File("numbers.txt")));
        assertEquals("496", Main._even(Main.read_File("test_numbers1.txt")));
    }

    @Test
    public void test_Time() throws IOException {
        XYSeries series = new XYSeries("Execution Time vs File Size");
        double[] sizes = {5, 1000, 10000, 100000, 1000000};
        double[] file_time = new double[5];
        long time;
        int k = 0;
        String fileName = "numbers.txt";
        long startTime = System.currentTimeMillis();
        Main.main(new String[]{fileName});
        long endTime = System.currentTimeMillis();
        time = endTime-startTime;
        file_time[k] = time;

        series.add(5, time_of_min(fileName));

        System.out.println("Время выполнения для 5 чисел: " + (time) + " мс");

        startTime = System.currentTimeMillis();
        fileName = "test_numbers1.txt";
        Main.main(new String[]{fileName});
        endTime = System.currentTimeMillis();
        ++k;
        time = endTime-startTime;
        file_time[k] = time;

        series.add(1000, time_of_min(fileName));
        System.out.println("Время выполнения для 1000 чисел: " + (time) + " мс");

        startTime = System.currentTimeMillis();
        fileName = "test_numbers2.txt";
        Main.main(new String[]{fileName});
        endTime = System.currentTimeMillis();
        ++k;
        time = endTime-startTime;
        file_time[k] = time;

        series.add(10000, time_of_min(fileName));
        System.out.println("Время выполнения для 10000 чисел: " + (time) + " мс");

        startTime = System.currentTimeMillis();
        fileName = "test_numbers3.txt";
        Main.main(new String[]{fileName});
        endTime = System.currentTimeMillis();
        ++k;
        time = endTime-startTime;
        file_time[k] = time;

        series.add(100000, time_of_min(fileName));
        System.out.println("Время выполнения для 100000 чисел: " + (time) + " мс");

        startTime = System.currentTimeMillis();
        fileName = "test_numbers4.txt";
        Main.main(new String[]{fileName});
        endTime = System.currentTimeMillis();
        ++k;
        time = endTime-startTime;
        file_time[k] = time;

        series.add(1000000, time_of_min(fileName));
        System.out.println("Время выполнения для 1000000 чисел: " + (time) + " мс");

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "the dependence of the execution time of the MIN function on the amount of numbers in the file",
                "File Size",
                "Time (ms)",
                dataset
        );
        ChartUtils.saveChartAsPNG(new File("histogram.png"), chart, 450, 400);
    }
}
