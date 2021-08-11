import org.apache.log4j.*;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static int add(int a, int b) {
		ConsoleAppender cp = new ConsoleAppender();
		cp.setThreshold(Level.INFO);
		cp.setLayout(new PatternLayout("%d [%p|%c|%c{1}]"));
		cp.activateOptions();
		LogManager.getRootLogger().addAppender(cp);
		
		logger.debug("Hello, this is a debug message.");
		logger.info("Hello, this is an info message.");
		
		try {
			
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		
		logger.debug("Hello, this is a debug message.");
		logger.info("Hello, this is an info message.");
		
		int c = a + b;
		return c;
		
	}
	
	public static void main(String[] args) {
		add(100, 200);
	}
}
