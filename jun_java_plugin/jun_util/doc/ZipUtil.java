package org.myframework.util;

import java.io.*; 
import java.util.zip.*; 
/** 
*����:zipѹ������ѹ 
*˵��:������ͨ��ZipOutputStream��ZipInputStreamʵ����zipѹ���ͽ�ѹ����. 
*����:����java.util.zip������֧�ֺ���,��zip�ļ���������Ϊ���ĵ��ļ�ʱ 
, author by http://www.bt285.cn http://www.5a520.cn 
*     �ͻ�����쳣:"Exception in thread "main " java.lang.IllegalArgumentException 
*               at   java.util.zip.ZipInputStream.getUTF8String(ZipInputStream.java:285) 
*���: 
*��������1���޸�import java.util.zip.ZipInputStream��ZipOutputStream. 
*          java.util.zipֻ֧��UTF-8,Ant�������ָ������. 
*��������2��ʹ��Apache Ant���ṩ��zip���ߡ� 
*          ��ʹ��java.util.zip�İ�,��ant.jar�ŵ�classpath��. 
*          ������ʹ��import org.apache.tools.zip.*; 
* 
*�������ѧϰ�ο�. 
* 
*@author Winty 
*@date   2008-8-3 
*@Usage: 
*   ѹ��:java Zip -zip "directoryName" 
*   ��ѹ:java Zip -unzip "fileName.zip" 
*/ 

public class ZipUtil{ 
    private ZipInputStream zipIn;      //��ѹZip 
    private ZipOutputStream zipOut;     //ѹ��Zip 
    private ZipEntry        zipEntry; 
    private static int      bufSize;    //size of bytes 
    private byte[]          buf; 
    private int             readedBytes; 
     
    public ZipUtil(){ 
        this(512); 
    } 

    public ZipUtil(int bufSize){ 
        this.bufSize = bufSize; 
        this.buf = new byte[this.bufSize]; 
    } 
     
    //ѹ���ļ����ڵ��ļ� 
    public void doZip(String zipDirectory){//zipDirectoryPath:��Ҫѹ�����ļ����� 
        File file; 
        File zipDir; 

        zipDir = new File(zipDirectory); 
        String zipFileName = zipDir.getName() + ".zip";//ѹ�������ɵ�zip�ļ��� 
        System.out.println(zipFileName);
        try{ 
            this.zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFileName))); 
            handleDir(zipDir , this.zipOut); 
            this.zipOut.close(); 
        }catch(IOException ioe){ 
            ioe.printStackTrace(); 
        } 
    } 

    //��doZip����,�ݹ����Ŀ¼�ļ���ȡ 
    private void handleDir(File dir , ZipOutputStream zipOut)throws IOException{ 
        FileInputStream fileIn; 
        File[] files; 

        files = dir.listFiles(); 
     
        if(files.length == 0){//���Ŀ¼Ϊ��,�򵥶�����֮. 
            //ZipEntry��isDirectory()������,Ŀ¼��"/"��β. 
            this.zipOut.putNextEntry(new ZipEntry(dir.toString() + "/")); 
            this.zipOut.closeEntry(); 
        } 
        else{//���Ŀ¼��Ϊ��,��ֱ���Ŀ¼���ļ�. 
            for(File fileName : files){ 
                //System.out.println(fileName); 

                if(fileName.isDirectory()){ 
                    handleDir(fileName , this.zipOut); 
                } 
                else{ 
                    fileIn = new FileInputStream(fileName); 
                    this.zipOut.putNextEntry(new ZipEntry(fileName.toString())); 

                    while((this.readedBytes = fileIn.read(this.buf))>0){ 
                        this.zipOut.write(this.buf , 0 , this.readedBytes); 
                    } 

                    this.zipOut.closeEntry(); 
                } 
            } 
        } 
    } 

    //��ѹָ��zip�ļ� 
    public void unZip(String unZipfileName){//unZipfileName��Ҫ��ѹ��zip�ļ��� 
        FileOutputStream fileOut; 
        File file; 

        try{ 
            this.zipIn = new ZipInputStream (new BufferedInputStream(new FileInputStream(unZipfileName))); 

            while((this.zipEntry = this.zipIn.getNextEntry()) != null){ 
                file = new File(this.zipEntry.getName()); 
                //System.out.println(file);/// 

                if(this.zipEntry.isDirectory()){ 
                    file.mkdirs(); 
                } 
                else{ 
                    //���ָ���ļ���Ŀ¼������,�򴴽�֮. 
                    File parent = file.getParentFile(); 
                    if(!parent.exists()){ 
                        parent.mkdirs(); 
                    } 

                    fileOut = new FileOutputStream(file); 
                    while(( this.readedBytes = this.zipIn.read(this.buf) ) > 0){ 
                        fileOut.write(this.buf , 0 , this.readedBytes ); 
                    } 
                    fileOut.close(); 
                } 
                this.zipIn.closeEntry();     
            } 
        }catch(IOException ioe){ 
            ioe.printStackTrace(); 
        } 
    } 

    //���û�������С 
    public void setBufSize(int bufSize){ 
        this.bufSize = bufSize; 
    } 

    //����Zip�� 
    public static void main(String[] args)throws Exception{ 
        if(args.length==2){ 
            String name = args[1]; 
            ZipUtil zip = new ZipUtil(); 

            if(args[0].equals("-zip")) 
                zip.doZip(name); 
            else if(args[0].equals("-unzip")) 
                zip.unZip(name); 
        } 
        else{ 
            System.out.println("Usage:"); 
            System.out.println("ѹ��:java Zip -zip C:/temp"); 
            System.out.println("��ѹ:java Zip -unzip http://www.feng123.com /fileName.zip"); 
            throw new Exception("Arguments error!"); 
        } 
    } 
}
