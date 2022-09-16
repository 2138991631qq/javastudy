package com.kdy;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class img {

    String s777;
    public String getImgLineText(String str2) {
//        System.out.println(str2);
        String str4 = "mso-font-kerning:1.0000pt;\"><font face=\"宋体\">如果是在一个服务器，随着业务功能的不断完善，各个模块的代码会耦合在一起，不利于维护：</font></span><span style=\"mso-spacerun:'yes';font-family:宋体;font-size:10.5000pt;";
        String str5 = "mso-font-kerning:1.0000pt;\"><font face=\"Times New Roman\">3</font></span><span style=\"mso-spacerun:'yes';font-family:宋体;font-size:10.5000pt;";
        String str3 = "mso-font-kerning:1.0000pt;\"><font face=\"宋体\">当服务</font><font face=\"Times New Roman\">A</font><font face=\"宋体\">调用服务</font><font face=\"Times New Roman\">B</font><font face=\"宋体\">，不需要</font><font face=\"Times New Roman\">A</font><font face=\"宋体\">记录</font><font face=\"Times New Roman\">B</font><font face=\"宋体\">的</font><font face=\"Times New Roman\">IP</font><font face=\"宋体\">和端口，只需要找到注册中心拉取就可以。</font></span><span style=\"mso-spacerun:'yes';font-family:宋体;font-size:10.5000pt;";
        String str = "font-size:10.5000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\"><img width=\"553\" height=\"137\" src=\"img.files/img8.png\"><span style=\"mso-spacerun:'yes';font-family:宋体;font-size:10.5000pt;";
        String str6 = "mso-font-kerning:1.0000pt;\"><font face=\"宋体\">一个请求调用服务</font><font face=\"Times New Roman\">A</font><font face=\"宋体\">，可能继续</font><font face=\"Times New Roman\">A</font><font face=\"宋体\">调用</font><font face=\"Times New Roman\">B</font><font face=\"宋体\">，</font><font face=\"Times New Roman\">B</font><font face=\"宋体\">调用</font><font face=\"Times New Roman\">C</font><font face=\"宋体\">。</font></span><span style=\"mso-spacerun:'yes';font-family:宋体;font-size:10.5000pt;";
        int i = str.indexOf("font face");

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<String> list5 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        String separator = ",";
        StringBuilder sb = new StringBuilder();


        int i2 = str2.indexOf("font face");
        int i22 = str2.indexOf("font face");
        int i3 = str2.indexOf("</font>");

        String s66 = null;
        String s00 = null;

        while (i2 > -1) {
            list.add(i2);
            i2 = str2.indexOf("font face", i2 + 8);
        }
        while (i3 > -1) {
            list3.add(i3);
            i3 = str2.indexOf("</font>", i3 + 5);
        }
        for (int i00 = 0; i00 <= list.size() - 1; i00++) {
            map.put(list.get(i00), list3.get(i00));
        }
        if (i22 > -1) {
//            System.out.println("为字体内容"+i22);
            for (Integer i0 : list) {
                Character l000 = str2.charAt(i0 + 11);
                String ls00 = l000.toString();
                if (ls00.equals("T")) {
                    String a220 = str2.substring(i0 + 11, i0 + 26);
                    boolean b1 = a220.equals("Times New Roman");
                    s00 = str2.substring(i0 + 28, map.get(i0));
                    if (b1) {
                        list5.add(s00);
                    }
                } else if (ls00.equals("宋")) {
                    String a220 = str2.substring(i0 + 11, i0 + 13);
                    if (a220.equals("宋体")) {
                        s66 = str2.substring(i0 + 15, map.get(i0));
                        list5.add(s66);
                    }
                }
            }
            for (int i666 = 0; i666 < list.size(); i666++) {
                if (i666 == list5.size() - 1) {
                    sb.append(list5.get(i666));
                } else {
                    sb.append(list5.get(i666));
                    sb.append(separator);
                }
            }
            String s666=sb.toString();
            s777 =s666.replaceAll(",", "");
//            System.out.println(list5);
//            System.out.println(s777);
        } else if (i2 == -1) {

            int i5 = str2.indexOf("<img");
            if (i5 > -1) {
                int i6 = str2.indexOf("src");
                if (i6 > -1) {
                    int i66 = str2.indexOf("img", i6+1);
                    if(i66>-1) {
                        int i7 = str2.indexOf("png");
//                    System.out.println(i6);
//                    System.out.println(i66);
//                    System.out.println(i7);
                        String w0 = str2.substring(i66 + 10, i7 + 3);
//                    System.out.println(w0);
                        s777 = w0;
                    }else if(i66==-1){
                        s777=null;
                    }
                }else if(i6==-1){
                    s777=null;
                }
            }else if(i5==-1){
                s777=null;
            }
        }
        return s777;
    }
}

