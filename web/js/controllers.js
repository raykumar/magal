'use strict';

var magalControllers = angular.module('magalControllers',[]);

magalControllers.controller('MainCtrl', ['$scope','$location','$http', 
    function MainCtrl($scope,$location,$http){        
        $http.get('http://localhost:9090/WF/webresources/wf/listciudad/0/100').
            success(function(data) {
                $scope.resultado = data;
            });        
    }
]);

magalControllers.controller('ListCityCtrl', ['$scope','$http', 
    function ListCityCtrl($scope,$http){        
            var ciudad = ' ';
            var url = 'http://localhost:9090/WF/webresources/wf/searchCity/0/100/'+ciudad;            
            console.log(url+";");
            $http.get(url).
            success(function(data) {                
                $scope.ciudadList = JSON.parse(data);
            });
        $scope.listCity = function (){                        
            
            $http.get('http://localhost:9090/WF/webresources/wf/listciudad/0/100').
            success(function(data) {
                
                $scope.ciudadList = JSON.parse(data);
            });
        }
        
    }
]);

magalControllers.controller('AddCityCtrl', ['$scope','$location', '$http', 
    function AddCityCtrl($scope, $location, $http) {
        $scope.addCity = function (){            
            var postData = {
                "ciu_nombre": $scope.ciudad
            };            
            
            $http({
                url: 'http://localhost:9090/WF/webresources/wf/insertCiudad',
                method: "POST",
                data: postData,
                withCredentials: true,
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS, Object',
                    'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With'
                }
            }).success(function (response){
              console.log("Insertado: "+response.ciu_nombre);  
              $location.path("/listCity");
            });
        };               
        $scope.listCiudades = function (){
            $location.path('/listCity');
        }; 
        
         $scope.deleteCity = function() {
            alert('Borrar Ciudad!');
         };      
        
}]);

magalControllers.controller('deleteCityCtrl', ['$scope','$location','$routeParams', '$http',
    function ($scope,$location,$routeParams, $http){                
        $scope.ciu_id = $routeParams.id;
        $scope.ciu_nombre = $routeParams.city;
        
        $scope.listCiudades = function (){
            $location.path('/listCity');
        }; 
        
        $scope.deleteCity = function (){            
            var postData = {
                "ciu_id": $scope.ciu_id,
                "ciu_nombre": $scope.ciu_nombre
                
            };     
            $http({
                url: 'http://localhost:9090/WF/webresources/wf/deleteCity/',
                method: "POST",
                data: postData,
                withCredentials: true,
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS, Object',
                    'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With'
                }
            }).success(function (response){
              console.log("Borrado: "+response.respuesta);  
              $location.path("/listCity");
            });
        };              
        
        
        
    }
]);

magalControllers.controller('UpdateCityCtrl', ['$scope','$location', '$http', '$routeParams',
    function UpdateCityCtrl($scope, $location, $http, $routeParams) {
        $scope.ciu_id = $routeParams.id;
        $scope.ciu_nombre = $routeParams.city;
        console.log($scope.ciu_nombre+' asdasd');
        $scope.updateCity = function (){            
            
            var postData = {      
                "ciu_id": $scope.ciu_id,
                "ciu_nombre": $scope.ciu_nombre
            };     
                                                           
            $http({
                url: 'http://localhost:9090/MagalWS/webresources/wf/updateCiudad',
                method: "PUT",
                data: postData,
                withCredentials: true,
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS, Object',
                    'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With'
                }
            }).success(function (response){
              console.log("Insertado: "+response.ciu_nombre);  
              $location.path("/listCity");
            });
        };               
        $scope.listCiudades = function (){
            $location.path('/listCity');
        };        
                 
}]);

magalControllers.directive('ngConfirmClick', [
        function(){
            return {
                link: function (scope, element, attr) {
                    var msg = attr.ngConfirmClick || "Are you sure?";
                    var clickAction = attr.confirmedClick;
                    element.bind('click',function (event) {
                        if ( window.confirm(msg) ) {
                            scope.$eval(clickAction);
                        }
                    });
                }
            };
    }]);