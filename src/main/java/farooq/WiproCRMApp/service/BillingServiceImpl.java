package farooq.WiproCRMApp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import farooq.WiproCRMApp.Playload.BillingDto;
import farooq.WiproCRMApp.entites.Billing;
import farooq.WiproCRMApp.exception.BillNotFoundedException;
import farooq.WiproCRMApp.repository.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService{
	
	private BillingRepository billingRepository;
	private ModelMapper mapper;
	public BillingServiceImpl(BillingRepository billingRepository, ModelMapper mapper) {
		super();
		this.billingRepository = billingRepository;
		this.mapper = mapper;
	}
	@Override
	public BillingDto saveOnebilling( BillingDto billingDto) {
		Billing bill = mapToEntity (billingDto);
		Billing savebill = billingRepository.save(bill);
		BillingDto dto =mapToDto(savebill);
		return dto;
	}
	private BillingDto mapToDto(Billing savebill) {
		BillingDto map = mapper.map(savebill,BillingDto.class);
		return map;
	}
	private Billing mapToEntity(BillingDto billingDto) {
		Billing map = mapper.map(billingDto, Billing.class);
		return map;
	}
	@Override
	public List<BillingDto> getallBilling() {
		List<Billing> findAll = billingRepository.findAll();
		return findAll.stream().map(bill->mapToDto(bill)).collect(Collectors.toList());
	}
	@Override
	public BillingDto getById(long id) {
		Billing bill = billingRepository.findById(id)
				.orElseThrow(()-> new BillNotFoundedException("Billing","id",id));
		return mapToDto(bill);
	}
	@Override
	public Billing updateById(long id, BillingDto billingDto) {
		Billing bill = billingRepository.findById(id)
				.orElseThrow(()-> new BillNotFoundedException("Billing","id",id));
		bill.setEmail(billingDto.getEmail());
		bill.setFirstName(billingDto.getFirstName());
		bill.setInvoice(billingDto.getInvoice());
		bill.setDate(billingDto.getDate());
		bill.setLastName(billingDto.getLastName());
		bill.setPrice(billingDto.getPrice());
		bill.setProduct(billingDto.getProduct());
		return bill;
	}
	@Override
	public void deleteById(long id) {
		Billing bill = billingRepository.findById(id)
				.orElseThrow(()-> new BillNotFoundedException("Billing","id",id));
		billingRepository.deleteById(id);
	}
	@Override
	public List<Billing> getPaginatedBilling(Integer pageNo, Integer pageSize, String sortby) {
		Pageable of = PageRequest.of(pageNo, pageSize, Sort.by(sortby));
		
		Page<Billing> findAll = billingRepository.findAll(of);
		return findAll.getContent();
	}
	

}
