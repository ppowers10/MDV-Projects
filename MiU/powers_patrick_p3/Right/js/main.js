
//Patrick Powers, Project 3 MiU, 1201, 1/3/2011

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
$(document).ready(function(){
	
	var recform = $('#recommendation');
	
	recform.validate();
	
})


//Wait until the DOM is ready
window.addEventListener("DOMContentLoaded", function(){

	//getElementById Function
	function $(x){
		var theElement = document.getElementById(x);
		return theElement;
	}
	
 
	function makeCats1(){
		var formTag = document.getElementsByTagName("form"), //formTag is an array
			selectSpan = $('select1'),
			makeSelect = document.createElement('select');
			makeSelect.setAttribute("id", "groups1");
			makeSelect.setAttribute("data-native-menu", "false")
			makeSelect.setAttribute("class", "required")
		for(var i=0, j=recommendationType.length; i<j; i++){
			var makeOption = document.createElement('option');
			var optText = recommendationType[i];
			makeOption.setAttribute("value", optText);
			makeOption.innerHTML =  optText;
			makeSelect.appendChild(makeOption);
		}
		selectSpan.appendChild(makeSelect);
	}
	

	function toggleControls(n){
		switch(n){
			case "on":
				$('recommendation').style.display = "none";
				$('clearRecommendation').style.display = "inline"; //inline
				$('displayRecommendation').style.display = "none";
				$('addNew').style.display = "inline"; //inline
				break;
			case "off":
				$('recommendation').style.display = "block"; //block
				$('clearRecommendation').style.display = "inline"; //inline
				$('displayRecommendation').style.display = "inline"; //inline
				$('addNew').style.display = "none"; //none
				$('items').style.display = "none"; //none
				break;
			//	break;
			default:
				return false;
		}
	}
	
	function storeData(key){
=======
function storeData(key){
>>>>>>> master
=======
function storeData(key){
>>>>>>> master
=======
function storeData(key){
>>>>>>> master
=======
function storeData(key){
>>>>>>> master
=======
function storeData(key){
>>>>>>> master
=======
function storeData(key){
>>>>>>> master
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
			item.groups1		= ["Recommendation Type:  ", $('groups1').value];
			item.name			= ["Recommendation Name:  ", $('name').value];
			item.rating			= ["Rating (1=bad, 5=amazing):  ", $('rating').value];
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
			item.phonenum		= ["Phone Number:  ", $('phonenum').value];
			item.email			= ["Email:  ", $('email').value];
			item.comments		= ["Comments:  ", $('comments').value];
=======
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
			item.comments		= ["Comments:  ", $('comments').value];
			item.phonenum		= ["Phone Number:  ", $('phonenum').value];
			item.email			= ["Email:  ", $('email').value];
			item.url			= ["Website:  ", $('url').value];
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
			item.location		= ["Location:  ", $('location').value];
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		alert("Recommendation Saved");
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	
	function getData(){
		toggleControls('on');
		if(localStorage.length === 0){
			autoFillData();
			alert("There are no current recommendations, so default data was added.");
		}
		//Write Data from Local Stograge to the browser.
		var makeDiv = document.createElement('div');
		makeDiv.setAttribute("id", "items");
		//makeDiv.setAttribute("data-role", "page");
		makeDiv.setAttribute("data-theme", "b");
		var makeContentDiv = document.createElement('div');
		makeContentDiv.setAttribute("data-role", "content");
		makeContentDiv.setAttribute("data-theme", "b");
		makeDiv.appendChild(makeContentDiv);
		var makeList = document.createElement('ul');
		makeContentDiv.appendChild(makeList);
		document.body.appendChild(makeDiv);
		$('items').style.display = "block";
		for(var i=0, j=localStorage.length; i<j; i++){
			 var makeLi = document.createElement('li');
			 makeLi.setAttribute("class", "recos")
			 var linksLi = document.createElement('li');
			 makeList.appendChild(makeLi);
			 var key = localStorage.key(i);
			 var value = localStorage.getItem(key);
			//Convert the string from local storage value back to an object by using JSON.parse().
			 var obj = JSON.parse(value);
			 var makeSubList = document.createElement('ul');
			 makeLi.appendChild(makeSubList);
			 getImage(obj.groups1[1], makeSubList);
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
/*		var json = {
			"request1": {
				"groups1": 		["Select Recommendation Type:", "Event"],
				"name": 		["Name:", "Dave Mathews Band"],
				"rating": 		["Rating (1=bad, 5=amazing):", "1"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "john.doe@email.com"],	
				"comments": 	["Comments:", "The DMB concert was amazing"]
				"location": 	["Location:", "Amway in Orlando"]
			},
			"request2": {
				"groups1": 		["Select Recommendation Type:", "Event"],
				"name": 		["Name:", "Dave Mathews Band"],
				"rating": 		["Rating (1=bad, 5=amazing):", "1"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "john.doe@email.com"],	
				"comments": 	["Comments:", "The DMB concert was amazing"]
				"location": 	["Location:", "Amway in Orlando"]
				}
		};
*/		
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
		$('phonenum').value = item.phonenum[1];
		$('email').value 	= item.email[1];
		$('comments').value = item.comments[1];
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
	
			storeData(this.key);
		}
	
		//Variable default
		var recommendationType = ["--Select Recommendation Type--", "Restaurant", "Bar", "Attraction", "Events", "Shopping"];
		var urgentValue = "Not Urgent";
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
=======
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master
=======
>>>>>>> master

var save = storeData;

$(document).ready(function(){
	
	var recform = $('#recommendation');
	
	recform.validate({
		invalidHandler: function(form, validator){},
		submitHandler: function(){
			var data = recform.serializeArray()
			storeData(data);
		}
	});
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
})
>>>>>>> master
=======
})
>>>>>>> master
=======
})
>>>>>>> master
=======
})
>>>>>>> master
=======
})
>>>>>>> master
=======
})
>>>>>>> master
