var app = angular.module('promotionManagement', []);

app.controller('saveController', function($scope, $http, $window) {

	// --------------- Inserting Data -----------------

	$scope.promotion = {
		id : "",
		promotionName : "",
		promotionState : "",
		promotionValidFrom : "",
		promotionExpiresAt : "",
		discountAmount : ""
	}

	$scope.saveData = function() {
		console.log("Submition Started");
		console.log($scope.promotion);

		$http({
			method : 'POST',
			url : 'http://localhost:8065/api/promotions',
			data : angular.toJson($scope.promotion),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function success(response) {
			console.log(response.data);
			$scope.promotion = null;
			$window.location.reload();
		}, function error(response) {
			console.log("error found");
			console.log(response.data);
		})
	}
});

// ------------------------ viewing all details of the promotion
// --------------------

app.controller('viewController', function($scope, $http, $window) {

	$http({
		method : 'GET',
		url : 'http://localhost:8065/api/promotions',
		data : angular.toJson($scope.promotion),
		headers : {
			'Content-Type' : 'application/json'
		}
	}).then(function(response) {
		$scope.promotions = response.data;

	});

	// --------------------- Delete Promotion -------------------

	$scope.deletePromotion = function(promotionid) {

		console.log("Delete Promotion===" + promotionid);

		$http({
			method : 'DELETE',
			url : 'http://localhost:8065/api/promotions/' + promotionid,
			data : angular.toJson($scope.promotion),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(response) {
			console.log(response.data);
			$window.location.reload();
		});

	}
	// ------------- Update Promotion ------------------

	$scope.selectpromotion = {
		id : "",
		promotionName : "",
		promotionState : "",
		promotionValidFrom : "",
		promotionExpiresAt : "",
		discountAmount : ""

	}
	$scope.clickedPromotion = function(x) {
		console.log("Data from Form===" + x);
		$scope.selectpromotion = x;

		$scope.selectpromotion.promotionValidFrom = new Date(
				$scope.selectpromotion.promotionValidFrom);
		$scope.selectpromotion.promotionExpiresAt = new Date(
				$scope.selectpromotion.promotionExpiresAt);

		console.log("Data Sending to Modal Form===" + $scope.selectpromotion);

	}
	$scope.updatePromotion = function() {

		$http({
			method : 'PUT',
			url : 'http://localhost:8065/api/promotions',
			data : angular.toJson($scope.selectpromotion),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(response) {
			console.log(response.data);
			$window.location.reload();
		});
	}
});
