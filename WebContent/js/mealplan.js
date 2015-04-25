
$(document).ready(function(){
var i;
var j;


for ( i = 0; i < 3; i++) {

	for ( j = 0; j < 7; j++) {


  $('#cell'+j+''+i).on('click', '.button-add-plan',
		function (event) {
	 		var i = $(this).closest('.result').find('.product').text();
		    var s = new String($(this).closest('.result-entry').find('.shopName').text() + ";");
		    $(this).closest('.result').next().val($(this).closest('.result').find('.select').val());
		  //  $('#supermarket').val($('#supermarket').val() + s);
			$(this).append(
				$('<div>').addClass('result-entry')//append(
					.append(
						$('<span>').addClass('product-name').text(
								$(this).closest('.result').find('.select').val()))
					.append(
						$('<span>').addClass('button-remove')
							.append($('<i>').addClass('fa').addClass('fa-times')))			
			);
			
			$(this).closest('.result').find('.select').val("")
		}
	);
	
	$('#cell'+j+''+i).on('click', '.button-remove',
		function() { 
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