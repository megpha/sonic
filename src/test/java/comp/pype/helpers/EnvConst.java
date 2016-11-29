package comp.pype.helpers;

public final class EnvConst {
	public static final String BASE_URL = getEnv("BASE_URL", "http://104.131.19.117/AutoSpecs/login");
	public static final String SELENIUM_GRID_URL = getEnv("BASE_URL", "http://0.0.0.0:4444/wd/hub");
	public static final boolean IS_LOCAL = getEnv("IS_LOCAL", "true") == "false";

	private static String getEnv(String env, String defaultValue) {
		String envValue = System.getenv(env);
		return (null == envValue) ? defaultValue : envValue;
	}

	private EnvConst() {
	}
}