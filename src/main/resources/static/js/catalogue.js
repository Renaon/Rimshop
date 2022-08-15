angular.module("catalogue", []).controller("catalogueController", function($scope, $http){
   const contextPath = 'http:://localhost:8189/catalog';

   $scope.init = function() {
      $http.get(contextPath).then(function(response){
         $scope.categories = response.data;
      });
   };
   $scope.init();
});