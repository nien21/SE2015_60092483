package kr.ac.mju;

public class Sugang {
	private int lectureID;
	private String studentName;
	private String professorName;
	private String result;
	
	public Sugang(int lectureId, String studentName, String professorName, String result) {
		setLectureID(lectureId);
		setStudentName(studentName);
		setProfessorName(professorName);
		setResult(result);
	}

	public Sugang(int lectureId, String studentName, String professorName) {
		setLectureID(lectureId);
		setStudentName(studentName);
		setProfessorName(professorName);

	}


	public String getProfessorName() {
		return professorName;
	}

	public String getResult() {
		return result;
	}

	public void setProfessorName(String professorId) {
		this.professorName = professorId;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getLectureID() {
		return lectureID;
	}

	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
	}

}
