package com;

import java.util.List;
import java.util.Scanner;

public class MainClass {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		UserDao dao=new UserDao();
		System.out.println("*****Welcome to User Application*****\n");
		boolean b=true;
		
		while(b)
		{
			System.out.println("1)Press 1 to Signup page\n2)Pree 2 to Login page\n3)Press 3 to Logout page\n4)Press 4 to View all Users\n5)Press 5 to View the User by using ID\n6)Press 6 to Update user by using ID\n7)Press 7 to delete user by using ID");
			int choice=sc.nextInt();
			
			
			switch(choice)
			{
			case 1:
			{
				System.out.println("Welcome to Signup page");
				System.out.print("Enter your id :");
				int id=sc.nextInt();
				
				System.out.print("Enter your First Name :");
				String fname=sc.next();
				
				System.out.print("Enter your Last Name :");
				String lname=sc.next();
				
				System.out.print("Enter your Gender :");
				String gender=sc.next();
				
				System.out.print("Enter your Email :");
				String email=sc.next();
				
				System.out.print("Enter your Password :");
				String password=sc.next();
				
				System.out.print("Enter your Phone Number :");
				long phone=sc.nextLong();
				
				User u=new User();
				u.setId(id);
				u.setFname(fname);
				u.setLname(lname);
				u.setGender(gender);
				u.setEmail(email);
				u.setPassword(password);
				u.setPhone(phone);
				
				dao.saveUser(u);
				
				break;
			}
			case 2:
			{
				System.out.println("Welcome to Login page");
				
				System.out.print("Enter your email:");
				String email=sc.next();
				
				System.out.print("Enter your password:");
				String password=sc.next();
				
				User u=dao.getByEmail(email);
				
				if(u !=null)
				{
					if(password.equals(u.getPassword()))
					{
						System.out.println("Successfully Login");
					}
					else
					{
						int count=0;
						for(int i=1;i<=count;i++)
						{
						System.out.println("Incorrect Password");
						count=i;
						break;
						}
						
					}
				}
				else
				{
					System.out.println("Email Not Found");
				}
				
				break;
			}
			case 3:
			{
				System.out.println("Logout Successfully");
				
				b=false;
				
				break;
			}
			case 4:
			{
				try {
					List<User> l = dao.fetchAll();
					for(User u : l)
			    {
				System.out.println(u);
				}
		       } catch (Exception e) {
				e.printStackTrace();
			   }
				
				break;
			}
			case 5:
			{
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				User u=dao.getById(id);
				
				System.out.println(u);
				
				break;
				
			}
			case 6:
			{
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				
				while(b){
					System.out.println("1)Press 1 to update the First Name\n2)Press 2 to update the Second Name\n3)Press 3 to update the Gender\n4)Press 4 to update the Email\n5)Press 5 to update the password\n6)Press 6 to update the Phone Number ");
					int choice1=sc.nextInt();
					
					switch(choice1)
					{
					case 1:
					{
						System.out.print("Enter the new First Name:");
						String fname=sc.next();
						
						User u=dao.getById(id);
						
						if(u !=null)
						{
							u.setFname(fname);
							dao.UpdateUser(u);
						}
						else
						{
							System.out.println("Id Not Found");
						}
						
						break;
						
					}
					case 2:
					{
						System.out.print("Enter the new Last Name:");
						String lname=sc.next();
						
						User u=dao.getById(id);
						
						if(u !=null)
						{
							u.setLname(lname);
							dao.UpdateUser(u);
						}
						else
						{
							System.out.println("Id Not Found");
						}
						
						break;
					}
					case 3:
					{
						System.out.print("Enter the Gender:");
						String gender=sc.next();
						
						User u=dao.getById(id);
						
						if(u !=null)
						{
							u.setGender(gender);
							dao.UpdateUser(u);
						}
						else
						{
							System.out.println("Id Not Found");
						}
						
						break;
					}
					case 4:
					{
						System.out.print("Enter the new Email:");
						String email=sc.next();
						
						User u=dao.getById(id);
						
						if(u !=null)
						{
							u.setEmail(email);
							dao.UpdateUser(u);
						}
						else
						{
							System.out.println("Id Not Found");
						}
						
						break;
					}
					case 5:
					{
						System.out.print("Enter the new Password:");
						String password=sc.next();
						
						User u=dao.getById(id);
						
						if(u !=null)
						{
							u.setPassword(password);
							dao.UpdateUser(u);
						}
						else
						{
							System.out.println("Id Not Found");
						}
						
						break;
					}
					case 6:
					{
						System.out.print("Enter the new Phone Number:");
						long phone=sc.nextLong();
						
						User u=dao.getById(id);
						
						if(u !=null)
						{
							u.setPhone(phone);
							dao.UpdateUser(u);
						}
						else
						{
							System.out.println("Id Not Found");
						}
						
						break;
					}
					default:
					{
						System.out.println("Invalid changing data");
					}
					}
					}
			}
			case 7:
			{
				System.out.print("Enter the id:");
				int id=sc.nextInt();
				
				User u=dao.getById(id);
				if(u !=null)
				{
				dao.deleteById(u, id);
			    }
				else
				{
					System.out.println("Id not Found");
				}
				break;
			}
			default:
			{
				System.out.println("Enter valid input");
			}
			}
			
		}
		
		
		
	}

}
