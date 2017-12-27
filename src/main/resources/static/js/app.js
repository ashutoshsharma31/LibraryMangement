/**
 * USER
 */
appUser = angular.module('user', []);                                                                             


//User Page

appUser.controller('usercontroller', function($scope, $http) {
	  $scope.users = []
	  $scope.userform = {
	  name : "",
	  emailId : "",
	  password: ""
	};

getUserDetails();

function getUserDetails(){
	
	$http.get('/api/users/').
    then(function(response) {
        $scope.data = response.data;
    });
	
}

appUser.controller('usercontroller',function($scope, $http) {
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



/**
 * BOOK
 */
appBook = angular.module('book', []);                                                                             


//User Page

appBook.controller('getcontroller', function($scope, $http) {
    $http.get('/api/books/').
        then(function(response) {
            $scope.data = response.data;
        });
});

appBook.controller('postcontroller',function($scope, $http) {
	    $scope.sendPost = function() {
	        var data = {
	        		'name': $scope.name,
	                'author': $scope.author,
	                'totalVolume': $scope.totalVolume,
	                'availableVolume': $scope.availableVolume
	                };
	        var config = {
	                headers : {
	                	'Content-Type': 'application/json'
	                }
	        }
	        $http.post("/api/books/", data,config).success(function(data, status) {
	        	alert("data posted");
	        	location.reload();
	        }) 
	    }
	}
);



/**
 * BORROW
 */
appBorrow = angular.module('borrow', []);                                                                             


//User Page

appUser.controller('getcontroller', function($scope, $http) {
    $http.get('/api/borrow/').
        then(function(response) {
            $scope.data = response.data;
        });
});

appUser.controller('bookBorrowcontroller',function($scope, $http) {
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

appUser.controller('bookReturncontroller',function($scope, $http) {
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


