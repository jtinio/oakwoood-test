package com.oakwood.web.api.user;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oakwood.dto.rest.resource.MessageResource;
import com.oakwood.dto.user.UserDto;
import com.oakwood.dto.user.UserRegistrationDto;
import com.oakwood.service.user.UserService;
import com.oakwood.utility.exception.EmailExistException;
import com.oakwood.utility.exception.ResourceNotFoundException;
import com.oakwood.utility.exception.UsernameExistException;
import com.oakwood.web.api.exception.InvalidRestRequestException;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@RestController
@RequestMapping("/users")
public class UserWebService {

	private final UserService userService;

	public UserWebService(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("{id}")
	public UserDto getUserDtoById(@PathVariable int id) throws ResourceNotFoundException {
		return userService.getUserById(id).orElseThrow(ResourceNotFoundException::new);
	}

	@PreAuthorize("hasRole('WRITE_PERMISSION')")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public MessageResource registerUser(final @Valid @RequestBody UserRegistrationDto userRegistrationDto,
			final BindingResult bindingResult)
			throws InvalidRestRequestException, UsernameExistException, EmailExistException {
		if (bindingResult.hasErrors()) {
			throw new InvalidRestRequestException("Invalid/Missing Parameters", bindingResult);
		}
		final Optional<Integer> id = userService.createUser(userRegistrationDto);
		if (!id.isPresent()) {
			// TODO
		}
		return new MessageResource("Success");
	}

}
