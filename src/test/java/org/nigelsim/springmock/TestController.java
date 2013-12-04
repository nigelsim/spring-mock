package org.nigelsim.springmock;

import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestControllerConfig.class })
public class TestController {

    @Autowired
    private TestControllerConfig mocks;
    @Autowired
    private Controller controller;

    /**
     * This test uses the controller method that should call
     * the service method {@link IService#performWork()}
     */
    @Test
    public void test_controller_method_a() {
        // Setup the expectation
        mocks.context.checking(new Expectations() {
            {
                oneOf(mocks.getMockService()).performWork();
            }
        });

        // Invoke the methods as required
        controller.methodA();

        // Check the assertions
        mocks.context.assertIsSatisfied();
    }

    /**
     * This one should fail because {@link Controller#methodB()} doesn't call
     * {@link IService#performWork}
     */
    @Test
    public void test_controller_method_b() {
        // Setup the expectation
        mocks.context.checking(new Expectations() {
            {
                oneOf(mocks.getMockService()).performWork();
            }
        });

        // Invoke the methods as required
        controller.methodB();

        // Check the assertions
        mocks.context.assertIsSatisfied();
    }
}
