var app = angular.module('borrow', []);

app.controller('borrowcontroller', function($scope, $http) {
    $scope.borrows = []
    $scope.userslist = []
    $scope.bookslist = []
    $scope.borrowform = {
        id: 0,
        user: 0,
        book: 0,
        borrowDate: "",
        returnDate: ""
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