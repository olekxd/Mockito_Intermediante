package com.bartcoder.workout;

import java.util.Arrays;
import java.util.List;

public class ForMyOwnExamples {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(11, 9, 12, 99);
		List<Integer> subNnumbers = numbers.subList(1, 3);

		for(Integer ints : subNnumbers){
			System.out.println(ints);
		}
	}

}
