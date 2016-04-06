'use strict';

var magalApp = angular.module('MagalApp', ['ngRoute','magalControllers','magalServices']);

magalApp.config(['$routeProvider', '$locationProvider', "$httpProvider",     
    function($routeProvider, $locationProvider, $httpProvider){
        $httpProvider.defaults.useXDomain = true;
        $httpProvider.defaults.headers.common['X-Request-With'];
        $routeProvider.when('/',{
            templateUrl: 'partials/main.html' ,
            controller: 'MainCtrl'
        }).when('/newCity',{
            templateUrl: 'partials/addCity.html' ,
            controller: 'AddCityCtrl'
        }).when('/listCity',{
            templateUrl: 'partials/listCity.html' ,
            controller: 'ListCityCtrl'
        }).when('/deleteCity/:id/:city',{
            templateUrl: 'partials/deleteCity.html' ,
            controller: 'deleteCityCtrl'
        }).when('/editCity/:id/:city',{
            templateUrl: 'partials/editCity.html' ,
            controller: 'UpdateCityCtrl'
        });
        
        $locationProvider.html5Mode(false).hashPrefix('!');
    }
]);




