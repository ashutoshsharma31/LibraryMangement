var app = angular.module('user', []);

app.controller('usercontroller', function($scope, $http) {
    $scope.users = []
    $scope.userform = {
        id: "",
        name: "",
        emailId: "",
        password: ""
    };

    getUserDetails();

    function getUserDetails() {
        $http({
            method: 'GET',
            url: '/api/users/'
        }).then(function successCallback(response) {
            $scope.users = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    $scope.sendPost = function() {
        $http({
            method: 'POST',
            url: '/api/users/',
            data: $scope.userform,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(response) {
            getUserDetails();
            $scope.users = response.data;
            clearForm();
        }, function(error) {

        });
    }
    $scope.editUser = function(user) {
        $scope.userform.id = user.id;
        $scope.userform.name = user.name;
        $scope.userform.emailId = user.emailId;
        $scope.userform.password = user.password;
    }
    $scope.deleteUser = function(user) {
        $http({
            method: 'DELETE',
            url: '/api/users/',
            data: user,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(getUserDetails());
    }

    function clearForm() {
        $scope.userform.id = "";
        $scope.userform.name = "";
        $scope.userform.emailId = "";
        $scope.userform.password = "";
    };
});