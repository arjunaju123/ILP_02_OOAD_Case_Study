package com.ilp.entity;
//Service(serviceCode,serviceName,rate)
public class Service {
		private String serviceCode;
		private String serviceName;
		private Double rate;
		public Service(String serviceCode, String serviceName, Double rate) {
			super();
			this.serviceCode = serviceCode;
			this.serviceName = serviceName;
			this.rate = rate;
		}
		public String getServiceCode() {
			return serviceCode;
		}
		public void setServiceCode(String serviceCode) {
			this.serviceCode = serviceCode;
		}
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public Double getRate() {
			return rate;
		}
		public void setRate(Double rate) {
			this.rate = rate;
		}
		@Override
		public String toString() {
			return "Service [serviceCode=" + serviceCode + ", serviceName=" + serviceName + ", rate=" + rate + "]";
		}		
}
