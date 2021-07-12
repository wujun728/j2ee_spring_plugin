package com.tanzhou.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Code_MarkerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��������ҳ�治����--������
		response.setHeader("Pragma", "No-cache");  // ����HTTP��Ӧ��ͷ��Ϣ
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// ����ͼƬ�Ŀ�Ⱥ͸߶�
		int width = 90, height = 40;
		// ����һ��ͼ�����
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		/**
		 * component�༰�������������ɶ����ʱ����Զ�����paint(Graphics g)����
		 */
		Graphics g = image.createGraphics();// �õ�ͼ��Ļ��ƻ���
		
		// �������ɫ���ͼ�񱳾�
		g.setColor(getRandColor(180, 250));
		/**
		 * fillRect��x,y,w,h�������������ǣ����һ����������x��yΪ��ʼ���꣨�����Ͻ����꣩,
		 * �������������ֱ�Ϊ��w��h,�Ǿ�������Ŀ�͸�,�����20��ʾ�����20���أ�15��ʾ���߶�15���ء�
�������������ĵط������������ҡ�
		 */
		g.fillRect(0, 0, width, height);
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			g.setColor(getRandColor(50, 100));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			/**
			 * fillRect��x,y,w,h�������������ǣ����һ����������x��yΪ��ʼ���꣨�����Ͻ����꣩,
			 * �������������ֱ�Ϊ��w��h,�Ǿ�������Ŀ�͸�,�����20��ʾ�����20���أ�
			 * 15��ʾ���߶�15���ء�
			 */
			g.drawOval(x, y, 5, 5);
		}
		g.setFont(new Font("", Font.PLAIN, 40)); // �������壬����׼���������
		String sRand = ""; // ������ַ���
		for (int i = 0; i < 4; i++) {
			// �����ĸ������ַ�
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// ���������ɫ
			g.setColor(new Color(20 + random.nextInt(80), 20 + random
					.nextInt(100), 20 + random.nextInt(90)));
			// ��������ֻ���ͼ����
			
			/**
			 * drawString 
public abstract void drawString(AttributedCharacterIterator iterator, 
int x, 
int y) 
ʹ�ô�ͼ�������ĵĵ�ǰ��ɫ������ָ���������������ı�������������Ϊÿ���ַ�ָ�����塣������ַ��Ļ���λ�ڴ�ͼ������������ϵͳ�� (x, y) λ�ô��� 

������ 
iterator - Ҫ�������ı��ĵ����� 
x - x ���ꡣ 
y - y ���ꡣ 
����μ��� 
drawBytes(byte[], int, int, int, int), drawChars(char[], int, int, int, int)
			 * 
			 */
			g.drawString(rand, (17 + random.nextInt(3)) * i + 8, 34);

			// ���ɸ�����
			for (int k = 0; k < 12; k++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(9);
				int yl = random.nextInt(9);
				/**
				 * ��������ǻ�һ��ֱ�ߣ���ô���Ƕ�֪������ȷ��һ��ֱ�ߣ������������ɺ�(X)��������(y)ȷ��һ���㣬���Ĳ���ʵ�ʾ���ȷ�������㣬��Ҫ����ֱ�ߵ���ʼ�����������յ�ĺ������ꡣ
X1��Y1��ȷ��ֱ�ߵ���ʼ�㣬��������Ϊx1��������Ϊy1�ĵ㡣ͬ��x2,y2ȷ��ֱ�ߵ��յ㡣
��A(x1,y1)  B(x2,y2) �Ϳ��Ի���ֱ��AB��
				 * 
				 * 
				 * 
				 * public abstract void drawLine(int x1,
                              int y1,
                              int x2,
                              int y2)�ڴ�ͼ�������ĵ�����ϵͳ�У�ʹ�õ�ǰ��ɫ�ڵ� (x1, y1) �� (x2, y2) ֮�仭һ���ߡ� 

������
x1 - ��һ����� x ���ꡣ
y1 - ��һ����� y ���ꡣ
x2 - �ڶ������ x ���ꡣ
y2 - �ڶ������ y ���ꡣ

Ʃ�磬���(0,0, 100, 200),���Ǵӻ�һ����(0,0)�㿪ʼ��Ŀ���(100,200����ֱ��
				 * 
				 * 
				 */
				g.drawLine(x, y, x + xl, y + yl);
			}
		}

		// �����ɵ���������ַ���д��session
		request.getSession().setAttribute("randomNumber", sRand);
		g.dispose(); // ʹͼ����Ч
		ImageIO.write(image, "JPEG", response.getOutputStream()); // ���ͼ��ҳ��
	}

	// ����һ���������ɫ ���У�min:��ɫ������Сֵ ;max:��ɫ�������ֵ
	public Color getRandColor(int min, int max) {
		Random random = new Random();
		if (min > 255) {
			min = 255;
		}
		if (max > 255) {
			max = 255;
		}
		int R = min + random.nextInt(max - min);
		int G = min + random.nextInt(max - min);
		int B = min + random.nextInt(max - min);
		/**
		 * 0~255   ��ɫ��0~7 λ       ��ɫ��8~15λ        ��ɫ��16~23λ
		 */
		return new Color(R, G, B);
	}

}
