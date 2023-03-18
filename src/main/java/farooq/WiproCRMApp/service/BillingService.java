package farooq.WiproCRMApp.service;

import java.util.List;

import javax.validation.Valid;


import farooq.WiproCRMApp.Playload.BillingDto;
import farooq.WiproCRMApp.entites.Billing;

public interface BillingService {

	BillingDto saveOnebilling(@Valid BillingDto billingDto);

	List<BillingDto> getallBilling();

	BillingDto getById(long id);

	Billing updateById(long id, BillingDto billingDto);

	void deleteById(long id);

	List<Billing> getPaginatedBilling(Integer pageNo, Integer pageSize, String sortby);

}
