package kr.netty.honeylink.api.service;

import java.util.List;

import kr.netty.honeylink.api.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public String getOne(){
		return testRepository.findOne();
		
	}

}
