//Patrick Powers
//VWF Project 2
//1112

//Wait until the DOM is ready
window.addEventListener("DOMContentLoaded", function(){

	//getElementById Function
	function $(x){
		var theElement = document.getElementById(x);
		return theElement;
	}
	
	//Create select field element and populate with options
	function makeCats1(){
		var formTag = document.getElementsByTagName("form"), //formTag is an array
			selectSpan = $('select1'),
			makeSelect = document.createElement('select');
			makeSelect.setAttribute("id", "groups");
		for(var i=0, j=bestContact.length; i<j; i++){
			var makeOption = document.createElement('option');
			var optText = bestContact[i];
			makeOption.setAttribute("value", optText);
			makeOption.innerHTML =  optText;
			makeSelect.appendChild(makeOption);
		}
		selectSpan.appendChild(makeSelect);
	}
	
	function makeCats2(){
		var formTag = document.getElementsByTagName("form"), //formTag is an array
			selectSpan = $('select2'),
			makeSelect = document.createElement('select');
			makeSelect.setAttribute("id", "groups");
		for(var i=0, j=service.length; i<j; i++){
			var makeOption = document.createElement('option');
			var optText = service[i];
			makeOption.setAttribute("value", optText);
			makeOption.innerHTML =  optText;
			makeSelect.appendChild(makeOption);
		}
		selectSpan.appendChild(makeSelect);
	}

	function storeData(){
		localStorage.setItem("test", "hello")	
	}
	
	//Variable default
	var bestContact = ["--Best Contact Method--", "Email", "Phone", "Text"];
	makeCats1();
	var service = ["--Choose A Service--", "'At your service' request", "Where to eat", "What to see", "Special event recommendation", "Need directions"];		
	makeCats2();
	
	//Set Link and Submit Click Events
	/*
	var displayLink = $('displayRequest');
	displayLink.addEventListener("click", getData);
	var clearLink = $('clearRequest');
	clearLink.addEventListener("click", clearLocal); */
	var save = $('submit');
	save.addEventListener("click", storeData);
	
});