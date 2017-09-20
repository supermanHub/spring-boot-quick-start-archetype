#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.repository;

import ${package}.support.jpa.CustomJpaRepository;
import ${package}.web.entity.User;

/**
 * <b>User Repository</b><br>
 * You can use NamedQuery or Query annotation here.<br>
 * 
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface UserRepository extends CustomJpaRepository<User, Long> {

	/**
	 * Find user by username
	 * 
	 */
	public User findByUsername(String username);
}
