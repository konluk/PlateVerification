package sk.konluk.PlateVerification.Domain;

import javax.persistence.*;

@Entity
@Table(name="stolen_plates")
public class CarPlate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String plate;

    private String email;

    private Integer searches;

    public CarPlate() {
    }

    public void addSearches(){
        this.searches++;
    }

    public Integer getSearches() {
        return searches;
    }

    public void setSearches(Integer searches) {
        this.searches = searches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
