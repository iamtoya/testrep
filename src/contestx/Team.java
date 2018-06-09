package contestx;
import java.util.ArrayList;

//neu Andy

public class Team {
	private Schule schule;
	private ArrayList<Speaker> speaker;
	private Boolean isJunior;
	private ArrayList<Teambewertung> bewertungen;
	

	public Team(Schule schule, boolean isJunior) {
		this.schule=schule;
		this.isJunior=isJunior;
		speaker = new ArrayList<Speaker>();
		for(int i = 0; i < 9; i++) { //9 = max Anzahl Speaker pro Team
			speaker.add(new Speaker("", this)); //verhindert durch setSpeakerAt() ausgelöste IndexOutOfBoundsException
		}
	}

	
	public Team(Schule schule, ArrayList<Speaker> speaker, Boolean isJunior) {
		this.schule=schule;
		this.speaker=speaker;
		this.isJunior=isJunior;
	}
	
	
	
	public Schule getSchule() {
		return schule;
	}
	
	public ArrayList<Speaker> getAllSpeaker() {
		return speaker;
	}
	
	public Boolean getIsJunior() {
		return isJunior;
	}
	
	public ArrayList<Teambewertung> getTeambewertungen() {
		return bewertungen;
	}
	//funktionierende Methode ohne Teambewertung, gesaved als backup
	//public void setPoints(Speaker[] speakers, int[] punkte, Zeitzone zeitzone) {
	//	for(int i = 0; i < speakers.length; i++) { //i = 1.,2.,3.,Reply-Speaker
	//		int j = 0;
	//		while(!speaker.get(j).equals(speakers[i])) {
	//			j++;
	//		}
	//		if(i != 3) speaker.get(j).setPunkteIn(zeitzone.getNumber()-1, punkte[i]); //-1, da speaker nullbasiert, zeitzonenNummer nicht
	//		else speaker.get(j).setPunkteIn(zeitzone.getNumber()-1+3, punkte[i]);
	//	  }
	//	
	//}
	
	public void setPoints(Speaker[] speakers, int[] punkte, Zeitzone zeitzone, boolean pro, boolean win) {
		int teampunkteGesamt = 0;
		Teambewertung tb = new Teambewertung();
		
		for(int i = 0; i < speakers.length; i++) { //i = 1.,2.,3.,Reply-Speaker
			int j = 0;
			while(!speaker.get(j).equals(speakers[i])) {
				j++;
			}
			if(i != 3) speaker.get(j).setPunkteIn(zeitzone.getNumber()-1, punkte[i]); //-1, da speaker nullbasiert, zeitzonenNummer nicht
			else speaker.get(j).setPunkteIn(zeitzone.getNumber()-1+3, punkte[i]);
		    }
		
		for(int k = 0; k < punkte.length; k++) {
			teampunkteGesamt = punkte[k] + teampunkteGesamt;	
			}
		
		tb.setGesamtpunkte(teampunkteGesamt);
		tb.setIsPro(pro);
		tb.setHaveWon(win);
		tb.setZeitzone(zeitzone);
		
		for(int z = 0; z < speakers.length; z++) {
			tb.setSpeakerAt(z, speakers[z]);
		}
		this.setTeambewertung(tb);
		//this.setTeambewertungAt(index, teambewertung);
	}
	
	
	public void setSchule(Schule schule) {
		this.schule = schule;
	}
	
	public void setSpeakerAt(int index, Speaker speaker) {
		this.speaker.set(index, speaker);
	}
	
	public void setIsJunior(Boolean isJunior) {
		this.isJunior = isJunior;
	}
	
	public void setTeambewertungAt(int index, Teambewertung teambewertung) {
		if(index<3) {
			this.bewertungen.set(index, teambewertung);
		}
	}
	
	public void setTeambewertung(Teambewertung teambewertung) {
		this.bewertungen.add(teambewertung);
	}
	

	
}
