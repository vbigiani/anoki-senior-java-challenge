package it.techgap.challenge.java.senior;

import java.util.ArrayList;
import java.util.List;

public class Challenge00BaseMethods {
	
	public static int round(double d) {
		return (int) Math.round(d);
	}
	
	public static int round(String d) {
		return round(Double.parseDouble(d));
	}
	
	public static int bitNeeded(int i) {
		if (i == Integer.MIN_VALUE) {
			return Integer.BYTES * 8;
		}
		return Integer.toString(Math.abs(i), 2).length();
	}
	
	public static boolean palindromic(int num){
		String sNum = Integer.toString(num);
		StringBuilder sb = new StringBuilder();
		sb.append(sNum);
		return sNum.equals(sb.reverse().toString());
	}
	
	public static int hex(String i){
		return Integer.parseInt(i, 16);
	}
	
	public static String swapXY(String i){
		if (i == null) {
			return null;
		}
		return i.codePoints().map(x -> {switch (x) {
		case 'x':
		case 'X':
			return 'y';
		case 'y': 
		case 'Y':
			return 'x';
		default:
			return x;
		}}).collect(StringBuilder::new,
		        StringBuilder::appendCodePoint, StringBuilder::append)
		        .toString();
	}
	
	public static Number[] findNumbers(String i){
		if (i == null) {
			return new Number[0];
		}
		List<Number> result = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		for (int p = 0; p < i.length(); p++) {
			char c = i.charAt(p);
			if (c != '.' && (c < '0' || c > '9')) {
				addResult(result, sb);
			} else {
				sb.append(c);
			}
		}
		addResult(result, sb);
		
		return result.toArray(new Number[result.size()]);
	}

	private static void addResult(List<Number> result, StringBuilder sb) {
		if (sb.length() > 0) {
			try {
				if (sb.indexOf(".") > -1) {
					result.add(Double.valueOf(sb.toString()));
				} else {
					result.add(Integer.valueOf(sb.toString()));
				}
			} catch (NumberFormatException e) {
				// ignore.
			}
		}
		sb.delete(0, sb.length());
	}

}
