var app = angular.module('borrow', []);

app.controller('borrowcontroller', function($scope, $http) {
    $scope.borrows = []
    $scope.userslist = []
    $scope.bookslist = []
    $scope.borrowform = {
        id: 0,
        user: 0,
        book: 0,
        borrowDate: ""
    };

    getBorrowDetails();
    getUsers();
    getBooks();
    $scope.myDate = new Date();
    function getBorrowDetails() {
        $http({
            method: 'GET',
            url: '/api/borrows/'
        }).then(function successCallback(response) {
            $scope.borrows = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    $('.datepicker').datepicker({
        dateFormat: 'dd/mm/yy',
        changeMonth: true,
        changeYear: true,
        onSelect: function(date) {
              angular.element($('.datepicker')).triggerHandler('input');
        }
      });
    
    function getUsers() {
        $http({
            method: 'GET',
            url: '/api/users/'
        }).then(function successCallback(response) {
            $scope.userslist = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
    
    function getBooks() {
        $http({
            method: 'GET',
            url: '/api/books/'
        }).then(function successCallback(response) {
            $scope.bookslist = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
    
    $scope.borrowBook = function() {
    	
    	alert($scope.borrowform);
        $http({
            method: 'POST',
            url: '/api/borrows/',
            data: $scope.borrowform,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response) {
            getBorrowDetails();
            $scope.borrows = response.data;
            clearForm();
        }, function(error) {

        });
    }
    $scope.returnBook = function(borrow) {
    	var today = new Date();
    	var dd = today.getDate();
    	var mm = today.getMonth()+1; //January is 0!
    	var yyyy = today.getFullYear();

    	if(dd<10) {
    	    dd = '0'+dd
    	} 

    	if(mm<10) {
    	    mm = '0'+mm
    	} 

    	borrow.returnDate=dd + '/' + mm + '/' + yyyy;
        $http({
            method: 'POST',
            url: '/api/borrows/',
            data: borrow,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response) {
            getBorrowDetails();
            $scope.borrows = response.data;
            clearForm();
        }, function(error) {

        });
    }

    
    
    $scope.editBorrow = function(borrow) {
        $scope.borrowform.id = borrow.id;
        $scope.borrowform.user = borrow.user;
        $scope.borrowform.book = borrow.book;
        $scope.borrowform.borrowDate = borrow.borrowDate;
        $scope.borrowform.returnDate = borrow.returnDate;
    }
    $scope.deleteBook = function(book) {
        $http({
            method: 'DELETE',
            url: '/api/borrows/',
            data: borrow,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(getBorrowDetails());
    }

    function clearForm() {
        $scope.borrowform.id = 0;
        $scope.borrowform.user = 0;
        $scope.borrowform.book = 0;
        $scope.borrowform.borrowDate = "";
        $scope.borrowform.returnDate = "";
    };
});

