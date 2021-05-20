package org.lxh.tagdemo ;
import java.io.* ;
import javax.servlet.jsp.* ;
import javax.servlet.jsp.tagext.* ;

public class AttributeTag extends TagSupport {
	private String name ;	// �������Ե�����
	private String scope ;	// �������Եķ�Χ
	
	public int doStartTag()
               throws JspException{	// ���ж������Ƿ����
		Object value = null ;
		if("page".equals(this.scope)){	// �Ƿ���page��Χ
			value = super.pageContext.getAttribute(this.name,PageContext.PAGE_SCOPE) ;
		}
		if("request".equals(this.scope)){	// �Ƿ���request��Χ
			value = super.pageContext.getAttribute(this.name,PageContext.REQUEST_SCOPE) ;
		}
		if("session".equals(this.scope)){	// �Ƿ���session��Χ
			value = super.pageContext.getAttribute(this.name,PageContext.SESSION_SCOPE) ;
		}
		if("application".equals(this.scope)){	// �Ƿ���request��Χ
			value = super.pageContext.getAttribute(this.name,PageContext.APPLICATION_SCOPE) ;
		}
		if(value == null){	// ��ʾ���ڸ�����û�д�����
			return TagSupport.SKIP_BODY ;	// û�����Բ�ִ�б�ǩ��
		} else {
			return TagSupport.EVAL_BODY_INCLUDE ;	// ִ�б�ǩ��
		}
	}

	public void setName(String name){
		this.name = name ;
	}
	public void setScope(String scope){
		this.scope = scope ;
	}
	public String getName(){
		return this.name ;
	}
	public String getScope(){
		return this.scope ;
	}
}