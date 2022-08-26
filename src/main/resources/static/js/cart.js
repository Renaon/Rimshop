

angular.module("Rimshop", []).controller("cartController", function($scope, $http){
    $scope.addToCart = function(id) {
        console.log("Добавляем в корзину")
    }
});

async function addToCart(){
    console.log("Добавляем в корзину");
}