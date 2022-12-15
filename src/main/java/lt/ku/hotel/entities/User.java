package lt.ku.hotel.entities;

import org.hibernate.validator.constraints.Length;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lt.ku.hotel.validation.DateConstraint;

import javax.persistence.*;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;




@Entity
@Table( name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Vardas turi būti ilgesnis nei 3 simboliai ir trumpesnis nei 20 simbolių")
    @NotNull @NotEmpty(message = "Vardas privalomas")
    private String name;
    
    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Pavardė turi būti ilgesnė nei 3 simboliai ir trumpesnė nei 20 simbolių")
    @NotNull @NotEmpty(message = "Pavardė privaloma")
    private String surname;
    
    @Column(length = 64)
    @Length(max = 15, message = "Telefonas turi būti ne ilgesnis nei 15 simbolių") @NotNull @NotEmpty(message = "Telefonas privalomas")
    private String phone;


    @Column(nullable = false, length = 64, unique = true)
    @Email(message="Netinkamas El. paštas", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    @NotEmpty(message = "El-paštas privalomas")
    private String email;
    
    @Column(nullable = false)
    @NotEmpty(message = "Slaptažodis privalomas")
    private String password;
    
    
    @Column(nullable = false)
    @NotEmpty
    private String type = "user";    // ADMINISTRATORIAUS SUKURIMUI KEISK I "admin"
    
    
    public User(){}

    
    

    public User(
			@Length(min = 3, max = 20, message = "Vardas turi būti ilgesnis nei 3 simboliai ir trumpesnis nei 20 simbolių") @NotNull @NotEmpty(message = "Vardas privalomas") String name,
			@Length(min = 3, max = 20, message = "Pavardė turi būti ilgesnė nei 3 simboliai ir trumpesnė nei 20 simbolių") @NotNull @NotEmpty(message = "Pavardė privaloma") String surname,
			@Length(max = 15, message = "Telefonas turi būti ne ilgesnis nei 15 simbolių") @NotNull @NotEmpty(message = "Telefonas privalomas") String phone,
			@Email(message = "Netinkamas El. paštas", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") @NotEmpty(message = "El-paštas privalomas") String email,
			@NotEmpty(message = "Slaptažodis privalomas") String password, @NotEmpty String type) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;

		this.email = email;
		this.password = password;
		this.type = type;
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

    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public void setId(Integer id) {
		this.id = id;
	}


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

	@Override
	public String getUsername() {
		return email;
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
        auth.add(new SimpleGrantedAuthority(this.type)); // SUKURTI ADMINISTRATORIU - keisk user type i "admin" ir kurk new acc.
        return auth;
    }
}
