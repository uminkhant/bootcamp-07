package ocm.jdc.mkt.enity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	@NonNull
	@AttributeOverride(name = "email" ,column = @Column(name = "p_email"))
	@AttributeOverride(name ="phone",column = @Column(name = "p_phone"))
	private Contact primaryContact;
	@AttributeOverride(name = "email" ,column = @Column(name = "s_email"))
	@AttributeOverride(name ="phone",column = @Column(name = "s_phone"))
	private Contact secondaryContact;
	@OneToOne
	private Address address;
}











