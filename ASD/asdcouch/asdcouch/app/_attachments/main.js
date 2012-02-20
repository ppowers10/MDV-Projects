//Patrick Powers, Project 1 MiU, 1202, 2/2/2011


$(document).ready(function(){
	
//couch ajax call for list all____________________________________________________
	$('#listAll').live('pageshow', function(){
		$('#listAllRec').empty();
		$.couch.db("frproject").view("frapp/recall",{
			success: function(data){
				console.log(data);
				$.each(data.rows, function(index, rec){
					var id = rec.id
					var oneRec = {};
						oneRec.category = rec.value.groups1;
						oneRec.name		= rec.value.name;
						oneRec.rating	= rec.value.rating;
					$(''+
						'<li>' +
							'<a href= "recall.html?recall=' + id + '">' +
								'<img src="' + oneRec.category + '.png">' +
								'<h2>' + oneRec.name +'</h2>' +
								'<p>' + 'Rating: ' + oneRec.rating + '</p>' + 
							'</a>' +
						'</li>'
					).appendTo('#listAllRec');
				});
				$("#listAllRec").listview("refresh");
			}
		})
	});

//couch ajax call for only restaurants_____________________________________________
	$('#restaurants').live('pageshow', function(){
		$('#listRestaurants').empty();
		$.couch.db("frproject").view("frapp/restaurants",{
			success: function(data){
				console.log(data);
				$.each(data.rows, function(index, rec){
					var id = rec.id
					var oneRec = {};
						oneRec.category = rec.value.groups1;
						oneRec.name		= rec.value.name;
						oneRec.rating	= rec.value.rating;
					$(''+
						'<li>' +
							'<a href= "recall.html?recall=' + id + '">' +
								'<img src="' + oneRec.category + '.png">' +
								'<h2>' + oneRec.name +'</h2>' +
								'<p>' + 'Rating: ' + oneRec.rating + '</p>' + 
							'</a>' +
						'</li>'
					).appendTo('#listRestaurants');
				});
				$("#listRestaurants").listview("refresh");
			}
		})
	});	

//couch ajax call for only bars_____________________________________________
	$('#bars').live('pageshow', function(){
		$('#listBars').empty();
		$.couch.db("frproject").view("frapp/bars",{
			success: function(data){
				console.log(data);
				$.each(data.rows, function(index, rec){
					var id = rec.id
					var oneRec = {};
						oneRec.category = rec.value.groups1;
						oneRec.name		= rec.value.name;
						oneRec.rating	= rec.value.rating;
					$(''+
						'<li>' +
							'<a href= "recall.html?recall=' + id + '">' +
								'<img src="' + oneRec.category + '.png">' +
								'<h2>' + oneRec.name +'</h2>' +
								'<p>' + 'Rating: ' + oneRec.rating + '</p>' + 
							'</a>' +
						'</li>'
					).appendTo('#listBars');
				});
				$("#listBars").listview("refresh");
			}
		})
	});	

//couch ajax call for only attractions_____________________________________________
	$('#attractions').live('pageshow', function(){
		$('#listAttractions').empty();
		$.couch.db("frproject").view("frapp/attractions",{
			success: function(data){
				console.log(data);
				$.each(data.rows, function(index, rec){
					var id = rec.id
					var oneRec = {};
						oneRec.category = rec.value.groups1;
						oneRec.name		= rec.value.name;
						oneRec.rating	= rec.value.rating;
					$(''+
						'<li>' +
							'<a href= "recall.html?recall=' + id + '">' +
								'<img src="' + oneRec.category + '.png">' +
								'<h2>' + oneRec.name +'</h2>' +
								'<p>' + 'Rating: ' + oneRec.rating + '</p>' + 
							'</a>' +
						'</li>'
					).appendTo('#listAttractions');
				});
				$("#listAttractions").listview("refresh");
			}
		})
	});	

//couch ajax call for only events_____________________________________________
	$('#events').live('pageshow', function(){
		$('#listEvents').empty();
		$.couch.db("frproject").view("frapp/events",{
			success: function(data){
				console.log(data);
				$.each(data.rows, function(index, rec){
					var id = rec.id
					var oneRec = {};
						oneRec.category = rec.value.groups1;
						oneRec.name		= rec.value.name;
						oneRec.rating	= rec.value.rating;
					$(''+
						'<li>' +
							'<a href= "recall.html?recall=' + id + '">' +
								'<img src="' + oneRec.category + '.png">' +
								'<h2>' + oneRec.name +'</h2>' +
								'<p>' + 'Rating: ' + oneRec.rating + '</p>' + 
							'</a>' +
						'</li>'
					).appendTo('#listEvents');
				});
				$("#listEvents").listview("refresh");
			}
		})
	});		
	
//couch ajax call for only shopping_____________________________________________
	$('#shopping').live('pageshow', function(){
		$('#listShopping').empty();
		$.couch.db("frproject").view("frapp/shopping",{
			success: function(data){
				console.log(data);
				$.each(data.rows, function(index, rec){
					var id = rec.id
					var oneRec = {};
						oneRec.category = rec.value.groups1;
						oneRec.name		= rec.value.name;
						oneRec.rating	= rec.value.rating;
					$(''+
						'<li>' +
							'<a href= "recall.html?recall=' + id + '">' +
								'<img src="' + oneRec.category + '.png">' +
								'<h2>' + oneRec.name +'</h2>' +
								'<p>' + 'Rating: ' + oneRec.rating + '</p>' + 
							'</a>' +
						'</li>'
					).appendTo('#listShopping');
				});
				$("#listShopping").listview("refresh");
			}
		})
	});	
	

var urlVars = function(){
	var urlData = $($.mobile.activePage).data("url");
	var urlParts = urlData.split('?');
	var urlPairs = urlParts[1].split('&');
	var urlValues = {};
	for(var pair in urlPairs) {
		var keyValue = urlPairs[pair].split('=');
		var key = decodeURIComponent(keyValue[0]);
		var value = decodeURIComponent(keyValue[1]);
		urlValues[key] = value;
	}
	return urlValues;
};	
	
//create drill down page_________$($.mobile.activePage)_______________________________________________
	$('#rec').live('pageshow', function(){
		var recIdent = urlVars()["recall"];
		$.couch.db("frproject").openDoc(recIdent, {
			success: function(data) {
				console.log(data);
				console.log(data.comments)
				$(''+
					'<div class="ui-grid-a">' +
						'<div class="ui-block-a">' +
							'<h3>' + data.name[1] + '</h3>' +
							'<p> Rating: ' + data.rating[1] + '</p>' +
							'<p>' + data.phonenum[1] + '</p>' +
							'<a href="' + data.url[1] + '">' +
								'<p>' + data.url[1] + '</p>' +
							'</a>' +
						'</div>' +
						'<div class="ui-block-b">' +
							'<a href="#" >' +
								'<img src="mapshot.png">' +
							'</a>' +
						'</div>' +
					'</div>' +
					'<h4>Review:</h4>' +
						'<p>' + data.comments[1] + '</p>'
					).appendTo('#contentArea');	
			},
		})
	});

//form validation________________________________________________________	
var recform = $("#recommendationform");
	
recform.validate({
	invalidHandler: function(form, validator){},
	submitHandler: function(){
		var data = recform.serializeArray();
		storeData(data)
		//console.log(data);
	}
});	

//save recommendation information_______________________________________
function storeData(){
	var item 				= {};
		item.groups1		= ["Category:", $('#groups1').val()];
		item.name			= ["Recommendation Title:", $('#name').val()];
		item.rating			= ["Rating (1=bad, 5=amazing):", $('#rating').val()];
		item.comments		= ["Comments:", $('#comments').val()];
		item.phonenum		= ["Phone Number:", $('#phonenum').val()];
		item.email			= ["Email:", $('#email').val()];
		item.url			= ["Website:", $('#url').val()];
		item.location		= ["Location:", $('#location').val()];
	$.couch.db("frproject").saveDoc(item, {
		success: function(data) {
			console.log(data);
			alert("Recommendation Saved");
			document.location.href = 'index.html';
		},
		error: function(status) {
			console.log(status);
			alert("Error while saving Recommendation");
		}
	})
	
};


		
		toggleControls('off');
		

	
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
		
		
		
		//Edit Single Item
		function editItem(key){
			console.log(key);
			//Grab the data from our item from Local Storage.
			var value = localStorage.getItem(this.key);
			console.log(localStorage.getItem(this.key));
			var item = JSON.parse(value);
			console.log(JSON.parse(value));
			//Show the from to edit the items
			toggleControls("off");
			
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
			$('#submit').val = "Save Edit";
			var editSubmit = $('#submit');
			//Save the key value established in this function as a property of the editSubmit event
			//so we can use that value when we save the data that we edited
			editSubmit.bind("click", recform.validate);
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
	
		
//		$('#displayRecommendation').bind("click", getData);
//		$('#clearRecommendation').bind("click", clearLocal);
//		$('#addRec').bind("click", formBack);

});