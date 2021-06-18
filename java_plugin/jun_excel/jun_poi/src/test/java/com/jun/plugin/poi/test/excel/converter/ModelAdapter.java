package com.jun.plugin.poi.test.excel.converter;


import com.jun.plugin.poi.test.excel.mapper.ExcelConverterMapperHandler;
import com.jun.plugin.poi.test.excel.vo.ListLine;
import com.jun.plugin.poi.test.excel.vo.ListRow;



/**  
 * 创建时间：2015-12-15下午2:12:56  
 * 项目名称：excel  
 * @author Wujun
 * @version 1.0   
 * 文件名称：Convertor.java  
 */
public interface ModelAdapter  {
	ListLine marshal(Object source,ExcelConverterMapperHandler handler);
	Object unmarshal(ListRow source, ExcelConverterMapperHandler handler);
}
 