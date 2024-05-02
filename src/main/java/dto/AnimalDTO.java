package dto;

import helpers.PetSex;
import helpers.PetType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class AnimalDTO {
    private PetType type;
    private PetSex sex;
    private String breed;
    private String color;
    private String distinctive_features;
    private String description;
    private String photo;
    private String location;
    private String contacts;
    private String email;
    private String text; //only Add new post
}
