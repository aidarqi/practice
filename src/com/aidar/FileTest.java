package com.aidar;

import java.io.*;
import java.util.Date;

/**
 * @desc
 * @date 17-7-3
 */
public class FileTest {
    public static void main(String[] args) {
        File f=new File("/home/upsmart/00");
        try{
           /*
            public boolean mkdir() {
                SecurityManager security = System.getSecurityManager();
                if (security != null) {
                    security.checkWrite(path);
                }
                if (isInvalid()) {
                    return false;
                }
                return fs.createDirectory(this);
            }

            public abstract boolean createDirectory(File f);
            */
           //mkdir()只能创建一级目录,文件路径已存在返回false,新建返回true
            System.out.println("mkdir目录: " + f.mkdir());

           /*
           public boolean createNewFile() throws IOException {
                SecurityManager security = System.getSecurityManager();
                if (security != null) security.checkWrite(path);
                if (isInvalid()) {
                    throw new IOException("Invalid file path");
                }
                return fs.createFileExclusively(path);
            }

            public abstract boolean createFileExclusively(String pathname)
        throws IOException;
            */
           //只能在目录已存在的情况下创建文件,文件已存在返回false,新建返回true
            File f1 = new File("/home/upsmart/00/0aaa.txt");
            System.out.println("createNewFile: " + f1.createNewFile());

            System.out.println(f.isDirectory() + ";" + f.isFile() + ";" + f.length());
            System.out.println(f1.isDirectory() + ";" + f1.isFile() + ";" + f1.length());

            //获取目录下所有文件
            File f2 = new File("/home/upsmart/apache-tomcat-8.0.35/webapps/ROOT");
            System.out.println(f2.isDirectory() + ";" + f2.isFile() + ";" + f2.length());
            if(f2.isDirectory()){
                File[] files = f2.listFiles();
                for (File file : files) {
                    System.out.println(file);
                }
            }

//            //删除文件或文件路径
//            if(f1.exists()){
//                f1.delete();
//            }
//            if(f.exists()){
//                f.delete();
//            }

//            f.mkdir();
//            //写文件
//            // true时表示若这个文件存在，则直接往0aaa.txt中追加字符串；默认为false,表示创建新的0aaa.txt(如果之前存在，则删掉)
//            FileWriter fileWriter = new FileWriter("/home/upsmart/00/0aaa.txt", true);
//            fileWriter.write(new Date()+ ";");
//            fileWriter.write("\n");
////            fileWriter.close();
//            //但如果需要写入的内容很多，就应该使用更为高效的缓冲器流类BufferedWriter。
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(new Date() + "");
//            bufferedWriter.newLine();
//            bufferedWriter.write(new Date() + "");
//            bufferedWriter.close();

            System.out.println("@@@@@@@@@@@@@@@@");
            InputStream in = new FileInputStream(f1);
            while(in.read() != -1){
                System.out.print(in.read() + " ");
            }

            System.out.println();
            System.out.println("$$$$$$$$$$$$$$$$");
            //读文件
            FileReader fileReader = new FileReader("/home/upsmart/00/0aaa.txt");
            while (fileReader.read() != -1){
                System.out.print(fileReader.read() + " ");
            }
            fileReader.close();
//            System.out.println("###########");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            while (bufferedReader.readLine() != null){
//                System.out.println(bufferedReader.readLine());
//            }

//            String tempString = null;
//            int line = 1;
//            while ((tempString = bufferedReader.readLine()) != null){
//                System.out.println("line " + line + ": " + tempString);
//                line++;
//            }
//            bufferedReader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
