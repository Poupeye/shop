angular.module('app', []).controller('indexController', function ($scope, $http) {
        const contextPath = 'http://localhost:8189/shop/api/v1';

        $scope.fillTable = function (pageIndex = 1) {
            $http({
                url: contextPath + '/product',
                method: 'GET',
                params: {
                    title: $scope.filter ? $scope.filter.title : null,
                    min_price: $scope.filter ? $scope.filter.min_price : null,
                    max_price: $scope.filter ? $scope.filter.max_price : null,
                    p: pageIndex
                }
            }).then(function (response) {
                $scope.ProductsPage = response.data;
                $scope.PaginationArray = $scope.generatePagesIndexes(1, $scope.ProductsPage.totalPages);
            });
        };

        $scope.showCart = function () {
            $http({
                url: contextPath + '/cart',
                method: 'GET'
            }).then(function (response) {
                $scope.Cart = response.data;
            });
        };

        $scope.generatePagesIndexes = function (startPage, endPage) {
            let arr = [];
            for (let i = startPage; i < endPage + 1; i++) {
                arr.push(i);
            }
            return arr;
        }

        $scope.deleteById = function (productId) {
            $http.delete(contextPath + '/product/' + productId)
                .then(function (response) {
                    $scope.fillTable();
                });
        };

        $scope.addToCart = function (productId) {
            $http.get(contextPath + '/cart/add/' + productId)
                .then(function (response) {
                    $scope.showCart();
                });
        };

        $scope.clearCart = function () {
            $http.get(contextPath + '/cart/clear')
                .then(function (response) {
                    $scope.showCart();
                });
        };

    $scope.deleteCartById = function (productId) {
        $http.delete(contextPath + '/cart/' + productId)
            .then(function (response) {
                $scope.showCart();
            });
    };

        $scope.fillTable();
        $scope.showCart();
    }
)
;