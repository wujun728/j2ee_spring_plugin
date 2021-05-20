package com.jun.plugin.poi.test.excel.converter;

import java.lang.reflect.Type;

import com.jun.plugin.poi.test.excel.core.handler.ConverterHandler;
import com.jun.plugin.poi.test.excel.vo.OutValue;
import com.jun.plugin.poi.test.excel.vo.OutValue.OutType;

public class AbstractFieldConvertor implements FieldValueConverter {

	@Override
	public boolean canConvert(Class<?> clz) {

		return false;
	}

	@Override
	public OutValue toObject(Object source,ConverterHandler converterHandler) {
		if(source==null){
			return null;
		}
		return new OutValue(OutType.STRING, source.toString());
	}

	@Override
	public Object fromString(String cell, ConverterHandler converterHandler,
			Type targetType) {
		if (cell == null) {
			return null;
		}
		return cell;
	}

}
