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
                @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY", query = "select o from Office o where o.country like :country"),
        // :country is wait for value from parameter
                @NamedQuery(name = "Office.FIND_BY_CITY_OR_COUNTRY", query = "select o from Office o where lower(o.city) " +
                        "like :city or lower(o.country) like :country")
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
