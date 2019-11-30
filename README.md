# DATACMNS-1627

Sample application for Spring Data Commons [Issue DATACMNS-1627](https://jira.spring.io/projects/DATACMNS/issues/DATACMNS-1627).

Demonstrates that the type of entities with a conflicting `@TypeAlias` my be non-deterministic upon retrieval.

Run

```
./gradlew test
```

a few times. The test should succeed and fail non-deterministically.
