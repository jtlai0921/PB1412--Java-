package com.mingrisoft.math;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

public class DescriptiveStatisticsTest {
    public static void main(String[] args) {
        DescriptiveStatistics ds = new DescriptiveStatistics(10);
        for (int i = 0; i < 10; i++) {
            ds.addValue(new Random().nextInt(10));// �V��ƶ����W�[10�Ӥp��10���H���ܼ�
        }
        System.out.println("��ƶ��������������G");
        System.out.println(Arrays.toString(ds.getValues()));
        System.out.println("��ƶ�����ƥ����ƬO�G" + ds.getMean());
        System.out.println("��ƶ����X�󥭧��ƬO�G" + ds.getGeometricMean());
        System.out.println("��ƶ�����t�O�G" + ds.getVariance());
        System.out.println("��ƶ����зǤ�t�O�G" + ds.getStandardDeviation());
        System.out.println("��ƶ����M�O�G" + ds.getSum());
        System.out.println("��ƶ�������M�O�G" + ds.getSumsq());
        System.out.println("��ƶ����̤j�ȬO�G" + ds.getMax());
        System.out.println("��ƶ����̤p�ȬO�G" + ds.getMin());
        System.out.println("��ƶ�������ƬO�G" + ds.getPercentile(50));
        System.out.println("��ƶ������׬O�G" + ds.getSkewness());
        System.out.println("��ƶ����p�׬O�G" + ds.getKurtosis());
    }
}
