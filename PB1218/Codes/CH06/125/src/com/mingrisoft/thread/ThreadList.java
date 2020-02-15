package com.mingrisoft.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadList {
    private static ThreadGroup getRootThreadGroups() {//��o�ڽu�{��
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();//��o�ثe�u�{��
        while (true) {
            if (rootGroup.getParent() != null) {//�p�GgetParent()�Ǧ^�ȫD�ūh���O�ڽu�{��
                rootGroup = rootGroup.getParent();//��o���u�{��
            } else {
                break;//�p�G��F�ڽu�{�իh�h�X�`��
            }
        }
        return rootGroup;//�Ǧ^�ڽu�{��
    }
    public static List<String> getThreads(ThreadGroup group) {//��o���w�u�{�դ��Ҧ��u�{�W
        List<String> threadList = new ArrayList<String>();      //�إ��x�s�u�{�W���C��
        Thread[] threads = new Thread[group.activeCount()]; //�ھڬ��ʽu�{�ƫإ߽u�{�}�C
        int count = group.enumerate(threads, false);//�ƻs�u�{��u�{�}�C
        for (int i = 0; i < count; i++) {//�ˬd�u�{�}�C�N�u�{�W�Ψ�Ҧb���x�s��C��
            threadList.add(group.getName() + "�u�{�աG" + threads[i].getName());
        }
        return threadList;//�Ǧ^�C��
    }
    public static List<String> getThreadGroups(ThreadGroup group) {//��o�u�{�դ��Ҧ��u�{
        List<String> threadList = getThreads(group);    //��o���w�u�{�դ��u�{�W
        ThreadGroup[] groups = new ThreadGroup[group.activeGroupCount()];//�إ߽u�{�հ}�C
        int count = group.enumerate(groups, false); //�ƻs�l�u�{�ը�u�{�ո��
        for (int i = 0; i < count; i++) {//�ˬd�Ҧ��l�u�{��
            threadList.addAll(getThreads(groups[i]));// �Q��getThreads()��k��o�u�{�W�C��
        }
        return threadList;//�Ǧ^�Ҧ��u�{�W
    }
    public static void main(String[] args) {
        for (String string : getThreadGroups(getRootThreadGroups())) {
            System.out.println(string);//�ˬd��X�C�����r��
        }
    }
}
