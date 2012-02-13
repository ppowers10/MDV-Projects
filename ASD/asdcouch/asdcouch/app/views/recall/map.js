function(doc) {
	if(doc._id.substr(0,4) === "rec:"){
		emit(doc._id, {
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