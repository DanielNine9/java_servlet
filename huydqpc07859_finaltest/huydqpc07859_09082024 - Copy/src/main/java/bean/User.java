package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "Id")
	public String id;
	@Column(name = "Password")
	public String password;
	@Column(name = "Fullname")
	public String fullname;
	@Column(name = "Email")
	public String email;
	@Column(name = "Admin")
	public Boolean admin = false;
//
//	@Column(name = "married")
//	public Boolean married = false;

	@Column(name = "Image")
	public String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

//	public Boolean getMarried() {
//		return married;
//	}
//
//	public void setMarried(Boolean married) {
//		this.married = married;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public User(String id, String password, String fullname, String email, Boolean admin) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
	}

	public User() {
		super();
	}

}
