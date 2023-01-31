package projekuas;

import java.util.Scanner;


public class InputDataKamar {
    public static void InputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             INPUT DATA KAMAR             ");
        System.out.println("==========================================");
        
        System.out.print("ID Kamar : ");
        String id_kamar = sc.nextLine();
        System.out.print("Tipe Kamar : ");
        String type_kamar = sc.nextLine();
        System.out.print("Harga Kamar : ");
        String hargakamar = sc.nextLine();
        System.out.print("ID Pelanggan : ");
        String id_pelanggan = sc.nextLine();
        
        try{
            Database.DataKamar(id_kamar, type_kamar, hargakamar, id_pelanggan);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
