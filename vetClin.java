/*********************
The following  code class outlines the program vetClin and puts the object class
 patientInfo to full use.
*/
//import all necessary libraries
import java.awt.*;
import java.io.*;	
import java.awt.event.*;

import javax.swing.*;

public class vetClin extends JFrame implements ActionListener
{
	//create container and JPanel
	Container contentPane;
	//create control array for mirror file
	static String[] control= new String[700];
	//integer to keep track of the total records
	static int totalRecords, row, column;
	static String [][] petInfo = new String[300][3];
	static String IDnum;
	//static int variable ID
	JTextField ID;
	//JFrame
	JFrame openWin, openWindow;
	JTable table;
	JPanel newPane;
	JLabel L;
	JButton Button;
	JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
;
	JTextField owner, phone, address, email, pet, breed, sex, dob, mvh, ns, id;
	
//method for mirror file
	public static void mirror() throws IOException
	{
		//create a counter “x”
				int x;
				//fileInput to get the mirror file “patientsmirror.txt”
				BufferedReader fileInput = null;
				
				//create a new file “test”
				File test = new File("patientsmirror.txt");
				
				//check to see if a control file exists
				if(test.exists()==true)
				{
					//read patientsmirror.txt
					fileInput= new BufferedReader(new FileReader("patientsmirror.txt"));
					
					//initialize the number of records
					totalRecords = Integer.valueOf(fileInput.readLine()).intValue();
				}
				else
				{
				 	//set total records to zero
					totalRecords =0;
				}

				//fill control array
				for(x=0; x<totalRecords; x++)
				{
					//fill array
					control[x] = fileInput.readLine();
				}
				
				//close the file(if opened)
				if(fileInput!=null)
				{
					//close file
					fileInput.close();
				}
				
				//output the update to the control file
				PrintWriter fileOutput = new PrintWriter(new FileWriter("studentmirror.txt"));
				fileOutput.println(totalRecords);
			
				for(x=0; x<totalRecords; x++)
				{
					fileOutput.println(control[x]);
				}
				//close
				fileOutput.close();
				
	}
	//method for creating the menu bar
	public vetClin()
	{
		
		//create  JBarMenu, JMenu, JButton, JLabel and JMenuItem
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//create JMenu (“File”) under which JMenuItems “Main Menu” 
		//and “Quit” will be
		menu = new JMenu("File");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		//have options on the screen
		contentPane=this.getContentPane();
		newPane= new JPanel();
	
		//add a button
		JButton Button;
		// create a label that says, “Welcome! Please select an option:”
		L = new JLabel("Welcome! Please select an option:");
		newPane.add(L);
		//create three buttons, “new Patient Record”, “Edit/View a Patient Record”
		// and,  “Display all Patients.”
		Button = new JButton("New Patient Record");
		Button.addActionListener(this);
		newPane.add(Button);
		
		Button = new JButton("Edit/View a Patient Record");
		Button.addActionListener(this);
		newPane.add(Button);
		
		Button = new JButton("Display all Patients");
		Button.addActionListener(this);
		newPane.add(Button);
		
		//The newPane is connected to the contentPane
		contentPane.add(newPane);

	}
	
	//method for inputing a new patient
	public void New() throws IOException
	{
		contentPane = getContentPane();
		//Create a new window to pop up
		openWin = new JFrame("New Patient");

		//Get the JFrames content pane
		Container Record = openWin.getContentPane();
		
		newPane = new JPanel();				
		//create a JLabel, JTextField and JButton 
		//make JLabels and JTextfields for the following information: 
			//Owner Name, Phone Number, Adress, Email, 
				//Pet Name, Breed, Sex, Date of Birth, 
				//Medical/ Vaccine History, and Neutered/sprayed
				//ID #
				
				L1 = new JLabel ("Owner’s Name: ");
				newPane.add(L1 );
				owner = new JTextField(30);
				newPane.add(owner);
				
				L2 = new JLabel("Phone Number: ");
				newPane.add(L2);
				phone = new JTextField(30);
				newPane.add(phone);
				
				L3  = new JLabel("Address (Home or unit number/street /postal code): ");
				newPane.add(L3);
				address = new JTextField(30);
				newPane.add(address);
				
				L4 = new JLabel("Email: ");
				newPane.add(L4);
				email = new JTextField(30);
				newPane.add(email);
				
				L5 = new JLabel("Pet Name: ");
				newPane.add(L5);
				pet = new JTextField(30);
				newPane.add(pet);
				
				L6 = new JLabel("Breed: ");
				newPane.add(L6);
				breed = new JTextField(30);
				newPane.add(breed);
				
				L7 = new JLabel("Sex: ");
				newPane.add(L7);
				sex = new JTextField(30);
				newPane.add(sex);
				
				L8 = new JLabel("Date of Birth: ");
				newPane.add(L8);
				dob = new JTextField(30);
				newPane.add(dob);
				
				L9 = new JLabel("Has Medical/Vaccine History? (yes or no): ");
				newPane.add(L9);
				mvh= new JTextField(30);
				newPane.add(mvh);
			
				L10 = new JLabel("Neutered/Sprayed? (yes or no): ");
				newPane.add(L10);
				ns = new JTextField(30);
				newPane.add(ns);
				
				L11 = new JLabel("ID Number: ");
				newPane.add(L11);
				id = new JTextField(30);
				newPane.add(id);

				//Make button to say “Add”
				
				Button = new JButton("Add");
				Button.addActionListener(this);
				newPane.add(Button);
		
				
				Record.add(newPane);
				
				//Give it an initial size
				openWin.setSize(400,650);

				//Show it
				openWin.setVisible(true);
	}
	
	//method for adding patient to list of records
	public void add() throws IOException
	{
		//create variables to hold each of the following:
				//Owner Name, Phone Number, Adress, Email, 
				//Pet Name, Breed, Sex, Date of Birth,
				//Medical/ Vaccine History, and Neutered/sprayed
				// ID #
				String Owner, Phone, Address, Email, Pet, Breed, Sex, Dob, Mvh, Ns;
				int Id;

				//declare random access file “patient.jsd”
				RandomAccessFile patientFile = new RandomAccessFile("patient.jsd","rw");

				//enter the information from each text field into appropriate variables
				Owner = owner.getText();
				Phone= phone.getText();
				Address= address.getText();
				Email= email.getText();
				Pet= pet.getText();
				Breed= breed.getText();
				Sex= sex.getText();
				Dob= dob.getText();
				Mvh= mvh.getText();
				Ns= ns.getText();
				Id= Integer.valueOf(id.getText()).intValue();
				
				//enter into array
				petInfo [Id][0]=id.getText();
				petInfo [Id][1]=Pet;
				petInfo [Id][2]=Owner;

				//send information to object patientInfo “patient”
				PatientInfo patient = new PatientInfo(Owner, Phone, Address, Email, Pet, Breed, Sex, Dob, Mvh, Ns, Id);

				//set random access pointer Id
				patientFile.seek((long)Id*PatientInfo.RECORD_SIZE);

				//write file
				patient.write(patientFile);

				//update control file
				control[totalRecords] = Integer.toString(Id);
				totalRecords++;

	}
	

	//method for searching for a record and displaying it
	public void search() throws IOException
	{
		contentPane = getContentPane();
		//Create a new window to pop up
		openWin = new JFrame("Search Patient");

		//Get the JFrames content pane
		Container Search = openWin.getContentPane();
		newPane = new JPanel();		
				
				//declare variables for JLabel, JTextField and JButton
				JLabel L1;
				JButton search;
				
				//Have JLabel say “Please enter ID Number”
				L1= new JLabel("Please enter ID Number");
				newPane.add(L1);
				ID = new JTextField(30);
				newPane.add(ID);

				//have JButton say “Search”
				search = new JButton("Search");
				search.addActionListener(this);
				newPane.add(search);
				
				Search.add(newPane);
				
				//Give it an initial size
				openWin.setSize(500,200);

				//Show it
				openWin.setVisible(true);
	}

	//method for retrieving the searched for data
	public void retrieve() throws IOException
	{
		openWindow = new JFrame("Patient");

		//Get the JFrames content pane
		Container Retrieve = openWindow.getContentPane();
		newPane = new JPanel();	
		JPanel bottomPane = new JPanel();
		bottomPane.setLayout(new BorderLayout());
		
		
		//declare variable patientInfo “patient”
		PatientInfo patient;
		int id;
		//declare RAF “patient.jsd”
		RandomAccessFile patientFile = new RandomAccessFile("patient.jsd","r");
		
		//read id number
		id = Integer.valueOf(ID.getText()).intValue();

		//check control file before displaying
		for(int x= 0; x<totalRecords; x++)
		{	
			if(Integer.valueOf(control[x]).intValue()==id)
			{
				//set access file pointer 
				patientFile.seek((long)id*PatientInfo.RECORD_SIZE);
				patient = new PatientInfo(patientFile);
				//print data found into JLabels
				L1 = new JLabel ("Owner’s Name:            ");
				newPane.add(L1);
				
				l1= new JLabel(patient.getOwner());
				newPane.add(l1);
				
				L2 = new JLabel("Phone Number:            ");
				newPane.add(L2);
				
				l2 = new JLabel(patient.getPhone());
				newPane.add(l2);
				
				L3  = new JLabel("Address :           ");
				newPane.add(L3);
				
				l3 = new JLabel(patient.getAddress());
				newPane.add(l3);
				
				L4 = new JLabel("Email:              ");
				newPane.add(L4);
				
				l4 = new JLabel(patient.getEmail());
				newPane.add(l4);
				
				L5 = new JLabel("Pet Name:                ");
				newPane.add(L5);
				
				l5 = new JLabel(patient.getPet());
				newPane.add(l5);
				
				L6 = new JLabel("Breed:                   ");
				newPane.add(L6);
				
				l6 = new JLabel(patient.getBreed());
				newPane.add(l6);
				
				L7 = new JLabel("Sex:                     ");
				newPane.add(L7);
				
				l7 = new JLabel(patient.getSex());
				newPane.add(l7);
				
				L8 = new JLabel("Date of Birth:           ");
				newPane.add(L8);
				
				l8 = new JLabel(patient.getDob());
				newPane.add(l8);
				
				L9 = new JLabel("Medical/Vaccine History: ");
				newPane.add(L9);
				
				l9 = new JLabel(patient.getMvh());
				newPane.add(l9);
				
				L10 = new JLabel("Neutered/Sprayed:        ");
				newPane.add(L10);
				
				l10 = new JLabel(patient.getNs());
				newPane.add(l10);
				
				L11 = new JLabel("ID Number:               ");
				newPane.add(L11);
				
				l11 = new JLabel(String.valueOf(patient.getID()));
				newPane.add(l11);
				
				//save id number in a string to use in method edit() and delete()
				IDnum = String.valueOf(patient.getID());

			}
		}
		//add bottomPane to south of newPane 
		newPane.add(bottomPane, BorderLayout.SOUTH);
		
		//edit and delete buttons
		Button = new JButton("Edit");
		Button.addActionListener(this);
		bottomPane.add(Button, BorderLayout.EAST);
		
		Button = new JButton("Delete");
		Button.addActionListener(this);
		bottomPane.add(Button, BorderLayout.WEST);
		
		//add newPane to window
		Retrieve.add(newPane);
		
		//Give it an initial size
		openWindow.setSize(280,350);

		//Show it
		openWindow.setVisible(true);
	}
	//method for editing patient
	public void edit() throws IOException
	{
		//open new window named edit
		openWin = new JFrame("Edit");

		//Get the JFrames content pane
		Container Edit = openWin.getContentPane();
		newPane = new JPanel();
		PatientInfo patient;
		
		//declare RAF “patient.jsd”
				RandomAccessFile patientFile = new RandomAccessFile("patient.jsd","r");
		
		 //for first label use patient ID# from search
		L1= new JLabel(IDnum);
		int id=Integer.valueOf(IDnum).intValue();
		int x;
		//make JLabels and JTextfields for the following information: 
		//Owner Name, Phone Number, Adress, Email, 
		//Pet Name, Breed, Sex, Date of Birth, 
		//Medical/ Vaccine History, and Neutered/sprayed
		//check control file before displaying
		for(x= 0; x<totalRecords; x++)
				{
		if(Integer.valueOf(control[x]).intValue()==id)
		{
			//set access file pointer 
			patientFile.seek((long)id*PatientInfo.RECORD_SIZE);
			patient = new PatientInfo(patientFile);
			
		L1 = new JLabel ("Owner’s Name: ");
		newPane.add(L1 );
		owner = new JTextField(patient.getOwner(), 30);
		newPane.add(owner);
		
		L2 = new JLabel("Phone Number: ");
		newPane.add(L2);
		phone = new JTextField(patient.getPhone(),30);
		newPane.add(phone);
		
		L3  = new JLabel("Address (Home or unit number/street /postal code): ");
		newPane.add(L3);
		address = new JTextField(patient.getAddress(),30);
		newPane.add(address);
		
		L4 = new JLabel("Email: ");
		newPane.add(L4);
		email = new JTextField(patient.getEmail(),30);
		newPane.add(email);
		
		L5 = new JLabel("Pet Name: ");
		newPane.add(L5);
		pet = new JTextField(patient.getPet(), 30);
		newPane.add(pet);
		
		L6 = new JLabel("Breed: ");
		newPane.add(L6);
		breed = new JTextField(patient.getBreed(), 30);
		newPane.add(breed);
		
		L7 = new JLabel("Sex: ");
		newPane.add(L7);
		sex = new JTextField(patient.getSex(), 30);
		newPane.add(sex);
		
		L8 = new JLabel("Date of Birth: ");
		newPane.add(L8);
		dob = new JTextField(patient.getDob(), 30);
		newPane.add(dob);
		
		L9 = new JLabel("Has Medical/Vaccine History? (yes or no): ");
		newPane.add(L9);
		mvh= new JTextField(patient.getMvh(), 30);
		newPane.add(mvh);
	
		L10 = new JLabel("Neutered/Sprayed? (yes or no): ");
		newPane.add(L10);
		ns = new JTextField(patient.getNs(), 30);
		newPane.add(ns);
		}
		}
		
		//Make button to say “Save”
		Button = new JButton("Save");
		Button.addActionListener(this);
		newPane.add(Button);
		
		Edit.add(newPane);
		
		//Give it an initial size
		openWin.setSize(400,650);

		//Show it
		openWin.setVisible(true);
	}
	public void Saved() throws IOException
	{
		
	
		//save new information
		//create variables to hold each of the following:
		//Owner Name, Phone Number, Adress, Email, 
		//Pet Name, Breed, Sex, Date of Birth,
		//Medical/ Vaccine History, and Neutered/sprayed
		// ID #
		String Owner, Phone, Address, Email, Pet, Breed, Sex, Dob, Mvh, Ns;
		int Id;

		//declare random access file “patient.jsd”
		RandomAccessFile patientFile = new RandomAccessFile("patient.jsd","rw");

		//enter the information from each text field into appropriate variables
		Owner = owner.getText();
		Phone= phone.getText();
		Address= address.getText();
		Email= email.getText();
		Pet= pet.getText();
		Breed= breed.getText();
		Sex= sex.getText();
		Dob= dob.getText();
		Mvh= mvh.getText();
		Ns= ns.getText();
		Id= Integer.valueOf(IDnum).intValue();
		
		//enter into array
		petInfo [Id][0]=IDnum;
		petInfo [Id][1]=Pet;
		petInfo [Id][2]=Owner;
		
		//send information to object patientInfo “patient”
		PatientInfo patient = new PatientInfo(Owner, Phone, Address, Email, Pet, Breed, Sex, Dob, Mvh, Ns, Id);

		//set random access pointer Id
		patientFile.seek((long)Id*PatientInfo.RECORD_SIZE);

		//write file
		patient.write(patientFile);

		//update control file
		control[totalRecords] = Integer.toString(Id);
		totalRecords++;
	}
	public void DelSaved() throws IOException
	{
	//Delete what has been saved
	for(int i=0;i<totalRecords; i++)
	{
		if(control[i].compareTo(IDnum)==0)
		{
			for(int j=i; j<totalRecords-1; j++)
			{
				control[j]= control[j+1];
			}
		}
		totalRecords--;
	}
	int Id= Integer.valueOf(IDnum).intValue();
	//enter into array
	petInfo [Id][0]="";
	petInfo [Id][1]="";
	petInfo [Id][2]="";
	Saved();
	}
	
	//method for deleting a patient
	public void delete()
	{
		//open new window named delete
		//get JFrames content pane
		openWin = new JFrame("Delete");

		//Get the JFrames content pane
		Container Delete = openWin.getContentPane();
		newPane = new JPanel();
		//create a JLabel,  and JButton
		//have JLabel say” Are you sure you want to delete?
		//JButton yes and JButton cancel
		L1 = new JLabel("Are you sure you want to delete?");
		newPane.add(L1);
		
		Button = new JButton("Yes");
		Button.addActionListener(this);
		newPane.add(Button);
		
		Button = new JButton("Cancel");
		Button.addActionListener(this);
		newPane.add(Button);
		
		Delete.add(newPane);
		
		//Give it an initial size
				openWin.setSize(300,200);

				//Show it
				openWin.setVisible(true);
	}
	//method for removing a patient from list
	public static void deleting() throws IOException
	{

		for(int i=0;i<totalRecords; i++)
		{
			if(control[i].compareTo(IDnum)==0)
			{
				for(int j=i; j<totalRecords-2; j++)
				{
					control[j]= control[j+1];
				}
				totalRecords--;
			}
		}
		int Id= Integer.valueOf(IDnum).intValue();
		//enter into array
		petInfo [Id][0]="";
		petInfo [Id][1]="";
		petInfo [Id][2]="";
	}

	//method for displaying all patients
	public void display() throws IOException
	{
		//open new window named delete
		//get JFrames content pane
		openWin = new JFrame("Patient Table");

		//Get the JFrames content pane
		Container Display = openWin.getContentPane();
		newPane = new JPanel();
		newPane.setLayout(new BorderLayout());
	
		//create a new table
		String[] columnNames = {"ID","Pet Name","Owner"};
		table = new JTable (petInfo, columnNames);
		newPane.add(table, BorderLayout.CENTER);
		
		//allow scroll capabilities for table
		JScrollPane scrollPane = new JScrollPane(table);
		newPane.add(scrollPane, BorderLayout.CENTER);
		
		Display.add(newPane);
		
		//Give it an initial size
		openWin.setSize(600,400);

		//Show it
		openWin.setVisible(true);
		
	}
	//add an action listener to handle the user clicking on menu items
		public void actionPerformed (ActionEvent e)
		{
			String event = e.getActionCommand();
			
			//use if statements for each button and menu option
			//if quit “hide();” “System.exit(0);”
			if(event.equals("Quit"))
			{
				System.exit(0);
			}

			//if new patient record call method “New()”
			else if (event.equals("New Patient Record"))
			{
				try
				{
					New();
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
			}
			// if edit/view a patient record call method “Search()”
			else if (event.equals("Edit/View a Patient Record"))
			{
				try{
					search();
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
					
			}
			// if display all patients call method “Display()”
			else if (event.equals("Display all Patients"))
			{	
				try
				{
					display();
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
			}
			//if add patient call method “add()”
			else if (event.equals("Add"))
			{
				openWin.dispose();
				try
				{
					add();
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
				
			}
			//if search call method “retrieve()”
			else if (event.equals("Search"))
			{
				openWin.dispose();
				
				try{
					
				retrieve();
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
				
			}
			//if edit call method “edit()”
			else if (event.equals("Edit"))
			{
				
				try
				{
					edit();
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
			}
			//if save call method “saved()”
			else if (event.equals("Save"))
			{
				openWin.dispose();
				openWindow.dispose();
				try{
					
					DelSaved();
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
				
			}
			//if delete  call method “delete()”
			else if (event.equals("Delete"))
			{
				delete();
			}
			//if yes call method “deleting()”
			else if (event.equals("Yes"))
			{
				openWin.dispose();
				openWindow.dispose();
				try
				{
					deleting();
					
				}
				catch(IOException ioerror)
				{
					System.out.println("error");
				}
				
				
			}
			//if cancel close window
			else if (event.equals("Cancel"))
			{
				openWin.dispose();
			}
		}

	
	public static void main(String [] args) throws IOException
	{

		//initialize a vetClinic window, set title to “Java Vet Clinic Records”, 
		//set size to 800 by 600
		vetClin window = new vetClin();
		window.setTitle("Java Vet Clinic Records");
		window.setSize(300,200);
		window.setVisible(true);
		
		mirror();
	}


}

