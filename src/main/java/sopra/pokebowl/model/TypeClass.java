package sopra.pokebowl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TypeClass")
public class TypeClass {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="type")
	private TypeEnum type;
	@Column(name="avatar")
	private String avatar;
	public Long getId() {
		return id;
	}
	
	
	
	public TypeClass() {
		super();
	}



	public TypeClass(Long id, TypeEnum type, String avatar) {
		super();
		this.id = id;
		this.type = type;
		this.avatar = avatar;
	}



	public void setId(Long id) {
		this.id = id;
	}
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	
}