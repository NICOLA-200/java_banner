package banner.example.banner;


import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private  Integer id;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentProfile() {
    }

    public StudentProfile(String bio) {
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private  String bio;
}
