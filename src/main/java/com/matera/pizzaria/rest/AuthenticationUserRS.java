package com.matera.pizzaria.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matera.pizzaria.dto.TokenTransferDto;
import com.matera.pizzaria.dto.UserLoginDto;
import com.matera.pizzaria.exception.HttpUnauthorizedException;
import com.matera.pizzaria.support.TokenUtils;

@Controller
@RequestMapping("/auth")
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
	@ResponseBody
	@RequestMapping(value = "user", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> getUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
			throw new HttpUnauthorizedException();
		}
		UserDetails userDetails = (UserDetails) principal;

		return ResponseEntity.ok(this.userService.loadUserByUsername(userDetails.getUsername()));
	}

	/**
	 * Authenticates a user and creates an authentication token.
	 * 
         * @param userLogin
	 * @return A transfer containing the authentication token.
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public TokenTransferDto authenticate(@RequestBody UserLoginDto userLogin) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userLogin.getUsername(), userLogin.getPassword());
		Authentication authentication = this.authManager
				.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload user as password of authentication principal will be null
		 * after authorization and password is needed for token generation
		 */
		UserDetails userDetails = this.userService.loadUserByUsername(userLogin
				.getUsername());

		TokenTransferDto tokenTransferDto = new TokenTransferDto(TokenUtils.createJwtToken(userDetails));
		return tokenTransferDto;
	}

}
