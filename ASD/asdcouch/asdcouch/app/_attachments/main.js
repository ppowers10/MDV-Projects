//Patrick Powers, Project 1 MiU, 1202, 2/2/2011


$(document).ready(function(){
	
//couch ajax call for list all____________________________________________________
	$('#listAll').live('pageshow', function(){
		$('#listAllRec').empty();
		$.couch.db("frapp").view("frapp/recall",{
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
		$.couch.db("frapp").view("frapp/restaurants",{
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
		$.couch.db("frapp").view("frapp/bars",{
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
		$.couch.db("frapp").view("frapp/attractions",{
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
		$.couch.db("frapp").view("frapp/events",{
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
		$.couch.db("frapp").view("frapp/shopping",{
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
		console.log(recIdent);
		$.couch.db("frapp").openDoc(recIdent, {
			success: function(data) {
				console.log(data);
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
$('#submit').bind('click', function(){
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
		var id 					= "rec:" + $('#name').val();
		var item 				= {};
			item.groups1		= ["Category:", $('#groups1').val()];
			item.name			= ["Recommendation Title:", $('#name').val()];
			item.rating			= ["Rating (1=bad, 5=amazing):", $('#rating').val()];
			item.comments		= ["Comments:", $('#comments').val()];
			item.phonenum		= ["Phone Number:", $('#phonenum').val()];
			item.email			= ["Email:", $('#email').val()];
			item.url			= ["Website:", $('#url').val()];
			item.location		= ["Location:", $('#location').val()];
		var doc = {
				_id		: id,
				groups1	: item.groups1,
				name	: item.name,
				rating	: item.rating,
				comments: item.comments,
				phonenum: item.phonenum,
				email	: item.email,
				url		: item.url,
				location: item.location
		};
		$.couch.db("frapp").saveDoc(doc, {
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
});

//revmove single recommendation_____________________________________
var urlUpdate = function(){
	var urlData = $($.mobile.activePage).data("url");
	var urlParts = urlData.split('=');
	var urlEnd = urlParts[1];
	return urlEnd
};

$('#deleteRec').live('click', function(){
	$.couch.db("frapp").openDoc(urlUpdate(), {
		success: function(data) {
			console.log(data);
			var doc = {
					_id: data["_id"],
					_rev: data["_rev"]
			};
			var deleteRec = confirm("Do you wish to delete this recommendation?");
			if(deleteRec){
				$.couch.db("frapp").removeDoc(doc, {
					success: function(data) {
				         console.log(data);
				         document.location.href = 'index.html';
				    },
				    error: function(status) {
				        console.log(status);
				    }
			    });
			}else{
				alert("Your recommendation has been deleted.")	
			}
		},
		error: function(status) {
			console.log(status);	
		}
	})
});

	
//edit recommendation___________________________________________________
$('#editRec').live('click', function(){
	var recIdent = urlVars()["recall"];
	console.log(recIdent);
	$.mobile.changePage("index.html#form");
	$.couch.db("frapp").openDoc(recIdent, {
		success: function(data) {
			console.log(data);
			$('#name').attr('disabled','disabled');
			$('#groups1').val(data.groups1[1]);
			$('#name').val(data.name[1]);
			$('#rating').val(data.rating[1]);
			$('#comments').val(data.comments[1]);
			$('#phonenum').val(data.phonenum[1]); 
			$('#email').val(data.email[1]);
			$('#url').val(data.url[1]);
			$('#location').val(data.location[1]);
			var recform1 = $("#recommendationform");
			
			recform1.validate({
				invalidHandler: function(form, validator){},
				submitHandler: function(){
					var data = recform1.serializeArray();
					storeAgain(data)
				}
			});
			function storeAgain(){
				var id 					= "rec:" + $('#name').val();
				var rev					= data._rev;
				var item 				= {};
					item.groups1		= ["Category:", $('#groups1').val()];
					item.name			= ["Recommendation Title:", $('#name').val()];
					item.rating			= ["Rating (1=bad, 5=amazing):", $('#rating').val()];
					item.comments		= ["Comments:", $('#comments').val()];
					item.phonenum		= ["Phone Number:", $('#phonenum').val()];
					item.email			= ["Email:", $('#email').val()];
					item.url			= ["Website:", $('#url').val()];
					item.location		= ["Location:", $('#location').val()];
				console.log(item);
				var doc = {
						_id		: id,
						_rev	: rev,
						groups1	: item.groups1,
						name	: item.name,
						rating	: item.rating,
						comments: item.comments,
						phonenum: item.phonenum,
						email	: item.email,
						url		: item.url,
						location: item.location
				};
				console.log(doc);
				$.couch.db("frapp").saveDoc(doc, {
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
			//});
		},
		error: function(status) {
			console.log(status);	
		}
	})
});
	
});