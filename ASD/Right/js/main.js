//Patrick Powers, Project 1 MiU, 1201, 1/3/2011


$(document).ready(function(){
	
	var recform = $("#recommendationform");
	
	recform.validate({
		//invalidHandler: function(form, validator){},
		submitHandler: function(){
			var data = recform.serializeArray();
			storeData(data)
		}
});

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
			item.groups1		= ["Category:  ", data[0].val];
			item.name			= ["Recommendation Title:  ", data[1].val];
			item.rating			= ["Rating (1=bad, 5=amazing):  ", data[2].val];
			item.comments		= ["Comments:  ", data[3].val];
			item.phonenum		= ["Phone Number:  ", data[4].val];
			item.email			= ["Email:  ", data[5].val];
			item.url			= ["Website:  ", data[6].val];
			item.location		= ["Location:  ", data[7].val];
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		console.log(id, JSON.stringify(item))
		alert("Recommendation Saved");
		
		}

function getData(){
		//toggleControls('on');
		if(localStorage.length === 0){
			autoFillData();
			alert("There are no current recommendations, so default data was added.");
		}
		//Write Data from Local Stograge to the browser.
		var makeDiv = document.createElement('div');
		makeDiv.setAttribute("id", "items");
		var makeList = document.createElement('ul');
		makeDiv.appendChild(makeList);
		document.body.appendChild(makeDiv);
		$('#items').style.display = "block";
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
		json;
		//Store the JSON OBJECT into Local Storage
		for(var n in json){
			var id = Math.floor(Math.random()*10000001);
			localStorage.setItem(id, JSON.stringify(json[n]));
		}
	}
	
	$('#displayRecommendation').bind("click", getData);
		
});