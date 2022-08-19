angular.module("catalogue", []).controller("catalogueController", function($scope, $http){
   const contextPath = 'http:://localhost:8189/catalog';

   $scope.init = function() {
      $http.get(contextPath).then(function(response){
         $scope.categories = response.data;
      });
   };
   $scope.init();

   $scope.loadPage = function (page) {
      $http({
         url: '/products',
         method: 'GET',
         params: {
            p: page
         }
      }).then(function (response) {

         $scope.productsPage = response.data;

         let minPageIndex = page - 2;
         if (minPageIndex < 1) {
            minPageIndex = 1;
         }

         let maxPageIndex = page + 2;
         if (maxPageIndex > $scope.productsPage.totalPages) {
            maxPageIndex = $scope.productsPage.totalPages;
         }

         $scope.paginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);

         console.log("PAGE FROM BACKEND")
         console.log($scope.productsPage);
      });
   };

   $scope.createNewProduct = function () {
      $http.post(contextPath + '/add', $scope.newProduct)
          .then(function successCallback(response) {
             $scope.loadPage(1);
             $scope.newProduct = null;
          }, function errorCallback(response) {
             console.log(response.data);
             alert('Error: ' + response.data.messages);
          });
   };
});