/**
 * 
 * 
 */
function addTypeSuccsess() {
	var alertMsg = '<%= request.getAttribute("alert") %>';

	if (alertMsg != "") {
		alert(alertMsg);
	}
}