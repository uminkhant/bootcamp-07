package ocm.jdc.mkt.enity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String phone;

}
