package com.revature.steps.hooks;

import com.revature.TestRunner;
import com.revature.utility.Setup;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class hooks {
    @Before
    public void databaseReset(){
        Setup.resetTestDatabase();
    }
    
    @After("@NeedsLogout")
    public void logout(){
        TestRunner.homePage.logout();
    }
}
