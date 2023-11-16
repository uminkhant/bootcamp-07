package ocm.jdc.mkt.enity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	private String userName;
	private String password;
}
