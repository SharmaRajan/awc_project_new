package com.dalmia.crudapp.validation;

import com.dalmia.crudapp.request.CompanyFormRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("companyValidator")
@PropertySource(value="classpath:messages.properties")
public class CompanyFormValidator implements Validator {

    @Autowired
    MessageSource messageSource;

    @Override
    public boolean supports(Class<?> paramClass) {
        return CompanyFormRequest.class.isAssignableFrom(paramClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CompanyFormRequest request = (CompanyFormRequest) target;

        if(request.getCompanyName().isEmpty() || request.getCompanyName() == null || request.getCompanyName() == ""){
            errors.rejectValue("companyName", "required"
                    ,new Object[] {"'companyName'"}
                    ,messageSource.getMessage("company.companyName.required", new Object[]{"Company Name"}
                            , null));
        }

        /*if(request.getIndustrySector().equals(null)  || request.getIndustrySector() == null){
            errors.rejectValue("industrySector", "required"
                    ,new Object[] {"'industrySector'"}
                    ,messageSource.getMessage("company.industrySector.required", new Object[]{"industry Sector Name"}
                            , null));
        }*/
    }
}
