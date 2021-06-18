package com.fiwan.qrgenerator;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.fiwan.utils.Utils;
import com.google.zxing.WriterException;

public class JProgressBar_1 extends JFrame {  
	Settings setting=Settings.getInstance();
	private static final long serialVersionUID = 3843865996171498087L;
	final JProgressBar_1 frame=null;  
	Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
	Dimension screenSize = kit.getScreenSize(); // ��ȡ��Ļ�ĳߴ�
	int screenWidth = screenSize.width; // ��ȡ��Ļ�Ŀ�
	int screenHeight = screenSize.height; // ��ȡ��Ļ�ĸ�
    public JProgressBar_1( ArrayList<String> list,final String folder) {  
    	int windowWidth = this.getWidth(); // ��ô��ڿ�
		int windowHeight = this.getHeight(); // ��ô��ڸ�
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ�����ʾ
        JLabel label = new JLabel("��������ͼƬ");  
        JProgressBar progressBar = new JProgressBar(); 
        JButton button = new JButton("��");  
        button.setEnabled(false);  
        Container container = getContentPane();  
        container.setLayout(new GridLayout(3, 1));  
        JPanel panel1= new JPanel(new FlowLayout(FlowLayout.LEFT));  
        JPanel panel2= new JPanel(new FlowLayout(FlowLayout.CENTER));  
        JPanel panel3= new JPanel(new FlowLayout(FlowLayout.RIGHT));  
        panel1.add(label);  
        panel2.add(progressBar);  
        panel3.add(button);  
        container.add(panel1);  
        container.add(panel2);  
        container.add(panel3);  
        progressBar.setStringPainted(true);
        
        new Progress(progressBar, button,list,folder).start();  
        button.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
        		try {
        			Runtime.getRuntime().exec("explorer.exe " + Utils.getCurrentPath()+File.pathSeparator+folder);
        		} catch (IOException ioe) {
        			ioe.printStackTrace();
        		}
                dispose();  
            }  
        });  
    }  
      
    private class Progress extends Thread {  
        JProgressBar progressBar;  
        JButton button;
        ArrayList<String> list;
        String folder;   
        Progress(JProgressBar progressBar, JButton button,ArrayList<String> list,String folder) {  
            this.progressBar = progressBar;  
            this.button = button; 
            this.list=list;
            this.folder=folder;
        }  
          
        public void run() {  
        	if (list.size()>0){
        		NumberFormat numberFormat = NumberFormat.getInstance(); 
        		numberFormat.setMaximumFractionDigits(2);  
    			
    			for (int i = 0; i < list.size(); i++) {
	    			String content=list.get(i);
	    			String filename = "FiwanQR" + System.currentTimeMillis();
	    			String path=Utils.CreateFilePathAndFile(folder,setting.getQrcodeFiletype(),filename);
	    			File file = new File(path);
    			try {
    				if (setting.getQrcodeFiletype().equals("eps") || setting.getQrcodeFiletype().equals("pdf")
    						|| setting.getQrcodeFiletype().equals("svg")) {
    					if (setting.getQrcodeFiletype().equals("eps")) {
    						ZxingHandler.createEPSQRCode(setting, file, content);
    					}
    					if (setting.getQrcodeFiletype().equals("pdf")) {
    						ZxingHandler.createPDFQRCode(setting, file, content);
    					}
    					if (setting.getQrcodeFiletype().equals("svg")) {
    						ZxingHandler.createSVGQRCode(setting, file, content);
    					}
    				} else {
    					if (setting.getQrcodeColor() == 0) {
    						ZxingHandler.writeToFileWithColor(ZxingHandler.GetBitMatrix(content, setting.getQrcodeSize(),setting.getQrcodeErrorRate()),
    								setting.getQrcodeFiletype(), file);
    					}
    					if (setting.getQrcodeColor() == 1) {
    						ZxingHandler.writeToFile(ZxingHandler.GetBitMatrix(content, setting.getQrcodeSize(),setting.getQrcodeErrorRate()),
    								setting.getQrcodeFiletype(), file);
    					}
    				}
    			} catch (IOException e) {
    				e.printStackTrace();
    			} catch (WriterException e) {
    				e.printStackTrace();
    			}
    			String result = numberFormat.format( (float)(i+1) / (float)list.size());
    			System.out.println(result);
    			if (!"0".equals(result)&&!"1".equals(result)){
    			 progressBar.setValue(Integer.parseInt(result.split("\\.")[1]));  
    			 }else {
    				 if("1".equals(result)){
    				 progressBar.setValue(100);  
    			 }
    			}
    			}
        	}
            progressBar.setIndeterminate(false);  
            progressBar.setString("������ɣ�");  
            button.setEnabled(true);  
        }  
    }  
}