
/**
 * Sends a form to delete a product
 * @param form_id
 * @returns void
 */
function deleteProduct(form_id){
	
	var r = confirm("¿Esta seguro que desea eliminar?");
	if(r){
		$('#'+form_id).submit();
	}
	
}


