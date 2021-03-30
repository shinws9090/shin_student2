package shin_student2.dto;

public class ID {
	private String id;
	private String pass;
	private String email;
	private boolean grant;
	
	
	
	public boolean isGrant() {
		return grant;
	}
	public void setGrant(boolean grant) {
		this.grant = grant;
	}
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
	
	
	public ID(String id) {
		super();
		this.id = id;
	}
	public ID(String id, String pass, String email, boolean grant) {
		super();
		this.id = id;
		this.pass = pass;
		this.email = email;
		this.grant = grant;
	}
	
	
	public ID(String id, boolean grant) {
		super();
		this.id = id;
		this.grant = grant;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ID other = (ID) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
