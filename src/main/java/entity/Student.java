package entity;

import javafx.beans.DefaultProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@DefaultProperty("private")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "student")
public class Student {

    @Id
    int id;
    @Column(name = "full_name", nullable = false)
    String fullName;
    @Column(nullable = false)
    String birthday;
    @Column(name = "class_name", nullable = false)
    String className;
    @Column( nullable = false)
    String Major;
    @Column( nullable = false)
    String hometown;
    @Column(nullable = false)
    String gender;
    @Column(name = "average_mark", nullable = false)
    float averageMark;
}
