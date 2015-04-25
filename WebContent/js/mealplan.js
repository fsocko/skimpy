
$(document).ready(function(){
var i;
var j;


for ( i = 0; i < 3; i++) {

	for ( j = 0; j < 7; j++) {


  $('#cell'+j+''+i).on('click', '.button-add-plan',
		function (event) {
	 		
		  if ($(this).closest('.result').find('.select').val() != ""){
		    	$(this).closest('.result').next().next().val($(this).closest('.result').find('.select').val());	
		    	
		        $(this).closest('.result').next().append(
				  $('<div>').addClass('result-entry')
					.append(
						$('<span>').addClass('product-name').text(
								$(this).closest('.result').find('.select').val()))
					.append(
						$('<span>').addClass('button-remove')
							.append($('<i>').addClass('fa').addClass('fa-times')))			
			);
		     
		        $(this).closest('.result').hide();
               
		        
		    }
			$(this).closest('.result').find('.select').val("")
		}
	);
	
	$('#cell'+j+''+i).on('click', '.button-remove',
		function() { 
		
		 $(this).closest('#add-item').prev().show();
		    $(this).closest('.result-entry').next().val("");
		    $(this).closest('.result-entry').remove();
			
			$("#cell"+j+""+i).closest('.result').attr('style', 'display:inline;');
         
	        $('#cell'+j+''+i).append(
					$('<div>').addClass('result-entry').append(
	        		$('<span>').addClass('product-name').append($
	        				('<input>'))).append($
	        						('<span>').addClass('button-add')));
	       
	});
		
}}});