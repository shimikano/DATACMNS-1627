package com.example;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public final class Datacmns1627ApplicationTests {

	@Autowired
	private ReactiveMongoOperations mongo;

	private final String fooCollectionName = "foo";

	@Test
	void nonDeterministicReturnType() {
		var fooCollection = mongo.getCollection(fooCollectionName);

		// manually insert a document
		StepVerifier.create(fooCollection.insertOne(new Document().append("_class", "foo")))
			.expectNextCount(1)
			.verifyComplete();

		// retrieve as a more general type
		mongo.find(new Query(), Object.class, fooCollectionName)
			.as(StepVerifier::create)
			.consumeNextWith(it ->
				// depending on the iteration order of the persistent entities in the mapping context,
				// we may either end up with a Foo or a Bar
				assertThat(it).isInstanceOf(Foo.class)
			)
			.verifyComplete();
	}

}
