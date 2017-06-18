package com.oms;

import org.springframework.stereotype.Component;

@Component
public class FirstClass implements Inter{

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("first");
	}

}
