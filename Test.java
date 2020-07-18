import java.util.Scanner;

public class Test {
    public static void main1(String[] args) {

        // 根据输入的日期，计算是这一年的第几天。
        // 详细描述：
        // 输入某年某月某日，判断这一天是这一年的第几天

        // 接口设计及说明：
        //
        // /*****************************************************************************
        // Description   : 数据转换
        // Input Param   : year 输入年份
        //                Month 输入月份
        //                Day 输入天
        //
        // Output Param  :
        // Return Value  : 成功返回0，失败返回-1（如：数据错误）
        // *****************************************************************************/
        // public static int iConverDateToDay(int year, int month, int day)
        // {
        //     /* 在这里实现功能，将结果填入输入数组中*/
        //     return 0;
        // }
        //
        // /*****************************************************************************
        // Description   :
        // Input Param   :
        //
        // Output Param  :
        // Return Value  : 成功:返回outDay输出计算后的第几天;
        //                                           失败:返回-1
        // *****************************************************************************/
        // public static int getOutDay()
        // {
        //  return 0;
        // }

        // 输入描述:
        // 输入三行，分别是年，月，日
        // 输出描述:
        // 成功:返回 outDay 输出计算后的第几天;

        // 示例:
        // 输入
        // 2012
        // 12
        // 31
        // 输出
        // 366

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int count = 0;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                for (int i = 1; i < month; i++) {
                    if (i < 8) {
                        if (i == 2) {
                            count += 29;
                        } else if (i % 2 == 0) {
                            count += 30;
                        } else {
                            count += 31;
                        }
                    } else {
                        if (i % 2 == 0) {
                            count += 31;
                        } else {
                            count += 30;
                        }
                    }
                }
                count += day;
            } else {
                for (int i = 1; i < month; i++) {
                    if (i < 8) {
                        if (i == 2) {
                            count += 28;
                        } else if (i % 2 == 0) {
                            count += 30;
                        } else {
                            count += 31;
                        }
                    } else {
                        if (i % 2 == 0) {
                            count += 31;
                        } else {
                            count += 30;
                        }
                    }
                }
                count += day;
            }
            System.out.println(count);
        }
    }

    public static void main2(String args[]) {

        // 1、对输入的字符串进行加解密，并输出。
        // 2、加密方法为：
        // 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写
        // 如字母 a 时则替换为 B；字母 Z 时则替换为 a；
        // 当内容是数字时则把该数字加 1，如 0 替换 1，1 替换 2，9 替换 0；
        // 其他字符不做变化。
        // 3、解密方法为加密的逆过程。

        // 接口描述：
        // 实现接口，每个接口实现 1 个基本操作：
        // void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出

        // 说明：
        // 1、字符串以 \0 结尾。
        // 2、字符串最长 100 个字符。
        // int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出

        //说明：
        // 1、字符串以 \0 结尾。
        // 2、字符串最长 100 个字符。

        // 输入描述:
        // 输入说明
        // 输入一串要加密的密码
        // 输入一串加过密的密码
        // 输出描述:
        // 输出说明
        // 输出加密后的字符
        // 输出解密后的字符

        // 示例:
        // 输入
        // abcdefg
        // BCDEFGH
        // 输出
        // BCDEFGH
        // abcdefg

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            enCryption(s1);
            deCryption(s2);
        }
        sc.close();
    }
    public static void enCryption(String s1) {
        // 加密
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] < 'z') {
                chars[i] = (char)(chars[i] + 1 - 32);
            } else if (chars[i] >= 'A' && chars[i] < 'Z') {
                chars[i] = (char)(chars[i] + 1 + 32);
            } else if (chars[i] >= '0' && chars[i] < '9') {
                chars[i] = (char)(chars[i] + 1);
            } else if (chars[i] == '9') {
                chars[i] = '0';
            } else if (chars[i] == 'Z') {
                chars[i] = 'a';
            } else if (chars[i] == 'z') {
                chars[i] = 'A';
            }
        }
        System.out.println(chars);
    }
    public static void deCryption(String s2) {
        // 解密
        char[] chars = s2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'a' && chars[i] <= 'z') {
                chars[i] = (char)(chars[i] - 1 - 32);
            } else if (chars[i] > 'A' && chars[i] <= 'Z') {
                chars[i] = (char)(chars[i] - 1 + 32);
            } else if (chars[i] > '0' && chars[i] <= '9') {
                chars[i] = (char)(chars[i] - 1);
            } else if (chars[i] == '0') {
                chars[i] = '9';
            } else if (chars[i] == 'a') {
                chars[i] = 'Z';
            } else if (chars[i] == 'A') {
                chars[i] = 'z';
            }
        }
        System.out.println(chars);
    }
}
