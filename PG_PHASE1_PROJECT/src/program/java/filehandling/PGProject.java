package program.java.filehandling;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class PGProject {

	public static void main(String[] args){
		

		System.out.println("Enter the directory to start operation");
		   Scanner	scan		=		new	Scanner(System.in);
		   Scanner	scanFile		=		new	Scanner(System.in);
		   String	FileDir	=	"D://SIMPLILEARN//JAVA DATA STRUCT//exception and file//";
		while(true){
		    System.out.flush();  
					System.out.println("Application name...PG File Oper");
					System.out.println("Developer..Bejoy Shankar Pal");
					System.out.println("Choose following:");

					System.out.println("1. List Files In Directory:");
					System.out.println("2. Files Operations:");

					System.out.println("3. Exit:");
					System.out.print("Enter the choice:");
					int	Input		=	scan.nextInt();
					switch(Input){
					case 1:{
						//Lists all files in a directory
						
						File file	=	new	File(FileDir);
//						String[] strFiles	=	file.listFiles();

//						File[] ArrFiles	=	file.listFiles();
//						List<File>	lstFiles	=	Arrays.asList(ArrFiles);
						List<String>	lstFiles	=	Arrays.asList(file.list());
						Collections.sort(lstFiles); 
				        // Let us print the sorted list
				        System.out.println("List after the use of" +
				                           " Collection.sort() :\n" + lstFiles);
						//}
						break;
					}
					case 2: {//File Operations
						while(true){
						    System.out.flush();  
						System.out.println("1. Add File name to Directory:");
						System.out.println("2. Delete Fle name in Directory:");
						System.out.println("3. Search File name to Directory:");
						System.out.println("4. Back:");

						System.out.print("Enter the choice:");
						Input		=	scan.nextInt();
						switch(Input){
							case 1:{//Adding a file..

								System.out.print("Enter the file name to add:");
								String	strFile	=	scanFile.next();
								System.out.println("Adding a file.."+strFile);
											File file	=	new	File(FileDir+strFile);
								try{
								if(file.createNewFile()){
									System.out.println("New File Created..");
								}else{
									if(file.exists()){
										System.out.println("File Already Exists..");
										System.out.println("File path:"+file.getAbsolutePath());
										System.out.println("File name:"+file.getName());
										System.out.println("File class:"+file.getClass());
										System.out.println("File parent:"+file.getParent());
										System.out.println("File space allocated:"+file.getUsableSpace());
										System.out.println("File length:"+file.length()); 
									}
									else
										System.out.println("File do not exists");
								}
								}catch(IOException e){
									e.printStackTrace();
								}
								break;
							}
							case 2:{//Delete a file..

								System.out.print("Enter the file name to delete :");
								String	strFile	=	scanFile.next();
								System.out.println("Delete a file.."+strFile);
											File file	=	new	File(FileDir+strFile);
	
								try{
									if(file.exists()  && 
											file.getCanonicalFile().getName().equals(file.getName())){
																								
									boolean b=file.delete();
									if(b==true)
										System.out.println("File deleted..");
									else
										System.out.println("FNF:File Not Found");
								}
							}catch(Exception e){
								e.printStackTrace();
							}
								break;
							}
							case 3:{ 
								System.out.print("Enter the file name to search :");
								//Search a file
								String	strFile	=	scanFile.next();
								System.out.println("Search a file.."+strFile);
								try{
											File file	=	new	File(FileDir+strFile);
											
								if(file.exists()  && file.getCanonicalFile().getName().equals(file.getName()))
									System.out.println("File Found.."+strFile);
								else
									System.out.println("FNF:File Not Found.."+strFile);
								}catch(Exception e){
									e.printStackTrace();
								}
								break;
							}
							case 4: {
								System.out.println("going back..");
								break;
								
							}
						}

						//Exit loop of file operations on choose Back to Main menu, 
						if(Input==4)
							break;
						}
					}
					}
						
					//Come out of loop on exit
					if(Input==3)
						break;
		}
	System.exit(0);
}
	
}
