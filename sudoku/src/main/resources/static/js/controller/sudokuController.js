(function() {

  'use strict';

  app.controller('game',  function($scope, $http, sudokuService) {
	    $scope.portVisible = false;
	    $scope.port= '8080';
		$scope.showresult = function() {
//			  alert('ti piace vincere facile')	
			  for (var i=0; i<$scope.celle.length; i++) {
		    		var cella = $scope.celle[i]
		    		for(var j=0; j<cella.length; j++){
		    			$scope.celle[i][j].valoreVisualizzato = $scope.celle[i][j].valore
		    			$scope.celle[i][j].corretto=true;
		    		}
		    	}
	  };
	  
		$scope.newGame = function(){
			sudokuService.nuovaGriglia($scope.port)
	        .then(
	        		
	        		function successCallback(response) {
	        			 $scope.celle = response.data.celle;
	        			 $scope.portVisible = false;

	        		}, function errorCallback(response) {
	        			$scope.portVisible = true;
	        		}
	        		
	        		);
		};
		
		$scope.isRight = function(cell){
			return cell.valore == cell.valoreVisualizzato;
			};
		
	    

		$scope.checkAll = function() {
			
			var checkRiga= [false, false, false, false, false, false, false, false, false];
			
			for(var j=0; j<9; j++){
	    		checkRiga[j]= true;
	    		
	    		for(var i =0; i<9; i++){
	    			var c =$scope.celle[j][i];
	    			checkRiga[j] = checkRiga[j] && c.valore==c.valoreVisualizzato;
	    		}
	    		for(var i =0; i<9; i++){
	    			$scope.celle[j][i].corretto=checkRiga[j];
	    		}
			}
			var checkColonna=[false, false, false, false, false, false, false, false, false];
			for(var j=0; j<9; j++){
			checkColonna[j]= true;
	    		for(var i =0; i<9; i++){
	    			var c =$scope.celle[i][j];
	    			checkColonna[j] = checkColonna[j] && c.valore==c.valoreVisualizzato;
	    			
	    		}
	    		for(var i =0; i<9; i++){
	    			$scope.celle[i][j].corretto=checkColonna[j] && checkRiga[i];
	    		}
			}
			    		 
			 
	for(var x=1; x<=9; x++){
				
				var blocco= x;
	    		var checkBlocco= true;
	    		 for (var i=0; i<$scope.celle.length; i++) {
	 	    		var cella = $scope.celle[i]
	 	    		for(var j=0; j<cella.length; j++){
	 	    			if(blocco==$scope.celle[i][j].blocco){
	 	    				checkBlocco = checkBlocco && $scope.celle[i][j].valoreVisualizzato == $scope.celle[i][j].valore;
	 	    				
	 	    			}
	 	    		}
	 	    	}//fine checkBlocco
	    		 for (var i=0; i<$scope.celle.length; i++) {
		 	    		var cella = $scope.celle[i]
		 	    		for(var j=0; j<cella.length; j++){
		 	    			if(blocco==$scope.celle[i][j].blocco){
		 	    				$scope.celle[i][j].corretto=checkBlocco || (checkColonna[j] || checkRiga[i]);
		 	    				
		 	    			}
		 	    		}
		 	    	}
			}
	    };    
	    
	    $scope.newGame();
		

	});

})();
