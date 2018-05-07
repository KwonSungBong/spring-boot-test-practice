package com.example.demo;

import com.example.demo.entity.TestEntity;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Test;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;

public class TestTestTestTests {

	@Test
	public void TEST1() {
		EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
				.seed(123L)
				.objectPoolSize(100)
				.randomizationDepth(3)
				.charset(Charset.forName("UTF-8"))
				.timeRange(LocalTime.MIN, LocalTime.MAX)
				.dateRange(LocalDate.now().minusDays(1), LocalDate.now())
				.stringLengthRange(5, 50)
				.collectionSizeRange(1, 10)
				.scanClasspathForConcreteTypes(true)
				.overrideDefaultInitialization(false)
				.build();

		Stream<TestEntity> testEntityStream = random.objects(TestEntity.class, 10);

		System.out.println();
	}

}
