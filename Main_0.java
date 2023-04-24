import java.util.Scanner;

public class Main_0
{
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk)
    {
        System.out.println("Nhap So Tai Khoan: ");
        tk.setSotk(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap Ten Tai Khoan: ");
        tk.setTenTK(sc.nextLine());
        tk.setSoTien(50);
    }
    public static void main(String[] args)
    {
        Account a[] = null;
        int k, n = 0;
        int chon;
        long s, d, c, f;
        boolean flag = true;
        do
        {
            System.out.println("Vui Long Chon: ");
            System.out.println("1.Nhập Thông Tin Của Khách Hàng\n"
                    + "2.Xuất Danh Sách Thông Tin Của Khách Hàng\n" + "3.Nạp Tiền\n" + "4.Rút Tiền\n"
                    + "5.Chuyển Tiền\n" + "Nhấn Phím 0 Để Exit!");
            chon = sc.nextInt();
            switch (chon)
            {
                case 1:
                {
                    System.out.println("Nhập Số Lượng Muốn Nhập Thông Tin: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++)
                    {
                        System.out.println("Khách Hàng Thu : " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                } break;
                case 2:
                {
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "So Tien Trong TK");
                    for (int i = 0; i < n; i++)
                    {
                        a[i].inTK();
                    }
                } break;
                case 3:
                {
                    System.out.println("Nhập Số Tài Khoản Cần Nạp: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++)
                    {
                        d = a[i].getsotk();
                        if (s == d)
                        {
                            System.out.println("Chọn Tài Khoản: " + d);
                            a[i].napTien();
                        }
                        else
                        {
                            System.out.println("");
                        }
                    }
                } break;
                case 4:
                {
                    System.out.println("Nhập Số Tài Khoản Cần Rút: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++)
                    {
                        d = a[i].getsotk();
                        if (s == d)
                        {
                            System.out.println("Chọn Tài Khoản: " + d);
                            a[i].rutTien();
                        }
                    }
                } break;
                case 5:
                {
                    double chuyen, nhan, tienChuyen;
                    System.out.print("Nhập Số Tài Khoản Chuyển Tiền: ");
                    s = sc.nextLong();
                    System.out.print("Nhập Số Tài Khoản Nhận Tiền: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++)
                    {
                        d = a[i].getsotk();
                        if (s == d)
                        {
                            chuyen = a[i].getSoTien();
                            for (int j = 0; j < n; j++)
                            {
                                f = a[j].getsotk();
                                if (c == f)
                                {
                                    nhan = a[j].getSoTien();
                                    System.out.println("Nhập số Tiền: ");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen)
                                    {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSoTien(chuyen);
                                        a[j].setSoTien(nhan);
                                        System.out.println("Tài Khoản " + d + " Đã Chuyển: $" + tienChuyen);
                                        System.out.println("Tài Khoản " + f + " Đã Nhận: $" + tienChuyen);
                                    }
                                    else
                                    {
                                        System.out.println("Số Tiền Nhập Không Hợp Lý!");
                                    }
                                }
                                else
                                {
                                    System.out.println("");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("");
                        }
                    }
                } break;
            }
        } while (chon!=0);
    }
}