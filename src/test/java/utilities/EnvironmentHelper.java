package utilities;

import org.testng.Assert;

/**
 * Generate the url according to the environment passed in the argument.
 */
public class EnvironmentHelper {
    public static String url;
    public static String env = "test"; //System.getProperty("env");




    /**
     * Append the environment and appName under scope
     *
     * @return Website URL
     */
//    public static String getURL(String appName) {
//        url = ("https://" + env + "-" + appName + ".altono.app/").toLowerCase();
//        return url;
//    }
    public static String getURL(String appName) {
        url = ("https://" + "test" + "-" + appName + ".altono.app/").toLowerCase();
        return url;

    }

}
