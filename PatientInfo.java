/**********************************
*class: patientInfo- patient object
*/
//import libraries
import java.io.*;

public class PatientInfo {
	
	//assign record size and declare variables for following:
	//Owner Name, Phone Number, Address, Email, 
	//Pet Name, Breed, Sex, Date of Birth, 
	//Medical/ Vaccine History, and Neutered/sprayed
	// all strings of byte size 30 and integer ID is 8 bytes
	protected int ID;
	protected String owner, phone, address, email, pet, breed, sex, dob, mvh, ns;
	protected static final int RECORD_SIZE = 308;
	
	
	//constructor: when another class calls to load a 
	//record of the class patientInfo
	
	public PatientInfo(RandomAccessFile input) throws IOException
	{
		//read integer for ID
		ID=input.readInt();
		
		//create holder for the bytes of size 30
		//fill bytes from the file
		//convert the bytes into a String	
		//repeat for all variables
		//create holder for the bytes of size 30
		byte[] ownerBytes = new byte[30];
		//fill ownerBytes from the file
		input.readFully(ownerBytes);
		//convert the bytes into a String
		owner = new String(ownerBytes, 0);
		
		//create holder for the bytes of size 30
		byte[] phoneBytes = new byte[30];
		//fill phoneBytes from the file
		input.readFully(phoneBytes);
		//convert the bytes into a String
		phone = new String(phoneBytes, 0);
		
		byte[] addressBytes = new byte[30];
		input.readFully(addressBytes);
		address = new String(addressBytes, 0);
		
		byte[] emailBytes = new byte[30];
		input.readFully(emailBytes);
		email = new String(emailBytes, 0);
		
		byte[] petBytes = new byte[30];
		input.readFully(petBytes);
		pet = new String(petBytes, 0);
		
		byte[] breedBytes = new byte[30];
		input.readFully(breedBytes);
		breed = new String(breedBytes, 0);
		
		byte[] sexBytes = new byte[30];
		input.readFully(sexBytes);
		sex = new String(sexBytes, 0);
		
		byte[] dobBytes = new byte[30];
		input.readFully(dobBytes);
		dob = new String(dobBytes, 0);
		
		byte[] mvhBytes = new byte[30];
		input.readFully(mvhBytes);
		mvh = new String(mvhBytes, 0);
		
		byte[] nsBytes = new byte[30];
		input.readFully(nsBytes);
		ns = new String(nsBytes, 0);
	}
	
	//constructor: when another class calls to create a new patient record
	//data to be stored is passed as parameters
	public PatientInfo (String Owner, String Phone, String Address, String Email, String Pet, String Breed, String Sex, String Dob, String Mvh, String Ns, int Id)
	{
		//store data passed in variables
		this.owner= Owner;
		this.phone= Phone;
		this.address=Address;
		this.email=Email;
		this.pet=Pet;
		this.breed=Breed;
		this.sex=Sex;
		this.dob=Dob;
		this.mvh=Mvh;
		this.ns=Ns;
		this.ID=Id;
		
		System.out.println(owner);
		
	}
	
	//method: When String field data is written to a random access file, 
	//and the String data is not as long as the prescribed maximum length 
	//of the field as outlined in the class, the String field should be
	//padded with spaces to prevent junk data storage in the field location 
	//of the random file. 

	public static String fillspace(String word, int lengthoffill)
	{
		//code to fill spaces
		int x;
		for(x = word.length(); x < lengthoffill ; x++)
		{
			word = word + " ";
		}
		return word;
	}
	
	//method: interracts with processed data in the patientInfo class
	public void write(RandomAccessFile output) throws IOException
	{
		//output the ID number
		output.writeInt(ID);
		//create temp holder for the bytes
		//convert your string into bytes and put them into
		//somethingBytes
		//write the bytes into your file
		//repeat for all variables
		byte[] ownerBytes = new byte[30];
		owner.getBytes(0, owner.length(), ownerBytes, 0);
		output.write(ownerBytes);
		
		byte[] phoneBytes = new byte[30];
		phone.getBytes(0, phone.length(), phoneBytes, 0);
		output.write(phoneBytes);
		
		byte[] addressBytes = new byte[30];
		address.getBytes(0, address.length(), addressBytes, 0);
		output.write(addressBytes);
		
		byte[] emailBytes = new byte[30];
		email.getBytes(0, email.length(),emailBytes, 0);
		output.write(emailBytes);
		
		byte[] petBytes = new byte[30];
		pet.getBytes(0, pet.length(), petBytes, 0);
		output.write(petBytes);
		
		byte[] breedBytes = new byte[30];
		breed.getBytes(0, breed.length(), breedBytes, 0);
		output.write(breedBytes);
		
		byte[] sexBytes = new byte[30];
		sex.getBytes(0, sex.length(), sexBytes, 0);
		output.write(sexBytes);
		
		byte[] dobBytes = new byte[30];
		dob.getBytes(0, dob.length(), dobBytes, 0);
		output.write(dobBytes);
		
		byte[] mvhBytes = new byte[30];
		mvh.getBytes(0, mvh.length(), mvhBytes, 0);
		output.write(mvhBytes);
		
		byte[] nsBytes = new byte[30];
		ns.getBytes(0, ns.length(), nsBytes, 0);
		output.write(nsBytes);
	}

//methods to return variables
	public int getID()
	{
		return ID;
	}
	public String getOwner()
	{
		return owner;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getAddress()
	{
		return address;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPet()
	{
		return pet;
	}
	public String getBreed()
	{
		return breed;
	}
	public String getSex()
	{
		return sex;
	}
	public String getDob()
	{
		return dob;
	}
	public String getMvh()
	{
		return mvh;
	}
	public String getNs()
	{
		return ns;
	}

}

