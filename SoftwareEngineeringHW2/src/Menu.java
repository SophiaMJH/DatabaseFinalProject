import java.util.*;
import java.io.*;


public class Menu {
	

	public static void showMenu(){
		
		System.out.println("1. Change the user account ");
		System.out.println("2. Manage the users’ phone book");
		System.out.println("3. Manage the user’s schedule");
		System.out.println("4. Manage the user’s notes");
		System.out.println("5. Logout");
		
		System.out.println("메뉴 선택: ");
		
		Scanner scan = new Scanner(System.in);
		int state = scan.nextInt();
		
		showMenu(state);
	}

	public static void showMenu(int state){
		
		while(state>=1 && state<=5){
			
			switch(state){
			case 1: changeAccount(); break;
			case 2: 
					System.out.println("1. Add a new address ");
					System.out.println("2. View all address");
					System.out.println("3. Delete an existing address");
					System.out.println("4.Quit");
						
			case 3: 
					System.out.println("1. Add a new schedule ");
					System.out.println("2. View all schedules");
					System.out.println("3. Delete an existing schedules");
					System.out.println("4.Quit");
					
			case 4: 
					System.out.println("1. Create a new note ");
					System.out.println("2. view all note");
					System.out.println("3. Delete an existing note");
					System.out.println("4.Quit");
					
			case 5: break;
			}
			
			System.out.println("메뉴 선택: ");
			Scanner scan = new Scanner(System.in);
			String select = scan.toString();
			
		}
	}
}
