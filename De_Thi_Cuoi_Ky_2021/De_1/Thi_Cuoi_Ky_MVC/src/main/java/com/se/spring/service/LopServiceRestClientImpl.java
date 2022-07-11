package com.se.spring.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.spring.model.Lop;
import com.se.spring.model.Sinhvien;

@Service
public class LopServiceRestClientImpl implements LopService {
	private RestTemplate restTemplate;
	private String crmRestLopUrl, crmRestSinhvienUrl;

	@Autowired
	public LopServiceRestClientImpl(RestTemplate theRestTemplate, @Value("${crm.rest.lop.url}") String lopUrl,
			@Value("${crm.rest.sinhvien.url}") String sinhvienUrl) {
		restTemplate = theRestTemplate;
		crmRestLopUrl = lopUrl;
		crmRestSinhvienUrl = sinhvienUrl;
	}

	@Override
	public List<Lop> getLops() {
		ResponseEntity<List<Lop>> responseEntity = restTemplate.exchange(crmRestLopUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Lop>>() {
				});
		List<Lop> lops = responseEntity.getBody();
		return lops;
	}

	@Override
	public void saveLop(Lop theLop) {
		int lopId = theLop.getId();
		if (lopId == 0) {
			restTemplate.postForEntity(crmRestLopUrl, theLop, String.class);
		} else {
			restTemplate.put(crmRestLopUrl, theLop);
		}
	}

	@Override
	public Lop getLop(int lopId) {
		Lop theLop = restTemplate.getForObject(crmRestLopUrl + "/" + lopId, Lop.class);
		return theLop;
	}

	@Override
	public void deleteLop(int lopId) {
		restTemplate.delete(crmRestLopUrl + "/" + lopId);
	}

	@Override
	public List<Sinhvien> getSinhviens(int lopId) {
		ResponseEntity<List<Sinhvien>> responseEntity = restTemplate.exchange(crmRestSinhvienUrl + "/" + lopId,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Sinhvien>>() {
				});
		List<Sinhvien> sinhviens = responseEntity.getBody();
		return sinhviens;
	}

	@Override
	public Sinhvien getSinhvien(int lopId, int sinhvienId) {
		Sinhvien theSinhvien = restTemplate.getForObject(crmRestSinhvienUrl + "/" + lopId, Sinhvien.class, sinhvienId);
		return theSinhvien;
	}
}
