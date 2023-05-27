package com.dalmia.crudapp;

import com.dalmia.crudapp.repository.ICompanyRepo;
import com.dalmia.crudapp.service.ICompanyService;

import com.dalmia.crudapp.service.IFacilityService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
/*import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

@SpringBootApplication
//@EnableSwagger2
public class CrudappApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@Autowired
//	private ICompanyService companyService;

//	@Autowired
//	private ICompanyRepo companyRepo;

//	@Autowired
//	private IFacilityService facilityService;

	private Logger logger = LoggerFactory.getLogger(CrudappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Encoded Jaadu: " + passwordEncoder.encode("Jaadu"));

		/*Company tempCompany = new Company();
		tempCompany.setCompanyName("TMH");
		tempCompany.setTotalNoOfFacility(23L);

		Facility facility = new Facility();
		facility.setFacilityName("Tata");
		facility.setAddressDetails("Bokaro");

		List<Facility> facilityList = new ArrayList<>();
		facilityList.add(facility);

		// mandatory
		facility.setCompany(tempCompany);
		tempCompany.setFacilities(facilityList);

		// save company as well as facility bcz of cascadeType.ALL in Company class
		Company savedCompany = companyService.save(tempCompany);

		// no need to save explicitly bcz CascadeType is defined in Company class
//		Facility savedFacility = facilityService.save(facility);

		System.out.println(savedCompany);

		logger.info("saved company : {}", savedCompany.getCompanyName());
//		logger.info("saved facility : {}", savedFacility.getFacilityName());

		Company tempCom = companyRepo.findById(4L).get();

		logger.info("company name : {} ",tempCom.getCompanyName());

		List<Facility> facilities = tempCom.getFacilities();

		for(Facility fa: facilities){
			logger.info("Facility: {},{}",fa.getFacilityName(),fa.getAddressDetails());
		}*/



	}

	/*@Bean
	public Docket api() {
		*//*return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();*//*

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.build();
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("simplifyingtech API")
				.description("simplifyingtech API for developers")
				.termsOfServiceUrl("https://simplifying.com")
				.termsOfServiceUrl("simplifyingtech@gmail.com")
				.version("2.0")
				.build();
	}*/

}
