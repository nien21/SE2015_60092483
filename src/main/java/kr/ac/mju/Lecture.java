package kr.ac.mju;

public class Lecture {
	private int id;
	private int year;
	private int grade;
	private int currentMaxNum;
	private int maxNum;
	private int credit;
	private String avg;
	private String name;
	private String professorName;
	
	public Lecture(int id, String name, String professorName, int year, int grade, int currentMaxNum, int maxNum, int credit) {
		setId(id);
		setName(name);
		setProfessorName(professorName);
		setYear(year);
		setGrade(grade);
		setCurrentMaxNum(currentMaxNum);
		setMaxNum(maxNum);
		setCredit(credit);
	}
	
	public Lecture(int id, String name, String professorName, int year, int grade, int maxNum, int credit) {
		setId(id);
		setName(name);
		setProfessorName(professorName);
		setYear(year);
		setGrade(grade);
		setMaxNum(maxNum);
		setCredit(credit);
	}
	public Lecture(int id, String name, String professorName, int year, int grade, int maxNum, int credit, String avg) {
		setId(id);
		setName(name);
		setProfessorName(professorName);
		setYear(year);
		setGrade(grade);
		setMaxNum(maxNum);
		setCredit(credit);
		setAvg(avg);
	}

	public int getId() {return id;}
	public int getYear() {return year;}
	public int getGrade() {return grade;}
	public int getCurrentMaxNum() {return currentMaxNum;}
	public int getMaxNum() {return maxNum;}
	public int getCredit() {return credit;}
	public String getName() {return name;}
	public String getProfessorName() {return professorName;}
	public void setId(int id) {this.id = id;}
	public void setYear(int year) {this.year = year;}
	public void setGrade(int grade) {this.grade = grade;}
	public void setCurrentMaxNum(int currentMaxNum) {this.currentMaxNum = currentMaxNum;}
	public void setMaxNum(int maxNum) {this.maxNum = maxNum;}
	public void setCredit(int credit) {this.credit = credit;}
	public void setName(String name) {this.name = name;}
	public void setProfessorName(String professorName) {this.professorName = professorName;}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
	
}
