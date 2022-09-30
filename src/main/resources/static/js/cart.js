let url = "http://localhost:8189/cart";

angular.module("Rimshop", []).controller("cartController", function($scope, $http){
    $scope.getCart = function() {
        console.log("проверяем корзину")
        $http({
            url : url + "/get_cart",
            method : "GET",
        }).then(function(response) {
            $scope.cartDto = response.data;
        })
    }
});
