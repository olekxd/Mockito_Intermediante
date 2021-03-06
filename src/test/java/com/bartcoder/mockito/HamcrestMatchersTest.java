package com.bartcoder.mockito;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void simpleTeststWithMethods_HamcrestMatcher() {
		List<Integer> scores = Arrays.asList(99 ,100 ,101, 105);
		//hasItmes
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99, 100));
		//everyItems > 90
		assertThat(scores, everyItem(greaterThan(90)));
		assertThat(scores, everyItem(lessThan(190)));
		
		//String examples
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		//Array examples
		Integer[] numbers = {1, 2, 3};
		assertThat(numbers, hasItemInArray(1));
		assertThat(numbers, arrayContaining(1,2,3));
		assertThat(numbers, arrayContainingInAnyOrder(3,2,1));
	}

}
