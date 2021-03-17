package shin_student2.dto;

public class ID {
	private String id;
	private String pass;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public ID(String id, String pass, String email) {
		super();
		this.id = id;
		this.pass = pass;
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("ID [id=%s, pass=%s, email=%s]", id, pass, email);
	}
	
}
