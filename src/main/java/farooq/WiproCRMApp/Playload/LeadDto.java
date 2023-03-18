package farooq.WiproCRMApp.Playload;

import javax.validation.constraints.*;

import farooq.WiproCRMApp.entites.Lead;

public class LeadDto {
    @NotBlank(message = "First name is required")
    @Size(max = 2, message = "First name must be less than or equal to 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 2, message = "Last name must be less than or equal to 50 characters")
    private String lastName;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobile;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Source is required")
    @Size(max = 20, message = "Source must be less than or equal to 50 characters")
    private String source;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public LeadDto(
			@NotBlank(message = "First name is required") @Size(max = 2, message = "First name must be less than or equal to 50 characters") String firstName,
			@NotBlank(message = "Last name is required") @Size(max = 2, message = "Last name must be less than or equal to 50 characters") String lastName,
			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits") String mobile,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email address") String email,
			@NotBlank(message = "Source is required") @Size(max = 20, message = "Source must be less than or equal to 50 characters") String source) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.source = source;
	}

	public LeadDto() {
		super();
	}

	
	}


	

   

