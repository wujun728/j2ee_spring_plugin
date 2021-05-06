package com.tanzhou.jmf;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import javax.swing.*;
// JFrame java��GUI����Ļ���˼·����JFrameΪ������������Ļ��window�Ķ����ܹ���󻯡���С�����رա�
/**
 * ActionListener��Java�й����¼������һ���ӿڣ��̳���EventListener��
ActionListener���ڽ��ղ����¼����������ӿڡ��Դ�������¼�����Ȥ�������ʵ�ִ˽ӿڣ�
��ʹ�ø��ഴ���Ķ����ʹ������� addActionListener 
����������ע�ᡣ�ڷ��������¼�ʱ�����øö���� actionPerformed ������
 */
public class SoundPlayer extends JFrame implements ActionListener {
	AudioClip adc; // ������Ƶ��������adc

	URL url; // ������Դ��λ������url

	JLabel lb = new JLabel();// ����һ����ǩ����lb

	JLabel la = new JLabel();// ����һ����ǩ����la

	File file;// �����ļ�����file

	String fileName;// ����fileName���������ڼ�¼����������

	boolean loop = false;// ����loop�����������ж��Ƿ���ЂŻ�����

	JFileChooser chooser = new JFileChooser();// ����һ���ļ�ѡ��������chooser

	//Icon a = new ImageIcon("C:\\Documents and Settings\\Administrator\\����\\image\\ying.jpg");// ����һ�����ͼƬ

	JPanel pn1 = new JPanel();// ����һ�������������Ĭ�ϲ���Ϊ��FlowLayout

	public static void main(String[] args) {
		new SoundPlayer();// ��������title
	}

	public SoundPlayer() {// ����Ĺ��������𵽳�ʼ�������ã��൱��Applect��init����
		super("���ֲ�����");// ����JFrame�Ĺ��췽�����������Ǵ���һ���µġ���ʼ���ɼ��ġ�����ָ������� Frame
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {// �û���������ϵͳ�˵��Ĺرհ�ť������dispose��ִ��windowClosed
				dispose();
				if (adc != null) {// ����Ƶ����adc��Ϊnull������£��رմ��ڵ�ͬʱ������Ҳ��ʧ
					adc.stop();
				}
			}
		});
		JButton[] bn = new JButton[3];// ����JButton����
		/**
		 * FlowLayout����ʽ���֣�       ������ռ�����Ⱥ�˳�������õĶ��뷽ʽ�����������У�һ����������һ�п�ʼ��������
		   BorderLayout���߽粼�֣�     ��������Ϊ���������ϡ��������������ÿ������ֻ�ܷ���һ�������
		   GridLayout�����񲼾֣�       �����Ŀռ仮�ֳ�M��N�е���������, ÿ������ֻ�ܷ���һ�������
		   CardLayout����Ƭ���֣�       ��ͬһ���ƣ�ÿ���ƶ�Ӧһ���������ÿ��ֻ����ʾ���е�һ���ơ���������һ���ռ��з�ֹ�����������
		   GridBagLayout����������֣�  GridLayout�������棬�����Ȼ�ǰ����С��з��ã�����ÿ���������ռ�ݶ������
		 */
		JPanel pn = new JPanel(new GridLayout());// ����һ�������������pn������Ϊ��GridLayout

		Icon[] ic = new Icon[3];// ����Icon����
		for (int i = 0; i < ic.length; i++) {// Ϊÿ��Icon����ͼ��
			ic[i] = new ImageIcon("C:\\Users\\Tony Liu\\Desktop\\image\\"
					+ (i + 1) + ".gif");
		}
		bn[0] = new JButton("��ʼ", ic[0]);// ����һ�������֣���ͼ��İ�Ť����
		bn[0].addActionListener(this);// ����¼�����
		bn[1] = new JButton("ֹͣ", ic[1]);
		bn[1].addActionListener(this);
		bn[2] = new JButton("ѭ��", ic[2]);
		bn[2].addActionListener(this);
		pn.add(bn[0], 0);// ����ʼ��Ť��ӵ����pn�ĵ�1��λ����
		pn.add(bn[1], 1);// ͬ��
		pn.add(bn[2], 2);// ͬ��
		this.add(pn, BorderLayout.SOUTH);// �����pn��ӵ�Frame��
//		// �����������Ĳ˵�
		JMenu fileMenu = new JMenu("�ļ�");
		JMenuItem openMemuItem = new JMenuItem("��");
		openMemuItem.addActionListener(this);
		fileMenu.add(openMemuItem);
		fileMenu.addSeparator();// ���һ���ָ���
		JMenuItem exitMemuItem = new JMenuItem("�˳�");
		exitMemuItem.addActionListener(this);
		fileMenu.add(exitMemuItem);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		String flag = "��ӭ����";
		this.setFrame(flag);// ����setFrame����
		this.setJMenuBar(menuBar);
		this.setSize(300, 360);// ����Frame�Ĵ�С
		this.setVisible(true);// ��Frame����Ϊ�ɼ�

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("�˳�")) {// ��������˳��˵���ر�windows����
			dispose();// ����dispose�Ա�ִ��windowClosed
			return;
		}
		if (e.getActionCommand().equals("��")) {// ��������򿪲˵��ѡ�����ֲ����ļ�
			int val = chooser.showOpenDialog(this);// �����ļ�ѡ�����ķ���״̬
			if (val == JFileChooser.APPROVE_OPTION) {// �������״̬ΪAPPROVE_OPTION
				file = chooser.getSelectedFile();// ����ѡ�е��ļ�
				fileName = file.getName();// ��ȡѡ�е��ļ����ļ���
				String flag = "���������ͣ�" + fileName;
				this.setFrame(flag);
				try {
					URL url = new URL("file:" + file.getPath());// ������Դ��λ��
					adc = JApplet.newAudioClip(url);// Ϊ��Ƶ��������adc��ֵ
					adc.play();// ��ʼ���Ŵ���Ƶ����
				} catch (MalformedURLException e1) {
					System.out.println("���ܲ��Ŵ��ļ�");
				}
			}
		}
		// ����û�����ѡ���ļ����򷵻�
		if (e.getActionCommand().equals("��ʼ")) {
			String flag = "���������ͣ�" + fileName;
			if (adc == null) {
				flag = "��ѡ�񲥷��ļ�";
				this.setFrame(flag);
				return;
			}
			adc.play();
			this.setFrame(flag);
		}
		if (e.getActionCommand().equals("ֹͣ")) {
			adc.stop();// ֹͣ���Ŵ���Ƶ������
			String flag = "ֹͣ���ţ�" + fileName;
			this.setFrame(flag);
		}
		if (e.getActionCommand().equals("ѭ��")) {
			loop = !loop;
			String flag = "";
			if (loop) {
				adc.play();
				adc.loop();// ��ѭ����ʽ��ʼ���Ŵ���Ƶ����
				flag = "ѭ�����ţ�" + fileName;
			} else {
				adc.play();
				flag = "˳�򲥷ţ�" + fileName;
			}
			this.setFrame(flag);
		}

	}
    /**
     * ��ȡ�����Ĳ���
     * 
     * 
     * @param flag
     */
	public void setFrame(String flag) {
		la.setText(flag);
		//lb.setIcon(a);
		pn1.add(la, 0);
		//pn1.add(lb, 1);
		this.add(pn1, FlowLayout.CENTER);
	}
}
