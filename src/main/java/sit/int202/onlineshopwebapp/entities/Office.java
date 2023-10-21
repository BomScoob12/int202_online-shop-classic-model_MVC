package sit.int202.onlineshopwebapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table(name = "Offices")

@NamedQueries(
        {
                @NamedQuery(name = "OFFICE.FINDALL", query = "select o from Office o"),
                @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY", query = "select o from Office o where o.country like :country")
        // :country is wait for value from parameter
        }
)
public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    @Column(name = "phone")
    private String phoneNumber;
    private String territory;

    @OneToMany(mappedBy = "officeCode")
    private List<Employee> employeeList;
}
