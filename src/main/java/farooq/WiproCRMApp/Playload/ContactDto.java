package farooq.WiproCRMApp.Playload;

import javax.validation.constraints.*;

public class ContactDto {
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 2, message = "First name must be less than or equal to 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 2, message = "Last name must be less than or equal to 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobile;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public ContactDto(Long id,
			@NotBlank(message = "First name is required") @Size(max = 2, message = "First name must be less than or equal to 50 characters") String firstName,
			@NotBlank(message = "Last name is required") @Size(max = 2, message = "Last name must be less than or equal to 50 characters") String lastName,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email address") String email,
			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits") String mobile) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public ContactDto() {
		super();
	}

  

}
