package com.jun.plugin.core.utils.demo;

import com.jun.plugin.core.utils.lang.Console;
import com.jun.plugin.core.utils.log.Log;
import com.jun.plugin.core.utils.log.LogFactory;
import com.jun.plugin.core.utils.log.StaticLog;
import com.jun.plugin.core.utils.log.dialect.commons.ApacheCommonsLogFactory;
import com.jun.plugin.core.utils.log.dialect.console.ConsoleLogFactory;
import com.jun.plugin.core.utils.log.dialect.jdk.JdkLogFactory;
import com.jun.plugin.core.utils.log.dialect.log4j.Log4jLogFactory;
import com.jun.plugin.core.utils.log.dialect.log4j2.Log4j2LogFactory;
import com.jun.plugin.core.utils.log.level.Level;

/**
 * 日志样例
 * @author Looly
 *
 */
public class LogDemo {
	public static void main(String[] args) {
		Log log = LogFactory.get();
		
		Console.log("----------------------------静态方法打印日志------------------------------");
		StaticLog.debug("This is static log of {}", Level.DEBUG);
		StaticLog.log(Level.DEBUG, null, "This is static log if {}", "CUSTOM");
		StaticLog.error(new Exception("Custom Exception"), "This is static log if {}", Level.ERROR);
		Console.log();
		
		Console.log("----------------------------自动选择日志------------------------------");
		// 自动选择日志实现
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		log.error("This is {} log", Level.ERROR);
		log.error(new Exception("Custom Exception"));
		
		log.log(Level.DEBUG, "This is {} log", "CUSTOM");
		Console.log();
		
		Console.log("----------------------------自定义为Log4j 日志------------------------------");
		// 自定义日志实现
		LogFactory.setCurrentLogFactory(new Log4jLogFactory());
		log = LogFactory.get();
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		log.error("This is {} log", Level.ERROR);
		log.log(Level.DEBUG, "This is {} log", "CUSTOM");
		log.error(new Exception("Custom Exception"));
		Console.log();
		
		Console.log("----------------------------自定义为Log4j2 日志------------------------------");
		// 自定义日志实现
		LogFactory.setCurrentLogFactory(new Log4j2LogFactory());
		log = LogFactory.get();
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		log.error("This is {} log", Level.ERROR);
		log.log(Level.DEBUG, "This is {} log", "CUSTOM");
		log.error(new Exception("Custom Exception"));
		Console.log();

		Console.log("----------------------------自定义为Common Log日志------------------------------");
		// 自定义日志实现
		LogFactory.setCurrentLogFactory(new ApacheCommonsLogFactory());
		log = LogFactory.get();
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		log.error("This is {} log", Level.ERROR);
		log.log(Level.DEBUG, "This is {} log", "CUSTOM");
		log.error(new Exception("Custom Exception"));
		Console.log();
		
		Console.log("----------------------------自定义为JDK Log日志------------------------------");
		// 自定义日志实现
		LogFactory.setCurrentLogFactory(new JdkLogFactory());
		log = LogFactory.get();
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		log.error("This is {} log", Level.ERROR);
		log.log(Level.DEBUG, "This is {} log", "CUSTOM");
		log.error(new Exception("Custom Exception"));
		Console.log();

		Console.log("----------------------------自定义为Console Log日志------------------------------");
		// 自定义日志实现
		LogFactory.setCurrentLogFactory(new ConsoleLogFactory());
		log = LogFactory.get();
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		log.error("This is {} log", Level.ERROR);
		log.log(Level.DEBUG, "This is {} log", "CUSTOM");
		log.error(new Exception("Custom Exception"));
		Console.log();
	}
}
