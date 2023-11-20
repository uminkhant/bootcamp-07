package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(length = 45,nullable = false)
	private String name;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean active;
	
	@ElementCollection
	@CollectionTable(name ="tags_tbl",
	joinColumns = @JoinColumn(name = "category_id"))
	private List<String>tags;
	
	@OneToMany(mappedBy = "category",orphanRemoval = true)
	private List<Product> products;
	
	{
		tags = new ArrayList<String>();
	}
	
	public void addTag(String...tag) {
		tags.addAll(List.of(tag));
	}
	
}
