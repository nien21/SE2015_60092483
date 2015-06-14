package kr.ac.mju;

public class User {
	private String ID;
	private String pwd;
	private String Name;
	private String type;
		
	public User() {
	 
	}
	
	public User(String ID, String pwd, String Name, String type) {
        this.ID = ID;
        this.pwd = pwd;
        this.Name = Name;
        this.type = type;
    }
	public User(String ID, String pwd) {
        this.ID = ID;
        this.setpwd(pwd);
    }
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setpwd(String pwd) {
		// TODO Auto-generated method stub
		this.pwd = pwd;
	}
	
	public String getpwd(){
		return this.pwd;
	}
	public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
