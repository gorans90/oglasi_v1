package service;

import models.Address;

public interface AddressService {

	public Address createAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public Address getAdressByUserId(long id);
	
	
	
	
}
