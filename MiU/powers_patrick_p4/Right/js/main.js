
//Patrick Powers, Project 3 MiU, 1201, 1/3/2011

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
			item.groups1		= ["Recommendation Type:  ", $('groups1').value];
			item.name			= ["Recommendation Name:  ", $('name').value];
			item.rating			= ["Rating (1=bad, 5=amazing):  ", $('rating').value];
			item.comments		= ["Comments:  ", $('comments').value];
			item.phonenum		= ["Phone Number:  ", $('phonenum').value];
			item.email			= ["Email:  ", $('email').value];
			item.url			= ["Website:  ", $('url').value];
			item.location		= ["Location:  ", $('location').value];
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		alert("Recommendation Saved");
	}

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
	
})