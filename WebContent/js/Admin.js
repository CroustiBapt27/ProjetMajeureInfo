$(document).ready(function() {	

	
	$("#ButtonGo").click(function() {
		$.post("rest/cmd/GO", {}, function(data, status) {
			//alert("Post Done received data: " + data + "\nStatus: " + status);
		});

	});
	$("#ButtonStop").click(function() {

		$.post("rest/cmd/STOP", {}, function(data, status) {
			//alert("Post Done received data: " + data + "\nStatus: " + status);
		});

	});

	
});