package shin_student2.dto;

public class Rank {
	private String rank;
	private double ranksco;
	
	
	
	public Rank() {
		super();
	}
	
	
	public Rank(String rank) {
		super();
		this.rank = rank;
	}


	public Rank(String rank, double ranksco) {
		super();
		this.rank = rank;
		this.ranksco = ranksco;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public double getRanksco() {
		return ranksco;
	}
	public void setRanksco(double ranksco) {
		this.ranksco = ranksco;
	}
	@Override
	public String toString() {
		return String.format("%s", rank==null?"":rank);
	}
	
	
	
}
