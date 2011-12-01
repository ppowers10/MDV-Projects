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
			makeSelect.setAttribute("id", "groups1");
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
			makeSelect.setAttribute("id", "groups2");
		for(var i=0, j=service.length; i<j; i++){
			var makeOption = document.createElement('option');
			var optText = service[i];
			makeOption.setAttribute("value", optText);
			makeOption.innerHTML =  optText;
			makeSelect.appendChild(makeOption);
		}
		selectSpan.appendChild(makeSelect);
	}
	//Find Value of selected radio button...this is for learning only since I have no radio buttons
	/*
	function getSelectedRadio(){
		var radios = document.forms[0].sex;
		for(var i=0; i<radios.lenth; i++){
			if(radios[i].checked){
			sexValue = radios[i].value;
			}
		}
	}
	*/
	//Find the value of selected checkbox.
	function getCheckboxValue(){
		if($('urgent').checked){
			urgentValue = $('urgent').value;
		}else{
			urgentValue = "Not Urgent"
		}
	}
	
	function storeData(){
		var id 					= Math.floor(Math.random()*10000001);
		//Gather up all our form field values and store in an object.
		//Oject properties contain array with the form label and input value.
		getCheckboxValue();
		var item 				= {};
			item.name			= ["Guest's Name:", $('name').value];
			item.roomnum		= ["Room #:", $('roomnum').value];
			item.phonenum		= ["Phone Number:", $('phonenum').value];
			item.email			= ["Email:", $('email').value];
			item.groups1		= ["Contact Method:", $('groups1').value];
			item.groups2		= ["Service Requested:", $('groups2').value];
			item.budget			= ["Budget:", $('budget').value];
			item.urgent			= ["Urgent", urgentValue];
			item.startdate		= ["Date Requested:", $('startdate').value];	
			item.comments		= ["Comments:", $('comments').value];
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		alert("Request Saved");
	}
	
	function getData(){
		//Write Data from Local Stograge to the browser.
		var makeDiv = document.createElement('div');
		makeDiv.setAttribute("id", "items");
		var makeList = document.createElement('ul');
		makeDiv.appendChild(makeList);
		document.body.appendChild(makeDiv);
		for(var i=0, j=localStorage.length; i<j; i++){
			 var makeLi = document.createElement('li');
			 makeList.appendChild(makeLi);
			 var key = localStorage.key(i);
			 var value = localStorage.getItem(key);
			//Convert the string from local storage value back to an object by using JSON.parse().
			 var obj = JSON.parse(value);
			 var makeSubList = document.createElement('ul');
			 makeLi.appendChild(makeSubList);
			 for(var n in obj){
			 	var makeSubLi = document.createElement('li');
			 	makeSublist.appendChild(makeSubLi);
			 	var optSubText = obj[n][0]+" "+obj[n][1];
			 	makeSubLi.innHTML = optSubText;
			 }
		}
	}
	//Variable default
	var bestContact = ["--Best Contact Method--", "Email", "Phone", "Text"];
	var service = ["--Choose A Service--", "'At your service' request", "Where to eat", "What to see", "Special event recommendation", "Need directions"];		
	var urgentValue = "Not Urgent";
	
	makeCats1();
	makeCats2();
	//Set Link and Submit Click Events
	var displayLink = $('displayRequest');
	displayLink.addEventListener("click", getData);
	var clearLink = $('clearRequest');
	clearLink.addEventListener("click", clearLocal);
	var save = $('submit');
	save.addEventListener("click", storeData);
	
});