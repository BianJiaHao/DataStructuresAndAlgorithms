package com.obito.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author admin
 */
public class ConvertZ_6
{
    public static String convert(String s, int numRows)
    {
        if (numRows == 1)
        {
            return s;
        }
        // 准备相同行数的队列
        List<Queue<Character>> queueList = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++)
        {
            Queue<Character> queue = new LinkedList<>();
            queueList.add(queue);
        }
        
        char[] charArray = s.toCharArray();
        
        int index = 0;
        
        boolean isAdd = true;
        
        for (int i = 0; i < charArray.length; i++)
        {
            queueList.get(index).add(charArray[i]);
            
            if (index == numRows - 1)
            {
                isAdd = false;
            }
            else if (index == 0)
            {
                isAdd = true;
            }
            
            if (isAdd)
            {
                index++;
            }
            else
            {
                index--;
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        // 输出
        for (Queue<Character> characters : queueList)
        {
            while (!characters.isEmpty())
            {
                Character poll = characters.poll();
                result.append(poll.toString());
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(convert("AB", 1));
    }
}
