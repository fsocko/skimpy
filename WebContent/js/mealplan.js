
$(document).ready(function(){
var i;
var j;


for ( i = 0; i < 3; i++) {

	for ( j = 0; j < 7; j++) {


  $('#cell'+j+''+i).on('click', '.select',
		function (event) {
	 		
		  if ($(this).val() != ""){
		    	$(this).closest('.result').find('.meal').val($(this).closest('.result').find('.select').val());	
		    	
		        $(this).closest('.result').next().append(
				  $('<div>').addClass('result-entry')
					.append(
						$('<span>').addClass('product-name-plan').text(
								$(this).closest('.result').find('.select').val()))
					.append(
						$('<span>').addClass('button-remove-plan')
							.append($('<i>').addClass('fa').addClass('fa-times')))			
			);
		     
		        $(this).closest('.result').hide();
               
		        
		    }
			$(this).closest('.result').find('.select').val("")
		}
	);
	
	$('#cell'+j+''+i).on('click', '.button-remove-plan',
		function() { 
		
		 $(this).closest('#add-item').prev().show();
		    $(this).closest('#add-item').prev().find('.meal').val("");
		    $(this).closest('.result-entry').remove();
			
			$("#cell"+j+""+i).closest('.result').attr('style', 'display:inline;');
         
	        $('#cell'+j+''+i).append(
					$('<div>').addClass('result-entry').append(
	        		$('<span>').addClass('product-name-plan').append($
	        				('<input>'))));
	       
	});
		
}}});