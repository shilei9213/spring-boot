package x.demo.springboot.starter.hw.outputformater;

import java.util.Objects;

/**
 * 使用对象toString() 格式化
 */
public class ToStringOutputFormater implements OutputFormater {
    /**
     * 格式
     *
     * @param obj 对象
     * @return 格式字符串
     */
    public <T> String format(T obj) {
        return "ToStringOutputFormater：" +Objects.toString(obj);
    }
}
