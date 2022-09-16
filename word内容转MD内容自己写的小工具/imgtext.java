package com.kdy;

import java.io.*;
import java.net.URLEncoder;
import java.util.Scanner;

public class imgtext {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("d://img.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("d://img2.txt"));
        //![](./JAVAWEB%E5%9F%BA%E7%A1%80%E7%AF%87%EF%BC%88%E5%8D%81%E4%B8%83%EF%BC%89/
        System.out.println("请点击下一行，输入需要处理的md文件的文章标题名称：");

        Scanner sc = new Scanner(System.in);

        String dirc = sc.next();

        //String dirc = "JAVAWEB基础篇（十七）";
        String src = "![](./"+URLEncoder.encode(dirc,"utf-8")+"/";

        String line;

        img img = new img();
//        String w666 = img.getImgLineText(line);

        while((line=br.readLine())!=null){
            String w666 = img.getImgLineText(line);
            if (w666!=null) {
//                System.out.println(w666);
//                System.out.println(src + line+".png)");
                if (w666.startsWith("img")){
                    System.out.println(src + w666+")");
                    bw.write(src + w666+")"+"\n");
                    FileInputStream fis =new FileInputStream("C:\\Users\\kongdeyi\\Desktop\\img.files\\"+w666);
                    FileOutputStream fos = new FileOutputStream("C:\\Users\\kongdeyi\\Desktop\\blog\\blog\\source\\_posts\\"+dirc+"\\"+w666);
                    byte[] bytes = new byte[1024];
                    int len =0;
                    while((len = fis.read(bytes))!=-1){
                        fos.write(bytes,0,len);
                    }
                    fos.close();
                    fis.close();
                }else if (w666.startsWith("http")){
                    System.out.println(w666);
                    bw.write(w666+"\n");
                }else if (!w666.startsWith("img")&&!w666.startsWith("http")){
                    System.out.println("##### "+w666);
                    bw.write("##### "+w666+"\n");
                }
            }
            /*if (w666.startsWith("img")){
                System.out.println(w666);
            }*/


            /*if (line.startsWith("1")) {
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }
            else if(line.startsWith("2")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("3")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("4")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("5")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("6")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("7")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("8")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("9")){
                System.out.println(src + line+".png)");
                bw.write(src + line+".png)"+"\n");
            }else if(line.startsWith("http")){
                System.out.println(line);
                bw.write(line+"\n");
            }else{
                System.out.println("##### "+line);
                bw.write("##### "+line+"\n");
            }*/
        }
        br.close();
        bw.close();



    }
}
