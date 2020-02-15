package com.mingrisoft.generic;

public class GenericArrayTest {
    public static void main(String[] args) {
        System.out.println("�إ�String���A���}�C�æV��W�[�����G������");
        GenericArray<String> stringArray = new GenericArray<String>(String.class, 10);
        stringArray.put(0, "������");
        System.out.println("String���A���}�C�����G" + stringArray.get(0));
        System.out.println("�إ�Integer���A���}�C�æV��W�[�����G123456789");
        GenericArray<Integer> integerArray = new GenericArray<Integer>(Integer.class, 10);
        integerArray.put(0, 123456789);
        System.out.println("Integer���A���}�C�����G" + integerArray.get(0));
    }
}
