package step_definitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.LogUtil;

public class DummyStepDefs {

    @Given("This test is passed")
    public void thisTestIsPassed() {
        LogUtil.infoLog(DummyStepDefs.class, "Passing step def");
        Assert.assertTrue(true);
    }

    @Given("This test has been failed")
    public void thisTestHasBeenFailed() {
        LogUtil.infoLog(DummyStepDefs.class, "Failing step def");
        Assert.fail("Deliberate Faiilure");
    }
}
