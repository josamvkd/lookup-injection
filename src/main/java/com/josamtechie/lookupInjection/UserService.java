package com.josamtechie.lookupInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    @Autowired
//    ApplicationContext applicationContext;

    public String getCurrentTempFromWeatherAPI(){
        //return applicationContext.getBean(WeatherService.class).getTodayTemp();
        return getWeatherServiceBean().getTodayTemp();
    }

    @Lookup
    public WeatherService getWeatherServiceBean(){
        return null;
    }

//    This approach will break the principle of IoC (Inversion Of Control)
//    @Lookup
//    public WeatherService getWeatherServiceBean(){
//        return applicationContext.getBean(WeatherService.class);
//    }
}
