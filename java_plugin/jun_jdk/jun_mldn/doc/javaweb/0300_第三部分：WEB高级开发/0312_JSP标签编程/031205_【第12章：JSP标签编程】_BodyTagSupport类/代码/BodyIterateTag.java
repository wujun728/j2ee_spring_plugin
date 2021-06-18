package org.lxh.tagdemo ;
import java.util.* ;
import javax.servlet.jsp.* ;
import javax.servlet.jsp.tagext.* ;

public class BodyIterateTag extends BodyTagSupport {
	private String name ;
	private String scope ;
	private String id ;	// ���id���ڱ��漯���е�ÿһ��Ԫ��
	private Iterator<?> iter = null ;
	public int doStartTag()
               throws JspException{
		Object value = null ;
		if("page".equals(this.scope)){
			value = super.pageContext.getAttribute(this.name,PageContext.PAGE_SCOPE) ;
		}
		if("request".equals(this.scope)){
			value = super.pageContext.getAttribute(this.name,PageContext.REQUEST_SCOPE) ;
		}
		if("session".equals(this.scope)){
			value = super.pageContext.getAttribute(this.name,PageContext.SESSION_SCOPE) ;
		}
		if("application".equals(this.scope)){
			value = super.pageContext.getAttribute(this.name,PageContext.APPLICATION_SCOPE) ;
		}
		if(value!=null && value instanceof List<?>){
			this.iter = ((List<?>)value).iterator() ;
			if(iter.hasNext()){
				// �����Ա�����page���Է�Χ֮��
				super.pageContext.setAttribute(this.id,iter.next()) ;
				return BodyTagSupport.EVAL_BODY_BUFFERED ;
			} else {
				return BodyTagSupport.SKIP_BODY ;
			}
		} else {
			return BodyTagSupport.SKIP_BODY ;
		}
	}

	public int doAfterBody()
                throws JspException{
		if(iter.hasNext()){
			// �����Ա�����page���Է�Χ֮��
			super.pageContext.setAttribute(this.id,iter.next()) ;
			return BodyTagSupport.EVAL_BODY_AGAIN ;	// ����ִ��doAfterBody()����
		} else {
			return BodyTagSupport.SKIP_BODY ;
		}
	}
	public int doEndTag()
             throws JspException{	// ����˷���û�б�д����û�����
		if(super.bodyContent != null){	
			try{
				super.bodyContent.writeOut(super.getPreviousOut()) ;
			}catch(Exception e){
			}
		}
		return BodyTagSupport.EVAL_PAGE ;	// ����ִ�����
	}

	public void setName(String name){
		this.name = name ;
	}
	public void setScope(String scope){
		this.scope = scope ;
	}
	public void setId(String id){
		this.id = id ;
	}
	public String getName(){
		return this.name ;
	}
	public String getScope(){
		return this.scope ;
	}
	public String getId(){
		return this.id ;
	}
}