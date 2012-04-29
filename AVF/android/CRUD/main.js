

//Wait until the DOM is ready
window.addEventListener("DOMContentLoaded", function(){

	//getElementById Function
	function $(x){
		var theElement = document.getElementById(x);
		return theElement;
	}
	
  	
	function toggleControls(n){
		switch(n){
			case "on":
				$('addEntry').style.display = "none";
				$('clearEntry').style.display = "none";
				$('displayEntry').style.display = "none";
				$('addNew').style.display = "inline";
                $('submit').style.display = "none";
                $('picture').style.display = "none";
                $('camera').style.display = "none";
				break;
			case "off":
				$('addEntry').style.display = "block";
				$('clearEntry').style.display = "none";
				$('displayEntry').style.display = "inline";
				$('addNew').style.display = "none";
				$('items').style.display = "none";
                $('submit').style.display = "inline";
                $('picture').style.display = "inline";
                $('camera').style.display = "inline";
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
			var id = key;
		}
		//Gather up all our form field values and store in an object.
		var item 				= {};
			item.name			= ["Title:  ", $('name').value];
			item.startdate		= ["Date Entered:  ", $('startdate').value];	
			item.comments		= ["Thoughts:  ", $('comments').value];
		//Save data into Local Storage: Use Stringify to convert our object to a string
		localStorage.setItem(id, JSON.stringify(item));
		alert("Request Saved");
	}
	
	function getData(){
		toggleControls('on');
		if(localStorage.length === 0){
			autoFillData();
			alert("No eJournal entries exist. A sample entry was added.");
		}
		//Write Data from Local Stograge to the browser.
		var makeDiv = document.createElement('div');
		makeDiv.setAttribute("id", "items");
        makeDiv.setAttribute("class", "g2");
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
	
	
	//JSON Object which will auto populate local storage
	function autoFillData(){
        var json = {
			"request1": {
				"name": 		["Title:", "eJournal Instructions"],
				"startdate": 	["Entry Date:", "4-25-2012"],
				"comments": 	["Comments:", "eJournal is an easy way to store your thoughts.  It's like a facebook status update, quick twitter, or an instigram, but only for you.  Take your thoughts with you and always have your journal by your side."]
			}
	};
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
		editLink.href = "#";
		editLink.key = key;
		var editText = "Edit Entry";
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
		var deleteText = "Delete Entry";
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
		$('name').value 	= item.name[1];
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
	
	function deleteItem(){
		var ask = confirm("Are you sure you want to delete this journal entry?");
		if(ask){
			localStorage.removeItem(this.key);
			alert("Journal Entry was deleted.");
			window.location.reload();
		}else{
			alert("Journal Entry was not deleted.");
		}
	}
	
	function clearLocal(){
		if(localStorage.lenght === 0){
			alert("There is no data to clear.");
		}else{
			localStorage.clear();
			alert("All entries were deleted!");
			window.location.reload();
			return false;
		}
	}
		
	function validate(e){
			storeData(this.key);
		}
	

	
	//Set Link and Submit Click Events
	var displayLink = $('displayEntry');
	displayLink.addEventListener("click", getData);
	var clearLink = $('clearEntry');
	clearLink.addEventListener("click", clearLocal);
	var save = $('submit');
	save.addEventListener("click", validate);
	
});