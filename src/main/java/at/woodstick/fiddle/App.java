package at.woodstick.fiddle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test class
 * @see #hasLogger()
 */
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	/**
	 * @return true if a {@link Logger} is available, false otherwise
	 */
	public boolean hasLogger() {
		LOGGER.debug("Logger: {}", LOGGER);
		return (LOGGER != null);
	}
	
	public static void main(String[] args) {
		LOGGER.info("Hello World!");
		App app = new App();
		if(app.hasLogger()) {
			LOGGER.info("Logger works!");
		}
	}
}
