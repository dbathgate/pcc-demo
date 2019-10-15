package io.pivotal.pccdemo.config;

import io.pivotal.pccdemo.model.Stuff;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.tests.mock.annotation.EnableGemFireMockObjects;

@Configuration
@Profile("test")
@CacheServerApplication
public class CloudCacheTestConfig {
}
