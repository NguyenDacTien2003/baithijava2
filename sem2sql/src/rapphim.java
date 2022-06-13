import java.sql.*;
import java.util.Scanner;
public class rapphim {
public static void main(String[] args)throws SQLException{
try(
    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/phimrap", "root", "");
    PreparedStatement pstmtInsert = conn.prepareStatement(
            "insert into phim values (?, ?, ?, ?, ?)");
    PreparedStatement pstmtUpdate = conn.prepareStatement(
            "update phim set maphim = ? where tenphim = ?");
    PreparedStatement pstmtDelete = conn.prepareStatement(
            "delete from phim where tenphim = ?");
    PreparedStatement pstmtSelect = conn.prepareStatement(
            "select * from phim where tenphim = ?");
    PreparedStatement pstmtUpdate2 = conn.prepareStatement(
            "update phim set thoigianchieu  = ? where tenphim = ?")
    ){
    conn.setAutoCommit(false);
    try{
        int type;
        int type2;
        int maphim;
        String tenphim;
        String  thoigianchieu;
        String Daodienphim = "";
        int timechieu;
        Scanner ip = new Scanner(System.in);
        do{
            System.out.println("Ban muon lam gi: ");
            System.out.println("1.Themphim\t\t2.Sua\t\t3.Timkiem");
            type = ip.nextInt();
            if (type == 1 ){
                System.out.println("THEM PHIM ");
                ip.nextLine();
                System.out.println("\nNhap ma phim: ");
                maphim = ip.nextInt();
                System.out.println("\nNhap ten phim: ");
                tenphim = ip.next();
                System.out.println("\nNhap thoi gian chieu phim:  ");
                thoigianchieu = ip.next();
                System.out.println("\nNhap ten dao dien: ");
                String Daoienphim = ip.next();
                System.out.println("\nNhap thoi luong phim: ");
                timechieu = ip.nextInt();
                pstmtInsert.setInt(1, maphim);
                pstmtInsert.setString(2, tenphim);
                pstmtInsert.setString(3, thoigianchieu);
                pstmtInsert.setString(4, "");
                pstmtInsert.setInt   (5, timechieu);
                pstmtInsert.executeUpdate();
                System.out.println("\t\t\tThanh cong!");
            }
            else if (type == 2){
                System.out.println("SUA THONG TIN PHIM");
                ip.nextLine();
                System.out.println("Nhap ten phim muon sua: ");
                tenphim = ip.nextLine();
                System.out.println("\nBan muon sua thong tin gi:");
                System.out.println("1.mahim\t\t2.thoigianchieu");
                type2 = ip.nextInt();
                if (type2 == 1){
                    System.out.println("== SUA maphim == ");
                    ip.nextInt();
                    System.out.println("Nhap maphim: ");
                    maphim = ip.nextInt();
                    pstmtUpdate.setInt(1, maphim);
                    pstmtUpdate.setString(2, tenphim);
                    pstmtUpdate.executeUpdate();
                }
                if (type2 == 2){
                    System.out.println("== SUA thoigianchieu ==");
                    ip.nextLine();
                    System.out.println("Nhap thoigianchieu: ");
                    thoigianchieu = ip.nextLine();
                    pstmtUpdate2.setString(1,thoigianchieu);
                    pstmtUpdate2.setString(2,tenphim);
                    pstmtUpdate2.executeUpdate();
                }

            }
            else if (type == 3){
                System.out.println(" \t\t\t\tTIM KIEM ID ");
                ip.nextInt();
                System.out.println("\nNhap ID ");
                maphim = ip.nextInt();
                pstmtSelect.setInt(1, maphim);
                ResultSet rset = pstmtSelect.executeQuery();
                while (rset.next()){
                    System.out.println(rset.getInt("maphim") + ", "
                            + rset.getString("tenphim") + ", "
                            + rset.getString("thoigianchieu") + ", "
                            + rset.getString("Daodienphim") + ", "
                            + rset.getInt("timechieu"));
                }
            }
            conn.commit();
            System.out.println("Ban co muon tiep tuc khong: ");
            System.out.println("4.Co\t\t5.Khong");
            type = ip.nextInt();
            if (type == 6){
                break;
            }
        }while (type != 1 || type != 2 || type != 3 || type != 4 || type != 5);

    } catch (SQLException ex) {
        System.out.println("NHAP SAI THONG TIN");
        conn.rollback();
        ex.printStackTrace();
    }
        }
    }
    }





