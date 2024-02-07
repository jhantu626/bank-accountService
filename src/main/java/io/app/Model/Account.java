package io.app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
		name = "account"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "account_holder_name")
	private String accountHolderName;
	@Column(columnDefinition = "double")
	private double balance;


}
