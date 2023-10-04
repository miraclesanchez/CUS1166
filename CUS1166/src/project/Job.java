
import java.time.LocalDate;

/*Project: Vehicular Cloud
 *Class: Job.java
 *By: Maria Andia 
 * 
 * */
public class Job {
	private String name;
	private String status;
	private LocalDate submissionDate;
	private Tuple id;
	
	public Job(String name, String status, LocalDate submissionDate, Tuple id) {
		this.name= name;
		this.status = status;
		this.submissionDate = submissionDate;
		this.id = id;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }


    public LocalDate getDate() {
        return submissionDate;
    }

    public void setDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

//    public Tuple getId() {
//        return id;
//    }
//
//    public void setId(Tuple id) {
//        this.id = id;
//    }
}
