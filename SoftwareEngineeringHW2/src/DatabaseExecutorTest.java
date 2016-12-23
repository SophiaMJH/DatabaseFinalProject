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
<<<<<<< HEAD
	
	private String setIndexName(int mainMenu){
		final int PHONEBOOK = 2;
		final int SCHEDULE = 3;
		final int NOTE = 4;
		
		String indexName = "";
		if(mainMenu == PHONEBOOK){
			indexName = "phoneIndex";
		}
		else if(mainMenu == SCHEDULE){
			indexName = "scheduleIndex";
		}
		else if(mainMenu == NOTE){
			indexName = "noteIndex";
		}
		return indexName;
	
	}
=======
>>>>>>> 4b4cf47255e9bf83bc27f77b520048ccf51eb44e
	}
