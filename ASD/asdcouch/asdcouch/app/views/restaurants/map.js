function(doc) {
	if(doc.groups1[1] === "Restaurant"){
		emit(doc.groups1[1], {
			"groups1"	: doc.groups1[1],
			"name"		: doc.name[1],
			"rating"	: doc.rating[1],
			"comments"	: doc.comments[1],
			"phonenum"	: doc.phonenum[1],
			"email"		: doc.email[1],
			"url"		: doc.url[1],
			"location"	: doc.location[1]
		});
	}
};