package com.se.spring.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.spring.model.Sinhvien;

@Service
public class SinhvienServiceRestClientImpl implements SinhvienService {
	private RestTemplate restTemplate;
	private String crmRestSinhvienUrl;
	private String crmRestOneSinhvienUrl;
	
	@Autowired
	public SinhvienServiceRestClientImpl(RestTemplate theRestTemplate,
			@Value("${crm.rest.sinhvien.url}") String sinhvienUrl,
			@Value("${crm.rest.one.sinhvien.url}") String oneSinhvienUrl) {
		restTemplate = theRestTemplate;
		crmRestSinhvienUrl = sinhvienUrl;
		crmRestOneSinhvienUrl = oneSinhvienUrl;
	}

	@Override
	public Sinhvien getSinhvien(int sinhvienId) {
		Sinhvien theSinhvien = restTemplate.getForObject(crmRestOneSinhvienUrl + "/" + sinhvienId, Sinhvien.class);
		return theSinhvien;
	}

	@Override
	public void saveSinhvien(Sinhvien theSinhvien, int lopId) {
		restTemplate.postForEntity(crmRestSinhvienUrl + "/" + lopId, theSinhvien, String.class);
	}

	@Override
	public void updateSinhvien(Sinhvien theSinhvien, int lopId) {
		restTemplate.put(crmRestSinhvienUrl + "/" + lopId, theSinhvien);
	}

	@Override
	public void deleteSinhvien(int sinhvienId) {
		restTemplate.delete(crmRestSinhvienUrl + "/" + sinhvienId);
	}
}
