package org.lxh.tagdemo ;
import java.text.* ;
import java.util.* ;
import javax.servlet.jsp.* ;
import javax.servlet.jsp.tagext.* ;
public class DateTag extends TagSupport {
	private String format ;	// ���������Ե�ʱ�����ͨ��setter���
	public int doStartTag()
               throws JspException{
		SimpleDateFormat sdf = new SimpleDateFormat(this.format) ;
		// ��ʾ���и�ʽ����������ʾ����
		try{
			super.pageContext.getOut().write(sdf.format(new Date())) ;
		}catch(Exception e){
			e.printStackTrace() ;	// �쳣�������
		}
		return TagSupport.SKIP_BODY ;
	}
	public void setFormat(String format){
		this.format = format ;
	}
	public String getFormat(){
		return this.format ;
	}
}