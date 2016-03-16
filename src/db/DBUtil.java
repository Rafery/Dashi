package db;

public class DBUtil {
	private static final String HOSTNAME = "localhost";
	private static final String PORT_NUM = "3307";
	private static final String DB_NAME = "laiproject";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	public static final String URL;
	// initialization ke yi yong yi xia method
	static {
		URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT_NUM + "/" + DB_NAME + "?user=" + USERNAME + "&password="
				+ PASSWORD;
	}
}
