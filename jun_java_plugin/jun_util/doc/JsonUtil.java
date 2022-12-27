package org.myframework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.IOUtils;
import org.jdom.Document;

/**
 * �ṩ��ͬ�Ľṹ����֮�������ת����JSON 
 * (XML,MAP,POJO ) -- >JSON
 * 
 * @author Administrator
 * 
 */
public class JsonUtil {
	/**
	 * ��xml�ַ���ת��ΪJSON����
	 * 
	 * @param xmlFile
	 *            xml�ַ���
	 * @return JSON����
	 */
	public JSON getJSONFromXml(String xmlString) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(xmlString);
		return json;
	}

	/**
	 * ��xmlDocumentת��ΪJSON����
	 * 
	 * @param xmlDocument
	 *            XML Document
	 * @return JSON����
	 */
	public JSON getJSONFromXml(Document xmlDocument) {
		String xmlString = xmlDocument.toString();
		return getJSONFromXml(xmlString);
	}

	/**
	 * ��xml�ַ���ת��ΪJSON�ַ���
	 * 
	 * @param xmlString
	 * @return JSON�ַ���
	 */
	public String getJSONStringFromXml(String xmlString) {
		return getJSONFromXml(xmlString).toString();
	}

	/**
	 * ��xmlDocumentת��ΪJSON�ַ���
	 * 
	 * @param xmlDocument
	 *            XML Document
	 * @return JSON�ַ���
	 */
	public String getJSONStringFromXMl(Document xmlDocument) {
		return getJSONStringFromXml(xmlDocument.toString());
	}

	/**
	 * ��ȡXML�ļ�׼��ΪJSON�ַ���
	 * 
	 * @param xmlFile
	 *            XML�ļ�
	 * @return JSON�ַ���
	 */
	public String getJSONStringFromXMLFile(String xmlFile) {
		InputStream is = JsonUtil.class.getResourceAsStream(xmlFile);
		String xml;
		JSON json = null;
		try {
			xml = IOUtils.toString(is);
			XMLSerializer xmlSerializer = new XMLSerializer();
			json = xmlSerializer.read(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	/**
	 * ��Java����ת��ΪJSON��ʽ���ַ���
	 * 
	 * @param javaObj
	 *            POJO,������־��model
	 * @return JSON��ʽ��String�ַ���
	 */
	public static String getJsonStringFromJavaPOJO(Object javaObj) {
		return JSONObject.fromObject(javaObj).toString(1);
	}

	/**
	 * ��Mapת��ΪJSON�ַ���
	 * 
	 * @param map
	 * @return JSON�ַ���
	 */
	public static String getJsonStringFromMap(Map<?, ?> map) {
		JSONObject object = JSONObject.fromObject(map);
		return object.toString();
	}
	
	/**
	 * ��Mapת��ΪJSON�ַ���
	 * 
	 * @param map
	 * @return JSON�ַ���
	 */
	public static String getJsonStringFromXml(Map<?, ?> map) {
		JSONObject object = JSONObject.fromObject(map);
		return object.toString();
	}
	
	public static void main(String[] args) {
		String jsString = "{'a':'1'}";
	}
}
