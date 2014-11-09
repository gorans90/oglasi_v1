package conf.inject;

import models.Address;
import models.Place;
import play.modules.guice.GuiceSupport;
import service.AddressService;
import service.AdsService;
import service.PlaceService;
import service.UserService;
import service.impl.AddressServiceImpl;
import service.impl.AdsServiceImpl;
import service.impl.PlaceServiceImpl;
import service.impl.UserServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import controllers.AddressController;
import controllers.AdsController;
import controllers.Application;
import controllers.PlaceController;
import controllers.UserController;

public class GuiceConfig extends GuiceSupport {

	private Module gmodule = new AbstractModule() {
		
		@Override
		protected void configure() {
			requestStaticInjection(Application.class);
			requestStaticInjection(UserController.class);
			requestStaticInjection(AdsController.class);
			requestStaticInjection(AddressController.class);
			requestStaticInjection(PlaceController.class);
			
			bind(UserService.class).to(UserServiceImpl.class);
			bind(AdsService.class).to(AdsServiceImpl.class);
			bind(AddressService.class).to(AddressServiceImpl.class);
			bind(PlaceService.class).to(PlaceServiceImpl.class);
		}
	};
//
//	@Override
//	protected Injector configure() {
//		Injector injector = Guice.createInjector(gmodule);
//		return injector;
//	}
	
	protected Injector configure() {
        return
        Guice.createInjector(gmodule);
     }
	
	
}
