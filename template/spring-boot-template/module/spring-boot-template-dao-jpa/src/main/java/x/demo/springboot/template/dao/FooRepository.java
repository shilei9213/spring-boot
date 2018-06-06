package x.demo.springboot.template.dao;

import org.springframework.data.repository.CrudRepository;
import x.demo.springboot.template.dao.entity.Foo;

/**
 * FooRepository
 *
 * @author shilei0907
 * @version 1.0, 2018/5/27
 */
public interface FooRepository extends CrudRepository<Foo, Long> {

}
