package designpatterns.行为型模式.通过中间类.解释器模式;

/**
 * 用来计算的实现
 * 
 * 作者: zhoubang 
 * 日期：2015年10月29日 上午10:12:01
 */
public class Minus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}