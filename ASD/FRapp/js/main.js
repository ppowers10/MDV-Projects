
//Patrick Powers, Project 1 MiU, 1201, 1/3/2011


//Wait until the DOM is ready
$(function(){
	 
	function makeCats1(){
		var formTag = $("form"), //formTag is an array
			selectSpan = $('#select1'),
			makeSelect = $('<select></select>');
			makeSelect.attr({	
			"id": "groups1",
			"data-native-menu": "false"
			});
		for(var i=0, j=recommendationType.length; i<j; i++){
			var makeOption = $('<option></options>');
			var optText = recommendationType[i];
			makeOption.attr("value", optText);
			makeOption.html(optText);
			makeSelect.append(makeOption);
		}
		selectSpan.append(makeSelect);
	}
	

	function toggleControls(n){
		switch(n){
			case "on":
				$('recommendation').style.display = "none";
				$('clearRecommendation').style.display = "inline";
				$('displayRecommendation').style.display = "none";
				$('addNew').style.display = "inline";
				break;
			case "off":
				$('recommendation').style.display = "block";
				$('clearRecommendation').style.display = "inline";
				$('displayRecommendation').style.display = "inline";
				$('addNew').style.display = "none";
				$('items').style.display = "none";
				break;
			//	break;
			default:
				return false;
		}
	}
	
	function storeData(key){
		//If there is no key, this means this is a brand new item and we need a new key
		if(!key){
			var id 					= Math.floor(Math.random()*10000001);
		}else{
			//set the id to the existing key we're editing so that it will save over the data
			//the key is the same key that's been passed along from the editSubmit event handler
			//to the validate function, adn then passed here, into the storeData function
			var id = key;
		}
		//Gather up all our form field values and store in an object.
		//Oject properties contain array with the form label and input value.
		//getCheckboxValue();
		var item 				= {};
			item.groups1		= ["Category:  ", $('#groups1').val];
			item.name			= ["Recommendation Title:  ", $('#name').val];
			item.rating			= ["Rating (1=bad, 5=amazing):  ", $('#rating').val];
			item.comments		= ["Comments:  ", $('#comments').val];
			item.phonenum		= ["Phone Number:  ", $('#phonenum').val];
			item.email			= ["Email:  ", $('#email').val];
			item.url			= ["Website:  ", $('#url').val];
			item.location		= ["Location:  ", $('#location').val];
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		alert("Recommendation Saved");
	}
	
	function getData(){
		toggleControls('on');
		if(localStorage.length === 0){
			autoFillData();
			alert("There are no current recommendations, so default data was added.");
		}
		//Write Data from Local Stograge to the browser.
		var makeDiv = $('<div></div>');
		makeDiv.attr("id", "items");
		var makeList = $('<ul></ul>');
		makeDiv.append(makeList);
		document.body.appendChild(makeDiv);
		$('#items').css("display", "block");
		for(var i=0, j=localStorage.length; i<j; i++){
			 var makeLi = $('<li></li>');
			 makeLi.attr("class", "recos")
			 var linksLi = $('<li></li>');
			 makeList.append(makeLi);
			 var key = localStorage.key(i);
			 var value = localStorage.getItem(key);
			//Convert the string from local storage value back to an object by using JSON.parse().
			 var obj = JSON.parse(value);
			 var makeSubList = $('<ul></ul>');
			 makeLi.append(makeSubList);
			 getImage(obj.groups1[1], makeSubList);
			 for(var n in obj){
			 	var makeSubLi = $('<li></li>');
			 	makeSubList.append(makeSubLi);
			 	var optSubText = obj[n][0]+" "+obj[n][1];
			 	makeSubLi.html(optSubText);
			 	makeSubList.append(linksLi); 
			 }
			makeItemLinks(localStorage.key(i), linksLi); //Create our edit and delete buttons or links for each item in local storage
		}
	}
	
	//get the image for the right category per request
	function getImage(catName, makeSubList){
		var imageLi = document.createElement('li');
		makeSubList.appendChild(imageLi);
		var newImg = document.createElement('img');
		var setSrc = newImg.setAttribute("src", "images/"+ catName +".png");
		imageLi.appendChild(newImg);
	}
	
	//JSON Object which will auto populate local storage
	function autoFillData(){
		json;
		//Store the JSON OBJECT into Local Storage
		for(var n in json){
			var id = Math.floor(Math.random()*10000001);
			localStorage.setItem(id, JSON.stringify(json[n]));
		}
	}

	//Make Items Links functions
	//creates edit and delete links for each stored item
	function makeItemLinks(key, linksLi){
		//add edit signle item link
		var editLink = document.createElement('a');
		editLink.setAttribute("id", "changeItem");
		editLink.href = "#";
		editLink.key = key;
		var editText = "Edit";
		editLink.addEventListener("click", editItem);
		editLink.innerHTML = editText;
		linksLi.appendChild(editLink);
		
		//add Line break
	//	var breakTag = document.createElement('br');
	//	linksLi.appendChild(breakTag);
		
		//add a delete single item link
		var deleteLink = document.createElement('a');
		deleteLink.setAttribute("id", "deleteItem");
		deleteLink.href = "#";
		deleteLink.key = key;
		var deleteText = "Delete";
		deleteLink.addEventListener("click", deleteItem);
		deleteLink.innerHTML = deleteText;
		linksLi.appendChild(deleteLink);
	}
	
	//Edit Single Item
	function editItem(){
		//Grab the data from our item from Local Storage.
		var value = localStorage.getItem(this.key);
		var item = JSON.parse(value);
		
		//Show the from to edit the items
		toggleControls("off");
		
		//populate the form feilds with the current localStorage values.
		$('groups1').value 	= item.groups1[1];
		$('name').value 	= item.name[1];
		$('rating').value 	= item.rating[1];
		$('comments').value = item.comments[1];
		$('phonenum').value = item.phonenum[1];
		$('email').value 	= item.email[1];
		$('url').value 		= item.url[1];
		$('location').value = item.location[1];
		
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
	
	function deleteItem(){
		var ask = confirm("Are you sure you want to delete this recommendation?");
		if(ask){
			localStorage.removeItem(this.key);
			alert("Recommendation was deleted.");
			window.location.reload();
		}else{
			alert("Recommendation was not deleted.");
		}
	}
	
	function clearLocal(){
		if(localStorage.lenght === 0){
			alert("There are no recommendations to clear.");
		}else{
			localStorage.clear();
			alert("All recommendations were deleted!");
			window.location.reload();
			return false;
		}
	}
		
	function validate(e){
		//Define the elements we want to check
		var getName 		= $('name');
		var getPhoneNum 	= $('phonenum');
		var getEmail	 	= $('email');
		var getGroups1 		= $('groups1');
		var getComments		= $('comments');
		
		//Reset the Error Messages
		errMsg.innerHTML = "";
		getName.style.border = "1px solid black";
		getPhoneNum.style.border = "1px solid black";
		getEmail.style.border = "1px solid black";
		getGroups1.style.border = "1px solid black";
		getComments.style.border = "1px solid black";
			
		
		//Get Error Messages
		var messageAry = [];
		
		///Service type request (groups1) validations
		if(getGroups1.value === "--Select Recommendation Type--"){
			var groups1Error = "Please choose a recommendation.";
			getGroups1.style.border = "1px solid red";
			messageAry.push(groups1Error);
		}
		
		//Guest Name Validations
		if(getName.value === ""){
			var nameError = "Please enter a name.";
			getName.style.border = "1px solid red";
			messageAry.push(nameError);
		}
/*		
		//Guest Phone Validations
	   	var rep = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
		if(!(rep.exec(getPhoneNum.value))){
			var phoneNumError = "Please enter a valid phone number.";
			getPhoneNum.style.border = "1px solid red";
			messageAry.push(phoneNumError);
		}
*/
		//Guest Email Validations
/*	   	var ree = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(!(ree.exec(getEmail.value))){
			var emailError = "Please enter a valid email address.";
			getEmail.style.border = "1px solid red";
			messageAry.push(emailError);
		}
*/		
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
			//If all is OK, save our data.  Send the key value (which came form the edit data function
			//Remember this key value was passed through the editSubmit event listner as a property.	
			storeData(this.key);
		}
	}
	
		//Variable default
		var recommendationType = ["--Select Recommendation Type--", "Restaurant", "Bar", "Attraction", "Events", "Shopping"];
		var errMsg = $('errors');
	
	makeCats1();
	
	//Set Link and Submit Click Events
	var displayLink = $('displayRecommendation');
	displayLink.addEventListener("click", getData);
	var clearLink = $('clearRecommendation');
	clearLink.addEventListener("click", clearLocal);
	var save = $('submit');
	save.addEventListener("click", validate);

});