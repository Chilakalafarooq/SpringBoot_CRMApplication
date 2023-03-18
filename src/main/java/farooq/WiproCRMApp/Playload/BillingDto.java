package farooq.WiproCRMApp.Playload;

import javax.validation.constraints.*;

public class BillingDto {
    private Long invoice;

    @NotBlank(message = "First name is required")
    @Size(max = 2, message = "First name must be less than or equal to 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 2, message = "Last name must be less than or equal to 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Date is required")
    private String date;

    @NotNull(message = "Price is required")
    private Integer price;

    @NotBlank(message = "Product is required")
    private String product;

	public Long getInvoice() {
		return invoice;
	}

	public void setInvoice(Long invoice) {
		this.invoice = invoice;
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BillingDto(
			@NotBlank(message = "First name is required") @Size(max = 2, message = "First name must be less than or equal to 50 characters") String firstName,
			@NotBlank(message = "Last name is required") @Size(max = 2, message = "Last name must be less than or equal to 50 characters") String lastName,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email address") String email,
			@NotBlank(message = "Date is required") String date, @NotNull(message = "Price is required") Integer price,
			@NotBlank(message = "Product is required") String product) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.price = price;
		this.product = product;
	}

	public BillingDto() {
		super();
	}


}
