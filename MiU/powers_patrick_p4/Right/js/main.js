
//Patrick Powers, Project 3 MiU, 1201, 1/3/2011

var save = function storeData(data){
		console.log(data)
	}

//var save = storeData;

$(document).ready(function(){
	
	var recform = $('#recommendation');
	
	recform.validate({
		invalidHandler: function(form, validator){},
		submitHandler: function(){
			var data = recform.serializeArray()
			save(data);
		}
	});
	
})