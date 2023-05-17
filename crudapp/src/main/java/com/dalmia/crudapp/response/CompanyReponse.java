package com.dalmia.crudapp.response;

import com.dalmia.crudapp.request.Header;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyReponse {

    private Header header;

    private CompanyListResponse data;

}
