import java.util.*;
import java.io.*;
import java.sql.SQLException;
import java.sql.*;

class Menu{
	String[] mainMenus = {"1. Change the user account", 
                          "2. Manage the users’ phone book", 
                          "3. Manage the user’s schedule",
                          "4. Manage the user’s notes",
                          "5. Logout"};
	String[][] subMenus = {{},{}, {"1. Add a new address", "2. View all address",
                                   "3. Delete an existing address", "4.Quit"},
	                              {"1. Add a new schedule", "2. View all schedules",
                                   "3. Delete an existing schedules", "4.Quit"},
                                  {"1. Create a new note", "2. view all note",
                                   "3. Delete an existing note", "4.Quit"}};
	int mainState;
	int subMenu;
	
	public void showMenu() throws SQLException {
		Scanner scan = new Scanner(System.in);
		mainState = 0;
		while(mainState != 5){
			for(int i=0; i<5; i++){
				System.out.println(mainMenus[i]);
			}
			System.out.print("메뉴 선택 : ");
			mainState=scan.nextInt();
			if(mainState == 5)
				break;
			showMenu(mainState);
		}
	}

	private void showMenu(int mainMenu) throws SQLException {
		Scanner scan = new Scanner(System.in);
		switch(mainMenu){
			case 1 : 
				AccountManager accountManager = new AccountManager();
				accountManager.changeAccount();
				break;
			
			case 2 : case 3 : case 4 :
				while(subMenu != 4){
					subMenu = showSubMenu(mainMenu);
					if(subMenu == 4)
						break;
					else{
						DatabaseExecutor databaseExecutor = new DatabaseExecutor();
						databaseExecutor.executeFunction(mainMenu, subMenu);
					}
				}
		}
		
	}
	
	private int showSubMenu(int mainState) {
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<4; i++){
			System.out.println(subMenus[mainState][i]);
		}
		System.out.print("메뉴 선택 : ");
		subMenu = scan.nextInt();
		return subMenu;
	}

}
