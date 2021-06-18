package com.jun.plugin.commons.util.callback.impl;

import java.util.Date;

import com.jun.plugin.commons.util.callback.IConvertValueDate;
import com.jun.plugin.commons.util.constant.SimpleDateFormatCase;

public class ConvertValueDate implements IConvertValueDate {
	private SimpleDateFormatCase formate;

	public ConvertValueDate(SimpleDateFormatCase formate) {
		this.formate = formate;
	}

	public ConvertValueDate() {
		this.formate = SimpleDateFormatCase.YYYY_MM_DD;
	}

	@Override
	public String getStr(String key) {
		return "";
	}

	@Override
	public String getStr(Date key) {
		return formate.getInstanc().format(key);
	}

}
