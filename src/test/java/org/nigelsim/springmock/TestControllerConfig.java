package org.nigelsim.springmock;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:default-context.xml" })
public class TestControllerConfig {
    /**
     * The JMock context
     */
    protected Mockery context;
    
    /**
     * Mock service property
     */
    private IService mockService;
    
    /**
     * Setup the context and the mock objects
     */
    public TestControllerConfig() {
        context = new JUnit4Mockery();
        mockService = context.mock(IService.class);
    }
    
    /**
     * Inject the mock objects into the Spring context
     * @return
     */
    @Bean
    public IService getMockService() {
        return mockService;
    }
}
