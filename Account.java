import java.text.NumberFormat;
import java.util.Scanner;

public class Account {
    private static long sotk;
    private static String tenTK;
    private static double soTien;
    private static String trangthai;

public Account() {
        this(sotk = 999999, tenTK = "chưa xác định", soTien = 50.0);
    }

    public Account(long sotk, String tenTK, double soTien) {
        this.sotk = sotk;
        this.tenTK = tenTK;
        this.soTien = soTien;
        this.trangthai = trangthai;


    }

    public long getsotk() {
        return sotk;
    }

    public void setSotk(long sotk) {
        if (sotk == 999999) {
            this.sotk = sotk;
          System.out.println("Tài Khoản Không Hợp Lệ");
        } else {
            this.sotk = sotk;
           System.out.println("Tài Khoản Hợp Lệ");
        }
    }
    public String getTenTK() {
        return tenTK;
    }
    public void setTenTK(String tenTK) {
        if(tenTK.isEmpty()){
            this.tenTK = tenTK;
            System.out.println("Tên Tài Khoản Không Hợp Lý");
        }
        else{
            this.tenTK = tenTK;
            System.out.println("Tên Tài Khoản Đã Được Cập Nhật");
        }
    }

    public double getSoTien() {
        return soTien;
    }
    public void setSoTien(double soTien) {
        if(soTien < 50){
            this.soTien = soTien;
            System.out.println("Số Tiền Trong Tài Khoản Không Hợp Lý");
        }
        else{
            this.soTien = soTien;
            System.out.println("Số Tiền Của Bạn Đã Được Cập Nhật");
        }
    }

    public String gettrangThai() {
        return trangthai;
    }
    public void setTrangThai(String trangThai) {
        this.trangthai = trangThai;
    }

    @Override
    public String toString() {
        return "Account [soTK=" + sotk + ", tenTK=" + tenTK + ", soTien=" + soTien + ", trangThai=" + trangthai + "]";
    }

    public double napTien()
    {
        double nap;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Số Tiền Cần Nạp: ");
        nap = sc.nextDouble();
        if (nap >= 0)
        {
            soTien = nap + soTien;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("Đã Nạp " + str1 + " Vào Tài Khoản");
        }
        else
        {
            System.out.println("Số Tiền Cần Nạp Không Hợp Lý!");
        }
        return nap;
    }

    public double rutTien()
    {
        double rut;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhâp Số Tiền Cần Rút Ra: ");
        rut = sc.nextDouble();
        if (rut <= soTien)
        {
            soTien = soTien - rut;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Da Rut" + str1 + "Da Tu Tai Khoan");
        }
        else
        {
            System.out.println("So Tien Muon Rut Khong Hop Ly!");
            return rutTien();
        }
        return rut;
    }

    public double daoHan()
    {
        double laiSuat = 0.035;
        soTien = soTien + soTien * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTien);
        System.out.println("Đã Được " + str1 + " Tu Dao Han 1 Thang");
        return soTien;
    }

    void inTK()
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTien);
        System.out.printf("%-10d %-20s %-20s \n", sotk, tenTK, str1);
    }
}
