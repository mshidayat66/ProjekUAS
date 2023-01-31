package projekuas;

import java.util.Scanner;


public class DaftarPegawai {
    public static void DaftarPegawai(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             DAFTAR AKUN PEGAWAI             ");
        System.out.println("=============================================");
        
        System.out.print("Username : ");
        String id_pegawai = sc.nextLine();
        System.out.print("Password : ");
        String pw = sc.nextLine();
        System.out.print("Nama Pegawai : ");
        String nama_pegawai = sc.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        
        try{
            Database.insertAkun(id_pegawai, nama_pegawai, jenis_kelamin, alamat, pw);
            System.out.println("Tolong ingat username anda");
            System.out.println("Username anda " + id_pegawai);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
