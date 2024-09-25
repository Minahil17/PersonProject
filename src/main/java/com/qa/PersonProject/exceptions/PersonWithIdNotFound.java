package com.qa.PersonProject.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A Person with that id does not exist")
public class PersonWithIdNotFound extends EntityNotFoundException {

}
