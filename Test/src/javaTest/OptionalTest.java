package javaTest;

import java.util.Optional;

public class OptionalTest {

	public OptionalTest() {}

	public static void main(String[] args) {
		Optional<?> testOptional = Optional.of(null);
		Optional<?> testOptional2 = Optional.of(args);
		Optional<?> testOptional3 = Optional.ofNullable(null);
		Optional<?> testOptional4 = Optional.ofNullable(args);


	}

}
