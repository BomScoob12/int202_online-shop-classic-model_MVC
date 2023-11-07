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

@NamedQueries({
        @NamedQuery(name = "EMPLOYEE.FIND_ALL", query = "select e from Employee e"),
        @NamedQuery(name = "EMPLOYEE.FIND_BY_OFFICE_CODE", query = "select e from Employee e where e.officeCode = :officeCode")
})
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
