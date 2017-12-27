var app = angular.module('book', []);

app.controller('bookcontroller', function($scope, $http) {
    $scope.books = []
    $scope.bookform = {
        id: "",
        name: "",
        author: "",
        totalVolume: "",
        availableVolume: ""
    };

    getBookDetails();

    function getBookDetails() {
        $http({
            method: 'GET',
            url: '/api/books/'
        }).then(function successCallback(response) {
            $scope.books = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    $scope.sendPost = function() {
        $http({
            method: 'POST',
            url: '/api/books/',
            data: $scope.bookform,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response) {
            getBookDetails();
            $scope.books = response.data;
            clearForm();
        }, function(error) {

        });
    }
    $scope.editBook = function(book) {
        $scope.bookform.id = book.id;
        $scope.bookform.name = book.name;
        $scope.bookform.author = book.author;
        $scope.bookform.totalVolume = book.totalVolume;
        $scope.bookform.availableVolume = book.availableVolume;
    }
    $scope.deleteBook = function(book) {
        $http({
            method: 'DELETE',
            url: '/api/books/',
            data: book,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(getBookDetails());
    }

    function clearForm() {
        $scope.bookform.id = "";
        $scope.bookform.name = "";
        $scope.bookform.author = "";
        $scope.bookform.totalVolume = "";
        $scope.bookform.availableVolume = "";
    };
});