package com.matera.pizzaria.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matera.pizzaria.model.TokenTransfer;
import com.matera.pizzaria.model.UserLogin;
import com.matera.pizzaria.support.TokenUtils;

@Controller
@RequestMapping("/xyz")
public class AuthenticationUserRS {

	@Autowired
	private UserDetailsService userService;

	@Autowired
	@Qualifier("authenticationManager")	
	private AuthenticationManager authManager;
	
	/**
	 * Retrieves the currently logged in user.
	 * 
	 * @return A transfer containing the username and the roles.
	 */
//	@RequestMapping(value = "authenticate", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
//	public UserTransfer getUser()
//	{
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		Object principal = authentication.getPrincipal();
//		if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
//			throw new HttpUnauthorizedException();
//		}
//		UserDetails userDetails = (UserDetails) principal;
//
//		return new UserTransfer(userDetails.getUsername(), this.createRoleMap(userDetails));
//	}

	/**
	 * Authenticates a user and creates an authentication token.
	 * 
	 * @param username
	 *            The name of the user.
	 * @param password
	 *            The password of the user.
	 * @return A transfer containing the authentication token.
	 */
	@RequestMapping(value = "authenticate", 
			method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public TokenTransfer authenticate(
			/*@RequestParam("username") String username,
			@RequestParam("password") String password*/
			@RequestBody UserLogin userLogin
			) {
		
		System.out.println(userLogin.getUsername());
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userLogin.getUsername(), userLogin.getPassword());
		Authentication authentication = this.authManager
				.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload user as password of authentication principal will be null
		 * after authorization and password is needed for token generation
		 */
		UserDetails userDetails = this.userService.loadUserByUsername(userLogin.getUsername());

		return new TokenTransfer(TokenUtils.createToken(userDetails));
	}
	
	private Map<String, Boolean> createRoleMap(UserDetails userDetails)
	{
		Map<String, Boolean> roles = new HashMap<String, Boolean>();
		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			roles.put(authority.getAuthority(), Boolean.TRUE);
		}

		return roles;
	}

}
