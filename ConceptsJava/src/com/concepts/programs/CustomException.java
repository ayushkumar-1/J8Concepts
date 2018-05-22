package com.concepts.programs;

import java.util.logging.Logger;

public class CustomException extends RuntimeException{
	
	public CustomException(String message) {
		super(message);
	}
}
