package com.paraline.runTest;

import com.paraline.test.Login;
import com.paraline.test.MyAccount;
import com.paraline.test.Register;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({Register.class, Login.class, MyAccount.class})
public class testSuite {
}
