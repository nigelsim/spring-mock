package org.nigelsim.springmock;

import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
    @Autowired
    private IService service;
    
    public void methodA() {
        service.performWork();
    }
    
    public void methodB() {
        // do nothing
    }
}
