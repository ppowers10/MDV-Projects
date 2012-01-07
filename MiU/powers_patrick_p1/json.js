//Patrick Powers
//VWF Project 4
//1112 12/1/2011


	//JSON Object which will auto populate local storage
		var json = {
			"request1": {
				"groups1": 		["Select Recommendation Type:", "Events"],
				"name": 		["Name:", "Dave Mathews Band"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "john.doe@email.com"],	
				"comments": 	["Comments:", "The DMB concert was amazing"],
				"location": 	["Location:", "Amway in Orlando"]
			},
			"request2": {
				"groups1": 		["Select Recommendation Type:", "Attraction"],
				"name": 		["Name:", "Universal"],
				"rating": 		["Rating (1=bad, 5=amazing):", "3"],
				"phonenum": 	["Phone Number:", "407-222-2222"],
				"email": 		["Email:", "universal@email.com"],	
				"comments": 	["Comments:", "I like city walk.  It is a great place to go and just enjoy walking around from bar to restaurant."],
				"location": 	["Location:", "Orlando"]
			},
			"request3": {
				"groups1": 		["Select Recommendation Type:", "Restaurant"],
				"name": 		["Name:", "Outback"],
				"rating": 		["Rating (1=bad, 5=amazing):", "4"],
				"phonenum": 	["Phone Number:", "407-555-5555"],
				"email": 		["Email:", "outback@email.com"],	
				"comments": 	["Comments:", "Outback steakhouse has great prices.  For $10, you can get a huge meal."],
				"location": 	["Location:", "Aloma Ave"]
			},
			"request4": {
				"groups1": 		["Select Recommendation Type:", "Bar"],
				"name": 		["Name:", "Filling Station"],
				"rating": 		["Rating (1=bad, 5=amazing):", "4"],
				"phonenum": 	["Phone Number:", "407-333-7333"],
				"email": 		["Email:", "filling@email.com"],	
				"comments": 	["Comments:", "The filling station has great burgers, but the bar is even more fun.  It can get very crowded on the weekends, so get there early while there are still parking spaces."],
				"location": 	["Location:", "Michigan"]
			},
			"request5": {
				"groups1": 		["Select Recommendation Type:", "Shopping"],
				"name": 		["Name:", "Brazilian Grocergy Store"],
				"rating": 		["Rating (1=bad, 5=amazing):", "4"],
				"phonenum": 	["Phone Number:", "407-888-8888"],
				"email": 		["Email:", "brazil@email.com"],	
				"comments": 	["Comments:", "The Brazilian grocery store is great.  It has a lot of things you won't find at any other store and relatively good prices."],
				"location": 	["Location:", "International drive near the outlets."]
			},
			"request6": {
				"groups1": 		["Select Recommendation Type:", "Restaurant"],
				"name": 		["Name:", "Camillas"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-233-4567"],
				"email": 		["Email:", "camillas@email.com"],	
				"comments": 	["Comments:", "Camillas is an all you can eat Brazilian buffet.  The food is great and if you are say you are a resident of FL,  you get a small discount in price."],
				"location": 	["Location:", "International Drive near outlets"]
			},
			"request7": {
				"groups1": 		["Select Recommendation Type:", "Bar"],
				"name": 		["Name:", "Redlight Redlight"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-789-7829"],
				"email": 		["Email:", "rlrl@email.com"],	
				"comments": 	["Comments:", "Best place in town to taste a new and interesting beer."],
				"location": 	["Location:", "off rt. 50 on Bennet."]
			},
			"request8": {
				"groups1": 		["Select Recommendation Type:", "Attraction"],
				"name": 		["Name:", "Disney World"],
				"rating": 		["Rating (1=bad, 5=amazing):", "3"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "disney@email.com"],	
				"comments": 	["Comments:", "It's Disney...enough said."],
				"location": 	["Location:", "South of Orlando"]
			},
			"request9": {
				"groups1": 		["Select Recommendation Type:", "Events"],
				"name": 		["Name:", "Farmers Market"],
				"rating": 		["Rating (1=bad, 5=amazing):", "3"],
				"phonenum": 	["Phone Number:", "999-999-9999"],
				"email": 		["Email:", "none@email.com"],	
				"comments": 	["Comments:", "Every Sunday there is a Farmers Market at downtown lake eola.  Its always fun to walk through if you have time to waste or just want to relax on a Sunday morning."],
				"location": 	["Location:", "Amway in Orlando"]
			},
			"request10": {
				"groups1": 		["Select Recommendation Type:", "Shopping"],
				"name": 		["Name:", "Lowes"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "lowes@email.com"],	
				"comments": 	["Comments:", "I love lowes."],
				"location": 	["Location:", "Off Semoran south of the 408."]
			},
			"request11": {
				"groups1": 		["Select Recommendation Type:", "Events"],
				"name": 		["Name:", "Dave Mathews Band"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "john.doe@email.com"],	
				"comments": 	["Comments:", "The DMB concert was amazing"],
				"location": 	["Location:", "Amway in Orlando"]
			},
			"request12": {
				"groups1": 		["Select Recommendation Type:", "Attraction"],
				"name": 		["Name:", "Universal"],
				"rating": 		["Rating (1=bad, 5=amazing):", "3"],
				"phonenum": 	["Phone Number:", "407-222-2222"],
				"email": 		["Email:", "universal@email.com"],	
				"comments": 	["Comments:", "I like city walk.  It is a great place to go and just enjoy walking around from bar to restaurant."],
				"location": 	["Location:", "Orlando"]
			},
			"request13": {
				"groups1": 		["Select Recommendation Type:", "Restaurant"],
				"name": 		["Name:", "Outback"],
				"rating": 		["Rating (1=bad, 5=amazing):", "4"],
				"phonenum": 	["Phone Number:", "407-555-5555"],
				"email": 		["Email:", "outback@email.com"],	
				"comments": 	["Comments:", "Outback steakhouse has great prices.  For $10, you can get a huge meal."],
				"location": 	["Location:", "Aloma Ave"]
			},
			"request14": {
				"groups1": 		["Select Recommendation Type:", "Bar"],
				"name": 		["Name:", "Filling Station"],
				"rating": 		["Rating (1=bad, 5=amazing):", "4"],
				"phonenum": 	["Phone Number:", "407-333-7333"],
				"email": 		["Email:", "filling@email.com"],	
				"comments": 	["Comments:", "The filling station has great burgers, but the bar is even more fun.  It can get very crowded on the weekends, so get there early while there are still parking spaces."],
				"location": 	["Location:", "Michigan"]
			},
			"request15": {
				"groups1": 		["Select Recommendation Type:", "Shopping"],
				"name": 		["Name:", "Brazilian Grocergy Store"],
				"rating": 		["Rating (1=bad, 5=amazing):", "4"],
				"phonenum": 	["Phone Number:", "407-888-8888"],
				"email": 		["Email:", "brazil@email.com"],	
				"comments": 	["Comments:", "The Brazilian grocery store is great.  It has a lot of things you won't find at any other store and relatively good prices."],
				"location": 	["Location:", "International drive near the outlets."]
			},
			"request16": {
				"groups1": 		["Select Recommendation Type:", "Restaurant"],
				"name": 		["Name:", "Camillas"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-233-4567"],
				"email": 		["Email:", "camillas@email.com"],	
				"comments": 	["Comments:", "Camillas is an all you can eat Brazilian buffet.  The food is great and if you are say you are a resident of FL,  you get a small discount in price."],
				"location": 	["Location:", "International Drive near outlets"]
			},
			"request17": {
				"groups1": 		["Select Recommendation Type:", "Bar"],
				"name": 		["Name:", "Redlight Redlight"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-789-7829"],
				"email": 		["Email:", "rlrl@email.com"],	
				"comments": 	["Comments:", "Best place in town to taste a new and interesting beer."],
				"location": 	["Location:", "off rt. 50 on Bennet."]
			},
			"request18": {
				"groups1": 		["Select Recommendation Type:", "Attraction"],
				"name": 		["Name:", "Disney World"],
				"rating": 		["Rating (1=bad, 5=amazing):", "3"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "disney@email.com"],	
				"comments": 	["Comments:", "It's Disney...enough said."],
				"location": 	["Location:", "South of Orlando"]
			},
			"request19": {
				"groups1": 		["Select Recommendation Type:", "Events"],
				"name": 		["Name:", "Farmers Market"],
				"rating": 		["Rating (1=bad, 5=amazing):", "3"],
				"phonenum": 	["Phone Number:", "999-999-9999"],
				"email": 		["Email:", "none@email.com"],	
				"comments": 	["Comments:", "Every Sunday there is a Farmers Market at downtown lake eola.  Its always fun to walk through if you have time to waste or just want to relax on a Sunday morning."],
				"location": 	["Location:", "Amway in Orlando"]
			},
			"request20": {
				"groups1": 		["Select Recommendation Type:", "Shopping"],
				"name": 		["Name:", "Lowes"],
				"rating": 		["Rating (1=bad, 5=amazing):", "5"],
				"phonenum": 	["Phone Number:", "407-340-7829"],
				"email": 		["Email:", "lowes@email.com"],	
				"comments": 	["Comments:", "I love lowes."],
				"location": 	["Location:", "Off Semoran south of the 408."]
			}
		};