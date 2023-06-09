import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
  public static void main(String[] args) throws Exception {
    // Ngày bắt đầu
    Date startDate = new Date(123, 5, 30); // Năm 123 là năm 2023, tháng 5 là tháng 6 (vì tháng bắt đầu từ 0), ngày 30

    // Ngày hiện tại
    Date currentDate = new Date();

    // Tính số ngày
    long numberOfDays = (currentDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);

    System.out.println("Số ngày từ ngày 2023-06-30 đến ngày hôm nay là: " + numberOfDays);
  }
}