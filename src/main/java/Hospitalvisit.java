import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Hospitalvisit {

    private String hospital_name;
    private ArrayList<LocalDate> date;

    public Hospitalvisit(String hospital_name) {
        this.hospital_name = hospital_name;
        this.date = new ArrayList<LocalDate>();
    }

    public void add_visitDetails(LocalDate date) {
        this.date.add(date);
    }


    public long get_lastNdaysvisit(int days) {

        LocalDate date = LocalDate.now();
        LocalDate past = date.minusDays(days);
        long location_count = this.date.stream().filter((s) -> s.isAfter(past) || s.compareTo(date) == 0).count();
        return location_count;
    }

    public long get_visitDuringAtimeRange(LocalDate date1,LocalDate date2) {

        long totalvisit = this.date.stream().filter((s) -> s.isAfter(date1) && s.isBefore(date2)).count();
        return totalvisit;
    }
}
