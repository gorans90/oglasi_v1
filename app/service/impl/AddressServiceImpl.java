package service.impl;

import models.Address;
import service.AddressService;

public class AddressServiceImpl implements AddressService {

	@Override
	public Address createAddress(Address address) {
		Address a = new Address();
		a = address;
		a.save();
		return a;
	}

	@Override
	public Address updateAddress(Address address) {
		Address a = Address.findById(address.id);
		a.streetName = address.streetName;
		a.houseNumber = address.houseNumber;
		a.place = address.place;
		a.latitude = address.latitude;
		a.longitude = address.longitude;
		a.save();
		return a;
	}

	@Override
	public Address getAdressByUserId(long id) {
		Address a = Address.find("userId = ?", id).first();
		return a;
	}

}
