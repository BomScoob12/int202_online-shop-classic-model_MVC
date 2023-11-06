package sit.int202.onlineshopwebapp.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name = "employees")

@NamedQueries(
        @NamedQuery(name = "EMPLOYEE.FINDALL", query = "select e from Employee e")
)
public class Employee {

    @Id
    @Column(name = "employeeNumber")
    private int id;
    private String lastname;
    private String firstname;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
    //join table by using relationship.
    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false, updatable = false)
    private Office office;
}
