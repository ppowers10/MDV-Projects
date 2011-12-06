//Patrick Powers
//VWF Project 3
//1112 12/1/2011

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
			urgentValue = "Not Urgent";
		}
	}
	
	function toggleControls(n){
		switch(n){
			case "on":
				$('conciergeRequest').style.display = "none";
				$('clearRequest').style.display = "inline";
				$('displayRequest').style.display = "none";
				$('addNew').style.display = "inline";
				break;
			case "off":
				$('conciergeRequest').style.display = "block";
				$('clearRequest').style.display = "inline";
				$('displayRequest').style.display = "inline";
				$('addNew').style.display = "none";
				$('items').style.display = "none";
				break;
			//	break;
			default:
				return false;
		}
	}
	
	function storeData(){
		var id 					= Math.floor(Math.random()*10000001);
		//Gather up all our form field values and store in an object.
		//Oject properties contain array with the form label and input value.
		getCheckboxValue();
		var item 				= {};
			item.name			= ["Guest's Name:  ", $('name').value];
			item.roomnum		= ["Room #:  ", $('roomnum').value];
			item.phonenum		= ["Phone Number:  ", $('phonenum').value];
			item.email			= ["Email:  ", $('email').value];
			item.groups1		= ["Contact Method:  ", $('groups1').value];
			item.groups2		= ["Service Requested:  ", $('groups2').value];
			item.budget			= ["Budget:", $('budget').value];
			item.urgent			= ["Urgent:  ", urgentValue];
			item.startdate		= ["Date Requested:  ", $('startdate').value];	
			item.comments		= ["Comments:  ", $('comments').value];
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		alert("Request Saved");
	}
	
	function getData(){
		toggleControls('on');
		if(localStorage.length === 0){
			alert("There are no current requests.");
		}
		//Write Data from Local Stograge to the browser.
		var makeDiv = document.createElement('div');
		makeDiv.setAttribute("id", "items");
		var makeList = document.createElement('ul');
		makeDiv.appendChild(makeList);
		document.body.appendChild(makeDiv);
		$('items').style.display = "block";
		for(var i=0, j=localStorage.length; i<j; i++){
			 var makeLi = document.createElement('li');
			 var linksLi = document.createElement('li');
			 makeList.appendChild(makeLi);
			 var key = localStorage.key(i);
			 var value = localStorage.getItem(key);
			//Convert the string from local storage value back to an object by using JSON.parse().
			 var obj = JSON.parse(value);
			 var makeSubList = document.createElement('ul');
			 makeLi.appendChild(makeSubList);
			 for(var n in obj){
			 	var makeSubLi = document.createElement('li');
			 	makeSubList.appendChild(makeSubLi);
			 	var optSubText = obj[n][0]+" "+obj[n][1];
			 	makeSubLi.innerHTML = optSubText;
			 	makeSubList.appendChild(linksLi); 
			 }
			makeItemLinks(localStorage.key(i), linksLi); //Create our edit and delete buttons or links for each item in local storage
		}
	}
	
	//Make Items Links functions that creates edit and delete links for each stored item
	function makeItemLinks(key, linksLi){
		//add edit signle item link
		var editLink = document.createElement('a');
		editLink.href = "#";
		editLink.key = key;
		var editText = "Edit Request";
		editLink.addEventListener("click", editItem);
		editLink.innerHTML = editText;
		linksLi.appendChild(editLink);
		
		//add Line break
		var breakTag = document.createElement('br');
		linksLi.appendChild(breakTag);
		
		//add a delete single item link
		var deleteLink = document.createElement('a');
		deleteLink.href = "#";
		deleteLink.key = key;
		var deleteText = "Delete Request";
		//deleteLink.addEventListener("click", deleteItem);
		deleteLink.innerHTML = deleteText;
		linksLi.appendChild(deleteLink);
	}
	
	function editItem(){
		//Grab the data from our item from Local Storage.
		var value = localStorage.getItem(this.key);
		var item = JSON.parse(value);
		
		//Show the from to edit the items
		toggleControls("off");
		
		//populate the form feilds with the current localStorage values.
		$('name').value 	= item.name[1];
		$('roomnum').value 	= item.roomnum[1];
		$('phonenum').value = item.phonenum[1];
		$('email').value 	= item.email[1];
		$('groups1').value 	= item.groups1[1];
		$('groups2').value 	= item.groups2[1];
		$('budget').value 	= item.budget[1];
		//var checks = document.forms[0].urgent;
		if(item.urgent[1] == "urgent"){
			$('urgent').setAttribute("checked", "checked");
		}
		$('startdate').value 	= item.startdate[1];
		$('comments').value 	= item.comments[1];
		
		//Remove the initial listener from the input "save" button.
		save.removeEventListener("click", storeData);
		//Change Submit button value to Save Edit
		$('submit').value = "Save Edit";
		var editSubmit = $('submit');
		//Save the key value established in this function as a property of the editSubmit event
		//so we can use that value when we save the data that we edited
		editSubmit.addEventListener("click", validate);
		editSubmit.key = this.key;
	}
	
	
	function clearLocal(){
		if(localStorage.lenght === 0){
			alert("There is no data to clear.");
		}else{
			localStorage.clear();
			alert("All requests are deleted!");
			window.location.reload();
			return false;
		}
	}
		
	function validate(e){
		//Define the elements we want to check
		var getName 		= $('name');
		var getPhoneNum 	= $('phonenum');
		var getEmail	 	= $('email');
		var getGroups2 		= $('groups2');
		var getComments		= $('comments');
		
		//Reset the Error Messages
		errMsg.innerHTML = "";
		getName.style.border = "1px solid black";
		getPhoneNum.style.border = "1px solid black";
		getEmail.style.border = "1px solid black";
		getGroups2.style.border = "1px solid black";
		getComments.style.border = "1px solid black";
			
		
		//Get Error Messages
		var messageAry = [];
		
		//Guest Name Validations
		if(getName.value === ""){
			var nameError = "Please enter a name.";
			getName.style.border = "1px solid red";
			messageAry.push(nameError);
		}
		
		//Guest Phone Validations
	   	var rep = /^([0-9]{3})+-([0-9]{3})+-([0-9]{4})$/;
		if(!(rep.exec(getPhoneNum.value))){
			var phoneNumError = "Please enter a valid phone number.";
			getPhoneNum.style.border = "1px solid red";
			messageAry.push(phoneNumError);
		}

		//Guest Email Validations
	   	var ree = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(!(ree.exec(getEmail.value))){
			var emailError = "Please enter a valid email address.";
			getEmail.style.border = "1px solid red";
			messageAry.push(emailError);
		}
		
			///Service type request (groups2) validations
		if(getGroups2.value === "--Choose A Service--"){
			var groups2Error = "Please choose a service.";
			getGroups2.style.border = "1px solid red";
			messageAry.push(groups2Error);
		}
		
		//Guest Comments Validations
		if(getComments.value === ""){
			var commentsError = "Please explain your service request.";
			getComments.style.border = "1px solid red";
			messageAry.push(commentsError);
		}
		
		//If there were errors, display them on the screen
		if(messageAry.length >= 1){
			for(var i=0, j=messageAry.length; i < j; i++){
				var txt = document.createElement('li');
				txt.innerHTML = messageAry[i];
				errMsg.appendChild(txt);
			}
			e.preventDefault();
			return false;
		}else{
			storeData(this.key);
		}
	}
	
		//Variable default
		var bestContact = ["--Best Contact Method--", "Email", "Phone", "Text"];
		var service = ["--Choose A Service--", "'At your service' request", "Where to eat", "What to see", "Special event recommendation", "Need directions"];		
		var urgentValue = "Not Urgent";
		var errMsg = $('errors');
	
	makeCats1();
	makeCats2();
	
	//Set Link and Submit Click Events
	var displayLink = $('displayRequest');
	displayLink.addEventListener("click", getData);
	var clearLink = $('clearRequest');
	clearLink.addEventListener("click", clearLocal);
	var save = $('submit');
	save.addEventListener("click", validate);
	
});