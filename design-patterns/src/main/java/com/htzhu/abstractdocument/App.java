package com.htzhu.abstractdocument;

import com.htzhu.abstractdocument.domain.Car;
import com.htzhu.abstractdocument.domain.HasModel;
import com.htzhu.abstractdocument.domain.HasParts;
import com.htzhu.abstractdocument.domain.HasPrice;
import com.htzhu.abstractdocument.domain.HasType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * App
 *
 * @author zhuhaitao
 * @date 2018/6/8 13:42
 **/
@Slf4j
public class App {

	public App() {
		log.info("Constructing parts and car");
		Map<String, Object> carProperties = new HashMap<>();
		carProperties.put(HasModel.PROPERTY, "300SL");
		carProperties.put(HasPrice.PROPERTY, 10000L);

		Map<String, Object> wheelProperties = new HashMap<>();
		wheelProperties.put(HasType.PROPERTY, "wheel");
		wheelProperties.put(HasModel.PROPERTY, "15C");
		wheelProperties.put(HasPrice.PROPERTY, 100L);

		Map<String, Object> doorProperties = new HashMap<>();
		doorProperties.put(HasType.PROPERTY, "door");
		doorProperties.put(HasModel.PROPERTY, "Lambo");
		doorProperties.put(HasPrice.PROPERTY, 300L);

		carProperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

		Car car = new Car(carProperties);

		log.info("car's model: {}", car.getModel().get());
		log.info("car's price: {}", car.getPrice().get());

		car.getParts().forEach(p -> log.info(" --> {}/{}/{}", p.getType().get(), p.getModel().get(),
				p.getPrice().get()));
	}

	public static void main(String[] args) {
		new App();
	}

}
