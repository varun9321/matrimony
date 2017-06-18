package com.oms;

import javax.servlet.Filter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer
extends AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class[] { OmsApplication.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
	return null;
}

@Override
protected String[] getServletMappings() {
	return new String[] { "/" };
}
@Override
protected Filter[] getServletFilters() {
   return new Filter[]{ 
   new DelegatingFilterProxy("springSecurityFilterChain"),
   new OpenEntityManagerInViewFilter()};
} 
}