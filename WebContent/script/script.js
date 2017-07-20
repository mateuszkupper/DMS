    var mainSection = angular.module('mainSection', ['ngRoute']);

    mainSection.config(function($routeProvider) {
        $routeProvider
        
	        .when('/doc/:id', {
	            templateUrl : '/DMS/templates/mainSectionForDocument.jsp',
	            controller  : 'mainSectionForDocumentController'
	        })        
        
            .when('/', {
                templateUrl : '/DMS/templates/mainSectionForHome.jsp',
                controller  : 'mainSectionForHomeController'
            })

            .when('/sec/:id', {
                templateUrl : '/DMS/templates/mainSectionForSection.jsp',
                controller  : 'mainSectionForSectionController'
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

    mainSection.controller('mainSectionForDocumentController', function($scope, $http, $routeParams) {
        var documentid = $routeParams.id;
    	$http.get('http://localhost:8080/DMS/document/' + documentid + '/sections').
        then(function(response) {
            $scope.sections = response.data;
            
            $scope.content = [];
            $scope.sections.forEach(function(item, index) {
            	$http.get('http://localhost:8080/DMS/section/' + item.id + '/content').
                then(function(responseContent) {
                	$scope.content.push(responseContent.data);
                    $scope.sectionsAndContent = $scope.sections.map(function(val, index) {
                        return {
                            data: val,
                            value: $scope.content[index]
                        }
                    }); 
                }); 
             });

        });
    	
    	$http.get('http://localhost:8080/DMS/document/' + documentid).
        then(function(response) {
            $scope.document = response.data;
        });
    }); 
    
   mainSection.controller('notificationsForHomeController', function($scope, $http) {
		var userid;
	    $http.get('http://localhost:8080/DMS/user').
	    then(function(response) {
	        $http.get('http://localhost:8080/DMS/user/' + response.data.id + '/notifications').
	        then(function(responseUser) {
	            $scope.notifications = responseUser.data;
	        });
	    }); 
    });

   mainSection.controller('mainSectionForSectionController', function($scope, $http, $routeParams) {
       var sectionid = $routeParams.id;   	
	   var userid;
       $http.get('http://localhost:8080/DMS/section/' + sectionid).
       then(function(response) {
    	   $scope.section = response.data;
    	   $http.get('http://localhost:8080/DMS/section/' + $scope.section.id + '/content').
           then(function(responseContent) {
               $scope.content = responseContent.data;              
           });
       });    
   });     
   
   angular.module('ng').filter('cut', function () {
       return function (value, wordwise, max, tail) {
           if (!value) return '';

           max = parseInt(max, 10);
           if (!max) return value;
           if (value.length <= max) return value;

           value = value.substr(0, max);
           if (wordwise) {
               var lastspace = value.lastIndexOf(' ');
               if (lastspace !== -1) {
                 if (value.charAt(lastspace-1) === '.' || value.charAt(lastspace-1) === ',') {
                   lastspace = lastspace - 1;
                 }
                 value = value.substr(0, lastspace);
               }
           }

           return value + (tail || ' …');
       };
   });