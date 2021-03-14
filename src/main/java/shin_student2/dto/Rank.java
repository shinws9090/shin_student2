package shin_student2.dto;

public class Rank {
	private String rank;
	private double rankSco;
	public Rank(String rank, double rankSco) {
		super();
		this.rank = rank;
		this.rankSco = rankSco;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public double getRankSco() {
		return rankSco;
	}
	public void setRankSco(double rankSco) {
		this.rankSco = rankSco;
	}
	@Override
	public String toString() {
		return String.format("Rank [rank=%s, rankSco=%s]", rank, rankSco);
	}
	
	
}
