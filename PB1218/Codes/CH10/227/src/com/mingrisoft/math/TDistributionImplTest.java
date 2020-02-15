package com.mingrisoft.math;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.TDistributionImpl;

public class TDistributionImplTest {
    public static void main(String[] args) throws MathException {
        TDistributionImpl t = new TDistributionImpl(5);// �s�W�@�Ӧۥѫ׬�5��T���G
        System.out.println("�ثeT���G���ۥѫסG" + t.getDegreesOfFreedom());
        double upperTail = t.cumulativeProbability(0.7267);
        System.out.println("�p���j��0.7267���m�H�סG" + upperTail);
        System.out.println("�p��0�I�����v�K�סG" + t.density(0));
        double domain = t.inverseCumulativeProbability(0.75);
        System.out.println("�p��m�H�פj��0.75����ȡG" + domain);
    }
}
