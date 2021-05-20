
package com.fiwan.utils;

/**
 * ֧�ֵ�����ö��
 * 
 */
public enum QCodeFileType {

	// -------------
	JPG("JPG", false), //
	BMP("BMP", false), //
	GIF("GIF", false), //
	PNG("PNG", false), //
	// TIF("TIF", false), //
	// TXT("TXT", false), //
	// HTML("HTML", false), //
	// XAML("XAML", false), //
	// ------------------------
	EPS("EPS", true), //
	PDF("PDF", true), //
	SVG("SVG", true), //
	;

	/**
	 * �Ƿ���ʸ��ͼ
	 */
	private final boolean vector;
	private final String chName;

	private QCodeFileType(String chName, boolean vector) {
		this.chName = chName;
		this.vector = vector;
	}

	/**
	 * @return Returns the chName.
	 */
	public String getChName() {
		return chName;
	}

	/**
	 * @return Returns the vector.
	 */
	public boolean isVector() {
		return vector;
	}
}
