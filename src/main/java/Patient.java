import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Patient {

    private int patientID;
    private String name;
    private String location;
    private List<Hospitalvisit> hospitalvisits;

    public Patient(int patientID, String name,String location,List<Hospitalvisit> hospitalvisits) {
        this.patientID = patientID;
        this.location = location;
        this.hospitalvisits = hospitalvisits;
        this.name = name;
    }

    /* Calculates the total number of time patients visited a particular hospital */
    public int visitcount(String hospital_name) {
        int count=0;
        List<Hospitalvisit> hospitalvisits = this.hospitalvisits;
        for(Hospitalvisit hospitalvisit : hospitalvisits) {
            if(hospitalvisit.hospital_name.equals(hospital_name))
                count = count + hospitalvisit.getTotalVisit();
        }
        return count;
     }

     public long getTotalVisitWithinArange(LocalDate date1,LocalDate date2) {

         long count = 0;
         for(Hospitalvisit hospitalvisit : hospitalvisits) {
             List<LocalDate> dates = hospitalvisit.getDates();
              count = count + dates.stream().filter((s) -> s.isAfter(date1) && s.isBefore(date2)).count();
         }
         return count;
     }

    public int getID() {
        return this.patientID;
    }


    public String getLocation() {
        return this.location;
    }

}