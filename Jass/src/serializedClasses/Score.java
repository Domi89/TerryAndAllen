package serializedClasses;

import java.io.Serializable;

public class Score implements Serializable{
	
	private String score ="";
	private boolean showed = false;
	
	public Score(String score) {
		this.setScore(score);
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public boolean isShowed() {
		return showed;
	}

	public void setShowed(boolean showed) {
		this.showed = showed;
	}
	
	public String toString() {
		return score;
	}

}
