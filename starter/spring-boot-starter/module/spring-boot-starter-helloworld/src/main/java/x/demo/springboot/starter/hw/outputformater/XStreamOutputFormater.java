package x.demo.springboot.starter.hw.outputformater;

import com.thoughtworks.xstream.XStream;

/**
 * 使用xml格式化
 */
public class XStreamOutputFormater implements OutputFormater {

    private XStream xStream;

    public XStreamOutputFormater(XStream xStream) {
        this.xStream = xStream;
    }

    /**
     * 格式
     *
     * @param obj 对象
     * @return 格式字符串
     */
    @Override
    public <T> String format(T obj) {
        return "XStreamOutputFormater：" + xStream.toXML(obj);
    }
}
