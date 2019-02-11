var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/clients',{
            templateUrl: '/views/clients.html',
            controller: 'clientsController'
        })
        .when('/vehicles',{
            templateUrl: '/views/vehicles.html',
            controller: 'vehiclesController'
        })
        .when('/courtyard',{
            templateUrl: '/views/courtyard.html',
            controller: 'courtyardController'
        })
        .when('/carpark',{
            templateUrl: '/views/carpark.html',
            controller: 'carparkController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

