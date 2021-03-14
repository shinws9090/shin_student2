package shin_student2.dto;

public class Score {

	private Subject subject;
	private int score;
	
	public Score(Subject subject, int scoer) {
		super();
		this.subject = subject;
		this.score = scoer;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getScoer() {
		return score;
	}
	public void setScoer(int scoer) {
		this.score = scoer;
	}
	@Override
	public String toString() {
		return String.format("Score [subject=%s, score=%s]", subject, score);
	}

}
