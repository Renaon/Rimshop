let url = 'http://localhost:8189/categories';
// let element0 = document.getElementById("categories");

angular.module('Rimshop', []).controller('catalogueController', function($scope, $http) {
    $scope.test = "Test"
    $scope.getCategories = function(page) {
        $http({
            url : url,
            method : "GET",
        }).then(function(response) {
            $scope.categories = response.data;
            console.log(categories);

        })
    }

    $scope.byCategory = function(category) {
        element0 = document.getElementById("categories");
        let productsPrint = ' ';
        $http({
            url : 'http://localhost:8189/category',
            method : 'GET',
            params : {name : category}
        }).then(function(response) {
           $scope.products = response.data;
            for (i in $scope.products) {
                productsPrint += '<td>' + $scope.products[i].title + '</td>' +
                    '<td>' + $scope.products[i].categoryTitle + '</td>' +
                    '<td>' + $scope.products[i].price + '</td>' +
                    '<td><button class="btn btn-outline-primary" ng-click="addToCart(p.id)">Add to Cart</button></td>';
            }
            element0.innerHTML ='<font color="white"> ' +
                '<table class="table">\n' +
                '            <tr>\n' +
                '                <td>Наименование</td>\n' +
                '                <td>Категория</td>\n' +
                '                <td>Стоимость</td>\n' +
                '                <td></td>\n' +
                '            </tr>\n' +
                '            <br>\n' +
                '            <tr>\n' +
                productsPrint +
                '            </tr>\n' +
                '        </table>' +
                '</font>';
        });
    }
});



