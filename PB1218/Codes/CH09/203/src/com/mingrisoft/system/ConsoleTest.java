package com.mingrisoft.system;

import java.io.Console;
import java.util.Arrays;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();// ��oConsole�ﹳ
        String username = console.readLine("�п�J�ϥΪ̦W�١G"); // ��o�ϥΪ̦W��
        char[] password = console.readPassword("�п�J�K�X�G"); // ��o�K�X
        System.out.println("�z���ϥΪ̦W�٬O�G" + username);// ��X�ϥΪ̦W��
        System.out.print("�z���K�X�O�G");
        for (char c : password) {
            System.out.print(c);// ��X�K�X
        }
        Arrays.fill(password, 'a');// �N�x�s�K�X���}�C���������ƻs���za�z
    }
}
