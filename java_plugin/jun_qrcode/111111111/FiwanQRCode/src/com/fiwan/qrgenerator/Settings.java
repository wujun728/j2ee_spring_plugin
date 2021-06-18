package com.fiwan.qrgenerator;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * �����������
 * ʹ�õ�������һ�������ࡣ
 * */
public class Settings {
    private Settings() {}  
    private static final Settings single = new Settings();  
    public static Settings getInstance() {  
        return single;  
    }  
    //���ö�ά�����ɫ Ĭ���Ǻ�ɫ
	private int qrcodeColor =0;  //0 ��ɫ    1 �ڰ�
	//���ö�ά��ĸ�ʽ Ĭ����png
	private String qrcodeFiletype ="png";
	//���ö�ά��Ĵ�С Ĭ����400px
	private int qrcodeSize =400;
	//���ö�ά����ݴ��� Ĭ����H
	private ErrorCorrectionLevel qrcodeErrorRate =ErrorCorrectionLevel.H;
	public int getQrcodeColor() {
		return qrcodeColor;
	}
	public void setQrcodeColor(int qrcodeColor) {
		this.qrcodeColor = qrcodeColor;
	}
	public String getQrcodeFiletype() {
		return qrcodeFiletype;
	}
	public void setQrcodeFiletype(String qrcodeFiletype) {
		this.qrcodeFiletype = qrcodeFiletype;
	}
	public int getQrcodeSize() {
		return qrcodeSize;
	}
	public void setQrcodeSize(int qrcodeSize) {
		this.qrcodeSize = qrcodeSize;
	}
	public ErrorCorrectionLevel getQrcodeErrorRate() {
		return qrcodeErrorRate;
	}
	public void setQrcodeErrorRate(ErrorCorrectionLevel qrcodeErrorRate) {
		this.qrcodeErrorRate = qrcodeErrorRate;
	}
}
