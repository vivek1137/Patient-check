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
    public ArrayList<visit> visited_count = new ArrayList<visit>();

    public Patient(int patientID, String name,String location) {
        this.patientID = patientID;
        this.location = location;
        this.hospitalvisits = new ArrayList<Hospitalvisit>();
        this.name = name;
    }

    public void hospital_visit_details(Hospitalvisit hospitalvisit) {
        this.hospitalvisits.add(hospitalvisit);
    }

    public int visitcount(String hospital_name) {
        int count=0;
        ArrayList<Hospitalvisit> hospitalvisits = this.hospitalvisits;
        for(Hospitalvisit hospitalvisit : hospitalvisits) {
            if(hospitalvisit.hospital_name.equals(hospital_name))
                count = count + hospitalvisit.getTotalVisit();
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