package com.example.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name="categoria")
public class CategoriaModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private Long Id;
		
		@Column
		@NotNull
		private String tipo;
		
	
		
		//relacionamento entre classes
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		private List<JogosModel> jogos;
		


		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		
		
		
}
