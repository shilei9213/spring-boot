package x.demo.springboot.starter.hw;

import x.demo.springboot.starter.hw.autoconfiguration.HelloWorldProperties;
import x.demo.springboot.starter.hw.outputformater.OutputFormater;

/**
 * 配置文件中的作者信息
 * HelloWorld
 * 对象信息
 */
public class HelloWorldTemplate {

    private HelloWorldProperties helloWorldProperties;

    private OutputFormater outputFormater;

    public HelloWorldTemplate(HelloWorldProperties helloWorldProperties, OutputFormater outputFormater) {
        this.helloWorldProperties = helloWorldProperties;
        this.outputFormater = outputFormater;
    }

    /**
     * 打印作者信息
     * 打印对象信息
     *
     * @param obj 打印的对象
     */
    public <T> String generate(T obj) {
        StringBuilder message = new StringBuilder();
        message.append("author: ").append(outputFormater.format(helloWorldProperties.getAuthor())).append("\n");
        message.append("say: Hello World!").append("\n");
        message.append("object: ").append(outputFormater.format(obj)).append("\n");
        return message.toString();
    }
}
