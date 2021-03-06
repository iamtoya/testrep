package contestx;
import java.io.Serializable;
import java.util.ArrayList;
//neu Andy

public class Judge implements Serializable {
	private static final long serialVersionUID = 2371325362221598149L;
	private String name;
	private Schule schule;
	private boolean erfahren;
	private ArrayList<Boolean> kannZuZeit;
	
	public Judge() { //Dummy-Judge
		name = "";
		erfahren = false;
		kannZuZeit = new ArrayList<>();
	}
	public Judge(String name, boolean erfahren) {
		this.name = name;
		this.erfahren = erfahren;
		kannZuZeit = new ArrayList<>();
		kannZuZeit.add(true);
		kannZuZeit.add(true);
		kannZuZeit.add(true);
		schule = new Schule("1");
	}
	
	public Judge(String name, Schule schule, boolean erfahren) {
		this.name=name;
		this.schule=schule;
		this.erfahren=erfahren;
		kannZuZeit = new ArrayList<>();
		kannZuZeit.add(true);
		kannZuZeit.add(true);
		kannZuZeit.add(true);
	}
	
	
	
	
	public String getName() {
		return name;
	}
	
	public Schule getSchule() {
		return schule;
	}
	
	public Boolean getErfahren() {
		return erfahren;
	}
	
	public Boolean getKannZuZZ1() {
		return kannZuZeit.get(0);
	}
	
	public Boolean getKannZuZZ2() {
		return kannZuZeit.get(1);
	}
	
	public Boolean getKannZuZZ3() {
		return kannZuZeit.get(2);
	}
	
	public Boolean getKannZuZeit(int zeitzone) {
		return kannZuZeit.get(zeitzone - 1);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSchule(Schule schule) {
		this.schule = schule;
	}
	
	public void setErfahren(Boolean erfahren) {
		this.erfahren = erfahren;
	}
	
	public void setKannZuZZ1(Boolean kann) {
		this.kannZuZeit.set(0, kann);
	}
	
	public void setKannZuZZ2(Boolean kann) {
		this.kannZuZeit.set(1, kann);
	}
	
	public void setKannZuZZ3(Boolean kann) {
		this.kannZuZeit.set(2, kann);
	}
	
	
}
