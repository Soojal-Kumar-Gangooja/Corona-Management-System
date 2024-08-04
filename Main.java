import java.util.Scanner;
import java.io.IOException;

class CoronaManagementSystem {

	Scanner sc = new Scanner(System.in);

	String[][] data;
	int id;

	CoronaManagementSystem(){

		data = new String[100][7];
		id = 1;
		menu();
	
	}

	void menu(){

		System.out.println("\n\n ***************************** Welcome To Corona Management System **************************** \n\n");
		System.out.println(" 1. Add Patient           \t 2. Update Patient            \t 3. Remove Patient \n");
		System.out.println(" 4. View Patients By City \t 5. View Patients By State    \t 6. View Patients By Country \n");
		System.out.println(" 7. View All Patients     \t 8. Get Patient Details By Id \t 9. Exit ");
		System.out.println("\n\n ********************************************************************************************** \n");
		System.out.print(" Enter Your Choice : ");
		
		try {

			int choice = Integer.parseInt(sc.nextLine());
			
			switch (choice) {
	
				case 1:
					
					addPatient();

					break;

				case 2:

					updatePatient();
					
					break;

				case 3:

					removePatient();

					break;

				case 4:

					viewPatientsByCity();
			
					break;

				case 5:

					viewPatientsByState();
		
					break;
	
				case 6:

					viewPatientsByCountry();

					break;

				case 7:

					viewAllPatients();
					
					break;
			
				case 8:
	
					viewPatientDetails();

					break;

				case 9:		
                    
                    sc.close();
					System.out.println("\n Program Exited Successfully!");
					System.exit(0);

					break;

				default:

					System.out.println("\n Invalid Choice . Enter Choice Again ");
					menu();
			
			}

		} catch (NumberFormatException e) {
			
			System.out.println("\n Invalid Choice . Enter Again ");
			menu();

		}

	}
	
	void addPatient(){

		System.out.println("\n\n ----------------------------- Enter Your Details ----------------------------- \n");

		System.out.print("\n Enter Your Name : ");
		String name = sc.nextLine().toLowerCase();

		System.out.print("\n Enter Your Father Name : ");
		String fatherName = sc.nextLine().toLowerCase();

		System.out.print("\n Enter Your City : ");
		String cityName = sc.nextLine().toLowerCase();

		System.out.print("\n Enter Your State : ");
		String stateName = sc.nextLine().toLowerCase();

		System.out.print("\n Enter Your Country : ");
		String countryName = sc.nextLine().toLowerCase();

		System.out.print("\n Enter Your COVID Report : ");
		String covidReport = sc.nextLine().toLowerCase();

		data[id-1][0] = String.valueOf(id);
		data[id-1][1] = name;
		data[id-1][2] = fatherName;
		data[id-1][3] = cityName;
		data[id-1][4] = stateName;
		data[id-1][5] = countryName;
		data[id-1][6] = covidReport;
		
		System.out.print("\n\n Added Patient Successfully \n");

		id++;
		
		menu();

	}

    void updatePatient(){

		try {

			System.out.print("\n\n Enter Your Patient Id : ");
			int getId = Integer.parseInt(sc.nextLine());
			boolean idFound = false;
		
			for(int i=0;i<id-1;i++){
		
				if( Integer.parseInt(data[i][0]) == getId){
					
					System.out.println("\n\n ********************************** What You Want to Update *********************************** \n");
					System.out.println(" 1. Patient Name  \t 2. Patient Father Name \t 3. Patient City \n");
					System.out.println(" 4. Patient State \t 5. Patient Country     \t 6. Patient Covid Report \n");
					
					try {
	
						System.out.print(" Enter Your Choice : ");
						int choice = Integer.parseInt(sc.nextLine());

						switch (choice) {
	
							case 1:
								
								System.out.print("\n\n Enter Patient New Name : ");
								data[i][1] = sc.nextLine().toLowerCase();
								System.out.println("\n Patient Name Updated Successfully ");
								
								break;
	
							case 2:
	
								System.out.print("\n\n Enter Patient New Father Name : ");
								data[i][2] = sc.nextLine().toLowerCase();
								System.out.println("\n Patient Father Name Updated Successfully ");
			
								break;

							case 3:

								System.out.print("\n\n Enter Patient New City : ");
								data[i][3] = sc.nextLine().toLowerCase();
								System.out.println("\n Patient City Updated Successfully ");
			
								break;

							case 4:

								System.out.print("\n\n Enter Patient New State : ");
								data[i][4] = sc.nextLine().toLowerCase();
								System.out.println("\n Patient State Updated Successfully ");

				
								break;

							case 5:

								System.out.print("\n\n Enter Patient New Country : ");
								data[i][5] = sc.nextLine().toLowerCase();
								System.out.println("\n Patient Country Updated Successfully ");
			
								break;

							case 6:

								System.out.print("\n\n Enter Patient New Covid Report : ");
								data[i][6] = sc.nextLine().toLowerCase();
								System.out.println("\n Patient Covid Report Updated Successfully ");
			
								break;
		
							default:
					
								System.out.println("\n\n Wrong Choice. Enter Again ");
								updatePatient();
		
						}
					
						idFound = true;
						break;

					} catch(NumberFormatException e){
					
						System.out.println("\n\n Invalid Choice. Enter Again ");
						updatePatient();
					
					}
					

				}
		
			}

			if(!idFound){
			
				System.out.println("\n\n ---------------------- ID Not Found ---------------------- ");
			
			}
		
		} catch(NumberFormatException e){

			System.out.println("\n\n Invalid Id. Enter Id Again");
			updatePatient();

		}

		menu();

	}

	void removePatient(){

		try {

			System.out.print("\n\n Enter Your Patient Id : ");
			int getId = Integer.parseInt(sc.nextLine());
			boolean idFound = false;
		
			for(int i=0;i<id-1;i++){
		
				if( Integer.parseInt(data[i][0]) == getId){
					
					data[i][0] = "#";
					data[i][1] = "#";
					data[i][2] = "#";
					data[i][3] = "#";
					data[i][4] = "#";
					data[i][5] = "#";
					data[i][6] = "#";

					System.out.println("\n Patient Deleted Successfully ");
					
					idFound = true;
					break;
				}

			}

			if(!idFound){
			
				System.out.println("\n\n ---------------------- ID Not Found ---------------------- ");
			
			}
		
		} catch(NumberFormatException e){

			System.out.println("\n\n Invalid Id. Enter Id Again");
			removePatient();

		}

		menu();


	}

	void viewPatientsByCity(){

		System.out.print("\n\n Enter Your City Name : ");
		String getCity = sc.nextLine().toLowerCase();
		boolean cityFound = false;
		int patientCount = 0;

		System.out.println("\n ******************** All Patients Details From Your City ******************** \n");

		for (int i=0;i<id-1;i++){
		
			if( data[i][3].equals(getCity) ){
				
				System.out.println("\n -------------------------------------- \n");
				System.out.println(" Id : " + data[i][0]);
				System.out.println(" Name : " + data[i][1]);
				System.out.println(" Father Name : " + data[i][2]);
				System.out.println(" City : " + data[i][3]);
				System.out.println(" State : " + data[i][4]);
				System.out.println(" Country : " + data[i][5]);
				System.out.println(" Covid Report : " + data[i][6]);
				System.out.println("\n -------------------------------------- ");
				cityFound = true;
				patientCount++;

			}
		}

		if(!cityFound){
		
			System.out.println("\n ---------------- NO Patient Found  ------------------ \n");
		
		}

		System.out.println("\n Total Patient Found From Your City : " + patientCount );
		System.out.println("\n\n ***************************************************************************** ");

		menu();

	}

	void viewPatientsByState(){

		System.out.print("\n\n Enter Your State Name : ");
		String getState = sc.nextLine().toLowerCase();
		boolean stateFound = false;
		int patientCount = 0;

		System.out.println("\n ******************** All Patients Details From Your State ******************** \n");

		for (int i=0;i<id-1;i++){
		
			if( data[i][4].equals(getState) ){
				
				System.out.println("\n -------------------------------------- \n");
				System.out.println(" Id : " + data[i][0]);
				System.out.println(" Name : " + data[i][1]);
				System.out.println(" Father Name : " + data[i][2]);
				System.out.println(" City : " + data[i][3]);
				System.out.println(" State : " + data[i][4]);
				System.out.println(" Country : " + data[i][5]);
				System.out.println(" Covid Report : " + data[i][6]);
				System.out.println("\n -------------------------------------- ");
				stateFound = true;
				patientCount++;

			}
		}

		if(!stateFound){
		
			System.out.println("\n ---------------- NO Patient Found  ------------------ \n");
		
		}

		System.out.println("\n Total Patient Found From Your State : " + patientCount );
		System.out.println("\n\n ***************************************************************************** ");

		menu();

	}

	void viewPatientsByCountry(){

		System.out.print("\n\n Enter Your Country Name : ");
		String getCountry = sc.nextLine().toLowerCase();
		boolean countryFound = false;
		int patientCount = 0;

		System.out.println("\n ******************** All Patients Details From Your Country ******************** \n");

		for (int i=0;i<id-1;i++){
		
			if( data[i][5].equals(getCountry) ){
				
				System.out.println("\n -------------------------------------- \n");
				System.out.println(" Id : " + data[i][0]);
				System.out.println(" Name : " + data[i][1]);
				System.out.println(" Father Name : " + data[i][2]);
				System.out.println(" City : " + data[i][3]);
				System.out.println(" State : " + data[i][4]);
				System.out.println(" Country : " + data[i][5]);
				System.out.println(" Covid Report : " + data[i][6]);
				System.out.println("\n -------------------------------------- ");
				countryFound = true;
				patientCount++;

			}
		}

		if(!countryFound){
		
			System.out.println("\n ---------------- NO Patient Found  ------------------ \n");
		
		}

		System.out.println("\n Total Patient Found From Your Country : " + patientCount );
		System.out.println("\n\n ***************************************************************************** ");

		menu();

	}

	void viewAllPatients(){
		
		System.out.println("\n ************************* All Patients Details ************************* \n");

		for (int i=0;i<id-1;i++){

			if(data[i][0] == "#"){ continue;};

			System.out.println("\n -------------------------------------- \n");
		
			System.out.println(" Id : " + data[i][0]);
			System.out.println(" Name : " + data[i][1]);
			System.out.println(" Father Name : " + data[i][2]);
			System.out.println(" City : " + data[i][3]);
			System.out.println(" State : " + data[i][4]);
			System.out.println(" Country : " + data[i][5]);
			System.out.println(" Covid Report : " + data[i][6]);

			System.out.println("\n -------------------------------------- ");

		}
		
		System.out.println("\n\n *********************************************************************** ");
		menu();
	
	}

	void viewPatientDetails(){

		try {

			System.out.print("\n\n Enter Your Patient Id : ");
			int getId = Integer.parseInt(sc.nextLine());
			boolean idFound = false;
			
			for(int i=0;i<id-1;i++){
			
				if( Integer.parseInt(data[i][0]) == getId){

					System.out.println("\n\n ************************ Patient Details ************************ \n");
					System.out.println(" Name : " + data[i][1] );
					System.out.println(" Father Name : " + data[i][2] );
					System.out.println(" City : " + data[i][3]);
					System.out.println(" State : " + data[i][4]);
					System.out.println(" Country : " + data[i][5]);
					System.out.println(" Covid Report : " + data[i][6]);
					System.out.println("\n ***************************************************************** ");
					idFound = true;
					break;

				}

			}

			if(!idFound){

				System.out.println("\n\n --------------------------- Id Not Found ! ---------------------- ");

			}

			menu();

		} catch (NumberFormatException e){

			System.out.println("\n\n Invalid Id. Enter Id Again ");
			viewPatientDetails();
		
		}

		
		menu();

	}

}


public class Main {

	public static void main(String[] args){

		CoronaManagementSystem CMS = new CoronaManagementSystem();

	}

}