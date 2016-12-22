import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;
import java.sql.*;

public class DatabaseExecutorTest {
	
	@Test
	public void setIndexNameTest() {
		DatabaseExecutor executedb = new DatabaseExecutor();
		int SCHEDULE = 3;
		assertNotNull(executedb.setIndexName(SCHEDULE));
		}
	}
