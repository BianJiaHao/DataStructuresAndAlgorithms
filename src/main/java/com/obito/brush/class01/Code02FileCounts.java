package com.obito.brush.class01;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * @author bianjiahao
 * 给定一个文件目录的路径，写一个函数统计这个目录下所有的文件数量并返回，隐藏文件也算，但是文件夹不算
 */
@Slf4j
public class Code02FileCounts {

    /**
     * 使用栈的方法
     * @param filePath 根文件目录
     * @return 文件数量
     */
    public static int way01(String filePath) {
        File root = new File(filePath);
        // 如果既不是文件也不是文件夹直接返回0
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        // 如果根目录就是文件，直接返回1
        if (root.isFile()) {
            return 1;
        }
        // 最后统计的文件数量
        int count = 0;
        // 准备一个栈
        Stack<File> files = new Stack<>();
        files.push(root);
        while (!files.isEmpty()) {
            File popFile = files.pop();
            for (File file : Objects.requireNonNull(popFile.listFiles())) {
                if (file.isFile()) {
                    count++;
                }
                if (file.isDirectory()) {
                    files.push(file);
                }
            }
        }
        return count;
    }

    /**
     * 使用队列的方法
     * @param filePath 根文件目录
     * @return 文件数量
     */
    public static int way02(String filePath) {
        File root = new File(filePath);
        // 如果既不是文件也不是文件夹直接返回0
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        // 如果根目录就是文件，直接返回1
        if (root.isFile()) {
            return 1;
        }
        // 最后统计的文件数量
        int count = 0;
        // 准备一个队列
        Queue<File> files = new LinkedList<>();
        files.add(root);
        while (!files.isEmpty()) {
            File pollFile = files.poll();
            for (File file : Objects.requireNonNull(pollFile.listFiles())) {
                if (file.isFile()) {
                    count++;
                }
                if (file.isDirectory()) {
                    files.add(file);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 文件目录
        String filePath = "D:\\WorkSpace";
        log.info("使用方法一文件数量为：{}",way01(filePath));
        log.info("使用方法二文件数量为：{}",way02(filePath));
    }
}
