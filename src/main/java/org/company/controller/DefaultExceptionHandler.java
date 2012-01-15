package org.company.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.company.service.SignupRequestNotFoundException;
import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Handles;
import org.jboss.solder.exception.control.HandlesExceptions;
import org.jboss.solder.servlet.WebRequest;

@HandlesExceptions
public class DefaultExceptionHandler {

	public void handleSignupRequestNotFoundException(
			@Handles @WebRequest CaughtException<SignupRequestNotFoundException> event, HttpServletResponse response,
			Logger log) {
		log.info("Exception logged by seam-catch catcher: "
				+ event.getException().getMessage());

		try {
			response.sendError(404);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}