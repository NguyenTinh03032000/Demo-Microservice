package ShopShoeApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")})
public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String address;
	
	private String phone_number;
	
	private String username;
	
	private String email;
	
	private String password;

	public AccountEntity(String name, String address, String phone_number, String username, String email, String password) {
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
