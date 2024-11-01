package utils;

public class Config {
    public static final String SELECTED_DRIVER = Constants.CHROME_DRIVER;
//    public static final String SELECTED_DRIVER = Constants.FIREFOX_DRIVER;
//    public static final String SELECTED_DRIVER = Constants.EDGE_DRIVER;

    public static final String ENVIROMENT = Constants.DEV;
    //    public static final String ENVIROMENT = Constants.TST;
    public static final Boolean HEADLESS = true;
    //	public static final Boolean HEADLESS = false;
    public static final int TIMEOUT = 30;                            //the time webdriver waits before giving up (in seconds)

}
