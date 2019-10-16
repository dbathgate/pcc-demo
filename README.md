# Pivotal Cloud Cache Testing Demo
* This demo covers how to write an integration test using a local in memory cloud cache

## Test Config
* Create a test configuration class that is annotated with `@CacheServerApplication`, which will spin up a local cloud cache server
* Set the configuration to activate on a specfic test profile using the `@Profile` annotation
* See [CloudCacheTestConfig.java](src/test/java/io/pivotal/pccdemo/config/CloudCacheTestConfig.java)
```java
@Configuration
@Profile("test")
@CacheServerApplication
public class CloudCacheTestConfig {
}
```

## Writing a Test
* Add `@RunWith(SpringRunner.class)` and `@SpringBootTest` to initialize the spring boot application
* Activiate the test profile set in the test configuration using `@ActiveProfiles`
* Note that spinning up a spring cloud cache instance on each test can break other test classes by corrupting the application context
* Adding a `@DirtiesContext` annotation will tell the test to reset the application context to not break other test classes
* Optionally can add `@AutoConfigureMockMvc` like in the example if making Mock MVC requests is disired
* See [StuffControllerTest.java](src/test/java/io/pivotal/pccdemo/controller/StuffControllerTest.java)

```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext
public class StuffControllerTest {
```