angular.module('sudokuService',[]).factory('sudokuService', ['$http', function($http) {
	var port="8080";
    var contextUrl = "http://localhost:"
	return{
		    
		    nuovaGriglia: function nuovaGriglia(newPort){
		    	if(newPort)
		    		port = newPort;
		    	return $http.get(contextUrl+port+'/game');
		    }
	    
		}
}]);
