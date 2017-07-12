    var mainSection = angular.module('mainSection', ['ngRoute']);

    mainSection.config(function($routeProvider) {
        $routeProvider

        //for each site eg. documents, section etc
            .when('/', {
                templateUrl : '/DMS/templates/mainSectionForHome.jsp',
                controller  : 'mainSectionForHomeController'
            })

            .when('/about', {
                templateUrl : 'pages/about.html',
                controller  : 'aboutController'
            })

            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'contactController'
            });
    });
    
    mainSection.controller('mainSectionForHomeController', function($scope, $http) {
    	var userid;
        $http.get('http://localhost:8080/DMS/user').
        then(function(response) {
            $http.get('http://localhost:8080/DMS/user/' + response.data.id + '/documents').
            then(function(responseUser) {
                $scope.documents = responseUser.data;
            });
        });
    });  





	var notification = angular.module('notifications', ['ngRoute']);

    notification.config(function($routeProvider) {
        $routeProvider

        //for each site eg. documents, section etc
            .when('/', {
                templateUrl : '/DMS/templates/notificationsForHome.jsp',
                controller  : 'notificationsForHomeController'
            })

            .when('/about', {
                templateUrl : 'pages/about.html',
                controller  : 'aboutController'
            })

            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'contactController'
            });
    });
    
    notification.controller('notificationsForHomeController', function($scope, $http) {
    	var userid;
        $http.get('http://localhost:8080/DMS/user').
        then(function(response) {
            $http.get('http://localhost:8080/DMS/user/' + response.data.id + '/notifications').
            then(function(responseUser) {
                $scope.notifications = responseUser.data;
            });
        });
    });

  