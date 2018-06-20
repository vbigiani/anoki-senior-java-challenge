package it.techgap.challenge.java.senior;

public class Challenge06Extra {
    public static String splitAndReverse(String i, int positions) {
    	String left = i.substring(0, positions);
    	String right = i.substring(positions);
    	
    	StringBuilder sb = new StringBuilder(right).reverse();
    	sb.append(left);
    	return sb.toString();
    }
}
