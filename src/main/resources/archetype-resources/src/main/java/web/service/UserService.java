#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * User service Implementation refer to {@link UserServiceImpl}
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface UserService extends UserDetailsService {

}
