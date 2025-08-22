import java.time.*;
import java.time.format.*;

class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.ofHours(9));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      
        System.out.println(now.format(formatter));
    }
}