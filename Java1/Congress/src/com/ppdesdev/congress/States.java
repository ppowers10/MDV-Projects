package com.ppdesdev.congress;

public enum States {
		 ALABAMA("AL"),
		 ALASKA("AK"),
		 ARIZONA("AZ"),
		 ARKANSAS("AR"),
		 CALIFORNIA("CA"),
		 COLORADO("CO"),
		 CONNECTICUT("CT"),
		 DELAWARE("DE"),
		 FLORIDA("FL"),
		 GEORGIA("GA"),
		 HAWAII("HI"),
		 IDAHO("ID"),
		 ILLINOIS("IL"),
		 INDIANA("IN"),
		 IOWA("IA"),
		 KANSAS("KS"),
		 KENTUCKY("KY"),
		 LOUISIANA("LA"),
		 MAINE("ME"),
		 MARYLAND("MD"),
		 MONTANA("MT"),
		 NEBRASKA("NE"),
		 NEVADA("NV"),
		 NEWHAMPSHIRE("NH"),
		 NEWJERSEY("NJ"),
		 NEWMEXICO("NM"),
		 NEWYORK("NY"),
		 NORTHCAROLINA("NC"),
		 NORTHDAKOTA("ND"),
		 OHIO("OH"),
		 OKLAHOMA("OK"),
		 Oregon("OR"),
		 PENNSYLVANIA("PA"),
		 RHODEISLAND("RI"),
		 SOUTHCAROLINA("SC"),
		 SOUTHDAKOTA("SD"),
		 TENNESSEE("TN"),
		 TEXAS("TX"),
		 UTAH("UT"),
		 VERMONT("VT"),
		 MASSACHUSETTS("MA"),
		 VIRGINIA("VA"),
		 MICHIGAN("MI"),
		 WASHINGTON("WA"),
		 MINNESOTA("MN"),
		 WESTVIRGINIA("WV"),
		 MISSISSIPPI("MS"),
		 WISCONSIN("WI"),
		 MISSOURI("MO"),
		 WYOMING("WY");

		 private String value;

		 private States (String value) {
		  this.value = value;
		 }
		 
		 public String getKey() {
		  return value;
		 }
}
