package org.myframework.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * POJO -> XML
 * @author Administrator
 * 
 */
public class XmlUtil {
	/**
	 * ��POJO ת��Ϊ XML�ַ���
	 * @param pojo
	 * @return
	 */
	public static String getXmlFromPojo(Object pojo) {
		XStream xstream = new XStream(new DomDriver());
		xstream.registerConverter(new SingleValueCalendarConverter());
		String strxml = xstream.toXML(pojo);
		return strxml;
	}
	
	  /**
     * ȱʡ�ַ���
     * */
    public static final String DEFAULT_ENCODING = "UTF-8";
    
    /**
     * ˽�й��캯������ֹ�Ƿ����ù��캯��
     * */
    private XmlUtil() {
    }

    /** 
     * Return the child element with the given name.  The element must be in
     *   the same name space as the parent element.
     *  @param element The parent element
     *  @param name The child element name
     *  @return The child element
     */
    public static Element child(Element element, String name) {
        return element.element(new QName(name, element.getNamespace()));
    }

    /**
     * �õ���������µĺ��ӽڵ�
     * @param element �ڵ�
     * @param name �ӽڵ�����
     * @param optional �Ƿ��ǿ�ѡ��
     * @return �ӽڵ�
     * @throws XMLDocException
     */
    public static Element child(Element element,
                                String name,
                                boolean optional)
        throws XMLDocException {
        Element child = element.element(new QName(name, element.getNamespace()));
        if (child == null && !optional) {
            throw new XMLDocException(name + " element expected as child of " +
                                      element.getName() + ".");
        }
        return child;
    }

    /** Return the child elements with the given name.  The elements must be in
        the same name space as the parent element.
        @param element The parent element
        @param name The child element name
        @return The child elements
     */
    public static List children(Element element, String name) {
        return element.elements(new QName(name, element.getNamespace()));
    }
    
    
    /**
     * �õ�ĳ���ڵ��µ�������Ϣ
     * @param element �ڵ�
     * @param name ������
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static String getAttribute(Element element,
                                      String name,
                                      boolean optional)
        throws XMLDocException {
    	Attribute attr = null;
    	if(element!=null)
    		attr = element.attribute(name);
        if (attr == null && !optional) {
        	if(element!=null)
        		throw new XMLDocException("Attribute " + name + " of " +
                                      element.getName() + " expected.");
        	else
        		return null;
        } else if (attr != null) {
            return attr.getValue();
        }
        else {
            return null;
        }
    }

    /**
     * �õ��ڵ�����ֵ��������Ϊ�����ͷ���
     * @param element �ڵ�
     * @param name ������
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */

    public static java.util.Date getAttributeAsDate(Element element,
        String name,
        boolean optional)
        throws XMLDocException {
        String value = getAttribute(element, name, optional);
        if ( (optional) && ( (value == null) || (value.equals("")))) {
            return null;
        }
        else {
            try {
                //�����ѡ�Ͳ��׳��쳣
                return DateUtil.parse(value );
            }
            catch ( Exception exception) {
                throw new XMLDocException(element.getName() + "/@" + name +
                                          " attribute: value format error.",
                                          exception);
            }
        }
    }

    /**
     * �õ�ĳ���ڵ��µ�������Ϣ��ֵ���ַ�������ʽ����
     * @param element �ڵ�
     * @param name ������
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static String getAttributeAsString(Element element,
                                              String name,
                                              boolean optional)
        throws XMLDocException {
        return getAttribute(element, name, optional);
    }

    /**
     * �õ�ĳ���ڵ��µ�������Ϣ��ֵ����������ʽ���ء�
     * ���û��ֵ����ת��Ϊ���Σ���ô�׳��쳣��
     * @param element �ڵ�
     * @param name ������
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static int getAttributeAsInt(Element element,
                                        String name,
                                        boolean optional)
        throws XMLDocException {
        try {
            return Integer.parseInt(getAttribute(element, name, optional));
        }
        catch (NumberFormatException exception) {
            throw new XMLDocException(element.getName() + "/@" + name +
                                      " attribute: value format error.",
                                      exception);
        }
    }

    /**
     * �õ�ĳ���ڵ��µ�������Ϣ��ֵ����������ʽ���ء�
     * �����ֵ�ǿ�ѡ�ģ�����û�и�ֵ�Ļ����ͷ��ص������ṩȱʡֵ��
     * @param element �ڵ�
     * @param name ������
     * @param defaultValue ȱʡֵ
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static int getAttributeAsInt(Element element,
                                        String name,
                                        int defaultValue,
                                        boolean optional)
        throws XMLDocException {
        String value = getAttribute(element, name, optional);
        if ( (optional) && ( (value == null) || (value.equals("")))) {
            return defaultValue;
        }
        else {
            try {
                return Integer.parseInt(value);
            }
            catch (NumberFormatException exception) {
                throw new XMLDocException(element.getName() + "/@" + name +
                                          " attribute: value format error.",
                                          exception);
            }
        }
    }

    /**
     * �õ�ĳ���ڵ��µ�������Ϣ��ֵ��float����ʽ���ء�
     * ���û��ֵ����ת��Ϊfloat����ô�׳��쳣��
     * @param element �ڵ�
     * @param name ������
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static float getAttributeAsFloat(Element element,
                                            String name,
                                            boolean optional)
        throws XMLDocException {
        try {
            return Float.parseFloat(getAttribute(element, name, optional));
        }
        catch (NumberFormatException exception) {
            throw new XMLDocException(element.getName() + "/@" + name +
                                      " attribute: value format error.",
                                      exception);
        }
    }

    /**
     * �õ�ĳ���ڵ��µ�������Ϣ��ֵ��float����ʽ���ء�
     * ���û��ֵ,����ȱʡֵ������У���ôת��Ϊfloat���������ת����ô�׳��쳣��
     * @param element �ڵ�
     * @param name ������
     * @param defaultValue ȱʡֵ
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static float getAttributeAsFloat(Element element,
                                            String name,
                                            float defaultValue,
                                            boolean optional)
        throws XMLDocException {
        String value = getAttribute(element, name, optional);
        if ( (optional) && ( (value == null) || (value.equals("")))) {
            return defaultValue;
        }
        else {
            try {
                return Float.parseFloat(value);
            }
            catch (NumberFormatException exception) {
                throw new XMLDocException(element.getName() + "/@" + name +
                                          " attribute: value format error.",
                                          exception);
            }
        }
    }

    /**
     * �õ�ĳ���ڵ��µ�������Ϣ��ֵ�Գ���������ʽ���ء�
     * ���û��ֵ����ת��Ϊ���Σ���ô�׳��쳣��
     * @param element �ڵ�
     * @param name ������
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static long getAttributeAsLong(Element element,
                                          String name,
                                          boolean optional)
        throws XMLDocException {
        try {
            return Long.parseLong(getAttribute(element, name, optional));
        }
        catch (NumberFormatException exception) {
            throw new XMLDocException(element.getName() + "/@" + name +
                                      " attribute: value format error.",
                                      exception);
        }
    }

    /**
     * �õ�ĳ���ڵ��µ�������Ϣ��ֵ����������ʽ���ء�
     * �����ֵ�ǿ�ѡ�ģ�����û�и�ֵ�Ļ����ͷ��ص������ṩȱʡֵ��
     * @param element �ڵ�
     * @param name ������
     * @param defaultValue ȱʡֵ
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static long getAttributeAsLong(Element element,
                                          String name,
                                          long defaultValue,
                                          boolean optional)
        throws XMLDocException {
        String value = getAttribute(element, name, optional);
        if ( (optional) && ( (value == null) || (value.equals("")))) {
            return defaultValue;
        }
        else {
            try {
                return Long.parseLong(value);
            }
            catch (NumberFormatException exception) {
                throw new XMLDocException(element.getName() + "/@" + name +
                                          " attribute: value format error.",
                                          exception);
            }
        }
    }

    /**
     * �õ�ĳ���ڵ��µ�ĳ���ֵĵ�һ�����ӽڵ�
     * @param element �ڵ�
     * @param name �ӽڵ�����
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static Element getFirstChild(Element element,
                                        String name,
                                        boolean optional)
        throws XMLDocException {
        java.util.List list = element.elements(new QName(name,
            element.getNamespace()));
        //�����Ŀ����0����ôֱ��ȡ��һ���Ϳ�����
        if (list.size() > 0) {
            return (Element) list.get(0);
        }
        else {
            if (!optional) {
                throw new XMLDocException(name +
                    " element expected as first child of " +
                    element.getName() + ".");
            }
            else {
                return null;
            }
        }
    }

    /**
     * �õ�ͬ���ֵܽڵ�,ͬ���ĵ�һ���ڵ㣬�������Լ�
     * @param element �ڵ�
     * @param optional �Ƿ��ǿ�ѡ��
     * @return �ڵ�
     * @throws XMLDocException
     */
    public static Element getSibling(Element element, boolean optional)
        throws XMLDocException {
        return getSibling(element, element.getName(), optional);
    }

    /**
     * �����Ƶõ��ֵܽڵ�
     * @param element �ڵ�
     * @param name �ӽڵ�����
     * @param optional �Ƿ��ǿ�ѡ��
     * @return �ڵ�
     * @throws XMLDocException
     */
    public static Element getSibling(Element element,
                                     String name,
                                     boolean optional)
        throws XMLDocException {
        java.util.List list = element.getParent().elements(name);
        if (list.size() > 0) {
            return (Element) list.get(0);
        }
        else {
            if (!optional) {
                throw new XMLDocException(name + " element expected after " +
                                          element.getName() + ".");
            }
            else {
                return null;
            }
        }
    }

    /**
     * �õ������ڵ��ֵ,���ַ�������
     * @param element �ڵ�
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static String getContent(Element element, boolean optional)
        throws XMLDocException {
        String content = null;
		if(element!=null)
			 content =element.getText();
        if (content == null && !optional) {
        	if(element!=null)
        		throw new XMLDocException(element.getName() +
                                      " element: content expected.");
            else 
            	return null;
        } else {
            return content;
        }
    }

    /**
     * �õ������ڵ��ֵ,���ַ�������
     * @param element �ڵ�
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static String getContentAsString(Element element, boolean optional)
        throws XMLDocException {
        return getContent(element, optional);
    }

    /**
     * �õ������ڵ��ֵ,���������ͷ���
     * @param element �ڵ�
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static int getContentAsInt(Element element, boolean optional)
        throws XMLDocException {
        try {
            return Integer.parseInt(getContent(element, optional));
        }
        catch (NumberFormatException exception) {
            throw new XMLDocException(element.getName() +
                                      " element: content format error.",
                                      exception);
        }
    }

    /**
     * �õ������ڵ��ֵ,���������ͷ���
     * @param element �ڵ�
     * @param defaultValue ȱʡֵ
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static int getContentAsInt(Element element,
                                      int defaultValue,
                                      boolean optional)
        throws XMLDocException {
        String value = getContent(element, optional);
        if ( (optional) && (value == null || value.equals(""))) {
            return defaultValue;
        }
        else {
            try {
                return Integer.parseInt(value);
            }
            catch (NumberFormatException exception) {
                throw new XMLDocException(element.getName() +
                                          " element: content format error.",
                                          exception);
            }
        }
    }

    /**
     * �õ������ڵ��ֵ,�Գ������ͷ���
     * @param element �ڵ�
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static long getContentAsLong(Element element, boolean optional)
        throws XMLDocException {
        try {
            return Long.parseLong(getContent(element, optional));
        }
        catch (NumberFormatException exception) {
            throw new XMLDocException(element.getName() +
                                      " element: content format error.",
                                      exception);
        }
    }

    /**
     * �õ������ڵ��ֵ,���������ͷ���
     * @param element �ڵ�
     * @param defaultValue ȱʡֵ
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static long getContentAsLong(Element element,
                                      long defaultValue,
                                      boolean optional)
        throws XMLDocException {
        String value = getContent(element, optional);
        if ( (optional) && (value == null || value.equals(""))) {
            return defaultValue;
        }
        else {
            try {
                return Long.parseLong(value);
            }
            catch (NumberFormatException exception) {
                throw new XMLDocException(element.getName() +
                                          " element: content format error.",
                                          exception);
            }
        }
    }

    /**
     * �õ������ڵ��ֵ,�Ը������ͷ���
     * @param element �ڵ�
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static float getContentAsFloat(Element element, boolean optional)
        throws XMLDocException {
        try {
            return Float.parseFloat(getContent(element, optional));
        }
        catch (NumberFormatException exception) {
            throw new XMLDocException(element.getName() +
                                      " element: content format error.",
                                      exception);
        }
    }

    /**
     * �õ������ڵ��ֵ,�Ը������ͷ���
     * @param element �ڵ�
     * @param defaultValue ȱʡֵ
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static float getContentAsFloat(Element element,
                                          float defaultValue,
                                          boolean optional)
        throws XMLDocException {
        String value = getContent(element, optional);
        if ( (optional) && (value == null || value.equals(""))) {
            return defaultValue;
        }
        else {
            try {
                return Float.parseFloat(value);
            }
            catch (NumberFormatException exception) {
                throw new XMLDocException(element.getName() +
                                          " element: content format error.",
                                          exception);
            }
        }
    }

    /**
     * �õ������ڵ��ֵ,���������ͷ���
     * @param element �ڵ�
     * @param optional �Ƿ��ǿ�ѡ��
     * @return ֵ
     * @throws XMLDocException
     */
    public static java.util.Date getContentAsDate(Element element,
                                                  boolean optional)
        throws XMLDocException {
        String value = getContent(element, optional);
        if ( (optional) && (value == null || value.equals(""))) {
            return null;
        }
        else {
            try {
                return DateUtil.parse(value );
            }
            catch ( Exception exception) {
                throw new XMLDocException(element.getName() +
                                          " element: content format error.",
                                          exception);
            }
        }
    }

    /**
     * �������ڵ���ӽڵ����ƣ��õ��ӽڵ�ֵ
     * @param root ���ڵ�
     * @param subTagName �ӽڵ�
     * @return ֵ
     */
    public static String getSubTagValue(Element root, String subTagName) {
        String returnString = root.elementText(subTagName);
        return returnString;
    }

    /**
     * �������ڵ㣬�ӽڵ����ƣ���ڵ����ƣ��õ�ֵ
     * @param root   ���ڵ�
     * @param tagName �ӽڵ�����
     * @param subTagName ��ڵ�����
     * @return ֵ
     */
    public static String getSubTagValue(Element root,
                                        String tagName,
                                        String subTagName) {
        Element child = root.element(tagName);
        String returnString = child.elementText(subTagName);
        return returnString;
    }

    /**
     * ��Element�ڵ㣬ֵΪString����
     * @param parent ���ڵ�
     * @param name �½ڵ�����
     * @param value �½ڵ�ֵ
     * @return element
     * @throws XMLDocException
     */
    public static Element appendChild(Element parent,
                                      String name,
                                      String value) {
        Element element = parent.addElement(new QName(name, parent.getNamespace()));
        if (value != null) {
            element.addText(value);
        }
        return element;
    }

    /**
     * ������Element�ڵ㣬��ֵ
     * @param parent ���ڵ�
     * @param name �½ڵ�����
     * @return Element �½��ڵ�
     * @throws XMLDocException
     */
    public static Element appendChild(Element parent, String name) {
        return parent.addElement(new QName(name, parent.getNamespace()));
    }

    /**
     * ������Element�ڵ㣬ֵΪint����
     * @param parent ���ڵ�
     * @param name �½ڵ�����
     * @param value �½ڵ�ֵ
     * @return element
     * @throws XMLDocException
     */
    public static Element appendChild(Element parent,
                                      String name,
                                      int value) {
        return appendChild(parent, name, String.valueOf(value));
    }

    /**
     * ������Element�ڵ㣬ֵΪ������
     * @param parent ���ڵ�
     * @param name �½ڵ�����
     * @param value �½ڵ�ֵ
     * @return element
     * @throws XMLDocException
     */
    public static Element appendChild(Element parent,
                                      String name,
                                      long value) {
        return appendChild(parent, name, String.valueOf(value));
    }

    /**
     * �¼�һ��floatֵ���͵Ľڵ㣬ֵΪ������
     * @param parent ���ڵ�
     * @param name �½ڵ������
     * @param value �½ڵ��ֵ
     * @return element
     * @throws XMLDocException
     */
    public static Element appendChild(Element parent,
                                      String name,
                                      float value) {
        return appendChild(parent, name, String.valueOf(value));
    }

    /**
     * ������Element�ڵ㣬ֵΪ������
     * @param parent ���ڵ�
     * @param name �½ڵ�����
     * @param value �½ڵ�ֵ
     * @return element
     * @throws XMLDocException
     */
    public static Element appendChild(Element parent,
                                      String name,
                                      java.util.Date value) {
        return appendChild(parent, name,
                           DateUtil.getInstance().format(value));
    }

    /**
     * ����ĵ�dtd�����Ƿ���ȷ
     * @param document �ĵ��ڵ�
     * @param dtdPublicId dtd����
     * @return boolean  ��ͬ����true,����false
     */
    public static boolean checkDocumentType(Document document,
                                            String dtdPublicId) {
        DocumentType documentType = document.getDocType();
        if (documentType != null) {
            String publicId = documentType.getPublicID();
            return publicId != null && publicId.equals(dtdPublicId);
        }
        return true;
    }

    /**
     * �½��ĵ�
     * @return Document  �ĵ��ڵ�
     * @throws XMLDocException
     */
    public static Document createDocument()
        throws XMLDocException {
        DocumentFactory factory = new DocumentFactory();
        Document document = factory.createDocument();
        return document;
    }

    /**
     * ͨ��Reader��ȡDocument�ĵ�
     * ���encodingStrΪnull����""����ô����ȱʡ����GB2312
     * @param in Reader��
     * @param encoding ������
     * @return documment
     * @throws XMLDocException
     */
    public static Document fromXML(Reader in, String encoding)
        throws XMLDocException {
        try {
            if (encoding == null || encoding.equals("")) {
                encoding = DEFAULT_ENCODING;
            }
            SAXReader reader = new SAXReader();
            Document document = reader.read(in, encoding);
            return document;
        }
        catch (Exception ex) {
            throw new XMLDocException(ex);
        }
    }

    /**
     * ������������ȡXML��Document��
     * ���encodingStrΪnull����""����ô����ȱʡ����GB2312
     * @param inputSource ����Դ
     * @param encoding ������
     * @return document
     * @throws XMLDocException
     */
    public static Document fromXML(InputStream inputSource, String encoding)
        throws XMLDocException {
        try {
            if (encoding == null || encoding.equals("")) {
                encoding = DEFAULT_ENCODING;
            }
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputSource, encoding);            
            return document;
        }
        catch (Exception ex) {
            throw new XMLDocException(ex);
        }
    }

    /**
     * ֱ�Ӵ��ַ����õ�XML��Document
     * @param source ��һ���ַ����ı�ת��ΪXML��Document����
     * @param encoding ������
     * @return <code>Document</code>
     * @throws XMLDocException
     */
    public static Document fromXML(String source, String encoding)
        throws XMLDocException {
        return fromXML(new StringReader(source), encoding);
    }

    /**
     * ��XML��Documentת��Ϊjava.io.Writer�����
     * ��֧�ָ���Schema�ļ���У��
     * @param document XML�ĵ�
     * @param outWriter ���д����
     * @param encoding ��������
     * @throws XMLDocException ������κ��쳣ת��Ϊ���쳣���
     */
    public static void toXML(Document document, java.io.Writer outWriter,
                             String encoding)
        throws XMLDocException {
        //
        OutputFormat outformat = OutputFormat.createPrettyPrint();
        if (encoding == null || encoding.trim().equals("")) {
            encoding = DEFAULT_ENCODING;
        }
        //���ñ�������
        outformat.setEncoding(encoding);
        XMLWriter xmlWriter = null;
        try {
            xmlWriter = new XMLWriter(outWriter, outformat);
            xmlWriter.write(document);
            xmlWriter.flush();
        }
        catch (java.io.IOException ex) {
            throw new XMLDocException(ex);
        }
        finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                }
                catch (java.io.IOException ex) {
                }
            }
        }
    }

    /**
     * ��XML��Documentת��Ϊjava.io.Writer�����
     * ��֧�ָ���Schema�ļ���У��
     * @param document XML�ĵ�
     * @param outStream ���д����
     * @param encoding ��������
     * @throws XMLDocException ������κ��쳣ת��Ϊ���쳣���
     */
    public static void toXML(Document document, java.io.OutputStream outStream,
                             String encoding)
        throws XMLDocException {
        //
        OutputFormat outformat = OutputFormat.createPrettyPrint();
        if (encoding == null || encoding.trim().equals("")) {
            encoding = DEFAULT_ENCODING;
        }
        //���ñ�������
        outformat.setEncoding(encoding);
        XMLWriter xmlWriter = null;
        try {
            xmlWriter = new XMLWriter(outStream, outformat);
            xmlWriter.write(document);
            xmlWriter.flush();
        }
        catch (java.io.IOException ex) {
            throw new XMLDocException(ex);
        }
        finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                }
                catch (java.io.IOException ex) {
                }
            }
        }
    }

    /**
     * ��XML�ĵ�ת��ΪString����
     * @param document Ҫת����XML��Document
     * @param encoding ��������
     * @return <code>String</code>
     * @throws XMLDocException ������κ��쳣ת��Ϊ���쳣���
     */
    public static String toXML(Document document, String encoding)
        throws XMLDocException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        toXML(document, stream, encoding);
        if (stream != null) {
            try {
                stream.close();
            }
            catch (java.io.IOException ex) {
            }
        }
        return stream.toString();
    }

	
	
}
