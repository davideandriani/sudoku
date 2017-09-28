app.directive('hideZero', function() {
	return {
	      require: '?ngModel', // get a hold of NgModelController
	      link: function(scope, element, attrs, ngModel) {

	        // Specify how UI should be updated
	        ngModel.$formatters.push(function(value) {
	          if (value === 0) {
	            // If the value is zero, return a blank string.
	            return '';
	          }

	          return value;
	        });
	      }
    };
});
    
    app.directive('restrictInput', function() {
	 return {
         restrict: 'A',
         link: function (scope, element, attrs) {
             var ele = element[0];
             var regex = RegExp(attrs.restrictInput);
             var value = ele.value;

             ele.addEventListener('keyup',function(e){
                 if (regex.test(ele.value)){
                     value = ele.value;
                 }else{
                     ele.value = '';
                 }
             });
         }
     };
});