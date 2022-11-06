angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1';
    $scope.loadCart = function (){
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response.data);
                $scope.ProductList = response.data;
            });
    }
    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
                // secret_key_part: $scope.filter ? $scope.filter.secret_key_part : null
            }
        }).then(function (response) {
            $scope.ProductPage = response.data;
        });
    };
    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createProductJson = function () {
        console.log($scope.newProductJson);
        $http.post(contextPath + '/products', $scope.newProductJson)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.putProductInCart = function (productId) {
        $http.get(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.loadProducts();
    // $scope.loadCart();
});
