package com.util.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.MessageDigest;

import android.content.Context;
import android.util.Log;

/**
 * Created by ce-ztzheng on 2016/3/2.
 * 这个类专门用来编写一些工具
 */
public class Util {
    /**
     * ping一个ip判断是否网络能用,当前好像都ping不通
     *
     * @return
     */
    public boolean ping(String ip) {

        String result = null;
        try {
            ip = "192.168.43.2";// ping 的地址，可以换成任何一种可靠的外网
            Process p = Runtime.getRuntime().exec("/system/bin/ping -c 3 -w 10 " + ip);// ping网址3次
            // 读取ping的内容，可以不加
            InputStream input = p.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            StringBuffer stringBuffer = new StringBuffer();
            String content = "";
            while ((content = in.readLine()) != null) {
                stringBuffer.append(content);
            }
            Log.d("------ping-----", "result content : " + stringBuffer.toString());
            // ping的状态
            int status = p.waitFor();
            if (status == 0) {
                result = "success";
                return true;
            } else {
                result = "failed";
            }
        } catch (IOException e) {
            result = "IOException";
        } catch (InterruptedException e) {
            result = "InterruptedException";
        } finally {
            Log.d("----result---", "result = " + result);
        }
        return false;
    }

    /**
     * 判断一个ip地址是否可达
     *
     * @param ip 需要判断的ip
     * @return
     */
    public boolean isIpReachable(String ip) {
        try {
            InetAddress addr = InetAddress.getByName(ip);
            if (addr.isReachable(3000)) {
                return true;
            }
            return false;
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 从百度获取时间
     *
     * @return
     */
    public long gettimefrombaidu() {
        URL url = null;
        long id = 0;
        try {
            System.out.println("get tiem:");
            url = new URL("http://www.baidu.com");
            URLConnection uc = url.openConnection();
            uc.setConnectTimeout(3000);
            uc.setReadTimeout(3000);
            uc.connect();
            id = uc.getDate();
            System.out.println("id::::::" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    /**
     * spil test
     */
    public void spil(){
        String test="hello|getda";
       String[] buf= test.split("\\|");
        for(String temp:buf){
            System.out.println("temp:"+temp);
        }
    }
    /**
     * md5加密算法
     */
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
