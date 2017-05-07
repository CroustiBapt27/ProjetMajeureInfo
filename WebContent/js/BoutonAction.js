$(document).ready(function() {	
	
	
/*	setInterval(function(){
		$.get("rest/cmd/env",function(data, status) { 
			document.getElementById("mesures").innerHTML = "<h4>Mesures:</h4>";
			$("#mesures").append("<h5> -------------------------- </h5>");			
			 for(i in data.data){
			 $("#mesures").append("<h5> "+data.data[i].name+ " = " + data.data[i].value +"</h5>");
			 }
			//alert("Get Done received data: " + data + "\nStatus: " + status);
			console.log("Get Done received data: " + data + "\nStatus: " + status);
			//alert("Done");
		});
		console.log('test');
	},5000);*/	

	
	$("#ButtonUp").click(function() {


		  $.ajax({
		       url : 'rest/cmd/UP', // La ressource ciblée
		       type : 'POST', // Le type de la requête HTTP.
		       data : "{\"login\":" + $.cookie('login') + ",\"token\":\""+ $.cookie('token')+"\"}",
		       success: function(data,status){
		    	  // alert("retour: " + data.etat);
		    	   	    	   
		       }
		});

	});
	
	
	$("#ButtonDown").click(function() {

		  $.ajax({
		       url : 'rest/cmd/DOWN', // La ressource ciblée
		       type : 'POST', // Le type de la requête HTTP.
		       data : "{\"login\":" + $.cookie('login') + ",\"token\":\""+ $.cookie('token')+"\"}",
		       success: function(data,status){
		    	  // alert("retour: " + data.etat);
		    	   	    	   
		       }
		});


	});
	$("#ButtonLeft").click(function() {

		  $.ajax({
		       url : 'rest/cmd/LEFT', // La ressource ciblée
		       type : 'POST', // Le type de la requête HTTP.
		       data : "{\"login\":" + $.cookie('login') + ",\"token\":\""+ $.cookie('token')+"\"}",
		       success: function(data,status){
		    	  // alert("retour: " + data.etat);
		    	   	    	   
		       }
		});

	});
	$("#ButtonRight").click(function() {
		  $.ajax({
			  url : 'rest/cmd/RIGHT', // La ressource ciblée
		       type : 'POST', // Le type de la requête HTTP.
		       data : "{\"login\":" + $.cookie('login') + ",\"token\":\""+ $.cookie('token')+"\"}",
		       success: function(data,status){
		    	  // alert("retour: " + data.etat);
		    	   	    	   
		       }
		});

	});

	
	$("#ButtonRefresh").click(function() {
		$.get("rest/cmd/env",
		function (data, status) {

			document.getElementById("myContent").innerHTML = "<h4>REFRESHED</h4>";
			document.getElementById("mesures").innerHTML = "<h4>Mesures:</h4>";
			$("#mesures").append("<h5> -------------------------- </h5>");			
			 for(i in data.data){
			 $("#mesures").append("<h5> "+data.data[i].name+ " = " + data.data[i].value +"</h5>");
			 			
			 
			 } 
		});
	});
		
});


