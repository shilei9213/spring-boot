package x.demo.springboot.template.dao.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 实体:
 * @Entity 指定实体，用于扫描发现
 *
 * @author shilei0907
 * @version 1.0, 2018/5/27
 */
@Data
@Entity
public class Foo {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.AUTO) //主键生成策略，autoincreace
    private Long id;
    private String name;
    private LocalDateTime createTime;
}
