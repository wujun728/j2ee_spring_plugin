package org.lxh.tagdemo ;
import java.io.* ;
import java.util.* ;
import javax.servlet.jsp.* ;
import javax.servlet.jsp.tagext.* ;
public class DynamicAddTag extends SimpleTagSupport implements DynamicAttributes {
		private Map<String,Float> num = new HashMap<String,Float>() ;
		public void doTag()
           throws JspException,
                  IOException{
			Float sum = 0.0f ;
			Iterator<Map.Entry<String,Float>> iter = this.num.entrySet().iterator() ;
			while(iter.hasNext()){
				Map.Entry<String,Float> value = iter.next() ;
				sum += value.getValue() ;	// ȡ��ÿһ������
			}
			super.getJspContext().getOut().write(sum + "") ;
		}
		public void setDynamicAttribute(String uri,
                         String localName,
                         Object value)
                         throws JspException{
			// ȡ�����õ�ÿһ����̬���ԣ���������Map������
			num.put(localName,Float.parseFloat(value.toString())) ;
		}
}