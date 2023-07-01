package rogerio.pst.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import rogerio.pst.annotations.JvmLanguage;

public class Developer {
	
	@JvmLanguage
	@NotBlank
	@JsonProperty("favorite-language")
	private String favoriteLanguage;

}
