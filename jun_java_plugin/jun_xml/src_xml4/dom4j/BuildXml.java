package dom4j;

import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;

public class BuildXml {
	public static void main(String[] args) {
		BuildXml xml = new BuildXml();
		String fileName = "src/student.xml";
		String[] studentName = { "������", "��ľ��", "����", "������", "����" };
		String[] courseName = { "���", "����", "���", "�ֻ�" };
		xml.buildXml
    (fileName, studentName, courseName);
	}
	public void buildXml(String fileName, 
      String[] studentName,
			String[] courseName) {
		// ����doc����
		Document doc = 
      DocumentHelper.createDocument();
		// ����xml�ĵ���Record������
		Element recordElement = 
      doc.addElement("Record");
    
		// ΪRecord������һ��Head�ڵ�
		Element headElement = 
      recordElement.addElement("Head");
		// ΪRecord������һ��body�ڵ�
		Element bodyElement = 
      recordElement.addElement("Body");
    
		// ΪHead�ڵ����һЩ�ӽڵ�
		Element codeEl = 
      headElement.addElement("Code");
		codeEl.setText("SD1101");
		Element examEl = 
      headElement.addElement("Exam");
		examEl.setText("��");
		// ���ñ���ķ����������ӽڵ�
		addParamList
    (bodyElement, courseName, studentName); 
		// ��ʽ�����xml�ĵ����������������
		try {
			FileWriter fileWriter = 
        new FileWriter(fileName);
			// �����˴���xml�ļ��ĸ�ʽΪ������
			OutputFormat xmlFormat = 
        OutputFormat.createPrettyPrint();
			// �����ļ������ʽ
			xmlFormat.setEncoding("gbk");
			// ����д�ļ�,����������ļ�,��ʽ
			XMLWriter xmlWriter = 
        new XMLWriter(fileWriter, xmlFormat);
			// ��doc�ĵ�д���ļ�
			xmlWriter.write(doc);
			// �ر�
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addParamList(
      Element bodyEl, String[] courseName,
			String[] studentName) {
		/** �ж����ֿγ̾Ͳ������ٸ����� */
		for (int i = 0; i < courseName.length;
    i++) {
			Element courseList = 
        bodyEl.addElement("CourseList");
			Element sheehEl = 
        courseList.addElement("CourseCode");
			sheehEl.setText(courseName[i]);
			/** ����ÿ��ѧ��ѡ��ȫ���γ� */
			addItem(studentName, courseList);
		}
	}

	private void addItem(
      String[] studentName, 
      Element courseList) {
		Element studentEl = 
      courseList.addElement("Student");
		for (int i = 0; i < studentName.length;
    i++) {
			Element studentNameEl = 
        studentEl.addElement("StudentName");
			studentNameEl.setText(studentName[i]);

			studentNameEl.
      addAttribute("score", 
          new Random().nextInt(100) + "");
		}
	}
}



