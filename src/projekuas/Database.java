package projekuas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {
    static final String jdbc = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/hotel";
    static final String username = "root";
    static final String password = "";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    static Statement state;
    
    public static String getPassword(String id_pegawai) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "SELECT pw FROM pegawai WHERE id_pegawai = (?)";
        ps = con.prepareStatement(query);
        ps.setString(1, id_pegawai);
        rs = ps.executeQuery();
        
        if(!rs.next()){
            return null;
        }
        else{
            return rs.getString(1).toString();
        }
    }
    
    public static void insertAkun(String id_pegawai, String nama_pegawai, String jenis_kelamin, String alamat, String pw) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO pegawai VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_pegawai);
        ps.setString(2, nama_pegawai);
        ps.setString(3, jenis_kelamin);
        ps.setString(4, alamat);
        ps.setString(5, pw);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Akun berhasil didaftarkan");
        }
        else{
            System.out.println("Akun gagal didaftarkan");
        }
    }
    
    public static void DataPelanggan(String id_pelanggan, String nama_pelanggan, String alamat, String jenis_kelamin, String id_pegawai) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO pelanggan VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_pelanggan);
        ps.setString(2, nama_pelanggan);
        ps.setString(3, alamat);
        ps.setString(4, jenis_kelamin);
        ps.setString(5, id_pegawai);
        
        if(ps.executeUpdate() > 0){
            InputDataKamar.InputData();
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void DataKamar(String id_kamar, String type_kamar, String hargakamar, String id_pelanggan) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO kamar VALUES (?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_kamar);
        ps.setString(2, type_kamar);
        ps.setString(3, hargakamar);
        ps.setString(4, id_pelanggan);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Data Berhasil Diinput");
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void ShowDataPelanggan() throws Exception{
        int no = 0;
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url, username, password);
            state = con.createStatement();
            String query = "SELECT pelanggan.*, kamar.* FROM pelanggan INNER JOIN kamar ON pelanggan.id_pelanggan=kamar.id_pelanggan";
            rs = state.executeQuery(query);
            
            while(rs.next()){
                no++;
                System.out.println("No."+ no);
                System.out.println("ID Pelanggan       : " + rs.getString("id_pelanggan"));
                System.out.println("Nama Pelanggan     : " + rs.getString("nama_pelanggan"));
                System.out.println("Alamat             : " + rs.getString("alamat"));
                System.out.println("Jenis Kelamin      : " + rs.getString("jenis_kelamin"));
                System.out.println("ID Pegawai         : " + rs.getString("id_pegawai"));
                System.out.println("ID Kamar           : " + rs.getString("id_kamar"));
                System.out.println("Tipe Kamar         : " + rs.getString("type_kamar"));
                System.out.println("Harga Kamar        : " + rs.getString("hargakamar"));
                System.out.println("-------------------------------------------------------");
            } 
        }
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }
}
