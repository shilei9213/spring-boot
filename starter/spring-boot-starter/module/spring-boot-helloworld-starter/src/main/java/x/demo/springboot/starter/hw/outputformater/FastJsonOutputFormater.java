package x.demo.springboot.starter.hw.outputformater;

import com.alibaba.fastjson.JSON;

/**
 * 使用fastjson格式化
 */
public class FastJsonOutputFormater implements OutputFormater {
    /**
     * 格式
     *
     * @param obj 对象
     * @return 格式字符串
     */
    public <T> String format(T obj) {
        return "FastJsonOutputFormater: " + JSON.toJSONString(obj);
    }
}
