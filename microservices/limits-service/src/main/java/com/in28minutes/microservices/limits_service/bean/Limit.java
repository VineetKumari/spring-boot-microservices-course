package com.in28minutes.microservices.limits_service.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties (value = "limits-service")
public class Limit {
	 private int minimum;	 
	 private int maximum;
	 public int getMinimum() {
		 return minimum;
	 }
	 public void setMinimum(int minimum) {
		 this.minimum = minimum;
	 }
	 public int getMaximum() {
		 return maximum;
	 }
	 public void setMaximum(int maximum) {
		 this.maximum = maximum;
	 }
	 public Limit(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	 }
	 public Limit() {
		super();
		// TODO Auto-generated constructor stub
	 }
	 @Override
	 public String toString() {
		return "Limit [minimum=" + minimum + ", maximum=" + maximum + "]";
	 }

}
