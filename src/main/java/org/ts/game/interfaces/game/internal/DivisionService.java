package org.ts.game.interfaces.game.internal;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ts.game.interfaces.game.rest.DivisionDto;

public abstract class DivisionService<O extends DivisionDto> {
	public abstract String getDivision(O dto);
	
	protected List<Integer> getMatchingNumbers(Integer[] drawNumbers, Integer[] numbers) {
		Stream<Integer> drawStream = Arrays.stream(drawNumbers);
		Stream<Integer> numbersStream = Arrays.stream(numbers);
		
		List<Integer> collect = Stream.concat(drawStream, numbersStream)
	            .collect(Collectors.groupingBy(Function.identity()))
	            .entrySet()
	            .stream()
	            .filter(e -> e.getValue().size() > 1)
	            .map(e -> e.getKey())
	            .collect(Collectors.toList());
		
		return collect;
	}
	
	protected Boolean arrayContains(Integer[] numbers, Integer number) {
		return Arrays.stream(numbers).anyMatch(i -> i == number);

	}
}
