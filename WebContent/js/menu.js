$(document).ready(function() {
	$('#submit').click(function() {

		$.ajax({
			type : 'POST',
			url : 'operation',
			data : {
				option : $("[name=option]:checked").val(),
				registration : $('#registration').val()
			},
			success : function(responseText) {
				$('#valid').html(responseText.replace(",", "<br>"));
				$("#tableDisplay").load("home.jsp #tableDisplay");
				$('#registration').val("");
			}
		});
	}),
	$("#search").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
});
