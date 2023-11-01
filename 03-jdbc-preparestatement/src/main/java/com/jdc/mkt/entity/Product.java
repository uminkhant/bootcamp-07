package com.jdc.mkt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

	private int id;
	@NonNull
	private String name;
	@NonNull
	private Double price;
	@NonNull
	private Size size;
	private Category catgory;
	private boolean active;
	
	public enum Size{
		SMALL,MEDIUM,LARGE
	} 
}
