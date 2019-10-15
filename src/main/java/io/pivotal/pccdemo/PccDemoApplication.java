package io.pivotal.pccdemo;

import io.pivotal.pccdemo.model.Stuff;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@EnableEntityDefinedRegions(clientRegionShortcut = ClientRegionShortcut.CACHING_PROXY, basePackageClasses = Stuff.class)
@EnableGemfireRepositories
public class PccDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PccDemoApplication.class, args);
    }

}
