angular.module('app',[]).controller('indexController',function ($scope,$http) {
    const contextPath = 'http://localhost:8189/shop';

    $scope.fillTable = function () {
        $http.get(contextPath + '/product')
            .then(function (response) {
                console.log(response);
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteById = function (id) {
        $http.get(contextPath + '/product/delete/'+ id)
            .then(function (response) {
                $scope.fillTable();
        });
    };

    $scope.fillTable();
});