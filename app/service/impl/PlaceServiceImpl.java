package service.impl;

import models.Place;
import service.PlaceService;

public class PlaceServiceImpl implements PlaceService {

	@Override
	public Place createPlace(Place p) {
		Place place = new Place();
		place = p;
		place.save();
		return place;
	}

	@Override
	public Place updatePlace(Place p) {
		Place place = Place.findById(p.id);
		place.name = p.name;
		place.ptt = p.ptt;
		place.save();
		return place;
	}

}
