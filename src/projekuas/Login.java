package projekuas;

import java.util.Scanner;

public class Login {
    public static void Login(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             LOGIN             ");
        System.out.println("===============================");
        
        System.out.print("Username : ");
        String id_pegawai = sc.nextLine();
        
        System.out.print("Password : ");
        String pw = sc.nextLine();
        System.out.println();
        
        try{
            if(pw.equals(Database.getPassword(id_pegawai))){
                Menu2.menuForm();
            }
            else{
                System.out.println("Username Atau Password Salah");
                System.out.println("");
                Login();
            }
        }
        catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}