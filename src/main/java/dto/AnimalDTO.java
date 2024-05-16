package dto;

import helpers.PetSex;
import helpers.PetType;
import interfaces.Path;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.util.Objects;

@Builder
@ToString
@Getter
@Setter
public class AnimalDTO implements Serializable, Path {
    private static final long serialVersionUID = 64565461L;

    private PetType type; //transient
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

    public static void serializableAnimalDTO(AnimalDTO animal, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(SERIALIZE_PATH + fileName))) {
            outputStream.writeObject(animal);
        } catch (IOException e) {
            System.out.println("serializable exception was thrown");
            e.printStackTrace();
        }
    }

    public static AnimalDTO deSerializableAnimalDTO(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(SERIALIZE_PATH + fileName))) {
            return (AnimalDTO) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("deserializable exception was thrown");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDTO animalDTO = (AnimalDTO) o;
        return type == animalDTO.type && sex == animalDTO.sex && Objects.equals(breed, animalDTO.breed) && Objects.equals(color, animalDTO.color) && Objects.equals(distinctive_features, animalDTO.distinctive_features) && Objects.equals(description, animalDTO.description) && Objects.equals(photo, animalDTO.photo) && Objects.equals(location, animalDTO.location) && Objects.equals(contacts, animalDTO.contacts) && Objects.equals(email, animalDTO.email) && Objects.equals(text, animalDTO.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, breed, color, distinctive_features, description, photo, location, contacts, email, text);
    }
}
