
function deleteProduct(idProduct){
	
	var r = confirm("¿Esta seguro que desea eliminar?");
	if(r){
		$.ajax({
		    url: '/products',
		    type: 'DELETE',
		    data: {id:idProduct},
		    success: function(data,result) {
	            window.location.href = data.redirect;
		    }
		});
	}
	
}


