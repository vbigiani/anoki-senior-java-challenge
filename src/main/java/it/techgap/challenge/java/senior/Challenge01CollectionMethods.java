package it.techgap.challenge.java.senior;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Challenge01CollectionMethods {
	
	public static int max(int[] in){
		if (in == null) {
			return Integer.MIN_VALUE;
		}
		return Arrays.stream(in).max().orElse(Integer.MIN_VALUE);
	}
	
	public static int min(int[] in){
		if (in == null) {
			return Integer.MAX_VALUE;
		}
		return Arrays.stream(in).min().orElse(Integer.MAX_VALUE);
	}
	
	public static int[] sortIt(int[] in){
		if (in == null) {
			return null;
		}
		int[] result = Arrays.copyOf(in, in.length);
		Arrays.sort(result);
		return result;
	}
	
	public static Boolean[] sortIt(Boolean[] in){
		if (in == null) {
			return null;
		}
		Boolean[] result = Arrays.copyOf(in, in.length);
		Arrays.sort(result, Comparator.reverseOrder());
		return result;
	}
	
	public static int[] removeNegative(int[] in){
		if (in == null) {
			return null;
		}
		return sortIt(Arrays.stream(in).filter(i -> i >= 0).toArray());
	}
	
	public static int count(String[] in, String e){
		if (in == null) {
			return 0;
		}
		return (int) Arrays.stream(in).filter(s -> Objects.equals(s, e)).count();
	}
	
	public static int maxRepetitions(String[] in){
		if (in == null) {
			return 0;
		}
		Map<Object, List<String>> values = Arrays.stream(in).collect(Collectors.groupingBy(x -> x));
		return values.values().stream().map(List::size).max(Comparator.naturalOrder()).orElse(0);
	}
	
	public static int[] mergeAndSort(int[]... in){
		return sortIt(Arrays.stream(in).flatMapToInt(Arrays::stream).distinct().toArray());
	}

}
