package conf.inject;

import play.modules.guice.GuiceSupport;
import service.AdsService;
import service.UserService;
import service.impl.AdsServiceImpl;
import service.impl.UserServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import controllers.AdsController;
import controllers.Application;
import controllers.UserController;

public class GuiceConfig extends GuiceSupport {

	private Module gmodule = new AbstractModule() {
		
		@Override
		protected void configure() {
			requestStaticInjection(Application.class);
			requestStaticInjection(UserController.class);
			requestStaticInjection(AdsController.class);
			
			bind(UserService.class).to(UserServiceImpl.class);
			bind(AdsService.class).to(AdsServiceImpl.class);
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
