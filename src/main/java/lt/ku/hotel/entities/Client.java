package lt.ku.hotel.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table( name = "client")
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Vardas turi būti ilgesnis nei 3 simboliai ir ne ilgesnis nei 20 simboliai")
    @NotNull @NotEmpty(message = "Vardas privalomas")
    private String name;
    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Pavarde turi būti ilgesnis nei 3 simboliai ir ne ilgesnis nei 20 simboliai")
    @NotNull @NotEmpty(message = "Pavarde privaloma")
    private String surname;
    @Column(length = 64)
    @Length(max = 15, message = "Telefonas turi būti ne ilgesnis nei 15 simboliu") @NotNull @NotEmpty(message = "Telefonas privalomas")
    private String phone;
    @Column(length = 64)
    @NotNull @NotEmpty(message = "Adresas privalomas")
    private String address;
    @Column(length = 64)
    @NotNull @NotEmpty(message = "Gimimo data privaloma")
    private Date birth_date;

    @Column(nullable = false, length = 64)
    @Email(message = "El-paštas turi būti įvestas tinkamu formatu") @NotNull @NotEmpty(message = "El-paštas privalomas")
    private String username;
    @Length(min = 3, max = 20, message = "Slaptažodis turi būti ilgesnis nei 3 simboliai ir ne ilgesnis nei 20 simboliai")
    @NotNull @NotEmpty(message = "Telefonas privalomas")
    private String password;
    @Column(nullable = false)
    @NotEmpty
    private String type = "user";

    public Client(){}

    public Client(String name, String surname, String phone, String address, Date birth_date, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.birth_date = birth_date;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(this.type));
        return auth;
    }
}
