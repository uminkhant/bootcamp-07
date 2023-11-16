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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer extends Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NonNull
	@AttributeOverride(name = "email" ,column = @Column(name = "p_email"))
	@AttributeOverride(name ="phone",column = @Column(name = "p_phone"))
	private Contact primaryContact;
	@AttributeOverride(name = "email" ,column = @Column(name = "s_email"))
	@AttributeOverride(name ="phone",column = @Column(name = "s_phone"))
	private Contact secondaryContact;
	@OneToOne
	@JoinTable(name ="cu_address_tbl", joinColumns = @JoinColumn(name = "cu_id",referencedColumnName = ""), 
	inverseJoinColumns = @JoinColumn(name = "addres_id")
	)
	private Address address;
}











