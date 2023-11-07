package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "product_gen")
	@SequenceGenerator(name = "product_gen", allocationSize = 1)
	//@TableGenerator(name = "product_gen")
	private int id;
	@NonNull
	private String name;
	@NonNull
	private Integer price;
	@NonNull
	private Size size;
	
	
	public enum Size{
		SMALL,MEDIUM,LARGE
	}
}
