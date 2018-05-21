package x.demo.springboot.starter.hw.outputformater;

/**
 * 格式化工具
 */
public interface OutputFormater {

    /**
     * 格式
     * @param obj 对象
     * @return 格式字符串
     */
    <T> String format(T obj);
}
