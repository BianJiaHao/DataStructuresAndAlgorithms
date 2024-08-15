package com.obito.leetcode;

/**
 * @author admin
 */
public class AddBinary_67
{
    // a = 11 b = 1
    public static String addBinary(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        
        // 进位
        int carry = 0;
        
        // 两个字符串长度的大值
        int n = Math.max(a.length(),b.length());
        
        for (int i = 0; i < n; i++)
        {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        
        // 最后的进位
        if (carry > 0)
        {
            sb.append("1");
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(addBinary("11","1"));
    }
}
