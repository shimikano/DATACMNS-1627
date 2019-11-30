# DATACMNS-1627

Sample application for Spring Data Commons [Issue DATACMNS-1627](https://jira.spring.io/projects/DATACMNS/issues/DATACMNS-1627).

Demonstrates that the type of entities with a conflicting `@TypeAlias` my be non-deterministic upon retrieval.

Run

```
./gradlew clean test
```

a few times (`clean` is important not to use cached successful test results).

The test should succeed and fail non-deterministically.
