package com.dalmia.dalmia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dalmia.dalmia.entity.Company;
import com.dalmia.dalmia.entity.IndrustrySector;
import com.dalmia.dalmia.exception.CompanyNotFound;
import com.dalmia.dalmia.exception.IndrustrySectorNotFound;
import com.dalmia.dalmia.header.Header;
import com.dalmia.dalmia.repository.CompanyRepo;
import com.dalmia.dalmia.repository.IndrustrySectorRepo;
import com.dalmia.dalmia.request.dto.CompanyRequestDto;
import com.dalmia.dalmia.response.dto.CompanyResponseDto;
import com.dalmia.dalmia.response.dto.IndrustrySectorResponseDto;
import com.dalmia.dalmia.responses.Response;

@Service
public class CompanyServiceImpl implements CompanyServiceLayor {

	private CompanyRepo repo;

	@Autowired
	private IndrustrySectorRepo indrustrySectorRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public CompanyServiceImpl(CompanyRepo repo) {
		this.repo = repo;
	}

	@Override
	public Response<List<CompanyResponseDto>> findAll() {

		Response<List<CompanyResponseDto>> response = new Response<>();

		List<Company> companyList = repo.findAll();

		List<CompanyResponseDto> companyResponseList = companyList.stream()
				.map((cat) -> modelMapper.map(cat, CompanyResponseDto.class)).collect(Collectors.toList());

//		companyList.stream().forEach(cat -> modelMapper.map(companyResponseList, CompanyResponse.class));

		Header header = new Header(HttpStatus.OK, "Sucessful");
		response.setHeader(header);
		response.setData(companyResponseList);

		return response;

	}

	@Override
	public Response<CompanyResponseDto> findById(int id) {

		Optional<Company> company = repo.findById(id);

		if (company.isPresent()) {
			Company comp = company.get();
			Header header = new Header(HttpStatus.OK, "sucessful");
			Response<CompanyResponseDto> response = new Response<>();
			CompanyResponseDto companyResponseDto = modelMapper.map(comp, CompanyResponseDto.class);

			// response set header
			response.setHeader(header);
			// response set data
			response.setData(companyResponseDto);
			return response;
		} else {

			// set header only
			Header header = new Header(HttpStatus.BAD_REQUEST, "User Id is invalid");
			throw new CompanyNotFound(header);
		}

	}

	@Override
	public Response<CompanyResponseDto> save(CompanyRequestDto companyRequestDto) {

		Optional<IndrustrySector> sector = indrustrySectorRepo.findById(companyRequestDto.getSectorId());
		Company company = modelMapper.map(companyRequestDto, Company.class);
		if(sector.isPresent()) {
			company.setSector(sector.get());
		}
		else {
			Header header = new Header(HttpStatus.BAD_REQUEST, "SectorId not valid");
			throw new IndrustrySectorNotFound(header);
		}

		
		if (repo.findByCompanyName(company.getCompanyName()) != null) {
			Header header = new Header(HttpStatus.BAD_REQUEST, "Company name already exist");
			throw new CompanyNotFound(header);
		}

		
		repo.save(company);
		CompanyResponseDto companyResponseDto = modelMapper.map(company, CompanyResponseDto.class);
		companyResponseDto.setSector(modelMapper.map(sector, IndrustrySectorResponseDto.class));
		Response<CompanyResponseDto> companyResponse = new Response<	>();
		Header header = new Header(HttpStatus.OK, "Successful");
		companyResponse.setHeader(header);
		companyResponse.setData(companyResponseDto);

		return companyResponse;
	}

	@Override
	public Header delete(int id) {
		Optional<Company> company = repo.findById(id);

		if (company.isPresent()) {
			repo.deleteById(id);
			Header header = new Header(HttpStatus.OK, "Deleted Successful");
			return header;

		} else {
			Header header = new Header(HttpStatus.BAD_REQUEST, "User Id is invalid");
			throw new CompanyNotFound(header);
		}

	}

}
