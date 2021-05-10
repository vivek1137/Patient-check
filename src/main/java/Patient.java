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
    private ArrayList<Hospitalvisit> hospitalvisits;
    Hospitalvisit hospitalvisit;
    public ArrayList<visit> visited_count = new ArrayList<visit>();

    public Patient(int patientID, String name,String location) {
        this.patientID = patientID;
        this.location = location;
        this.hospitalvisits = new ArrayList<Hospitalvisit>();
        this.name = name;
    }
    /*  Add the hospital visited by the patient */
    public void hospital_visit_details(Hospitalvisit hospitalvisit) {
        this.hospitalvisits.add(hospitalvisit);
    }

    /* Calculates the total number of time patients visited a particular hospital */
    public int visitcount(String hospital_name) {
        int count=0;
        ArrayList<Hospitalvisit> hospitalvisits = this.hospitalvisits;
        for(Hospitalvisit hospitalvisit : hospitalvisits) {
            if(hospitalvisit.hospital_name.equals(hospital_name))
                count = count + hospitalvisit.getTotalVisit();
        }
        return count;
     }

     public long getTotalVisitWithinArange(LocalDate date1,LocalDate date2) {
         int i;
         long count = 0;
         for(i=0;i<this.hospitalvisits.size();i++) {
             ArrayList<LocalDate> dates = this.hospitalvisits.get(i).getDates();
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