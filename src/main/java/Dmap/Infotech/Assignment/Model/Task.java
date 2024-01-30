package Dmap.Infotech.Assignment.Model;

// Model
// Task.java


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Builder

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private Long id;
    private String title;
    private String description;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Constructors
    public Task() {}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Task(Long id,String title,String description)
    {
        this.id=id;
        this.title=title;
        this.description=description;
    }
}

