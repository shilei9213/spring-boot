# Web 项目

## 一 集成
1）依赖：
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

    会依赖mvc，aop
    
## 二 demo
1）HelloWorldController
2）HelloWorldControllerTest

## 三 使用fastjson 解析json
1）添加fastjson 包：必须1.2.10+
    适配HttpMessageConverter类 ： 
            FastJsonHttpMessageConverter ：适配4.2以下
            FastJsonHttpMessageConverter4 ：适配4.2以上
            
2）配置fastjson：
    法1：
        （1）启动类 extends WebMvcConfigurerAdapter
        （2）覆盖方法 configureMessageConverters
    法2：
        直接在创建配置Bean，走AutoConfiguration：x.demo.springboot.template.web.config.WebMvcConfig
        
3）验证
    可以添加fastjson 时间序列化
    
## 四 使用springboot devtools 进行热部署
原理：spring-boot-devtools 是一个为开发者服务的一个模块，其中最重要的功能就是自动应用代码更改到最新的App上面去。原理是在发现代码有更改之后，重新启动应用，但是比速度比手动停止后再启动还要更快，更快指的不是节省出来的手工操作的时间。
其深层原理是使用了两个ClassLoader，一个Classloader加载那些不会改变的类（第三方Jar包），另一个ClassLoader加载会更改的类，称为 restart ClassLoader,这样在有代码更改的时候，原来的restart ClassLoader 被丢弃，重新创建一个restart ClassLoader，由于需要加载的类相比较少，所以实现了较快的重启时间（5秒以内）。
1）添加依赖
        <!--热部署-->
        <!--
           devtools可以实现页面热部署（即页面修改后会立即生效，这个可以直接在application.properties文件中配置spring.thymeleaf.cache=false来实现），
           实现类文件热部署（类文件修改后不会立即生效），实现对属性文件的热部署。
           即devtools会监听classpath下的文件变动，并且会立即重启应用（发生在保存时机），注意：因为其采用的虚拟机机制，该项重启是很快的
        -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
            <scope>true</scope>
        </dependency>

2) 添加maven 插件
    <build>
        <plugins>
            <!-- 打包插件-->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!--fork :  如果没有该项配置，肯呢个devtools不会起作用，即应用不会restart -->
                    <fork>true</fork>
                </configuration>
            </plugin>
        </plugins>
    </build>

3）IDEA设置；
    IDEA 默认在非RUN或DEBUG情况下才会自动编译。因此，我们在启动Spring Boot后，再次修改类的时候不会自动编译的，开启在Run状态自动编译的流程如下：
    setting -> build 

4）补充
  如果设置SpringApplication.setRegisterShutdownHook(false)，则自动重启将不起作用。
  
  默认情况下，/META-INF/maven，/META-INF/resources，/resources，/static，/templates，/public这些文件夹下的文件修改不会使应用重启，但是会重新加载（devtools内嵌了一个LiveReload server，当资源发生改变时，浏览器刷新）。
  
  如果想改变默认的设置，可以自己设置不重启的目录：spring.devtools.restart.exclude=static/**,public/**，这样的话，就只有这两个目录下的文件修改不会导致restart操作了。
  
  如果要在保留默认设置的基础上还要添加其他的排除目录：spring.devtools.restart.additional-exclude;
  
  如果想要使得当非classpath下的文件发生变化时应用得以重启，使用：spring.devtools.restart.additional-paths，这样devtools就会将该目录列入了监听范围。
  
  设置 spring.devtools.restart.enabled 属性为false，可以关闭自动重启。可以在application.properties中设置，也可以通过设置环境变量的方式。
  
## 日志
1）spring boot 调整日志级别 debug：
    application.yaml 中 debug: true； 会跳帧框架，spring，hibernate 日志级别的debug；但自定义日志不会
    
2）文件输出：
    默认只输出控制台，写文件方法如下:
        logging.file: 指定文件路径，文件名
        logging.path: 指定日志文件路径，会在目录下创建spring.log
    默认10m截断，级别error，warn，info
     
3）日志级别：
    logging.level.*: WARN ； 其中 * 是包名，级别可以是ERROR,WARN,INFO,DEBUG,TRACE,FATAL,OFF
    
4）自定义输出格式:
    logging.pattern.console:
    logging.pattern.file:
        
5) 自定义日志配置
    logback：logback-spring.xml, logback-spring.groovy, logback.xml, logback.groovy
    log4j2：log4j2-spring.xml , log4j2.xml
    
    spring 官方推荐优先使用带有-spring.xml 作为日志配置
   
6) log4j2 配置
    （1）忽略自带的日志框架
    
                <exclusions>
                     <exclusion>
                         <artifactId>spring-boot-starter-logging</artifactId>
                         <groupId>org.springframework.boot</groupId>
                     </exclusion>
                 </exclusions>
                 
     例如：可通过插件操作
            <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-web</artifactId>
                 <exclusions>
                     <exclusion>
                         <artifactId>spring-boot-starter-logging</artifactId>
                         <groupId>org.springframework.boot</groupId>
                     </exclusion>
                 </exclusions>
             </dependency>

     （2）引入log4j2
             <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-log4j2</artifactId>
             </dependency>
             
      (3) 添加log4j2-spring.xml进行自定义
      
      (4) 按照环境读取log4j2文件
       application.yml 不同profile中添加
       logging:
         config: classpath:log4j2-test.xml
         
## maven profile 过滤配置文件
pom.xml 配置插件
    <build>
        <plugins>
            <!-- 打包插件-->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <!--spring-boot为了保护application.yml和application.properties，修改了默认的占位符${...}为@...@-->
            <!--为了spring boot的yml和properties文件能够使用maven变量替换,使用${}占位符-->
            <plugin>
                <artifactId>maven-resources-plugin</artifactId>
                <configuration>
                    <encoding>utf-8</encoding>
                    <useDefaultDelimiters>true</useDefaultDelimiters>
                </configuration>
            </plugin>
        </plugins>

        <!-- 资源文件加载 -->
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
                <includes>
                    <include>**/*</include>
                </includes>
            </resource>
        </resources>
    </build>