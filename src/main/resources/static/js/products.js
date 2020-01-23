
function deleteProduct(idProduct){
	
	var r = confirm("¿Esta seguro que desea eliminar?");
	if(r){
		console.log('Eliminando');
		$.ajax({
		    url: '/products',
		    type: 'DELETE',
		    data: {id:idProduct},
		    success: function(data,result) {
	           console.log(data);
		    }
		});
	}
	
}


