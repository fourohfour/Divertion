package io.github.fourohfour.divertion.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadException extends Exception {
	private static final long serialVersionUID = -3431291128125031440L;
	
	public FileReadException(String message, String itemname, String filename, int line){
		StackTraceElement[] st = this.getStackTrace();
		List<StackTraceElement> stack = new ArrayList<>(Arrays.asList(st));
		stack.add(0, new StackTraceElement(message, itemname, filename, line));
		this.setStackTrace(stack.toArray(new StackTraceElement[stack.size()]));
	}
}
