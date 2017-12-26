/**
 * 
 */
app = angular.module('user', []);                                                                             


//User Page

app.controller('getcontroller', function($scope, $http) {
    $http.get('/api/users/').
        then(function(response) {
            $scope.data = response.data;
        });
});

app.controller('postcontroller',function($scope, $http) {
	    $scope.sendPost = function() {
	        var data = {
	        		'name': $scope.name,
	                'emailId': $scope.emailId,
	                'password': $scope.password
	                };
	        var config = {
	                headers : {
	                	'Content-Type': 'application/json'
	                }
	        }
	        $http.post("/api/users/", data,config).success(function(data, status) {
	        	alert("data posted");
	        	location.reload();
	        }) 
	    }
	}
);

