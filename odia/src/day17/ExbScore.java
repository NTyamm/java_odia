package day17;

public class ExbScore {
	private String subjectTitle;
	private int point;
	private int grade;
	private int term;
	
	public ExbScore(String subjectTitle, int grade, int term, int point) {
		this.subjectTitle = subjectTitle;
		this.point = point;
		this.grade = grade;
		this.term = term;
	}

	
	public ExbScore(String subjectTitle, int grade, int term) {
		super();
		this.subjectTitle = subjectTitle;
		this.grade = grade;
		this.term = term;
	}


	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}
