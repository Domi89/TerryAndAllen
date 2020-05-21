package serializedClasses;

import java.io.Serializable;

public enum Rank implements Serializable {
	
	Saechs (6, 6, 0, 0, 11, 0),
	Sibe (7, 7, 0, 0, 0, 0),
	Acht (8, 8, 0, 0, 8, 8),
	Nuen (9, 13, 0, 14, 0, 0),
	Zaeh (10, 9, 10, 10, 10, 10),
	Under (11, 14, 2, 20, 2, 2),
	Ober (12, 10, 3, 3, 3, 3), 
	Koenig (13, 11, 4, 4, 4, 4),
	Ass (14, 12, 11, 11, 0, 11);	
	
	private int rankNormal;
	private int rankTrumpf;
	private int pointsNormal;
	private int pointsTrumpf;
	private int pointsUndeufe;
	private int pointsObeabe;
	
	private Rank(int rankNormal, int rankTrumpf, int pointsNormal, int pointsTrumpf,
			int pointsUndeufe, int pointsObeabe) {
		this.rankNormal=rankNormal;
		this.rankTrumpf=rankTrumpf;
		this.pointsNormal=pointsNormal;
		this.pointsTrumpf=pointsTrumpf;
		this.setPointsUndeufe(pointsUndeufe);
		this.setPointsObeabe(pointsObeabe);
		
	}

	public int getRankNormal() {
		return rankNormal;
	}



	public void setRankNormal(int rankNormal) {
		this.rankNormal = rankNormal;
	}



	public int getRankTrumpf() {
		return rankTrumpf;
	}



	public void setRankTrumpf(int rankTrumpf) {
		this.rankTrumpf = rankTrumpf;
	}



	public int getPointsNormal() {
		return pointsNormal;
	}



	public void setPointsNormal(int pointsNormal) {
		this.pointsNormal = pointsNormal;
	}



	public int getPointsTrumpf() {
		return pointsTrumpf;
	}



	public void setPointsTrumpf(int pointsTrumpf) {
		this.pointsTrumpf = pointsTrumpf;
	}



	public String toString() {
		return this.name() +" Rank ohne Trumpf: "+this.rankNormal+" Rank mit Trumpf: "+this.rankTrumpf+" Punkte ohne Trumpf: "+this.pointsNormal+" Punkte mit Trumpf: "+this.pointsTrumpf;
	}

	public int getPointsUndeufe() {
		return pointsUndeufe;
	}

	public void setPointsUndeufe(int pointsUndeufe) {
		this.pointsUndeufe = pointsUndeufe;
	}

	public int getPointsObeabe() {
		return pointsObeabe;
	}

	public void setPointsObeabe(int pointsObeabe) {
		this.pointsObeabe = pointsObeabe;
	}
	

	
	
}
