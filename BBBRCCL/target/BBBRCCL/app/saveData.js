var app = angular.module('promotionManagement', []);

app.controller('saveController', function($scope, $http) {

	$scope.promotion = {
		promotionName : "",
		promotionState : "",
		promotionValidFrom : "",
		promotionExpiresAt : "",
		discountPercentage : ""
	}

	$scope.saveData = function() {
		console.log("Submition Started");
		console.log($scope.promotion);

		$http({
			method : 'POST',
			url : '/saveData',
			data : angular.toJson($scope.promotion),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function success(response) {
			console.log(response.data);
		}, function error(response) {
			console.log("error found");
			console.log(response.data);
		})

	}

})