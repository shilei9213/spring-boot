package x.demo.springboot.actuator.app;

/**
 * App 信息
 *
 * @author shilei0907
 * @version 1.0, 2018/11/5
 */
public class App {
    private String name;
    private String platform;

    public App() {

    }

    public App(String name, String platform) {
        this.name = name;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
