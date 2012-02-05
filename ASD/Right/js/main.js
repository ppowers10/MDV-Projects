<<<<<<< HEAD
<<<<<<< HEAD
//Patrick Powers, Project 1 ASD, 1201, 1/3/2011
=======
//Patrick Powers, Project 1 MiU, 1202, 2/2/2011
>>>>>>> master
=======
//Patrick Powers, Project 1 MiU, 1202, 2/2/2011
>>>>>>> master


$(document).ready(function(){
	
<<<<<<< HEAD
=======
	toggleControls('off');
	
>>>>>>> master
	var recform = $("#recommendationform");
	
	recform.validate({
		//invalidHandler: function(form, validator){},
		submitHandler: function(){
			var data = recform.serializeArray();
			storeData(data)
<<<<<<< HEAD
		}
});

=======
			console.log(data);
		}
});

function toggleControls(n){
		switch(n){
			case "on":
				$('#recommendationform').css("display" , "none");
				$('#clearRec').css("display" , "inline");
				$('#displayRec').css("display" , "none");
				$('#addRec').css("display" , "inline");
				break;
			case "off":
				$('#recommendationform').css("display" , "block");
				$('#clearRec').css("display" , "block");
				$('#displayRec').css("display" , "block");
				$('#addRec').css("display" , "none");
				$('#items').css("display" , "none");
				break;
			//	break;
			default:
				return false;
		}
	}
	
function formBack(){
	toggleControls('off');
}	

>>>>>>> master
function storeData(data){
		//If there is no key, this means this is a brand new item and we need a new key
		if(!data.key){
			var id 					= Math.floor(Math.random()*10000001);
		}else{
			//set the id to the existing key we're editing so that it will save over the data
			//the key is the same key that's been passed along from the editSubmit event handler
			//to the validate function, adn then passed here, into the storeData function
			var id = data.key;
		}
		//Gather up all our form field values and store in an object.
		//Oject properties contain array with the form label and input value.
		//getCheckboxValue();
		var item 				= {};
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> master
			item.groups1		= ["Category:  ", data[0].value];
			item.name			= ["Recommendation Title:  ", data[1].value];
			item.rating			= ["Rating (1=bad, 5=amazing):  ", data[2].value];
			item.comments		= ["Comments:  ", data[3].value];
			item.phonenum		= ["Phone Number:  ", data[4].value];
			item.email			= ["Email:  ", data[5].value];
			item.url			= ["Website:  ", data[6].value];
			item.location		= ["Location:  ", data[7].value];
<<<<<<< HEAD
=======
			item.groups1		= ["Category:  ", data[0].val];
			item.name			= ["Recommendation Title:  ", data[1].val];
			item.rating			= ["Rating (1=bad, 5=amazing):  ", data[2].val];
			item.comments		= ["Comments:  ", data[3].val];
			item.phonenum		= ["Phone Number:  ", data[4].val];
			item.email			= ["Email:  ", data[5].val];
			item.url			= ["Website:  ", data[6].val];
			item.location		= ["Location:  ", data[7].val];
>>>>>>> master
=======
>>>>>>> master
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		console.log(id, JSON.stringify(item))
		alert("Recommendation Saved");
		
		}

function getData(){
<<<<<<< HEAD
		//toggleControls('on');
=======
		toggleControls('on');
>>>>>>> master
		if(localStorage.length === 0){
			autoFillData();
			alert("There are no current recommendations, so default data was added.");
		}
		//Write Data from Local Stograge to the browser.
<<<<<<< HEAD
<<<<<<< HEAD

=======
=======
>>>>>>> master
		
		//need to create the JQM page tht the data will be held on
/*		var makePage = $('<div></div>');
		makePage.attr({
			"data-theme": "b",
			"id": "viewdata"
		});
		$('body').append(makePage);
		var createLink = $('<a></a>');
		createLink.attr({
			"href": "#home",
			"data-direction": "reverse"
		});
		makePage.append(createLink);
		var createLinkDiv = $('<div></div>');
		createLinkDiv.attr({
			"data-role": "header",
			"data-theme": "b",
			"align": "center"
		});
		createLink.append(createLinkDiv);
		var createLinkImage = $('<img></img>');
		createLinkImage.attr({
			"src": "images/fr_header.png"
		});
		createLinkDiv.append(createLinkImage);
		//ends the header section of the page
			
		//create content area of JQM
		var makeContent = $('<div></div>');
		makeContent.attr({
			"data-role": "content",
			"data-theme": "b"
		});
		makePage.append(makeContent);		
*/		
		//previous code
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master
		var makeDiv = $('<div></div>');
		makeDiv.attr("id", "items");
		var makeList = $('<ul></ul>');
		makeDiv.append(makeList);
		$("#recommendationform").after(makeDiv);
<<<<<<< HEAD
		$("#item").css("display", "block");
		for(var i=0, j=localStorage.length; i<j; i++){
			 var makeLi = $('<li></li>');
			 makeLi.attr("class", "recos")
=======
		$("#items").css("display", "block");
		for(var i=0, j=localStorage.length; i<j; i++){
			 var makeLi = $('<li></li>');
			 makeLi.attr("class", "recos");
>>>>>>> master
			 var linksLi = $('<li></li>');
			 makeList.append(makeLi);
			 var key = localStorage.key(i);
			 var value = localStorage.getItem(key);
			//Convert the string from local storage value back to an object by using JSON.parse().
			 var obj = JSON.parse(value);
<<<<<<< HEAD
=======
			 console.log(JSON.parse(value));
>>>>>>> master
			 var makeSubList = $('<ul></ul>');
			 makeLi.append(makeSubList);
			 getImage(obj.groups1[1], makeSubList);
			 for(var n in obj){
<<<<<<< HEAD
			 	var makeSubLi = $('<li></li>');
			 	makeSubList.append(makeSubLi);
			 	var optSubText = obj[n][0]+" "+obj[n][1];
<<<<<<< HEAD
			 	makeSubLi.html(optSubText);
=======
			 	makeSubLi.innerHTML = optSubText;
>>>>>>> master
			 	makeSubList.append(linksLi); 
			 }
=======
			 	var makeSubLi = document.createElement('li');
			 	makeSubList.append(makeSubLi);
			 	var optSubText = obj[n][0]+" "+obj[n][1];
			 	makeSubLi.innerHTML = optSubText;
			 	makeSubList.append(linksLi); 
			 }
		//	 for(var n in obj){
		//	 	var makeSubLi = $('<li></li>');
		//	 	makeSubList.append(makeSubLi);
		//	 	var optSubText = obj[n][0]+" "+obj[n][1];
		//	 	makeSubLi.innerHTML = optSubText;
		//	 	makeSubList.append(linksLi); 
		//	 }
>>>>>>> master
			makeItemLinks(localStorage.key(i), linksLi); //Create our edit and delete buttons or links for each item in local storage
		}
	}
	
	function getImage(catName, makeSubList){
		var imageLi = $('<li></li>');
<<<<<<< HEAD
		makeSubList.append(imageLi);
		var newImg = $('<img></img>');
		var setSrc = newImg.attr("src", "images/"+ catName +".png");
=======
		imageLi.css("display", "inline");
		makeSubList.append(imageLi);
		var newImg = $('<img></img>');
		var setSrc = newImg.attr("src", "images/"+ catName +".png");
		setSrc.css("display", "inline");
>>>>>>> master
		imageLi.append(newImg);
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
	
	function makeItemLinks(key, linksLi){
		//add edit signle item link
		var editLink = $('<a></a>');
<<<<<<< HEAD
<<<<<<< HEAD
		editLink.attr({
			"id": "changeItem",
			"data-role": "button",
			"href": "#"
		})
=======
		editLink.attr("id", "changeItem");
>>>>>>> master
		editLink.href = "#";
		editLink.key = key;
		var editText = "Edit";
		editLink.bind("click", editItem);
		editLink.html(editText);
		linksLi.append(editLink);
=======
		editLink.attr("id", "changeItem");
		editLink.href = "#";
		editLink.key = key;
		var editText = "Edit";
		editLink.html(editText);
		linksLi.append(editLink);
		editLink.bind("click", editItem);
>>>>>>> master
		
		//add Line break
	//	var breakTag = document.createElement('br');
	//	linksLi.appendChild(breakTag);
		
		//add a delete single item link
<<<<<<< HEAD
<<<<<<< HEAD
		
		var deleteLink = $('<a></a>');
		deleteLink.attr({
			"id": "deleteItem",
			"data-role": "button",
			"href": "#"
		})
		//deleteLink.href = "#";
=======
		var deleteLink = $('<a></a>');
		deleteLink.attr("id", "deleteItem");
		deleteLink.href = "#";
>>>>>>> master
=======
		var deleteLink = $('<a></a>');
		deleteLink.attr({
			"id": "deleteItem",	
			"data-role": "button"
		});
		deleteLink.href = "#";
>>>>>>> master
		deleteLink.key = key;
		var deleteText = "Delete";
		deleteLink.bind("click", deleteItem);
		deleteLink.html(deleteText);
		linksLi.append(deleteLink);
	}
	
	//Edit Single Item
	function editItem(){
		//Grab the data from our item from Local Storage.
		var value = localStorage.getItem(this.key);
<<<<<<< HEAD
		var item = JSON.parse(value);
		
		//Show the from to edit the items
		//toggleControls("off");
=======
		console.log(localStorage.getItem(this.key));
		var item = JSON.parse(value);
		console.log(JSON.parse(value));
		//Show the from to edit the items
		toggleControls("off");
>>>>>>> master
		
		//populate the form feilds with the current localStorage values.
		$('#groups1').value 	= item.groups1[1];
		$('#name').value		= item.name[1];
		$('#rating').value 		= item.rating[1];
		$('#phonenum').value 	= item.phonenum[1];
		$('#email').value		= item.email[1];
		$('#comments').value 	= item.comments[1];
		$('#location').value	= item.location[1];
		
		//Remove the initial listener from the input "save" button.
		save.removeEventListener("click", storeData);
		//Change Submit button value to Save Edit
<<<<<<< HEAD
<<<<<<< HEAD
		//$('#submit').val = "Save Edit";
		//var editSubmit = $('#submit');
		//Save the key value established in this function as a property of the editSubmit event
		//so we can use that value when we save the data that we edited
		$('#submit').attr("value", "Save Edit").bind("click", recform.validate);
=======
=======
>>>>>>> master
		$('#submit').val = "Save Edit";
		var editSubmit = $('#submit');
		//Save the key value established in this function as a property of the editSubmit event
		//so we can use that value when we save the data that we edited
		editSubmit.bind("click", recform.validate);
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master
		editSubmit.key = this.key;
	}
	
	function deleteItem(){
		var ask = confirm("Are you sure you want to delete this recommendation?");
		if(ask){
<<<<<<< HEAD
			localStorage.removeItem(this.key);
=======
			localStorage.removeItem('name');
>>>>>>> master
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

	
	$('#displayRecommendation').bind("click", getData);
<<<<<<< HEAD
=======
	$('#clearRecommendation').bind("click", clearLocal);
	$('#addRec').bind("click", formBack);
>>>>>>> master
		
});