#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.support.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * <b>Custom Repository Factory Bean</b> <BR>
 * 
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public class CustomRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {

	public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new CustomRepositoryFactory(entityManager);
	}
}
