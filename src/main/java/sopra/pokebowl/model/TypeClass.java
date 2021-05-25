package sopra.pokebowl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "TypeClass")
public class TypeClass {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private TypeEnum type;
	@Column(name="avatar")
	private String avatar;
	
	public TypeClass() {
		super();
	}

	public TypeClass(TypeEnum type, String avatar) {
		super();
		this.type = type;
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
