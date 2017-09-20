#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import ${package}.web.entity.User;
import ${package}.web.repository.UserRepository;
import ${package}.web.service.UserService;

/**
 * User service implementation
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private @Autowired UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Assert.hasText(username, "User name must not be empty");

		User user = userRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("User is not found");
		} else {
			return user;
		}
	}

}
